<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main">
	<h2>회원 로그인</h2>
	<form:form action="login.do" id="login_form"
	                            modelAttribute="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<form:label path="id">아이디</form:label>
				<form:input path="id"/>
				<form:errors path="id" cssClass="error-color"/>       
			</li>
			<li>
				<form:label path="passwd">비밀번호</form:label>
				<form:password path="passwd"/>
				<form:errors path="passwd" cssClass="error-color"/>       
			</li>
		</ul>   
		<div class="align-center">
			<input type="submit" value="로그인">
			<input type="button" value="홈으로"
			   onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>                         
	</form:form>	
</div>
<!-- 중앙 컨텐츠 끝 -->