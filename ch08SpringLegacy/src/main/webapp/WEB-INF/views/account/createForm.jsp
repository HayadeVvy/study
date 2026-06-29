<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form:form action="create.do" modelAttribute="command">
	아이디:<form:input path="id"/>
	<form:errors path="id"/>
	<br>
	이름 : <form:input path="name"/>
	<form:errors path="name"/>
	<br>
	주소 : <form:input path="address"/>
	<form:errors path="address"/>
	<br>
	<input type="submit" value="전송">
</form:form>
</body>
</html>



