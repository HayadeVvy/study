<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Long user_num = (Long)session.getAttribute("user_num");
	if(user_num==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 탈퇴 폼</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		const form = document.getElementById('delete_form');
		const passwd = document.getElementById('passwd');
		form.onsubmit = function(){
			const items = 
				document.querySelectorAll('.input-check');
			for(let i=0;i<items.length;i++){
				if(items[i].value.trim()==''){
					const label = document.querySelector(
							'label[for="'+items[i].id+'"]');
					alert(label.textContent + ' 입력 필수');
					items[i].value = '';
					items[i].focus();
					return false;
				}//end of if
				
				//비밀번호와 비밀번호 확인 일치 여부 체크
				if(items[i].id == 'cpasswd' && 
						 passwd.value != items[i].value){
					alert('비밀번호와 비밀번호 확인이 불일치합니다.');
					items[i].value = '';//데이터 초기화
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
	<h1>사원탈퇴</h1>
	<form id="delete_form" action="deleteUser.jsp" method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id"
				   class="input-check" maxlength="12">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd"
				    class="input-check" maxlength="12">
			</li>
			<li>
				<label for="cpasswd">비밀번호 확인</label>
				<input type="password" id="cpasswd"
				      class="input-check" maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="사원탈퇴">
			<input type="button" value="홈으로"
			       onclick="location.href='main.jsp'">
		</div>
	</form>
</div>
</body>
</html>
<%
	}
%>






