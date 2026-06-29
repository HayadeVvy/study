package kr.a25.iostream;

public class Movie {
	/*
	 * [실습]
	 * 멤버변수 : private - 영화제목(name),
	 *          제작연도(create_year),
	 *          감독(director),배우(actor),
	 *          장르(genre),상영시간(time)
	 * 멤버메서드 :public - get/set 메서드
	 */
	private String name;//영화제목
	private String create_year;//제작연도
	private String director;//감독
	private String actor;//배우
	private String genre;//장르
	private int time;//상영시간
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreate_year() {
		return create_year;
	}
	public void setCreate_year(String create_year) {
		this.create_year = create_year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return String.format(
			"%s\t%s\t%s\t%s\t%s\t%d%n",
			name,create_year,director,
			actor,genre,time);
	}
	
}







