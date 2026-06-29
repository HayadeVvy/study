<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	//이벤트 연결
	$('#find_form').submit(function(){
		const items = document.querySelectorAll('.form-input');
		for(let i=0;i<items.length;i++){
			if(items[i].value.trim()==''){
				let label = document.querySelector(
						      'label[for="'+items[i].id+'"]');
				alert(label.textContent + ' 입력 필수');
				items[i].value = '';
				items[i].focus();
				return false;
			}//end of if
		}//end of for
	});//end of submit	
});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h4>비밀번호 찾기</h4>
		<div>
			비밀번호를 분실하셨나요?<br>
			가입할 때 사용한 아이디와 이메일을 입력하시면<br>
			이메일로 임시비밀번호를 보내드립니다.<br><br>
		</div>
		<form id="find_form" action="sendPassword.do"
		       method="post">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" id="id"
					  maxlength="12" autocomplete="off"
					  class="form-input">
				</li>
				<li>
					<label for="email">이메일</label>
					<input type="email" name="email" id="email"
					  maxlength="50" class="form-input">   
				</li>
			</ul> 
			<div class="align-center">
				<input type="submit" value="전송">
				<input type="button" value="홈으로"
				  onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</div>      
		</form>
	</div>
</div>
</body>
</html>




