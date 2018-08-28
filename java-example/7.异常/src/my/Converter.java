package my;

public class Converter {
	public int status = 0;
//	抛出异常
	public int str3Int (String str) throws Exception {
		if (str.length() > 11) {
			throw new Exception("超出范围");
		}
		
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!isValid(ch)) {
				throw new Exception("非法字符");
			}
			
			res = res * 10 + (ch - '0');
		}
		
		return res;
	}
	
//	将字符串转成int
	public int str2Int (String str) {
		status = 0;
		if (str.length() > 11) {
			status = -2; //长度太长
			return 0;
		}
		
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!isValid(ch)) {
				status = -1;
				return 0;
			}
			
			res = res * 10 + (ch - '0');
		}
		
		return res;
	}
	
//	检查是否非法字符
	private boolean isValid (char ch) {
		if (ch >= '0' && ch<= '9') {
			return true;
		}
		
		if (ch == '-') {
			return true;
		}
		return false;
	}
 }
