<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//메시지 초기화
	$('.form-input').on('input',function(){
		$(this).parent().find('.error-text').text('');
	});
	
	$('#login_form').submit(function(event){
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
		<h4>로그인</h4>
		<form id="login_form" action="login.do"
		       method="post">
			<ul>
				<li class="floating-label">
					<input type="text" name="id" id="id"
					  maxlength="12" autocomplete="off"
					  class="form-input" placeholder="아이디">
					<label for="id">아이디</label>  
					<span class="error-text"></span>
				</li>
				<li class="floating-label">
					<input type="password" name="passwd" id="passwd"
					  maxlength="12" class="form-input"
					  placeholder="비밀번호">
					  <label for="passwd">비밀번호</label>
					<span class="error-text"></span>  
				</li>
			</ul> 
			<div class="align-center">
				<input type="submit" value="로그인">
				<input type="button" value="비밀번호찾기"
				    onclick="location.href='sendPasswordForm.do'">
				<input type="button" value="홈으로"
				  onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</div>      
		</form>
	</div>
</div>
</body>
</html>




