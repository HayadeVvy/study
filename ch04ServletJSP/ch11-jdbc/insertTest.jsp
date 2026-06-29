<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 등록</title>
<link rel="stylesheet" href="../css/style.css" 
                                     type="text/css">                               
</head>
<body>
<%
	//전송된 데이터 반환
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	int korean = Integer.parseInt(
			   request.getParameter("korean"));
	int english = Integer.parseInt(
			   request.getParameter("english"));
	int math = Integer.parseInt(
			   request.getParameter("math"));
	int sum = korean + english + math;
	int avg = sum / 3;
	
	String grade;
	switch(avg/10){
	case 10:
	case 9: grade = "A";break;
	case 8: grade = "B";break;
	case 7: grade = "C";break;
	case 6: grade = "D";break;
	default: grade = "F";
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	int cnt = 0;
	
	try{
		//Connection 객체 반환
		conn = DBUtil.getConnection();
		//SQL문 작성
		sql = "INSERT INTO tscore (id,name,korean,english,"
		    + "math,sum,avg,grade,reg_date) VALUES "
		    + "(?,?,?,?,?,?,?,?,SYSDATE)";
		
		//JDBC 수행 3단계
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(++cnt, id);
		pstmt.setString(++cnt, name);
		pstmt.setInt(++cnt, korean);
		pstmt.setInt(++cnt, english);
		pstmt.setInt(++cnt, math);
		pstmt.setInt(++cnt, sum);
		pstmt.setInt(++cnt, avg);
		pstmt.setString(++cnt, grade);
		
		//JDBC 수행 4단계
		pstmt.executeUpdate();
%>
	<div class="result-display">
		<div class="align-center">
			성적 등록 성공!<br>
			<input type="button" value="목록보기"
			   onclick="location.href='selectTest.jsp'">
		</div>
	</div>
<%		
	}catch(Exception e){
%>
	<div class="result-display">
		<div class="align-center">
			오류 발생! 성적 등록 실패!<br>
			<input type="button" value="성적 등록폼"
			   onclick="location.href='insertTestForm.jsp'">
		</div>
	</div>
<%		
		e.printStackTrace();
	}finally{
		DBUtil.executeClose(null, pstmt, conn);
	}
%>
</body>
</html>








