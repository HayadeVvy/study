package kr.spring.mvc08.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class MemberCommand {
	//정규표현식으로 패턴 검사
	@Pattern(regexp="^[0-9a-zA-Z]+$",message="영문,숫자만 입력 가능")
	private String id;
	//문자열의 길이 지정
	@Size(min=4,max=10)
	private String password;
	@NotBlank
	private String name;
	@NotNull
	@Range(min=1,max=200)
	//타입을 int로 하면 기본 셋팅할 때 input태그에 0이 보여지는
	//Integer로 하면 null이기 때문에 input태그에 아무것도 표시하지 않음
	private Integer age;
	@NotBlank
	@Email
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberCommand [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", email="
				+ email + "]";
	}
}
