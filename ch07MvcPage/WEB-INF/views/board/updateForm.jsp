<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//메시지 초기화
	$('.form-input').on('input',function(){
		$(this).parent().find('.error-text').text('');
	});
	
	$('#update_form').submit(function(event){
		let isValid = true;
		//모든 에러 텍스트 초기화
		$('.error-text').text('');
		
		$('.form-input').each(function(index,item){
			if($(item).val().trim()==''){
				$(item).val('');
				$(this).parent().find('.error-text')
				                .css('color','red')
				                .text('입력 필수');
				isValid = false;
			}
		});
		
		//하나라도 유효하지 않으면 submit 막기
		if(!isValid){
			event.preventDefault();
		}
		
	});
});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h4>글 수정</h4>
		<form id="update_form" action="update.do"
		       method="post" enctype="multipart/form-data">
			<input type="hidden" name="board_num"
			                value="${board.board_num}">
			<ul>
				<li>
				    <label for="title">제목</label> 
					<input type="text" name="title" id="title"
					  maxlength="50" class="form-input"
					  value="${board.title}">
					<span class="error-text"></span>
				</li>
				<li>
					<label for="content">내용</label>
					<textarea rows="5" cols="40" name="content"
					  id="content" class="form-input">${board.content}</textarea>
					<span class="error-text"></span>  
				</li>
				<li>
					<label for="filename">이미지</label>
					<input type="file" name="filename"
					 id="filename" 
					 accept="image/gif,image/png,image/jpeg">
					<c:if test="${!empty board.filename}">
					<div id="file_detail">
						<img src="${pageContext.request.contextPath}/upload/${board.filename}" width="100">
						<input type="button" value="파일 삭제" id="file_del">
						<script type="text/javascript">
							$(function(){
								$('#file_del').click(function(){
									let choice = confirm('삭제하시겠습니까?');
									if(choice){
										//서버와 통신
										$.ajax({
											url:'deleteFile.do',
											type:'post',
											data:{board_num:${board.board_num}},
											dataType:'json',
											success:function(param){
												if(param.result == 'logout'){
													alert('로그인 후 사용하세요');
												}else if(param.result == 'success'){
													$('#file_detail').hide();
												}else if(param.result == 'wrongAccess'){
													alert('잘못된 접속입니다.');
												}else{
													alert('파일 삭제 오류 발생');
												}
											},
											error:function(){
												alert('네트워크 오류 발생');
											}
										});
									}
								});
							});
						</script>
					</div>
					</c:if> 
				</li>
			</ul> 
			<div class="align-center">
				<input type="submit" value="수정">
				<input type="button" value="글상세"
				  onclick="location.href='detail.do?board_num=${board.board_num}'">
			</div>      
		</form>
	</div>
</div>
</body>
</html>




