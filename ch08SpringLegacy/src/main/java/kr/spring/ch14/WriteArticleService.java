package kr.spring.ch14;

public class WriteArticleService {
	private WriteArticleDAO writeArticleDAO;

	//의존관계 설정방식 : 프로퍼티
	public void setWriteArticleDAO(WriteArticleDAO writeArticleDAO) {
		this.writeArticleDAO = writeArticleDAO;
	}
	
	public void write() {
		System.out.println(
				"WriteArticleService의 write메서드 실행");
		writeArticleDAO.insert();
	}
	
}
