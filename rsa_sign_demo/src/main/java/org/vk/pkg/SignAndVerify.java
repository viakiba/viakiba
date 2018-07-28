package org.vk.pkg;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

/**
 * @author viakiba
 * @description
 * @date Create in 13:46 2018/7/28
 */
@Slf4j
public class SignAndVerify {

    //========================================= 直接对hash值进行填充和加密 ========================
    /**
     * @description 对信息签名
     * @date: 21:52 2018/7/28
     * @params [plainData 带签名的信息 , radix_hex 证书参数进制, publicModulus 公钥的模, privateExponent 私钥指数, alg 算法名称]
     * @return java.lang.String
     * @author viakiba
     */
    public static String sign(String plainData, int radix, String publicModulus, String privateExponent, String alg) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(SignConstants.RSA);
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(new BigInteger(publicModulus, radix),
                new BigInteger(privateExponent, radix));
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(alg);
        signature.initSign(privateKey);
        signature.update(plainData.getBytes(SignConstants.UTF_8));
        //签名结果做base64编码
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /**
     * @description 验证签名
     * @date: 21:52 2018/7/28
     * @params [plainData 带签名的信息 , sign 签名结果 , radix_hex 证书参数进制, publicModulus 公钥的模, privateExponent 私钥指数, alg 算法名称]
     * @return java.lang.String
     * @author viakiba
     */
    public static boolean verify(String plainData, String sign, int radix, String publicModulus, String publicExponent, String alg) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(SignConstants.RSA);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(publicModulus, radix),
                new BigInteger(publicExponent, radix));
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        final Signature signature = Signature.getInstance(alg);
        signature.initVerify(publicKey);
        signature.update(plainData.getBytes(SignConstants.UTF_8));
        //要对传进的签名结果先做base64解码
        return signature.verify(Base64.getDecoder().decode(sign));
    }


    // ================================ 计算出信息的消息摘要对消息摘要进行签名与验签 ===============

    /**
     * @description 先摘要后签名
     * @date: 23:00 2018/7/28
     * @params [plainData 需要签名的数据, radix 证书进制, publicModulus 公钥模, privateExponent 私钥指数, markAlg 摘要算法, signAlg 签名算法]
     * @return java.lang.String
     * @author viakiba
     */
    public static String signMark(String plainData, int radix, String publicModulus, String privateExponent, String markAlg, String signAlg) throws Exception{
        byte[] outputDigest_verify = messageDigest(plainData, markAlg);

        KeyFactory keyFactory = KeyFactory.getInstance(SignConstants.RSA);
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(new BigInteger(publicModulus, radix),
                new BigInteger(privateExponent, radix));
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        Signature Sign = Signature.getInstance(signAlg);
        Sign.initSign(privateKey);
        Sign.update(outputDigest_verify);
        return Base64.getEncoder().encodeToString(Sign.sign());
    }

    /**
     * @description
     * @date: 23:00 2018/7/28
     * @params plainData 需要签名的数据, sign 签名结果, radix 证书进制, publicModulus 公钥模, privateExponent 私钥指数, markAlg 摘要算法, signAlg 签名算法]
     * @return boolean
     * @author viakiba
     */
    public static boolean verifyMarkSign(String plainData, String sign, int radix, String publicModulus, String publicExponent, String markAlg, String signAlg ) throws Exception{
        byte[] outputDigest_verify = messageDigest(plainData, markAlg);

        KeyFactory keyFactory = KeyFactory.getInstance(SignConstants.RSA);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(publicModulus, radix),
                new BigInteger(publicExponent, radix));
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        Signature verifySign = Signature.getInstance(signAlg);
        verifySign.initVerify(publicKey);
        verifySign.update(outputDigest_verify);
        return verifySign.verify(Base64.getDecoder().decode(sign));
    }

    /**
     * @description 获取消息摘要 MD/SHA
     * @date: 23:29 2018/7/28
     * @params [plainData, markAlg]
     * @return byte[]
     * @author viakiba
     */
    public static byte[] messageDigest(String plainData, String markAlg) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        messageDigest = MessageDigest.getInstance(markAlg);
        messageDigest.update(plainData.getBytes());
        byte[] outputDigest_verify = messageDigest.digest();
        log.info("消息摘要 " +Base64.getEncoder().encodeToString(outputDigest_verify));
        return outputDigest_verify;
    }

    /**
     * @description 根据约定的key和消息得到消息摘要 Hmac
     * @date: 23:25 2018/7/28
     * @params [encryptText, encryptKey]
     * @return byte[]
     * @author viakiba
     */
    public static byte[] messageDigest(String data, String key, String digestAlg) throws Exception {
        byte[] keyData=key.getBytes(SignConstants.UTF_8);
        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(keyData, digestAlg);
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(digestAlg);
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);
        byte[] text = data.getBytes(SignConstants.UTF_8);
        //完成 Mac 操作
        return mac.doFinal(text);
    }

}
