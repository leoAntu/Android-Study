package my;

public class Machine {
	public int money = 0;
	//插入RMB 1,5,10
	public void insertCash (int cash) {
		if (cash > 10) {
			System.out.println("只能识别1，5，10元");
			return;
		}
		
		this.money += cash;
		System.out.println("当前余额：" + this.money);
	}
	//显示当前余额
	public void show() {
		System.out.println(money);
	}
	
	//交易完成,吐出游戏币
	public int exchange() {
		int numofCoin = this.money / 1;
		this.money = 0;
		System.out.println("交易完成， 当前余额: " + this.money);
		return numofCoin;
	}
}
