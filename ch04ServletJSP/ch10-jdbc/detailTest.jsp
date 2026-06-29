<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil" %>    
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 보기</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		//Connection 객체 반환
		conn = DBUtil.getConnection();
	
		//SQL문 작성
		sql = "SELECT * FROM product WHERE num=?";
		
		//JDBC 수행3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setInt(1, num);		
		
		//JDBC 수행4단계 : SQL문을 테이블에 반영하고 결과행을 ResultSet에 담음
		rs = pstmt.executeQuery();
		//상품명, 가격, 재고, 원산지, 등록일
		if(rs.next()){
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			String origin = rs.getString("origin");
			String reg_date = rs.getString("reg_date");
%>
<div class="page-main">
	<h2>상품 정보</h2>
	<ul>
		<li>번호 : <%= num %></li>
		<li>상품명 : <%= name %></li>
		<li>가격 : <%= String.format("%,d원",price) %></li>
		<li>재고 : <%= String.format("%,d원",stock) %></li>
		<li>원산지 : <%= origin %></li>
		<li>등록일 : <%= reg_date %></li>
	</ul>
	<hr width="100%" size="1" noshade="noshade">
	<div class="align-right">
		<input type="button" value="수정" 
		        onclick="location.href='updateTestForm.jsp?num=<%= num %>'">
		<input type="button" value="삭제" id="delete_btn"> 
		<input type="button" value="목록"
	             onclick="location.href='selectTest.jsp'">               
	</div>
	<script type="text/javascript">
		let delete_btn = document.getElementById('delete_btn');
		//이벤트 연결
		delete_btn.onclick=function(){
			let choice = confirm('삭제하시겠습니까?');
			if(choice){
				location.replace('deleteTest.jsp?num=<%=num%>');
			}
		};
	</script>
</div>
<%			
		}else{
%>
<div class="result-display">
    <div class="align-center">
	상품 정보가 없습니다.<p>
	<input type="button" value="목록"
	             onclick="location.href='selectTest.jsp'">
	</div>
</div>	
<%			
		}
	}catch(Exception e){
%>
<div class="result-display">
    <div class="align-center">
		오류 발생! 상품 정보 호출 실패!<p>
		<input type="button" value="목록"
	             onclick="location.href='selectTest.jsp'">
	</div>
</div>	
<%		
		e.printStackTrace();
	}finally{
		//자원 정리
		DBUtil.executeClose(rs, pstmt, conn);
	}
	
%>
</body>
</html>










