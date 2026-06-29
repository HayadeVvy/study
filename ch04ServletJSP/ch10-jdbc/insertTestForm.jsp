<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="../css/style.css" 
                                type="text/css">
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
<div class="page-main">
	<h2>상품 등록</h2>
	<!-- 상품명(name),가격(price),재고(stock),원산지(origin) -->
	<form id="myForm" action="insertTest.jsp" method="post">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" size="20" maxlength="10">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" min="1" max="999999999">
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" id="stock" min="0" max="999999999">
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin" id="origin" size="20" maxlength="10">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="보내기"> 
		    <input type="button" value="목록" onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>
</body>
</html>






