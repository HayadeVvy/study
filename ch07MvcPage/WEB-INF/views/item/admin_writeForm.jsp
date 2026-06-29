<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//메시지 초기화
	$('.form-input,input[type=radio]').on('input',function(){
		$(this).parent().find('.error-text').text('');
	});
	
	$('#write_form').submit(function(event){
		let isValid = true;
		//모든 에러 텍스트 초기화
		$('.error-text').text('');
		
		if($('input[type=radio]:checked').length < 1){
			$('input[type=radio]').parent().find('.error-text')
			                .css('color','red')
			                .text('선택 필수');
			isValid = false;			
		}
		
		$('.form-input').each(function(index,item){
			if($(item).val().trim()==''){
				$(item).val('');
				$(this).parent().find('.error-text')
				                .css('color','red')
				                .text('입력 필수');
				isValid = false;
			}
		});
		
		//하나라도 유효하지 않으면 submit 막기
		if(!isValid){
			event.preventDefault();
		}
		
	});
});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h4>상품 등록</h4>
		<form id="write_form" action="adminWrite.do"
		       method="post" enctype="multipart/form-data">
			<ul>
				<li>
					<label>상품표시여부</label>
					<input type="radio" name="status" 
					       value="1" id="status1">미표시
					<input type="radio" name="status" 
					       value="2" id="status1">표시
					<span class="error-text"></span>       
				</li>
				<li>
				    <label for="name">상품명</label> 
					<input type="text" name="name" id="name"
					  maxlength="10" class="form-input">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="price">가격</label> 
					<input type="number" name="price" id="price"
					  min="1" max="999999999" class="form-input">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="quantity">수량</label> 
					<input type="number" name="quantity" id="quantity"
					  min="0" max="9999999" class="form-input">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="photo1">상품사진1</label> 
					<input type="file" name="photo1" id="photo1"
					  accept="image/gif,image/png,image/jpeg" 
					  class="form-input">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="photo2">상품사진2</label> 
					<input type="file" name="photo2" id="photo2"
					  accept="image/gif,image/png,image/jpeg" 
					  class="form-input">
					<span class="error-text"></span>
				</li>
				<li>
					<label for="detail">상품설명</label>
					<textarea rows="5" cols="30" name="detail"
					  id="detail" class="form-input"></textarea>
					<span class="error-text"></span>  
				</li>
			</ul> 
			<div class="align-center">
				<input type="submit" value="등록">
				<input type="button" value="목록"
				  onclick="location.href='adminList.do'">
			</div>      
		</form>
	</div>
</div>
</body>
</html>




