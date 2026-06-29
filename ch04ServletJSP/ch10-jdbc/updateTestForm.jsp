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
<title>상품정보 수정</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
window.onload=function(){
	let myForm = document.getElementById('myForm');
	myForm.onsubmit=function(){
		let items = document.querySelectorAll('input[type="text"],input[type="number"],textarea');
		for(let i=0;i<items.length;i++){
			if(items[i].value.trim()==''){
				let label = document.querySelector('label[for="'+items[i].id+'"]');
				alert(label.textContent + ' 필수 입력');
				items[i].value = '';
				items[i].focus();
				return false;
			}
		}
	};
};
</script> 
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
	
		//SQL문
		sql = "select * from product where num = ?";
		
		//JDBC 수행3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		
		//JDBC 수행4단계 : SQL문을 실행하고 결과행을 ResultSet에 담음
		rs = pstmt.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			String origin = rs.getString("origin");
%>			
<div class="page-main">
	<h2>상품정보 수정</h2>
	<form id="myForm" action="updateTest.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" size="20" maxlength="10" value="<%=name%>">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" value="<%=price%>"
				             min="1" max="999999999">
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" id="stock" value="<%=stock%>"
				                    min="0" max="999999999">
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin" id="place" size="20" maxlength="10" value="<%=origin%>">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="보내기">
			<input type="button" value="목록" 
			  onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>			
<%			
		}else{
%>
		<div class="result-display">
		    <div class="align-center">
				오류발생! 상품정보 수정 폼 호출 실패!<br>
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
			오류발생! 상품정보 수정 폼 호출 실패!<br>
			<input type="button" value="목록"
			    onclick="location.href='selectTest.jsp'">
			</div>    
		</div>
<%			
		e.printStackTrace();
	}finally{
		//자원정리
		DBUtil.executeClose(rs, pstmt, conn);
	}
%>
</body>
</html>






