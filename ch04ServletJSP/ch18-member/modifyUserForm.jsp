<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.member.dao.MemberDAO" %>
<%@ page import="kr.member.vo.MemberVO" %>
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
<title>회원정보수정</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	//데이터 전송시 유효성 체크
	$('#modify_form').submit(function(){
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
			}			
		}
	});
});
</script>
</head>
<body>
<%
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO member = dao.getMember(user_num);
	if(member.getPhone()==null){
		member.setPhone("");
	}
%>
<div class="page-main">
	<h1>회원정보수정</h1>
	<form action="modifyUser.jsp" method="post"
	                                id="modify_form">
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
				  class="input-check" maxlength="10"
				  value="<%= member.getName() %>">         
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" 
				  id="passwd" class="input-check" 
				                    maxlength="12">         
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email"
				  class="input-check" maxlength="50"
				  value="<%= member.getEmail() %>">         
			</li>
			<li>
				<label for="phone">전화번호</label>
				<input type="text" name="phone" id="phone"
				  maxlength="15"
				  value="<%= member.getPhone() %>">         
			</li>
		</ul>    
		<div class="align-center">
			<input type="submit" value="수정">
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





