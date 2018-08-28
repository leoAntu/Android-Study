package my;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/dingdongqianbaofuyin/eclipse/12.文件操作/abc.txt");
//		文件相关操作
		if (file.exists()) {
			System.out.println("存在");
		} else {
			System.out.println("不存在");
		}
		
		if (file.isFile()) {
			System.out.println("是文件");
		} else {
			System.out.println("不是文件");
		}
		
//		文件长度
		System.out.println(file.length());
//		最后修改时间
		long last = file.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date(last));
		System.out.println(time);

		
//		目录相关操作
		File d = new File("/Users/dingdongqianbaofuyin/eclipse/12.文件操作/images");
//		创建images目录
		d.mkdirs();
		
//		查看有多少子目录  只扫描一级子目录
		File d2 = new File("/Users/dingdongqianbaofuyin/eclipse");
		
		File[] subFile = d2.listFiles();
		for (File f : subFile) {
			if (f.isDirectory()) {
				System.out.println("扫描到目录:" + f);
			} else {
				System.out.println("扫描到文件:" + f);
			}
		}
	}

}
