<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=968b58efdcdf81589347da0f2f97fd87&libraries=services"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#photo_btn').click(function(){
		$('#photo_choice').show();
		$(this).hide();//수정 버튼 감추기
	});
	
	//이미지 미리보기
	//처음 화면에 보여지는 이미지 저장
	let photo_path = $('.my-photo').attr('src');
	$('#photo').change(function(){
		let my_photo = this.files[0];
		if(!my_photo){
			//선택을 취소하면 원래 처음 화면으로 되돌림
			$('.my-photo').attr('src',photo_path);
			return;
		}
		
		if(my_photo.size > 1024 * 1024){
			alert(Math.round(my_photo.size/1024) 
					     + 'kb(1024kb까지만 업로드 가능)');
			$('.my-photo').attr('src',photo_path);
			$(this).val('');//선택한 파일 정보 지우기
			return;
		}
		
		//화면에서 이미지 미리보기 처리
		const reader = new FileReader();
		reader.readAsDataURL(my_photo);
		
		reader.onload=function(){
			$('.my-photo').attr('src',reader.result);
		};		
	});//end of change
	
	//이미지 전송
	$('#photo_submit').click(function(){
		if($('#photo').val()==''){
			alert('파일을 선택하세요!');
			$('#photo').focus();
			return;
		}
		//파일 전송
		
		//전체 데이터를 전부 지정할 때
		//const form_data = new FormData($(this)[0]);
		
		const form_data = new FormData();
		//개별 데이터를 지정할 때
		//업로드할 파일은 $('#photo').files[0]를 호출할 수 없음
		//$('#photo')[0].files[0] 또는
		//document.getElementById('photo').files[0]
		//형식으로 호출 가능
		form_data.append('photo',$('#photo')[0].files[0]);
		
		//서버와 통신
		$.ajax({
			url:'updateMyPhoto.do',
			type:'post',
			data:form_data,
			dataType:'json',
			contentType:false,//데이터 객체를 문자열로 바꿀지에 대한 값.true이면 일반문자
			processData:false,//해당 타입을 true로 하면 일반문자로 구분
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인 후 사용하세요');
				}else if(param.result == 'success'){
					alert('프로필 사진이 수정되었습니다.');
					//수정된 이미지 정보 저장
					photo_path = $('.my-photo').attr('src');
					$('#photo').val('');
					$('#photo_choice').hide();
					$('#photo_btn').show();//수정 버튼 표시
				}else{
					alert('파일 전송 오류 발생');
				}	
			},
			error:function(){
				alert('네트워크 오류 발생');
			}			
		});
	});//end of click
	
	//이미지 미리보기 취소
	$('#photo_reset').click(function(){
		//초기 이미지 표시(이미지 미리보기 전 이미지로 되돌리기)
		$('.my-photo').attr('src',photo_path);
		$('#photo').val('');
		$('#photo_choice').hide();
		$('#photo_btn').show();//수정 버튼 표시
	});//end of click
	
	/*
	1. https://developers.kakao.com/ 로 이동
	2. 로그인
	3. 웹 개발 시작 앱생성 - 예)GEO
	4. 설정 - 일반
	5. 플랫폼 - 웹 http://127.0.0.1:8080 으로 지정 ip 사용시 ip 지정
	6. Javascript 키를 복사해서 script에 표시
	7. 자바스크립트 관련 지도 가이드 - https://apis.map.kakao.com/web/guide/
	*/
	
	function getMyLocation(){
		//지도를 표시할 div
		var mapContainer = document.getElementById('map');
		mapOption = {
			center:new daum.maps.LatLng(33.450701,126.570667),//지도의 중심좌표(초기값으로 주소를 좌표로 바꿔서 제공하면 중심 좌표가 바뀜)
			level:3//지도의 확대 레벨
		};
		
		//지도 생성
		var map = new daum.maps.Map(mapContainer,mapOption);
		
		//주소-좌표 변환 객체 생성
		var geocoder = new daum.maps.services.Geocoder();
		//주소로 좌표 검색
		//상세 주소를 형식에 맞지 않게 입력했을 때 지도에 표시가
		//안 되기 때문에 상세 주소는 표시하지 않음
		geocoder.addressSearch('${member.address1}',
				                  function(result,status){
			//정상적으로 검색이 완료되었으면
			if(status === daum.maps.services.Status.OK){
				console.log('lat:' + result[0].y);
				console.log('lng:' + result[0].x);
				var coords = new daum.maps.LatLng(
						          result[0].y,result[0].x);
				
				//결과값으로 받은 위치에 마커 표시
				var marker = new daum.maps.Marker({
					map:map,
					position:coords,
					clickable:true
				});
				//인포윈도우를 이용해서 장소에 대한 설명을 표시
				var infowindow = new daum.maps.InfoWindow({
					content:'<div style="width:300px;text-align:center;padding:6px 0;">우리집<br>${member.address1} ${member.address2}</div>',
					removable:true
				});
				
				//지도의 중심을 결과값으로 받은 위치로 이동
				map.setCenter(coords);
			}
			
			//마커에 클릭이벤트를 등록
			daum.maps.event.addListener(marker,'click',function(){
				//마커 위에 인포윈도우를 표시
				infowindow.open(map,marker);
			});
			
		});
	}
	getMyLocation();
});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h4>회원정보</h4>
		<div class="mypage-div">
			<h3>프로필 사진</h3>
			<ul>
				<li>
					<c:if test="${empty member.photo}">
					<img src="${pageContext.request.contextPath}/images/face.png" width="200" height="200" class="my-photo">
					</c:if>
					<c:if test="${!empty member.photo}">
					<img src="${pageContext.request.contextPath}/upload/${member.photo}" width="200" height="200" class="my-photo">
					</c:if>
				</li>
				<li>
					<div class="align-center">
						<input type="button" value="수정" id="photo_btn">
					</div>
					<div id="photo_choice" style="display:none;">
						<input type="file" id="photo"
						   accept="image/gif,image/png,image/jpeg">
						<br>
						<input type="button" value="전송" id="photo_submit">
						<input type="button" value="취소" id="photo_reset">   
					</div>
				</li>
			</ul>
			<h3>
				연락처
				<input type="button" value="연락처 수정"
				 onclick="location.href='modifyUserForm.do'">
			</h3>
			<ul>
				<li>아이디 : ${member.id}</li>
				<li>이름 : ${member.name}</li>
				<li>전화번호 : ${member.phone}</li>
				<li>이메일 : ${member.email}</li>
				<li>우편번호 : ${member.zipcode}</li>
				<li>주소 : ${member.address1} ${member.address2}</li>
				<li>가입일 : ${member.reg_date}</li>
				<c:if test="${!empty member.modify_date}">
				<li>최근 정보 수정일 : ${member.modify_date}</li>
				</c:if>
			</ul>
			<div id="map" style="width:100%;height:300px;"></div>
			<h3>
				비밀번호 수정
				<input type="button" value="비밀번호 수정"
				  onclick="location.href='modifyPasswordForm.do'"> 
			</h3>
			<h3>
				회원 탈퇴
				<input type="button" value="회원 탈퇴"
				  onclick="location.href='deleteUserForm.do'">
			</h3>
		</div>
		<div class="mypage-div">
			<h3>
				내가 쓴 게시물 목록(채팅)
				<input type="button" value="더보기"
				 onclick="location.href='${pageContext.request.contextPath}/board/myBoardList.do'">
			</h3>
			<table>
				<tr>
					<th>제목</th>
					<th>등록일</th>
					<th>채팅</th>
				</tr>
				<c:forEach var="myBoard" items="${myBoardList}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${myBoard.board_num}">${fn:substring(myBoard.title,0,26)}</a></td>
					<td>${myBoard.reg_date}</td>
					<td>
					<c:if test="${myBoard.chat_num > 0}">
						<input type="button" 
						 value="채팅 목록(${myBoard.unread_cnt})"
						 onclick="location.href='${pageContext.request.contextPath}/board/chatRoomList.do?board_num=${myBoard.board_num}'">
					</c:if>	 
					</td>
				</tr>
				</c:forEach>
			</table>
		
			<h3>
				내가 채팅한 게시물 목록
				<input type="button" value="더보기"
				 onclick="location.href='${pageContext.request.contextPath}/board/myChatList.do'">
			</h3>
			<table>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>채팅</th>
				</tr>
				<c:forEach var="myChat" items="${myChatList}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${myChat.board_num}">${fn:substring(myChat.title,0,26)}</a></td>
					<td>${myChat.id}</td>
					<td>${myChat.reg_date}</td>
					<td>
						<input type="button" 
						 value="채팅(${myChat.unread_cnt})"
						 onclick="location.href='${pageContext.request.contextPath}/board/chatDetail.do?board_num=${myChat.board_num}'">
					</td>
				</tr>
				</c:forEach>
			</table>
		
			<h3>
				내가 좋아하는 게시물 목록 
				<input type="button" value="더보기"
				 onclick="location.href='${pageContext.request.contextPath}/board/myBoardFavList.do'">
			</h3>
			<table>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}">${fn:substring(board.title,0,26)}</a></td>
					<td>${board.id}</td>
					<td>${board.reg_date}</td>
				</tr>	
				</c:forEach>
			</table> 
			
			<h3>주문목록
				<input type="button" value="더보기"
				 onclick="location.href='${pageContext.request.contextPath}/order/orderList.do'">
			</h3>
			<table>
				<tr>
					<th>주문번호</th>
					<th>상품명</th>
					<th>주문날짜</th>
					<th>배송상태</th>
				</tr>
				<c:forEach var="order" items="${orderList}">
				<tr>
					<td>${order.order_num}</td>
					<td><a href="${pageContext.request.contextPath}/order/orderDetail.do?order_num=${order.order_num}">${order.item_name}</a></td>
					<td>${order.reg_date}</td>
					<td>${order.statusName}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="mypage-end"></div>
	</div>
</div>
</body>
</html>




