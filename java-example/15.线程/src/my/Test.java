package my;

import java.util.ArrayList;
import java.util.Random;

public class Test {

//	鸡蛋类
	class Egg {
		int id; //鸡蛋编号
		public Egg(int id) {
			this.id = id;
		}
		
		public String toString() {
			return "Egg:("+id+")";
		}
	}
	
//	母鸡（生产者）
	class Hen extends Thread {
		ArrayList<Egg> basket;
		
		public Hen (ArrayList<Egg> basket) {
			// TODO Auto-generated constructor stub
			this.basket = basket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			Random random = new Random();
			int count = 0;
			
			while(true) {
				Egg egg = new Egg(++count);
				synchronized (basket) {
					basket.add(egg);
//					发出通知
					basket.notify();
				}
				System.out.println("产出：" + egg);
				
				//休息一段时间， 1 ~ 5s随机
				int interval = 1 + random.nextInt(4);
				try {
					Thread .sleep(interval * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
//	男孩（消费者）
	class Boy extends  Thread {
		ArrayList<Egg> basket;

		public Boy (ArrayList<Egg> basket) {
			// TODO Auto-generated constructor stub
			this.basket = basket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				Egg egg = null;
				synchronized (basket) {
//					先等待，阻塞线程，直到notify发出
					try {
						basket.wait();
					} catch (InterruptedException e) {
					
					}
					
					if (basket.size() > 0) {
						egg = basket.remove(0);
					}
					
					if (egg != null) {
						System.out.println("吃掉：" + egg);
					}
					
				}
			}
		}
	}
	
	
	public void test() {
		ArrayList<Egg> basket = new ArrayList<Egg>();
		
		Hen xiaoji = new Hen(basket);
		Boy xiaoming = new Boy(basket);
		
		xiaoji.start();
		xiaoming.start();
	}
	
}
