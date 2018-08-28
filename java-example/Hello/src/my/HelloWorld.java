package my;
import my.Student;
import my.Book;
import my.Scren;
import my.Example;
import my.Machine;
import my.SetterGetter;
import my.Constructor;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import javax.security.auth.Subject;
import javax.sound.midi.MidiChannel;

import af.util.AFMath; //导入不同包路径下的类

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("hello world");
//		System.out.print("我今年" + 20 + "岁");
//		
//		System.out.println("数值：" + 12345);
//		System.out.println("平方：" + (123 * 123));
//		System.out.println("立方：" + (123 * 123 * 123));
//		int 类型
		
//		double 类型
//		double c = 123.23;
//		double d = -349.0;
//		System.out.println(c + d);

//		String类型
//		String name = "山东黄金";
//		System.out.println(name);
		
//		boolean 类型 true, false
//		boolean sex = true;
//		System.out.println(sex);
		
//		基本算术操作符
//		int a = 10;
//		int b = 4;
//		boolean res = a > b;
//		System.out.println(res);

//		赋值操作符 final 代表常量，不能修改
//		final int num = 10;
////		num = 11;
//		System.out.println(num);

//		自增操作符
//		int a = 10;
//		a++;
//		System.out.println(a);

//		类型转换  boolean不支持int的转换
//		double a = 12.22;
//		int b = (int) a;
//		System.out.println(b);

//		for 循环
//		int total = 0;
//		for(int i = 1; i <= 100; i++) {
//			total += i * i;
//		}
//		System.out.println(total);

//		数组的创建
//		int[] arr = new int[30]; //创建一个长度为30的int数组
//		arr[0] = 98;
//		arr[1] = 33;
//		arr[2] = 89;
//		arr[3] = 99;
//		
//		int s = arr[0] + arr[1];
//		System.out.println(s);
////		遍历
//		for(int i = 0; i < 4; i++) {
//			System.out.println(arr[i]);
//		}
//
//		int[] arr2 = {32,34,54};	
//		System.out.println(arr2[0]);

//		class创建
//		Student s1 = new Student();
//		s1.id = "123123";
//		s1.name = "lisi";
//		s1.sex = true;
//		s1.cellphone = "13511112222";
//		System.out.println(s1.id);
//		System.out.println(s1.name);
//		System.out.println(s1.sex);
//		System.out.println(s1.cellphone);

//		Book b = new Book();
//		b.title = "c++";
//		b.price = 49.0;
		
//		class 方法
//		Student s = new Student();
//		s.show();
//		s.show2(5);
//		System.out.println(s.show3(1));
//		System.out.println(s.show3(100, 200));

//		调用当前对象
//		Scren s = new Scren();
//		s.width = 1366;
//		s.height = 768;
//		int p = s.pixel();
//		System.out.println(p);
		
//		省略与重名
//		Example example = new Example();
//		example.showNumber();
//		example.test();
//		example.setNumber(100);
		
//		游戏币插入讲解
//		Machine machine = new Machine();
//		machine.insertCash(5);
//		machine.insertCash(10);
//		int coins = machine.exchange();
//		System.out.println("拿到了" + coins + "个游戏币");		
		
//		访问修饰符 public private 
		
//		getter & setter方法
//		SetterGetter setterGetter = new SetterGetter();
//		setterGetter.setNumber(100);
//		System.out.println(setterGetter.getNumber());		

//	构造方法，1方法名必须和类相同，2没有返回值类型
//	能做更多的初始化工作。都能重载
//		Constructor constructor = new Constructor("123", "lisi", true);
//		System.out.println(constructor.name);	

//		对象的销毁 对象失去引用，会被自动回收，GC机制 （garbage collect）
		
//		继承  public class MyVideoFile extends MyFile  
//		java只能只能单继承
		
//		重写 方法上面添加 @Override
		
//		构造方法的继承
//		1.默认调用父类的无参数构造方法
//		2、父类有多个构造方法，可以指定构造方法。调用 super（123）;
//		Children children = new Children();
		
