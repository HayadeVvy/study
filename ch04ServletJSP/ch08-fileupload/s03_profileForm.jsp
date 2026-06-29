<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 폼</title>
<script type="text/javascript">
window.onload=function(){
	//img 태그
	const image = document.getElementById('image');
	//전송 버튼
	const submit_btn = 
		     document.getElementById('submit_btn');
	//파일을 선택할 때
	const file = document.getElementById('file');
	//이벤트 연결
	file.onchange=function(){
		if(!file.files[0]){
			      //파일을 선택한 후 다시 취소하는 경우
			image.src = '../images/face.png';
			submit_btn.style.display = 'none';
			return;
		}
		//선택한 이미지 읽기
		const reader = new FileReader();
		reader.readAsDataURL(file.files[0]);
		
		reader.onload=function(){
			image.src = reader.result;
			submit_btn.style.display = '';
		};
	};
};
</script>
</head>
<body>
<h2>프로필 사진 업로드하기</h2>
<img src="../images/face.png" width="200" height="200"
    id="image">
<form action="/ch04ServletJSP/profile" method="post"
  enctype="multipart/form-data">
	<input type="file" name="file" id="file"
	    accept="image/png,image/jpeg,image/gif">
	<input type="submit" value="전송"
	      style="display:none;" id="submit_btn">      
</form>
</body>
</html>




