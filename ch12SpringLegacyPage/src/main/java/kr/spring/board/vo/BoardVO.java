package kr.spring.board.vo;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	private long board_num;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private int hit;
	private Date reg_date;
	private Date modify_date;
	private MultipartFile upload;
	private String filename;
	private String ip;
	private long mem_num;
	
	private String id;
	private String nick_name;
	
	//별명이 있을 경우 별명, 별명이 없을 경우 id 반환
	public String getUserName() {
		if(nick_name!=null) return nick_name;
		else return id;
	}
}







