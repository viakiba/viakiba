package org.vk.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author viakiba
 * @description
 * @date Create in 22:23 2018/8/6
 */
@Slf4j
public class JoseUtil {

    /**
     * @description 产生一对公私钥对
     * @date: 22:49 2018/7/30
     * @params [keyPairType, keyPairLength]
     * @return RsaKey
     * @author viakiba
     */
    public RsaKey genKeyPair(String keyPairType, int keyPairLength){
        KeyPairGenerator keyPairGen = null;
        RSAPrivateKey privateKey = null;
        RSAPublicKey publicKey = null;
        RsaKey rsaKey = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance(keyPairType);
            keyPairGen.initialize(keyPairLength);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            publicKey = (RSAPublicKey) keyPair.getPublic();
            privateKey = (RSAPrivateKey) keyPair.getPrivate();
            rsaKey = new RsaKey(publicKey.getModulus(),publicKey.getPublicExponent(),privateKey.getPrivateExponent());
            log.info(rsaKey.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return rsaKey;
    }

    /**
     *  获取指定位数的随机字节数组
     * @param size
     * @return
     */
    public static byte[] randomByte(int size){
        byte[] bytes = new byte[size];
        try {
            SecureRandom secureRandom3 = SecureRandom.getInstance("SHA1PRNG");
            secureRandom3.nextBytes(bytes);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * @description 存储RSA产生的公私钥信息
     * @author viakiba
     * @date Create in 22:38 2018/7/30
     */
    @Slf4j
    @AllArgsConstructor
    @Data
    public static class RsaKey {
        private BigInteger publicModulus;
        private BigInteger publicExpoent;
        private BigInteger privateExpoent;
    }
}
