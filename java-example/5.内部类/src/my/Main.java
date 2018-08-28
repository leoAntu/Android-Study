package my;

import my.StudentManage.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		内部类，在实际中使用并不常见
		StudentManage studentManage = new StudentManage();
		studentManage.test();
		
//		静态内部类
		StudentManage.ABC a = new StudentManage.ABC();
		a.work();
		
//		匿名内部类 没有类名
		studentManage.test1();
		
	}

}
