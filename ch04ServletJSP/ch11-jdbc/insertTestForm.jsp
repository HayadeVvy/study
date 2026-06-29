<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 등록</title>
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
	<h2>성적 등록</h2>
	<form id="myForm" action="insertTest.jsp" 
	                                   method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id"
				       size="20" maxlength="10">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
				                 size="20" maxlength="10">
			</li>
			<li>
				<label for="korean">국어</label>
				<input type="number" name="korean" id="korean"
				      min="0" max="100">
			</li>
			<li>
				<label for="english">영어</label>
				<input type="number" name="english" id="english"
				      min="0" max="100">
			</li>
			<li>
				<label for="math">수학</label>
				<input type="number" name="math" id="math"
				      min="0" max="100">
			</li>
		</ul> 
		<div class="align-center">
			<input type="submit" value="보내기">
			<input type="button" value="목록"
			    onclick="location.href='selectTest.jsp'">
		</div>                                  
	</form>
</div>
</body>
</html>





