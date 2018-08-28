package my;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		线程机制 两个类都继承 Thread， 重写run方法。 再调用start启动

//		Buddhist b = new Buddhist();
//		b.start();;
//		
//		Confucian confucian = new Confucian();
//		confucian.start();;
		
//		线程的调度 sleep
		
//		线程的创建，两种方法：1.继承Thread。 2。实现Runnable接口
//		为什么有两种实现。。因为java不能实现多继承，如果你的类已经继承了别的类，又要作为线程使用，只能用这种方法
//		PepeoA a = new PepeoA();
//		PepeoB b2 = new PepeoB();
//		
//		Thread thread = new Thread(a);
//		thread.start();
//		Thread thread2 = new Thread(b2);
//		thread2.start();
		
//		匿名类实现线程, 更方便的创建使用，不需要再去创建类继承
//		Thread t2 = new Thread() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for (int i = 0; i < 500; i++) {
//					System.out.println("bbbsdfsdfsfds");	
////					线程的调度 sleep
////					try {
////						Thread.sleep(100);
////					} catch (InterruptedException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
//				}
//			}
//		};
//		t2.start();
		
//		线程的终止，run退出后，就终止了， 如果想提前终止，只能使用break,或者return
//		Thread t3 = new Thread() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for (int i = 0; i < 500; i++) {
//					System.out.printf("%d\n", i);	
//					if (i== 100) {
//						break;
//					}
//				}
//			}
//		};
//		t3.start();
		
//	等待线程退出
//		Buddhist b = new Buddhist();
//		b.start();
//		b.join(); //等待作用
////		先等b完成后，在执行下面的事情
//
//		for (int i = 0; i < 3; i++) {
//			System.out.println("我自己的事情");
//		}
//		System.out.println("exit");
		
//		线程的同步机制 synchronized(obj){}  //互斥锁  obj指任意对象
//		注意不要死锁
		
//		线程的通知机制 wait - notify  1.必须结合synchronized使用，2.obj必须是一个对象 
		Test t = new Test();
		t.test();
		
	}

}
