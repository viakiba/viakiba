package haust.viakiba.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 * 有误
 * @author viakiba
 *
 */
public class AesCheat {
	private Key key;
	/**
	 * AES CBC模式使用的Initialization Vector
	 */
	private IvParameterSpec iv;
	/**
	 * Cipher 物件
	 */
	private Cipher cipher;
	
	
	public AesCheat(String aesKey){
		this.key = new SecretKeySpec(getHash("MD5",aesKey), "AES");
		this.iv = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0});
		try {
			this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (final Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * 加密方法
	 * 
	 * 说明：采用128位
	 * 
	 * @return 加密结果
	 */
	public String encrypt(String data){
		try {
			byte[] bytes = data.getBytes("UTF-8");
			cipher.init(Cipher.ENCRYPT_MODE, key,iv);
			byte[] encryData = cipher.doFinal(bytes);
			
			String result = new String (Base64.encodeBase64(encryData),"UTF-8");
			
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	private static byte[] getHash(String algorithm, String aesKey) {
		try {
			byte[] bytes = aesKey.getBytes("UTF-8");
			final MessageDigest digest = MessageDigest.getInstance("algorithm");
			digest.update(bytes);
			return digest.digest();
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}
}
