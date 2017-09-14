package com.yuncanting.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Description 安全工具类
 * @Author viakiba
 * @Date 2017-09-03
 */
@Component
public class SecurityUtil {
    public static final String key = "karanotesviakiba";

    public SecurityUtil() {
    }

    private static final String[] hexDigits = { "v", "1", "i", "3", "a", "5", "k", "7", "i", "9", "b", "b", "a", "d", "e", "f" };


    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) throws Exception{
        String resultString = null;
        resultString = new String(origin);
        MessageDigest md = MessageDigest.getInstance("MD5");
        resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        return resultString;
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b
     * 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public String getSHA1(String token, String timestamp, String nonce)  {
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
