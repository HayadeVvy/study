<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>    
<%
	Long user_num = 
	         (Long)session.getAttribute("user_num");
	if(user_num==null){//로그인이 되지 않은 경우
		response.sendRedirect("loginForm.jsp");
	}else{//로그인 된 경우
		long board_num = Long.parseLong(
				  request.getParameter("board_num"));
	    BoardDAO dao = BoardDAO.getInstance();
	    BoardVO board = dao.getBoard(board_num);
	    //로그인한 회원번호와 작성자 회원번호 일치 여부 체크
	    if(user_num == board.getNum()){
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
window.onload=function(){
	//데이터 전송시 유효성 체크
	const myForm = document.getElementById('update_form');
	//이벤트 연결
	myForm.onsubmit=function(){
		const items = document.querySelectorAll(
                                    '.input-check');
		for(let i=0;i<items.length;i++){
			if(items[i].value.trim()==''){
				const label = 
					document.querySelector('label[for="'+items[i].id+'"]');

				alert(label.textContent + ' 필수 입력');
				items[i].value = '';
				items[i].focus();
				return false;
			}//end of if
		}//end of for			
	};
};
</script>
</head>
<body>
<div class="page-main">
	<h1>글 수정</h1>
	<form id="update_form" action="update.jsp" 
	                                  method="post">
	    <input type="hidden" name="board_num" 
	                       value="<%= board_num %>">                              
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"
				     size="30" maxlength="50"
				     class="input-check"
				     value="<%= board.getTitle() %>">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" 
				id="content" class="input-check"><%= board.getContent() %></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글 수정">
			<input type="button" value="목록"
			       onclick="location.href='list.jsp'">
		</div>                                  
	</form>
</div>
</body>
</html>
<%
	}else{
%>
	<script>
		alert('잘못된 접속입니다.');
		location.replace('list.jsp');
	</script>
<%		
	}
}
%>










