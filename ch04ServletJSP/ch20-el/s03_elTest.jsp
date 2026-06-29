<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 4개 영역에 저장된 데이터 읽기</title>
</head>
<body>
<%
	String str = "여름 여행";

	pageContext.setAttribute("msg1", "봄");
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
	application.setAttribute("msg4", "겨울");
%>
<%--
내장 객체명을 생략하고 속성명을 호출하면 JSP 4개 영역에서 
page,request,session,application 영역 순으로 검색해서
해당 속성명 있으면 속성값을 반환
 --%>
스크립트의 표현식 : <%= str %><br>
EL : ${str}<br>
page scope(영역) : ${pageScope.msg1}, ${msg1}<br>
request scope(영역) : ${requestScope.msg2}, ${msg2}<br>
session scope(영역) : ${sessionScope.msg3}, ${msg3}<br>
application scope(영역) : ${applicationScope.msg4}, ${msg4}
</body>
</html>







