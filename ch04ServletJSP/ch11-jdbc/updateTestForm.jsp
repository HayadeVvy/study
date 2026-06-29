<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 수정</title>
<link rel="stylesheet" href="../css/style.css" 
                                      type="text/css">
<script type="text/javascript">
window.onload=function(){
	const myForm = document.getElementById('myForm');
	//이벤트 연결
	myForm.onsubmit=function(){
		const items = document.querySelectorAll(
				    'input[type="text"],input[type="number"]);
		for(let i=0;i<items.length;i++){
			if(items[i].value.trim()==''){
				const label = 
					document.querySelector(
							'label[for="'+items[i].id+'"]');
				alert(label.textContent + ' 필수 입력');
				items[i].value = '';
				items[i].focus();
				return false;
			}
		}
	};
}
</script>                                                   
</head>
<body>
<div class="page-main">
	<h2>성적 수정</h2>
<%
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		//Connection 객체 반환
		conn = DBUtil.getConnection();
		//SQL문 작성
		sql = "SELECT * FROM tscore WHERE id=?";
		//PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setString(1, id);
		//ResultSet 반환
		rs = pstmt.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			int korean = rs.getInt("korean");
			int english = rs.getInt("english");
			int math = rs.getInt("math");
%>
	<form id="myForm" action="updateTest.jsp" 
	                                   method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="hidden" name="id" 
				                     value="<%= id %>">
				<%= id %>                     
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
				     value="<%= name %>" 
				     size="20" maxlength="10">
			</li>
			<li>
				<label for="korean">국어</label>
				<input type="number" name="korean" id="korean"
				      min="0" max="100"
				      value="<%= korean %>">
			</li>
			<li>
				<label for="english">영어</label>
				<input type="number" name="english" id="english"
				      min="0" max="100"
				      value="<%= english %>">
			</li>
			<li>
				<label for="math">수학</label>
				<input type="number" name="math" id="math"
				      min="0" max="100"
				      value="<%= math %>">
			</li>
		</ul> 
		<div class="align-center">
			<input type="submit" value="보내기">
			<input type="button" value="목록"
			    onclick="location.href='selectTest.jsp'">
		</div>                                  
	</form>
<%			
		}else{
%>
	<div class="result-display">
		<div class="align-center">
			오류 발생! 성적 수정 폼 호출 실패!<p>
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
			오류 발생! 성적 수정 폼 호출 실패!<p>
			<input type="button" value="목록"
			   onclick="location.href='selectTest.jsp'">
		</div>
	</div>
<%		
		e.printStackTrace();
	}finally{
		DBUtil.executeClose(rs, pstmt, conn);
	}
%>	
</div>
</body>
</html>








