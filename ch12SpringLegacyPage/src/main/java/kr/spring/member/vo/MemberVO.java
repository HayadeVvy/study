package kr.spring.member.vo;

import java.io.IOException;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.mindrot.bcrypt.BCrypt;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//byte[]타입의 photo 프로퍼티는 제외
//toString()를 실행할 때 느려지는 현상
@ToString(exclude = "photo")
public class MemberVO {
	private long mem_num;
	@Pattern(regexp="^[A-Za-z0-9+]{4,12}$")
	private String id;
	private String nick_name;
	private int auth;
	@NotBlank
	private String name;
	@Size(min=4,max=10)
	private String passwd;
	@NotBlank
	private String phone;
	@Email
	@NotBlank
	private String email;
	@Size(min=5,max=5)
	private String zipcode;
	@NotBlank
	private String address1;
	@NotBlank
	private String address2;
	private byte[] photo;
	private String photo_name;
	private Date reg_date;
	private Date modify_date;
	
	//비밀번호 변경시 현재 비밀번호를 저장하는 용도로 사용
	//회원 가입, 회원정보 수정 폼에서 데이터 전송시 now_passwd
	//를 표시하지 않기 때문에 name이 전송되지 않아 에러가 발생하지
	//않음
	@Size(min=4,max=10)
	private String now_passwd;
	
	//별명이 있을 경우 별명, 별명이 없을 경우 id 반환
	public String getUserName() {
		if(nick_name!=null) return nick_name;
		return id;
	}
	
	//비밀번호 일치 여부 체크
	public boolean isCheckedPasswd(String userPasswd) {
		if(auth > 1 && BCrypt.checkpw(userPasswd, passwd)) {
			return true;
		}
		return false;
	}
	
	//이미지 BLOB 처리
	public void setUpload(MultipartFile upload)
	                             throws IOException{
		//MultipartFile -> byte[]
		setPhoto(upload.getBytes());
		//파일 이름
		setPhoto_name(upload.getOriginalFilename());
	}
}







