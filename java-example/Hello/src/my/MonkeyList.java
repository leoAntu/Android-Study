package my;

public class MonkeyList {
	//创建假头节点
	private Monkey head = new Monkey(0, "石猴");
	
	//添加猴子
	public void add(Monkey m) {
		m.next = head.next;
		head.next = m;
	}
	
	//按id查找猴子
	public Monkey get (int id) {
		Monkey node = head.next;
		while (node != null) {
			if (node.id == id) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
}
