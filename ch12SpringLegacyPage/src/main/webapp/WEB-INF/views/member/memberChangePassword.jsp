<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main">
	<h2>비밀번호 변경</h2>
	<form:form action="changePassword.do" id="change_form"
	                            modelAttribute="memberVO">
		<ul>
			<li>
				<form:label path="now_passwd">현재 비밀번호</form:label>
				<form:password path="now_passwd"/>
				<form:errors path="now_passwd" cssClass="error-color"/>       
			</li>
			<li>
				<form:label path="passwd">새비밀번호</form:label>
				<form:password path="passwd"/>
				<form:errors path="passwd" cssClass="error-color"/>       
			</li>
			<li>
				<label for="confirm_passwd">새비밀번호 확인</label>
				<input type="password" id="confirm_passwd">
				<span id="message_id"></span>       
			</li>
		</ul>   
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="MY페이지"
			   onclick="location.href='myPage.do'">
		</div>                         
	</form:form>	
</div>
<!-- 중앙 컨텐츠 끝 -->