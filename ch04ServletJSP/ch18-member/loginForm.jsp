<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
window.onload=function(){
	//데이터 전송시 유효성 체크
	const myForm = document.getElementById('login_form');
	//이벤트 연결
	myForm.onsubmit=function(){
		const items = document.querySelectorAll(
                                    '.input-check');
		for(let i=0;i<items.length;i++){
			if(items[i].value.trim()==''){
				const label = 
					document.querySelector('label[for="'+items[i].id+'"]');

				alert(label.textContent + ' 필수 입력');
				items[i].value = '';
				items[i].focus();
				return false;
			}//end of if
		}//end of for			
	};
};
</script>
</head>
<body>
<div class="page-main">
	<h1>로그인</h1>
	<form action="login.jsp" method="post" 
	                                 id="login_form">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id"
				    maxlength="12" class="input-check">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd"
				   id="passwd" maxlength="12"
				   class="input-check">
			</li>
		</ul> 
		<div class="align-center">
			<input type="submit" value="로그인">
			<input type="button" value="홈으로"
			 onclick="location.href='main.jsp'">
		</div>                                
	</form>
</div>
</body>
</html>





