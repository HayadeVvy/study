<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil" %> 
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 삭제</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%
	//전송된 데이터 반환
    int num = Integer.parseInt(request.getParameter("num"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try{
		//Connection 객체 생성
		conn = DBUtil.getConnection();
	
		//SQL문
		sql = "DELETE FROM product WHERE num = ?";
		
		//JDBC 수행3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,num);
		
		//JDBC 수행4단계 : SQL문 실행
		pstmt.executeUpdate();
%>
		<div class="result-display">
			상품 정보 삭제 완료!<p>
			<input type="button" value="목록 보기"
			    onclick="location.href='selectTest.jsp'">
		</div>
<%		
	}catch(Exception e){
%>
		<div class="result-display">
			오류 발생! 상품 정보 삭제 실패!<p>
			<input type="button" value="목록 보기"
			        onclick="location.href='selectTest.jsp'">
		</div>
<%		
		e.printStackTrace();
	}finally{
		//자원 정리
		DBUtil.executeClose(null, pstmt, conn);
	}
%>
</body>
</html>








