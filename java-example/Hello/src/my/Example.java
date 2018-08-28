package my;

public class Example {
	public int number = 10;
	
	
	
	public void showNumber() {	
		System.out.println("当前值: " + number);
	}

	// 方法内有一个变量叫number ，与属性number重名,不能省略this
	public void test() {
		int number = 12; // 局部变量
		System.out.println("number is " + this.number); //
	}

	public void setNumber (int number) // 局部变量 
	{

	// 左边this.number指的是属性

	// 右边 number指的是局部变量

		this.number = number;
		System.out.println("number is " + this.number); //

	}
}
