package example0201.my;

public class Student
{
	public int id;  // 学号
	public String name; // 姓名
	public String phone; // 手机号
	
	public Student()
	{
		
	}
	
	public Student(int id, String name, String phone)
	{
		this.id = id;
		this.phone = phone;
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return "学号:" + id + ", 姓名:" + name + ",手机号:" + phone;
	}
	
	
}
