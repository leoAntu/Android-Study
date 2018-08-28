package my;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//静态对象可以直接调用，不需要先创建对象
//		1.在第一次使用时，静态对象被创建
//		2.静态对象不会被系统回收
//		静态对象只有一个实例
		Example.s.test();
		
//		单列
		Earth.iEarth.showContries();
	}

}
