package haust.viakiba.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
/**
 * 有误
 * @author viakiba
 *
 */
public class Md5Cheat {
	/**
	 * MD5加密算法
	 * 
	 * 说明：32位加密算法
	 * 
	 * @param 待加密的数据
	 * @return 加密结果，全小写的字符串
	 */
	public static String MD5(String s){
		char hexDigits[] = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f'	};
		
		try {
			byte[] btInput = s.getBytes("utf-8");
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			//
			mdInst.update(btInput);
			//获得秘闻
			byte[] md = mdInst.digest();
			//把秘闻转为16进制
			int j = md.length;
			char str[] = new char[j*2];
			int k = 0;
			for(int i = 0 ; i<j ; i++){
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			
			return new String(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
	}
}
