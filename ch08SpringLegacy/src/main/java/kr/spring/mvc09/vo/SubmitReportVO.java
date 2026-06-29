package kr.spring.mvc09.vo;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.spring.mvc09.validator.FileRequired;

public class SubmitReportVO {
	@NotBlank
	private String subject;
	@FileRequired
	private MultipartFile reportFile;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MultipartFile getReportFile() {
		return reportFile;
	}
	public void setReportFile(MultipartFile reportFile) {
		this.reportFile = reportFile;
	}
	@Override
	public String toString() {
		return "SubmitReportVO [subject=" + subject + ", reportFile=" + reportFile + "]";
	}
}
