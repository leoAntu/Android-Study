package my;


public class Constructor {
	
	public String id;

	public String name;

	public boolean sex;
	
//	构造方法，1方法名必须和类相同，2没有返回值类型
	public Constructor (String id, String name, boolean sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		
	}
	
}
