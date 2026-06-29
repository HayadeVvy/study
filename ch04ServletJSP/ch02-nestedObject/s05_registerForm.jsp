<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]회원가입</title>
</head>
<body>
<!-- 
[전송된 데이터 출력 예시]
이름 : 홍길동
아이디 : dragon
비밀번호 : 1234
전화번호 : 010-1234-5678
취미 : 영화보기,음악감상
자기소개
서울에서 태어나서 계속 서울에서 거주
 -->
<form action="s06_register.jsp" method="post">
	<ul>
		<li>
			<label for="name">이름</label>
			<input type="text" name="name" 
			  size="10" id="name">
		</li>
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" size="30"
			   id="id">
		</li>
		<li>
			<label for="password">비밀번호</label>
			<input type="password" name="password"
			  id="password">
		</li>
		<li>
			<label for="phone">전화번호</label>
			<input type="text" name="phone" id="phone">
		</li>
		<li>
			<label>취미</label>
			<input type="checkbox" name="hobby"
			   value="영화보기">영화보기
			<input type="checkbox" name="hobby"
			   value="음악감상">음악감상
			<input type="checkbox" name="hobby"
			   value="등산">등산
			<input type="checkbox" name="hobby"
			   value="낚시">낚시           
		</li>
		<li>
			<label for="content">자기소개</label>
			<textarea rows="5" cols="60"
			   name="content" id="content"></textarea>
		</li>
	</ul>
	<input type="submit" value="전송">
</form>
</body>
</html>







