package test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//抽象对象不能实例化
//		Student student = new Student();
		
//		抽象类的抽象方法在子类必须要实现
		ChildrenStory childrenStory = new ChildrenStory();
		childrenStory.name();
	}

}