//		Object类 所有类的根父类都是Object
		
//		toString方法。  类似OC中的description方法.打印类的信息，调试的时候更方便
//		Student student = new Student();
//		student.id = "1231";
//		student.name = "lisi";
//		System.out.println(student);
		
//		多态，是指以下语法现象,			简单的讲，就是父类调用子类的方法
//		重载， 重写， 泛型
//		Pie pie = new ApplePie();
//		Baby baby = new Baby();
//		baby.eat(pie);
		
//		java 包（packgage） 就是指添加文件夹。
//		AFMath afMath = new AFMath();
		
//		静态方法static （全局方法） 既没有访问this的属性，也没有访问this的方法，是一种特殊的方法
//		特征： 1.该方法拷贝到哪个类里都行
//			  2.该方法与这个类没有特别的关系
//		调用静态方法时，不需要创建对象。 直接通过类调用（类似类方法）
//		boolean res = Machine.isPrime(100);
		
//		静态方法示例 系统自带Math
//		Math.abs(-1); //绝对值
//		Math.pow(2, 3);// 求2的3次幂
		
		
//		13.程序的入口 mian函数
	
//		14 常用工具栏的使用
//		1.字符串
//		拼接
//		String string = "hello" + "world";
//		长度
//		int n = string.length();
//		System.out.println(n);
//		空字符串 长度为0的字符串 和null是两回事，null不指向任何对象
//		String a = "";
		
//		子串 endIndex 是不包含的
//		String sub = string.substring(1, 4);
//		System.out.println(sub);

//		两个字符串是否相同 ，大小写严格判断
//		String s2 = "helloworlD";
//		if (string.equals(s2)) {
//			System.out.println("相等");
//		} else {
//			System.out.println("不相等");
//		}
		
//		按字典序比较 compareTo  compareToIgnoreCase//忽略大小写
//		String s3 = "liming";
//		String s4 = "lilei";
//		=0 两个相同
//		if (s3.compareTo(s4) < 0) {
//		}
		
//		格式化
//		String s5 = String.format("姓名：%s, 年龄：%d, 身高：%2f", "liming",15,1.75);
//		System.out.println(s5);

//		indeOf 查找子串
//		startsWith() 判断前缀
//		endsWith() 判断后缀
//		String filename = "test.mp4";
//		if (filename.endsWith("mp4")) {
//			System.out.println("相等");
//		} else {
//			System.out.println("不相等");
//		}
		
//		2.包装类
//		String string = "123";
//		int a = Integer.valueOf(string);
//		String s = String.valueOf(339);
//		System.out.println(a);
//		System.out.println(s);

//		3.控制台界面编程
//		AfConsole c = new AfConsole();
//		
//		c.print("请输入用户名: ");
//		String username = c.readString("guest");
//		
//		c.print("请输入密码: ");
//		String password = c.readString("");
//
//		
//		if(password.equals("123456"))
//		{
//			c.println(username + ",你好! 欢迎进入系统!");
//		}
//		else
//		{
//			c.println("密码错误！");
//		}

//		4.随机数 Random类
//		Random random = new Random();
//		生产三个 0-1000的数
//		for(int i = 0; i < 3; i ++) {
//			int s = random.nextInt(1000);
//			System.out.println(s);
//		}
		//员工抽奖
//		String[] names = {"shaofa","lisi","xiaoming","xiaoli","xiaohong"};
//		int s = random.nextInt(names.length - 1);
//		System.out.println("恭喜：" + names[s] + "获得特等奖");

		//员工抽奖,抽出三个一等奖
