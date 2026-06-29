package kr.spring.mvc09.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileRequiredValidator 
     implements ConstraintValidator<FileRequired, MultipartFile>{

	@Override
	 public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
		return file!=null && !file.isEmpty();
	 }

}
