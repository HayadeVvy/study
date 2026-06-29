package kr.board.vo;

import java.sql.Date;

public class BoardVO {
	private long board_num;		//글 번호
	private String title;		//제목
	private String content;		//내용
	private int hit;			//조회수
	private Date reg_date;		//등록일
	private Date modify_date;	//수정일
	private String filename;	//파일명
	private String ip;			//ip주소
	private long mem_num;		//회원 번호
	
	private String id;			//회원 아이디
	private int auth;			//회원 등급
	private String photo;		//회원 프로필 사진명
	
	private long chat_num;		//채팅 번호
	private int unread_cnt;		//읽지 않은 채팅수

	public long getChat_num() {
		return chat_num;
	}

	public void setChat_num(long chat_num) {
		this.chat_num = chat_num;
	}

	public long getBoard_num() {
		return board_num;
	}

	public void setBoard_num(long board_num) {
		this.board_num = board_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getMem_num() {
		return mem_num;
	}

	public void setMem_num(long mem_num) {
		this.mem_num = mem_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getUnread_cnt() {
		return unread_cnt;
	}

	public void setUnread_cnt(int unread_cnt) {
		this.unread_cnt = unread_cnt;
	}
}






