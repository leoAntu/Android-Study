package my;

public class Student {

	public String id; //学号
	public String name; //姓名
	public boolean sex; //性别
	public String cellphone; //手机
	
	public void show() {
		for(int i=0; i<10; i++) {
			System.out.println("报数: " + (i+1));
		}
	}
	
	public void show2(int number) {
		for(int i= 0; i<number; i++) {
			System.out.println("报数: " + (i+1));
		}
	}
	
	public int show3(int number) {
		return 100;
	}
	
	//重载  方法名相同，参数不同。
	public int show3(int number,int number2) {
		return number + number2;
	}
	
	@Override
	public String toString() {
		String s = "学号：" + this.id + "name：" + this.name ;
		return s;
	}
}
