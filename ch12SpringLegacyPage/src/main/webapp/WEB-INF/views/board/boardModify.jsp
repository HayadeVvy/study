<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 중앙 컨텐츠 시작 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#content').summernote({
			height:300
		});
		$('.modal input[type="text"]').css('width',530);
	});
</script>
<div class="page-main">
	<h2>글 수정</h2>
	<form:form modelAttribute="boardVO" 
	     id="update_form" enctype="multipart/form-data" 
	     action="update.do">
		<form:errors element="div" 
		                     cssClass="error-color"/>
			<form:hidden path="board_num"/>                      
		<ul>
			<li>
				<form:label path="title">제목</form:label>
				<form:input path="title"/>
				<form:errors path="title"
				             cssClass="error-color"/>
			</li>
			<li><b>내용</b></li>
			<li>
				<%-- 
			 	summernote의 이미지 처리 방식
			 	data:image/jpeg;base64 사용
			 	data:image/jpeg;base64는 데이터 URL(
			 	Data URL) 형식 중 하나로, 이미지 파일(여기서는
			 	JPEG)을 Base64 인코딩하여 텍스트 형태로 웹
			 	페이지나 애플리케니션에 직접 삽입할 수 있게 만든 
			 	표현
				 --%>
				<form:textarea path="content"/>
				<form:errors path="content"
				    cssClass="error-color"/>
			</li>
			<li>
				<form:label path="upload">이미지</form:label>
				<input type="file" name="upload"
				  id="upload" 
				  accept="image/gif,image/png,image/jpeg">
				<c:if test="${!empty boardVO.filename}">
				<div id="file_detail">
					(${boardVO.filename})파일이 등록되어 있습니다.
					<input type="button" value="파일 삭제"
					       id="file_del">
					<script type="text/javascript">
						$(function(){
							$('#file_del').click(function(){
								let choice = confirm('삭제하시겠습니까?');
								if(choice){
									$.ajax({
										url:'deleteFile.do',
										data:{board_num:${boardVO.board_num}},
										type:'post',
										dataType:'json',
										success:function(param){
											if(param.result == 'logout'){
												alert('로그인 후 사용하세요');
											}else if(param.result == 'wrongAccess'){
												alert('잘못된 접속입니다');
											}else if(param.result == 'success'){
												$('#file_detail').hide();
											}else{
												alert('파일 삭제 오류 발생');
											}
										},
										error:function(){
											alert('네트워크 오류');
										}
									});
								}
							});
						});
					</script>       
				</div>
				</c:if>  
			</li>
		</ul>    
		<div class="align-center">
			<form:button>전송</form:button>
			<input type="button" value="목록"
			       onclick="location.href='list.do'">
		</div>                                              
	</form:form>
</div>
<!-- 중앙 컨텐츠 끝 -->





