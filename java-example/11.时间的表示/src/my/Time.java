package my;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.crypto.Data;

public class Time {

	public static void main(String[] args) {
		
//		2月10 --- 3月10 相差多少天
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018, 1, 10, 0, 0, 0);  //2月
		c2.set(2018, 2, 10, 0, 0, 0); //3月
		
		long delta = c2.getTimeInMillis() - c1.getTimeInMillis();
		long days = delta / (24 * 60 * 60 * 1000);
		
		System.out.println("相差" + days + "天");
		
		
		c1.add(Calendar.DAY_OF_MONTH, -15);  //2月10 前15天是多久
		
		System.out.printf("结果：%d-%d-%d",
				c1.get(Calendar.YEAR),
				c1.get(Calendar.MONTH) + 1,
				c1.get(Calendar.DAY_OF_MONTH)
		);
		System.out.println("");

//		日期格式打印
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));

	}
}