//		 int[] result = new int[3]; //结果保存数组
//		 int count = 0; //记录多少人获取
//		 while (count < 3) {
//			 //抽取一个工号
//			 int s = random.nextInt(names.length - 1);
//			 //检测s是否已经中过奖
//			 boolean exist = false;
//			 for (int i = 0; i < count; i++) {
//				if (result[i] == s) {
//					exist = true;
//					break;
//				}
//			}
//			 
//			 //如果存在，继续抽，否则就记录中奖人员的工号
//			 if (exist) {
//				continue;
//			} else {
//				result[count] = s;
//				count++;
//			}
//		 }
//		 
//		 for (int i = 0; i < result.length; i++) {
//			System.out.println("第"+ (result[i] + 1) + "号员工中奖");
//		}
	
//		5.char  只能表示一个字符，用单引号括起来
//		char c1 = 'a';
//		char c2 = '9';
//		char c3 = '你';
//		
//		int n = c1; //字符编码
//		System.out.println(n);

//		15.链表
//		Monkey m1 = new Monkey(1, "xiaoli");
//		Monkey m2 = new Monkey(2, "xiaozhang");
//		Monkey m3 = new Monkey(3, "xiaowang");
//		//连接节点
//		m1.next = m2;
//		m2.next = m3;
//		m3.next = null;
//			
//		//从尾部插入节点
//		Monkey m4 = new Monkey(4, "huahua");
//		//先找到尾节点
//		Monkey tail = m1;
//		while (tail.next != null) {
//			tail = tail.next;
//		}
//		tail.next = m4;
//		m4.next = null;
//		
//		//插入到指定位置 插入id 2的后面
//		Monkey m5 = new Monkey(5, "红红");
//		Monkey node = m1;
//		while (node != null) {
//			if (node.id == 2) {
//				m5.next = node.next;
//				node.next = m5;
//				break;
//			}
//			
//			node = node.next;
//		}
//		
//		//删除节点
//		
//		//遍历链表
//		Monkey headNode = m1; //头部
//		while (headNode != null) {
//			System.out.println(headNode.name);
//			headNode = headNode.next;
//		}
		
//	有头链表  用一个固定的假节点来充当头节点。
//		Monkey m1 = new Monkey(1, "xiaoli");
//		Monkey m2 = new Monkey(2, "xiaozhang");
//		Monkey m3 = new Monkey(3, "xiaowang");
		
		//创建一个假头节点
//		Monkey head = new Monkey(0, "石猴");
//		head.next = m1;
//		m1.next = m2;
//		m2.next = m3;
//		
//		Monkey m4 = new Monkey(4, "huahua");
//		m4.next = head.next;
//		head.next = m4;
		
		//删除节点 删除id 2的节点
//		Monkey node2 = head.next;
//		Monkey prev = head;
//		while (node2 != null) {
//			if (node2.id == 2) {
//				prev.next = node2.next;
//				break;
//			}
//			prev = node2;
//			node2 = node2.next;
//		}
		
		//方式2
//		Monkey node3 = head;
//		while (node3.next != null) {
//			if (node3.next.id == 2) {
//				node3.next = node3.next.next;
//				break;
//			}
//			node3 = node3.next;
//		}
//		
//		Monkey node = head.next;
//		while (node != null) {
//			System.out.println(node.name);
//			node = node.next;
//		}
		
//		容器封装
//		Monkey m1 = new Monkey(1, "xiaoli");
//		Monkey m2 = new Monkey(2, "xiaozhang");
//		Monkey m3 = new Monkey(3, "xiaowang");
//		
//		MonkeyList list = new MonkeyList();
//		list.add(m1);
//		list.add(m2);
//		list.add(m3);
//
//		Monkey node = list.get(2);
//		System.out.println(node.name);

//		数组链表 ArrayList 是JDK自带的容器工具类
		Monkey m1 = new Monkey(1, "xiaoli");
		Monkey m2 = new Monkey(2, "xiaozhang");
		Monkey m3 = new Monkey(3, "xiaowang");
		
		ArrayList<Monkey> list = new ArrayList<Monkey>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		list.remove(1);
		for (int i = 0; i < list.size(); i++) {
			Monkey monkey = list.get(i);
			System.out.println(monkey.name);
		}
		
		

	}

}
