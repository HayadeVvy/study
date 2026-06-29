<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="kr.util.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>  
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	int count = 0;
	
	try{
		//Connection 객체 반환
		conn = DBUtil.getConnection();
		//SQL문 작성
		sql = "SELECT COUNT(*) FROM tproduct";
		//PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//SQL문 실행
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			count = rs.getInt(1);
%>
			{
				"result":"success",
				"count":<%= count %>
			}
<%			
		}else{
%>
			{"result":"failure"}
<%			
		}
	}catch(Exception e){
%>
			{"result":"failure"}
<%		
		e.printStackTrace();
	}finally{
		DBUtil.executeClose(rs, pstmt, conn);
	}
%>  






