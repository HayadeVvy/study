package kr.spring.mvc06.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.mvc06.vo.MemberInfo;

public class MemberInfoValidator implements Validator {

	//Validator가 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	/*
	 * 유효성 체크를 수행하는 메서드
	 * target 객체에 대한 검증을 실행하고 검증 결과 문제가 있을
	 * 경우 errors 객체에 어떤 문제인지에 대한 정보를 저장
	 */
	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo)target;
		if(memberInfo.getId()==null || 
				memberInfo.getId().trim().isEmpty()) {
			                  //필드   //에러코드		 
			errors.rejectValue("id", "required");
		}
		if(memberInfo.getName()==null || 
				memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if(memberInfo.getAddress()==null ||
				memberInfo.getAddress().trim().isEmpty()) {
			errors.rejectValue("address", "required");
		}
		
	}

}



