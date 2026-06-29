package kr.a22.util;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		int year = today.get(Calendar.YEAR);//연
		                    //월 0 ~ 11
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);//일
		
		System.out.printf(
				"%d년%d월%d일 ",year,month,date);
		
		                   //요일 1(일) ~ 7(토)
		int day = today.get(Calendar.DAY_OF_WEEK);
		
		String[] days = 
			{"일","월","화","수","목","금","토"};
		System.out.print(days[day-1]+"요일");
		                    //오전 0, 오후 1
		int amPm = today.get(Calendar.AM_PM);
		String str = 
			amPm == Calendar.AM ? "오전" : "오후";
		
		//0~11, 정오와 자정은 12 아니라 0으로 표시 됨
		int hour = today.get(Calendar.HOUR);//시 HOUR_OF_DAY(24시 표기)
		int min = today.get(Calendar.MINUTE);//분
		int sec = today.get(Calendar.SECOND);//초
		
		System.out.printf(
				" %s %d시%d분%d초",str,hour,min,sec);
		
	}
}



