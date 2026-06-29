<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" 
                                      type="text/css">
<script type="text/javascript">
window.onload=function(){
	//데이터 전송시 유효성 체크
	const myForm = document.getElementById('delete_form');
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
	<h2>글 삭제</h2>
	<form id="delete_form" action="delete.do" method="post">
		<input type="hidden" name="num" value="${num}">
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" 
				   id="passwd" size="12" maxlength="12" class="input-check">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글 삭제">
			<input type="button" value="목록"
			    onclick="location.href='list.do'">
		</div>
	</form>
</div>
</body>
</html>







