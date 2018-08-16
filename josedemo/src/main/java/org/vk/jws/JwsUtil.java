package org.vk.jws;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.StringUtil;
import org.vk.constant.JoseConstants;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * @author viakiba
 * @description
 * @date Create in 22:34 2018/7/30
 */
public class JwsUtil {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * @description 对信息签名
     * @date: 21:52 2018/7/28
     * @params [plainData 带签名的信息 , radix 证书参数进制, publicModulus 公钥的模, privateExponent 私钥指数, alg 算法名称]
     * @return java.lang.String
     * @author viakiba
     */
    public static String sign(String plainData, int radix, String publicModulus, String privateExponent, String alg) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(new BigInteger(publicModulus, radix),
                new BigInteger(privateExponent, radix));
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(alg);
        signature.initSign(privateKey);
        signature.update(StringUtil.getBytesAscii(plainData));
        //签名结果做base64编码
        return  Base64Url.encode(signature.sign());
    }

    /**
     * @description 验证签名
     * @date: 21:52 2018/7/28
     * @params [plainData 带签名的信息 , sign 签名结果 , radix 证书参数进制, publicModulus 公钥的模, privateExponent 私钥指数, alg 算法名称]
     * @return java.lang.String
     * @author viakiba
     */
    public static boolean verify(String plainData, String sign, int radix, String publicModulus, String publicExponent, String alg) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(publicModulus, radix), new BigInteger(publicExponent, radix));
        //构建公钥信息
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        final Signature signature = Signature.getInstance(alg);
        signature.initVerify(publicKey);
        signature.update(StringUtil.getBytesAscii(plainData));

        byte[] decode = Base64Url.decode(sign);
        //要对传进的签名结果先做base64解码
        return signature.verify(Base64Url.decode(sign));
    }

    public static void main(String[] args) throws Exception {
        //================================================ 使用 JOSE 库进行 解析 ================================
        String message = "这是RSA1_5加密算法的jwe示例。";
        JsonWebSignature senderJws = new JsonWebSignature();
        senderJws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);//设置签名算法
        senderJws.setHeader("iat",String.valueOf(System.currentTimeMillis()));
        senderJws.setPayload(message);//设置待签名数据

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(new BigInteger(JoseConstants.PUBLIC_MODULUS,JoseConstants.RSA_KEY_RADIX),
                new BigInteger(JoseConstants.PRIVATE_EXPONENT,JoseConstants.RSA_KEY_RADIX));
        PrivateKey privateKey = keyFactory.generatePrivate(rsaPrivateKeySpec);//构建签名需要的私钥

        senderJws.setKey(privateKey);//把私钥设置进去
        String compactSerialization = senderJws.getCompactSerialization();//签名并得到结果

        System.out.println(compactSerialization);
        //================================================= 对得到的结果进行分步验证 =====================================
        //代码验证签名
        String[] split = compactSerialization.split("\\.");
        String encodeHeader = split[0];
        String encodeData = split[1];
        String encodeSign = split[2];

        System.out.println(Base64Url.decodeToString(encodeHeader,"UTF-8"));
        System.out.println(Base64Url.decodeToString(encodeData,"UTF-8"));

        String finalData = split[0] +"."+ split[1];//拼接实际的签名数据 包括header部分，heder一般会包括时间戳信息
        boolean verify = verify(finalData, encodeSign, JoseConstants.RSA_KEY_RADIX, JoseConstants.PUBLIC_MODULUS, JoseConstants.PUBLIC_EXPONENT,"SHA256withRSA");
        System.out.println(verify ? "签名被认可":"签名不被认可");

        //=================================================使用 JOSE 库进行 解析====================================
        JsonWebSignature senderVerifyJws = new JsonWebSignature();
//        senderVerifyJws.setPayload(Base64Url.decodeToString(split[1],"UTF-8"));
        senderVerifyJws.setCompactSerialization(compactSerialization);

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(JoseConstants.PUBLIC_MODULUS, JoseConstants.RSA_KEY_RADIX),
                new BigInteger(JoseConstants.PUBLIC_EXPONENT, JoseConstants.RSA_KEY_RADIX));
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        senderVerifyJws.setKey(publicKey);
        boolean b = senderVerifyJws.verifySignature();
        System.out.println(b ? "签名被认可":"签名不被认可");
    }
}
