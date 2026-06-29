package kr.spring.mvc06.vo;

import javax.validation.constraints.NotBlank;

public class MemberInfo {
	/*
	 * @NotNull : null만 허용하지 않음
	 * @NotBlank : null, ""(빈문자열), " "(공백)을 허용하지 않음
	 * @NotEmpty : null과 ""(빈문자열)을 허용하지 않음
	 */
	
	@NotBlank(message = "아이디를 입력하세요")
	private String id;
	@NotBlank(message = "이름을 입력하세요")
	private String name;
	@NotBlank(message = "주소를 입력하세요")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
