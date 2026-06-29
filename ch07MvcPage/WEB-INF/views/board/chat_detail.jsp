<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<c:if test="${user_num == boardChatRoomVO.reader_num}">
		<h2>
			[${boardChatRoomVO.title}]의
			등록자 <small>${boardChatRoomVO.writer_id}</small>님과 채팅
		</h2>
		</c:if>
		<c:if test="${user_num == boardChatRoomVO.writer_num}">
		<h2>
			[${boardChatRoomVO.title}]에 관심이 있는 사용자
			<small>${boardChatRoomVO.reader_id}</small>님과 채팅
		</h2>
		</c:if>
		<div id="chatting_message"></div>
		<form id="chatting_form">
			<input type="hidden" name="chatroom_num"
			  value="${boardChatRoomVO.chatroom_num}"
			  id="chatroom_num">
			<ul>
				<li>
					<label for="message">내용</label>
					<textarea rows="5" cols="40"
					 name="message" id="message"></textarea>
					<input type="submit" value="전송">
				</li>
			</ul>  
		</form>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	const message_socket = 
		new WebSocket("ws://localhost:8080/ch07MvcPage/webSocket");
	message_socket.onopen = function(evt){
		message_socket.send("board:");
	};
	//서버로부터 메시지를 받으면 호출되는 함수 지정
	message_socket.onmessage = function(evt){
		//메시지 알림
		let data = evt.data;
		if(data.substring(0,6) == 'board:'){
			console.log('데이터 처리');
			selectData();
		}
	};
	message_socket.onclose = function(evt){
		//소켓이 종료된 후 부과적인 작업이 있을 경우 명시
		console.log('chat close');
	}
	//채팅 메시지 전송을 위한 enter key 처리
	$('#message').keydown(function(event){
		if(event.keyCode == 13 && !event.shiftKey){
			//trigger : 이벤트 발생
			$('#chatting_form').trigger('submit');
		}
	});
	
	//채팅 데이터 읽기
	function selectData(){
		//서버와 통신
		$.ajax({
			url:'chatMessageList.do',
			type:'post',
			data:{chatroom_num:$('#chatroom_num').val()},
			dataType:'json',
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인 후 사용하세요!');
					message_socket.close();
				}else if(param.result == 'success'){
					$('#chatting_message').empty();
					
					let chat_date = '';
					$(param.list).each(function(index,item){
						let output = '';
						//날짜 추출
						if(chat_date != item.chat_date.split(' ')[0]){
							chat_date = item.chat_date.split(' ')[0];
							output += '<div class="date-position"><span>'
							        + chat_date + '</span></div>';
						}
						//채팅 메시지 작성자 회원 번호와 로그인한 회원 번호 일치 여부 체크
						if(item.mem_num == ${user_num}){
							output += '<div class="from-position">'+item.id;
						}else{
							output += '<div class="to-position">'+item.id;
						}
						output += '<div class="item">';
						output += (item.read_check !=0 ? '<b>①</b>' : '') 
						       + ' <span>' + item.message + '</span>'; 
						//시간 표시
						output += '<div class="align-right">' 
						       + item.chat_date.split(' ')[1] + '</div>';
						output += '</div></div>'; 
						
						//문서 객체에 추가
						$('#chatting_message').append(output);
						//스크롤을 하단으로 위치시킴
						$('#chatting_message').scrollTop(
								      $('#chatting_message')[0].scrollHeight);
						
					});
				}else{
					alert('채팅 메시지 호출 오류');
					message_socket.close();
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
				message_socket.close();
			}
		});
	}
	
	//채팅 등록
	$('#chatting_form').submit(function(event){
		//기본 이벤트 제거
		event.preventDefault();
		
		if($('#message').val().trim()==''){
			alert('내용을 입력하세요');
			$('#mesage').val('').focus();
			return;
		}
		
		//form 이하의 태그에 입력한 데이터를 모두 읽어옴
		let form_data = $(this).serialize();
				
		//서버와 통신
		$.ajax({
			url:'chatWrite.do',
			type:'post',
			data:form_data,
			dataType:'json',
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
					message_socket.close();
				}else if(param.result == 'success'){
					//폼 초기화
					$('#message').val('').focus();
					message_socket.send('board:');
				}else{
					alert('메시지 등록 오류!');
					message_socket.close();
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
				message_socket.close();
			}
		});
	});
</script>	
</div>
</body>
</html>




