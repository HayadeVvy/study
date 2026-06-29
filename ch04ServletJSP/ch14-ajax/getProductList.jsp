<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="kr.util.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
[<% 
	String pageNum = request.getParameter("pageNum");
	String rowCount = request.getParameter("rowCount");
	
	if(pageNum == null) pageNum = "1";
	if(rowCount == null) rowCount = "10";
	
	int currentPage = Integer.parseInt(pageNum);
	int pageSize = Integer.parseInt(rowCount);
	
	int startRow = (currentPage-1)*pageSize + 1;
	int endRow = currentPage * pageSize;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		//Connection 객체 반환
		conn = DBUtil.getConnection();
		//SQL문 작성
		sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM "
		    + "(SELECT * FROM tproduct ORDER BY pid DESC)a) "
		    + "WHERE rnum>=? AND rnum <=?";
		//PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		//SQL문 실행
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			String pid = rs.getString("pid");
			String pname = rs.getString("pname");
			String psize = rs.getString("psize");
			String pcolor = rs.getString("pcolor");
			int pcost = rs.getInt("pcost");
			
			if(rs.getRow()>1) out.print(",");
			
%>
			{
				"pid":"<%= pid %>",
				"pname":"<%= pname %>",
				"psize":"<%= psize %>",
				"pcolor":"<%= pcolor %>",
				"pcost":<%= pcost %>
			}
<%			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBUtil.executeClose(rs, pstmt, conn);
	}	
%>]



