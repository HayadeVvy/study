<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" 
                                      type="text/css">
<script type="text/javascript">
window.onload=function(){
	//데이터 전송시 유효성 체크
	const myForm = document.getElementById('modify_form');
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
	<h2>글 수정</h2>
	<form id="modify_form" action="modify.do" method="post"
	                     enctype="multipart/form-data">
		<input type="hidden" name="num" value="${boardVO.num}">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"
				   size="30" maxlength="50" class="input-check"
				   value="${boardVO.title}">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
				   size="10" maxlength="10" class="input-check"
				   value="${boardVO.name}">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" 
				   id="passwd" size="12" maxlength="12" 
				   class="input-check"
				   placeholder="*등록한 비밀번호 입력">
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email"
				   size="20" maxlength="50" class="input-check"
				   value="${boardVO.email}">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40"
				  name="content" id="content" 
				  class="input-check">${boardVO.content}</textarea>
			</li>
			<li>
				<label for="filename">사진</label>
				<input type="file" name="filename"
				 id="filename" 
				 accept="image/gif,image/png,image/jpeg">
				 <c:if test="${!empty boardVO.filename}">
				 <br>
				 <img src="${pageContext.request.contextPath}/upload/${boardVO.filename}"
				                width="100" style="margin-left:125px;">
				 </c:if>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글 수정">
			<input type="button" value="목록"
			    onclick="location.href='list.do'">
		</div>
	</form>
</div>
</body>
</html>







