package my;

import java.sql.Date;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		时间蹉
		long now = System.currentTimeMillis();
		System.out.println(now);
		
		Date date = new Date(now);
		System.out.println(date);

		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; //从0 - 11
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(min);
		System.out.println(sec);

		
		
		
	}

}
