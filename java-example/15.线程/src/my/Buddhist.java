package my;

public class Buddhist extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 500; i++) {
			System.out.println("q11111111");	
//			线程的调度 sleep
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
