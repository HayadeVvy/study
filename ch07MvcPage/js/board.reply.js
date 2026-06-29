$(function(){
	const rowCount = 10;
	let currentPage;
	let totalCount;
	
	/* ========================
	 * 댓글 목록 요청 및 렌더링
	 * ======================== */
	function loadReplyList(pageNum){
		currentPage = pageNum;
		$('#loading').show();
		
		//서버와 통신
		$.ajax({
			url:'listReply.do',
			type:'post',
			data:{
				  pageNum, //pageNum:pageNum
				  rowCount, //rowCount:rowCount
				  board_num:$('#board_num').val()
			  },
			dataType:'json',
			success:function(param){
				$('#loading').hide();
				totalCount = param.count;
				
				if(pageNum == 1){
					$('#output').empty();//첫 페이지일 경우 초기화
				}
				
				//댓글 리스트 렌더링
				param.list.forEach(item => {
					let html = `
						<div class="item">
							<h4>${item.id}</h4>
							<div class="sub-item">
								<p>${item.re_content}</p>
                                <span class="modify-date">${item.re_modifydate ? '최근 수정일 : ' + item.re_modifydate : '등록일 : ' + item.re_date}</span>
					`;
					if(param.user_num == item.mem_num){
						html += `
							<input type="button" data-renum="${item.re_num}" value="수정" class="modify-btn">
							<input type="button" data-renum="${item.re_num}" value="삭제" class="delete-btn">
						`;
					}
					
					html += `
								<hr size="1" noshade width="100%">
							</div>
						</div>	
					`;
					$('#output').append(html);
				});
				//페이지 버튼 처리
				//조건이 true이면 표시, false이면 미표시
				$('.paging-button').toggle(currentPage < Math.ceil(totalCount/rowCount));				
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류 발생');
			}
		});
	}
	
	/* ========================
	 * 더보기 버튼 클릭
	 * ======================== */	
	$('.paging-button input').click(()=>{
		loadReplyList(currentPage + 1);
	});
	
	/* ========================
	 * 댓글 등록
	 * ======================== */	
	$('#re_form').submit(function(event){
		//기본 이벤트 제거
		event.preventDefault();
		
		if($('#re_content').val().trim()==''){
			alert('내용을 입력하세요!');
			$('#re_content').val('').focus();
			return;		
		}
		
		//서버와 통신
		$.ajax({
			url:'writeReply.do',
			type:'post',
			data:$(this).serialize(),
			dataType:'json',
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인해야 작성할 수 있습니다.');
				}else if(param.result == 'success'){
					//폼 초기화
					resetReplyForm();
					loadReplyList(1);
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});	
	});
	
	function resetReplyForm(){
		$('#re_content').val('');
		$('#re_first .letter-count').text('300/300');
	}
	
	/* ========================
	 * 댓글 수정 폼 보여주기
	 * ======================== */	
	$(document).on('click','.modify-btn',function(){
		const re_num = $(this).data('renum');//=$(this).attr('data-renum')
		const content = $(this).siblings('p').html().replace(/<br>/gi,'\n');
		
		const modifyForm = `
			<form id="mre_form">
				<input type="hidden" name="re_num"
				                 value="${re_num}">
				<textarea rows="3" cols="50"
				 name="re_content" id="mre_content"
				 class="rep-content">${content}</textarea>
				 <div id="mre_first"><span class="letter-count">300/300</span></div>
				 <div id="mre_second" class="align-right">
				 	<input type="submit" value="수정">
					<input type="button" value="취소" class="re-reset">
				 </div>	 
			</form>
			<hr size="1" noshade width="100%">
		`;
		
		resetModifyForm();
		$(this).parent().hide();//class가 sub-item인 div 미표시
		$(this).closest('.item').append(modifyForm);
		
		//글자수 반영
		const remain = 300 - content.length;
		$('#mre_first .letter-count').text(`${remain}/300`);
		
	});	
	
	//수정폼 취소 버튼
	$(document).on('click','.re-reset',resetModifyForm);
	
	function resetModifyForm(){
		$('.sub-item').show();
		$('#mre_form').siblings('hr').remove();
		$('#mre_form').remove();
	}	
	
	/* ========================
	 * 댓글 수정
	 * ======================== */	
	$(document).on('submit','#mre_form',function(event){
		//기본 이벤트 제거
		event.preventDefault();
		
		const content = $('#mre_content').val().trim();
		if(content ==''){
			alert('내용을 입력하세요');
			$('#mre_content').val('').focus();
			return;
		}
		
		//서버와 통신
		$.ajax({
			url:'updateReply.do',
			type:'post',
			data:$(this).serialize(),
			dataType:'json',
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인해야 수정할 수 있습니다.');
				}else if(param.result == 'success'){
					const parent = $('#mre_form').parent();
					parent.find('p').html(escapeAndBr(content));
					parent.find('.modify-date').text('최근 수정일 : 5초미만');
					//수정폼 초기화
					resetModifyForm();
				}else if(param.result == 'wrongAccess'){
					alert('타인의 글을 수정할 수 없습니다.');
				}else{
					alert('댓글 수정 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
		
	});
	
	/* ========================
	 * 댓글 삭제
	 * ======================== */
	$(document).on('click','.delete-btn',function(){
		const re_num = $(this).data('renum');//data-renum
		//서버와 통신
		$.ajax({
			url:'deleteReply.do',
			type:'post',
			data:{re_num},
			dataType:'json',
			success:function(param){
				if(param.result == 'logout'){
					alert('로그인해야 삭제할 수 있습니다.');
				}else if(param.result == 'success'){
					alert('삭제 완료!');
					loadReplyList(1);
				}else if(param.result == 'wrongAccess'){
					alert('타인의 글을 삭제할 수 없습니다.');
				}else{
					alert('댓글 삭제 오류 발생');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}
		});
	});	
	
	/* ========================
	 * textarea 글자수 체크
	 * ======================== */
	$(document).on('keyup','textarea',function(){
		let text = $(this).val();
		if(text.length > 300){
			$(this).val(text.substring(0,300));
		}
		
		const remain = `${300 - $(this).val().length}/300`;
		const target = $(this).attr('id') == 're_content' ? '#re_first' : "#mre_first";
		$(`${target} .letter-count`).text(remain);
		
	});	

	/* ========================
	 * HTML 이스케이프 + 줄바꿈 처리
	 * ======================== */	
	function escapeAndBr(str){
		return str.replace(/</g, '&lt;')
		          .replace(/>/g, '&gt;')
				  .replace(/\rn|\r|\n/g, '<br>');
	}
		
	/* ========================
	 * 초기 댓글 목록 호출
	 * ======================== */	
	loadReplyList(1);
});







