<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//메시지 초기화
	$('.form-input').on('input',function(){
		$(this).parent().find('.error-text').text('');
	});
	
	$('#write_form').submit(function(event){
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
		<h4>게시판 글쓰기</h4>
		<form id="write_form" action="write.do"
		       method="post" enctype="multipart/form-data">
			<ul>
				<li>
				    <label for="title">제목</label> 
					<input type="text" name="title" id="title"
					  maxlength="50" class="form-input">
					<span class="error-text"></span>
				</li>
				<li>
					<label for="content">내용</label>
					<textarea rows="5" cols="40" name="content"
					  id="content" class="form-input"></textarea>
					<span class="error-text"></span>  
				</li>
				<li>
					<label for="filename">이미지</label>
					<input type="file" name="filename"
					 id="filename" 
					 accept="image/gif,image/png,image/jpeg">
				</li>
			</ul> 
			<div class="align-center">
				<input type="submit" value="등록">
				<input type="button" value="목록"
				  onclick="location.href='list.do'">
			</div>      
		</form>
	</div>
</div>
</body>
</html>




