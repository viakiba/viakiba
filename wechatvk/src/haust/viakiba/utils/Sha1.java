package haust.viakiba.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Sha1 {
	
	public static String getSHA1(String token, String timestamp, String nonce)  {
        String[] array = new String[] { token, timestamp, nonce };
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < 3; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        // SHA1签名生成
        try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
			    shaHex = Integer.toHexString(digest[i] & 0xFF);
			    if (shaHex.length() < 2) {
			        hexstr.append(0);
			    }
			    hexstr.append(shaHex);
			}
			System.out.println(hexstr);
			return hexstr.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
}
	
}
