<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" 
                                      type="text/css">
</head>
<body>
<div class="page-main">
	<h2>게시판 글 상세</h2>
	<ul>
		<li>번호 : ${boardVO.num}</li>
		<li>제목 : ${boardVO.title}</li>
		<li>작성자 : ${boardVO.name}</li>
		<li>이메일 : ${boardVO.email}</li>
	</ul>
	<hr size="1" noshade="noshade" width="100%">
	<c:if test="${!empty boardVO.filename}">
	<div class="align-center">
		<img src="${pageContext.request.contextPath}/upload/${boardVO.filename}"
		                                style="max-width: 500px">
	</div>
	</c:if>
	<p>
		${boardVO.content}
	</p>
	<hr size="1" noshade="noshade" width="100%">
	<div class="align-right">
		작성일 : ${boardVO.reg_date}
		<input type="button" value="수정"
		   onclick="location.href='modifyForm.do?num=${boardVO.num}'">
		<input type="button" value="삭제"
		   onclick="location.href='deleteForm.do?num=${boardVO.num}'">
		<input type="button" value="목록"
		   onclick="location.href='list.do'">      
	</div>
</div>
</body>
</html>






