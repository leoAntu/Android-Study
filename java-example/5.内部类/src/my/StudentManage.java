package my;

public class StudentManage {

	public String name;
	public void show() {
		System.out.println(this.name);
	}
	
	public void test() {
		Student student = new Student();
		student.work();
	}
	
	
//	Student 为内部类 可为public 或private
	public class Student {
		public void work() {
//			内部类 是可以在内部直接访问外部的方法和属性
			StudentManage.this.name = "sdfhsf";
			StudentManage.this.show();
		}
		
	}
	
//	静态内部类
	public static class ABC {
			public void work() {
//				StudentManage.this.name = "LISI";  不能直接访问外部的值 static已经是全局
				
				System.out.println("fasdasdasd");

			}	
	}
	
//	匿名内部类 没有类名
	public void test1() {
		AudioOutput aOutput= new AudioOutput() {
			@Override
			public void play() {
				// TODO Auto-generated method stub
				System.out.println("aaaaaaaa");
			}
		};
		
		aOutput.play();
	}
}
