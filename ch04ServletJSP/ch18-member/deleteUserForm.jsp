<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Long user_num = 
	          (Long)session.getAttribute("user_num");
	if(user_num==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인이 된 경우
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 폼</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
window.onload=function(){
	//비밀번호 확인
	const passwd = document.getElementById('passwd');
	//데이터 전송시 유효성 체크
	const myForm = document.getElementById('delete_form');
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
			
			//비밀번호와 비밀번호 확인 일치 여부 체크
			if(items[i].id == 'cpasswd' 
					      && passwd.value != items[i].value){
				alert('비밀번호와 비밀번호 확인 불일치');
				items[i].value = '';
				items[i].focus();
				return false;
			}
			
		}//end of for			
	};
};
</script>
</head>
<body>
<div class="page-main">
	<h1>회원탈퇴</h1>
	<form action="deleteUser.jsp" method="post" 
	                                 id="delete_form">
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
			<li>
				<label for="cpasswd">비밀번호 확인</label>
				<input type="password" name="cpasswd"
				   id="cpasswd" maxlength="12"
				   class="input-check">
			</li>
		</ul> 
		<div class="align-center">
			<input type="submit" value="회원탈퇴">
			<input type="button" value="MyPage"
			 onclick="location.href='myPage.jsp'">
		</div>                                
	</form>
</div>
</body>
</html>
<%
	}
%>












