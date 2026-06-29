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
<title>글 수정</title>
<link rel="stylesheet" href="../css/style.css" 
                                   type="text/css">
<script type="text/javascript">
window.onload=function(){
	const myForm = document.getElementById('myForm');
	//이벤트 연결
	myForm.onsubmit=function(){
		const items = document.querySelectorAll(
				    'input[type="text"],input[type="password"],textarea');
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
	<h2>글 수정</h2>
<%
	int num = Integer.parseInt(
			          request.getParameter("num"));
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	try{
		conn = DBUtil.getConnection();
		//SQL문 작성
		sql = "SELECT * FROM tboard WHERE num=?";
		//JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//?에 데이터 바인딩
		pstmt.setInt(1,num);
		//JDBC 수행 4단계 : SQL문을 테이블에 반영하고 
		//결과행을 ResultSet에 담음
		rs = pstmt.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			String title = rs.getString("title");
			String content = rs.getString("content");
%>
	<form id="myForm" action="updateTest.jsp" 
	                                  method="post">
		<input type="hidden" name="num" value="<%= num %>">                                  
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
				   size="20" maxlength="10" value="<%= name %>">
			</li>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"
				   size="30" maxlength="50" value="<%= title %>">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd"
				  id="passwd" size="20" maxlength="10">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40"
				  name="content" id="content"><%= content %></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록"
			   onclick="location.href='selectTest.jsp'">
		</div>
	</form>
<%			
		}else{
%>
<div class="result-display">
	<div class="align-center">
		수정할 글 정보 호출 실패!<br>
		<input type="button" value="게시판 목록"
		  onclick="location.href='selectTest.jsp'">
	</div>
</div>
<%			
		}
	}catch(Exception e){
%>
<div class="result-display">
	<div class="align-center">
		오류 발생! 수정할 글 정보 호출 실패!<br>
		<input type="button" value="게시판 목록"
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
</div>
</body>
</html>




