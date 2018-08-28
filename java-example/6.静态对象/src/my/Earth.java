package my;

//单例
public class Earth {

	public static Earth iEarth = new Earth();
//	构造方法，设为私有
	private Earth () {
		
	}
	
	public void showContries() {
		System.out.println("单例");
	}
}
