package kr.spring.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.spring.todo.service.TodoService;
import kr.spring.todo.vo.TodoVO;
import lombok.extern.slf4j.Slf4j;

/*
 * REST(Representational State Transfer)의 약자.
 * 클라이언트와 서버 간의 두 컴퓨터 시스템이 인터넷을 통해 정보를
 * 안전하게 교환하기 위해 사용하는 인터페이스
 * 
 * HTTP URI(Uniform Resource Indetifier)를 이용해서
 * 자원(Resource) 명시
 * 
 * HTTP Method(POST,GET,PUT,DELETE,PATCH 등)를 통해 해당
 * 자원(URI)에 대한 CRUD Operation을 적용
 * 
 * CREATE : 데이터 생성(POST)
 * READ : 데이터 조회(GET)
 * UPDATE : 데이터 수정(PUT(전체 수정),PATCH(일부 수정))
 * DELETE : 데이터 삭제(DELETE)
 * 
 * REST의 구성 요소
 * 1)자원(Resource) : HTTP URI
 *   - 자원을 구별하는 ID는 /groups/group_id
 * 2)행위(Verb) : HTTP Method (GET,POST,PUT,DELETE,PATCH)
 * 3)표현
 *  - JSON,XML,TEXT,RSS 등 여러 형태의 응답을 받을 수 있음  
 * 
 * 적절한 HTTP 상태 코드
 * 200 OK
 * 201 Created
 * 404 Not Found
 * 500 Internal Server Error
 * 
 */

//@Controller 어노테이션과 @ResponseBody의 조합
@RestController
@Slf4j
@RequestMapping("/todo")
public class TodoRestController {
	@Autowired
	private TodoService todoService;
	
	//할 일 등록
	@PostMapping("/write")
	//@RequestBody를 이용해서 JSON 데이터를 VO 타입으로 변환
	//하도록 지정
	public ResponseEntity<Map<String,String>> write(
			            @RequestBody TodoVO todoVO){
		
		log.debug("<<할 일 등록>> : " + todoVO);
		
		Map<String,String> mapAjax = 
				new HashMap<String,String>();
		
		//할 일 등록
		todoService.insertTodo(todoVO.getTodo());
		mapAjax.put("result", "success");		
		
		return new ResponseEntity<Map<String,String>>(
				                 mapAjax,HttpStatus.OK);
	}
	
	//할 일 목록
	@GetMapping("/list")
	public ResponseEntity<List<TodoVO>> getList(){
		
		List<TodoVO> list = todoService.selectList();
		
		return new ResponseEntity<List<TodoVO>>
		                       (list,HttpStatus.OK);
	}
	
	//할 일 체크
	@PutMapping("/update")
	public ResponseEntity<Map<String,String>> modify(
			             @RequestBody TodoVO todoVO){
		log.debug("<<할 일 체크>> : " + todoVO);
		
		Map<String,String> mapAjax = 
				      new HashMap<String,String>();
		todoService.updateTodo(todoVO);
		mapAjax.put("result", "success");
		
		return new ResponseEntity<Map<String,String>>(
				                mapAjax,HttpStatus.OK);
	}

	//할 일 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,String>> delete(
			@PathVariable long id){
		
		log.debug("할 일 삭제 - id : " + id);
		
		todoService.deleteTodo(id);
		
		Map<String,String> mapAjax = 
				new HashMap<String,String>();
		mapAjax.put("result", "success");
		
		return new ResponseEntity<Map<String,String>>(
				              mapAjax,HttpStatus.OK);
	}
	
	
}










