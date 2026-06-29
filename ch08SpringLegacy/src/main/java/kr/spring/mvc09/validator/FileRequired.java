package kr.spring.mvc09.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*
 * 커스텀 Bean Validation 어노테이션(@FileRequired)을 정의
 * MutipartFile이 비어있거나 null인지 검사
 */

//어노테이션이 JavaDoc 문서 생성시 포함되도록 설정.
//개발자가 API 문서를 볼 때 @FileRequired가 표시
@Documented
//Bean Validation에게 "이 어노테이션은 검증용이다"라고 알려줌
//실제 검증 로직은 FileRequiredValidator 클래스에서 수행
@Constraint(validatedBy = FileRequiredValidator.class)
//이 어노테이션을 어디에 붙일 수 있는지 지정 필드 또는 메서드 파라미터에 표시 가능
@Target({ElementType.FIELD, ElementType.PARAMETER})
//어노테이션 정보를 JVM 실행 시점까지 유지.
//Validation 프레임워크가 런타임에 
//이 어노테이션을 읽어 검증할 수 있게 해줌
@Retention(RetentionPolicy.RUNTIME)
public @interface FileRequired {
	//검증 실패 시 사용할 기본 오류 메시지
	String message() default "파일은 필수입니다.";
	//Validation Group 기능을 위한 속성. 대부분의 경우 기본값 그대로 
	//사용
	Class<?>[] groups() default {};
	
	//검증 오류에 추가 메타데이터를 전달할 때 사용.
	//실무에서는 거의 사용하지 않음
	Class<? extends Payload>[] payload() default {};
}



