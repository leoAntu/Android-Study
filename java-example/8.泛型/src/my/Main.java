package my;

public class Main {

	public static void main(String[] args) {

//	泛型实质是用 object 最为类型存储，任意类都继承object ，和oc一样
		
//		泛型的定义
//		public class Sample <T> {
//	}
		Sample<Student> aSample = new Sample<Student>();
		aSample.setValue(new Student("123"));
		Student aStudent = aSample.getValue();
		System.out.println(aStudent.name);
	
	
	}
}
