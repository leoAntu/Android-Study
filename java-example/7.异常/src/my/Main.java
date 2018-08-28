package my;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//一般的容错处理
		Converter oConverter = new Converter();
		int res = oConverter.str2Int("123er");
		if (oConverter.status == 0) {
			System.out.println(res);
		} else {
			System.out.println("失败");
		}
		
//		异常机制 进行出错处理
		try {
			int res2 = oConverter.str3Int("123we");
			System.out.println(res2);
		} catch (Exception e) {
			System.out.println(e);
		}
		
//		自定义异		创建Exception的子类就行，想怎么定义都行
//		依次的匹配不同的错误类，直到找到相应的处理
//		try {
//			
//		} catch (Exception e) {
//		} catch (自定义Exception e) {
//			
//		} finally {  // 最后执行的一步操作，可以用来做清理工作，比如关闭文件，数据库等操作
//		}
		
	}

}
