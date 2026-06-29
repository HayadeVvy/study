<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//메시지 초기화
	$('.form-input,input[type=radio]').on('input',function(){
		$(this).parent().find('.error-text').text('');
	});
	
	$('#modify_form').submit(function(event){
		let isValid = true;
		//모든 에러 텍스트 초기화
		$('.error-text').text('');
		
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
	
	//이미지 미리보기
	$('#photo1,#photo2').change(function(){
		let my_photo = this.files[0];
		let $item_photo = 
			$(this).parent().find('.my-photo');
		if(!my_photo){
			$item_photo.attr('src',
					  '../upload/'+$item_photo.attr(
							             'data-img'));
			return;
		}
		
		if(my_photo.size > 1024 * 1024){
			alert(Math.round(my_photo.size/1024) 
					    + 'kbytes까지만 업로드 가능');
			$item_photo.attr('src',
					  '../upload/'+$item_photo.attr(
							             'data-img'));
			$(this).val('');
			return;
		}
		
		const reader = new FileReader();
		reader.readAsDataURL(my_photo);
		
		reader.onload=function(){
			$item_photo.attr('src',reader.result);
		};		
	});	
});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h4>상품 수정</h4>
		<form id="modify_form" action="adminModify.do"
		       method="post" enctype="multipart/form-data">
			<input type="hidden" name="item_num" value="${item.item_num}">
			<ul>
				<li>
					<label>상품표시여부</label>
					<input type="radio" name="status" 
					       value="1" id="status1"
					       <c:if test="${item.status==1}">checked</c:if>
					       >미표시
					<input type="radio" name="status" 
					       value="2" id="status1"
					       <c:if test="${item.status==2}">checked</c:if>
					       >표시       
				</li>
				<li>
				    <label for="name">상품명</label> 
					<input type="text" name="name" id="name"
					  maxlength="10" class="form-input"
					  value="${item.name}">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="price">가격</label> 
					<input type="number" name="price" id="price"
					  min="1" max="999999999" class="form-input"
					  value="${item.price}">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="quantity">수량</label> 
					<input type="number" name="quantity" id="quantity"
					  min="0" max="9999999" class="form-input"
					  value="${item.quantity}">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="photo1">상품사진1</label>
				    <img src="${pageContext.request.contextPath}/upload/${item.photo1}" data-img="${item.photo1}" width="50" height="50" class="my-photo"> 
					<br>
					<input type="file" name="photo1" id="photo1"
					  accept="image/gif,image/png,image/jpeg">
					<span class="error-text"></span>
				</li>
				<li>
				    <label for="photo2">상품사진2</label> 
					<img src="${pageContext.request.contextPath}/upload/${item.photo2}" data-img="${item.photo2}" width="50" height="50" class="my-photo">
					<br>
					<input type="file" name="photo2" id="photo2"
					  accept="image/gif,image/png,image/jpeg">
					<span class="error-text"></span>
				</li>
				<li>
					<label for="detail">상품설명</label>
					<textarea rows="5" cols="30" name="detail"
					  id="detail" class="form-input">${item.detail}</textarea>
					<span class="error-text"></span>  
				</li>
			</ul> 
			<div class="align-center">
				<input type="submit" value="수정">
				<input type="button" value="삭제" id="delete_btn">
				<script type="text/javascript">
					const delete_btn = 
						document.getElementById('delete_btn');
					//이벤트 연결
					delete_btn.onclick=function(){
						let choice = confirm('삭제하시겠습니까?');
						if(choice){
							location.replace(
							'adminDelete.do?item_num=${item.item_num}');
						}
					};					
				</script>
				<input type="button" value="목록"
				  onclick="location.href='adminList.do'">
			</div>      
		</form>
	</div>
</div>
</body>
</html>




