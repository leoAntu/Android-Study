package my;

//接口定义, 类似oc中的协议
public interface AudioOutput {

//	接口中定义的方法不能加大括号，必须为public
	public void play(AudioData samples);
	public void stop();
}
