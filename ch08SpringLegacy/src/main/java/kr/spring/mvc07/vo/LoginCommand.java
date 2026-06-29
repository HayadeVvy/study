package kr.spring.mvc07.vo;

import javax.validation.constraints.NotBlank;

public class LoginCommand {
	
	@NotBlank(message = "아이디를 입력하세요")
	private String userId;
	@NotBlank(message = "비밀번호를 입력하세요")
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCommand [userId=" + userId + ", password=" + password + "]";
	}
}
