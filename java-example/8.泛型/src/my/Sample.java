package my;

public class Sample <T>{

	T value;
	
	public void setValue (T value) {
		this.value = value;
	}
	
	public T getValue () {
		return this.value;
	}
}
