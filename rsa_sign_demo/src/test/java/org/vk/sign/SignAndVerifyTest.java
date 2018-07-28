package org.vk.sign;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.testng.annotations.Test;
import org.vk.pkg.SignAndVerify;
import org.vk.pkg.SignConstants;

import java.security.*;
import java.util.Base64;

/**
 * @author viakiba
 * @description
 * @date Create in 12:44 2018/7/28
 */
@Slf4j
public class SignAndVerifyTest {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
      * @description jvm支持的详细算法信息
      * @date: 21:46 2018/7/28
      * @params
      * @return
      * @author viakiba
      */
    @Test
    public void test0(){
        for (Provider provider : Security.getProviders()){
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()){
                System.out.println("  Algorithm  Pattern: " + service);
            }
            System.out.println("\n");
        }
    }

    /**
      * @description jvm支持的算法信息 简明的
      * @date: 21:47 2018/7/28
      * @params
      * @return
      * @author viakiba
      */
    @Test
    public void test1(){
        for (Provider provider : Security.getProviders()){
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()){
                System.out.println("  Algorithm: " + service.getAlgorithm());
            }
            System.out.println("\n");
        }
    }

    /**
      * @description 验证签名算法
      * @date: 22:02 2018/7/28
      * @params
      * @return
      * @author viakiba
      */
    @Test
    public void test2() throws Exception{
        String data = "I am vk!";
//        String alg = SignConstants.MD2_WITH_RSA;
//        String alg = SignConstants.MD5_WITH_RSA;
//        String alg = SignConstants.SHA1_WITH_RSA;
//        String alg = SignConstants.SHA224_WITH_RSA;
        String alg = SignConstants.SHA256_WITH_RSA;
//        String alg = SignConstants.SHA384_WITH_RSA;
//        String alg = SignConstants.SHA512_WITH_RSA;
        String signData = SignAndVerify.sign(data, SignConstants.radix_hex,SignConstants.publicModulus,
                                                                    SignConstants.privateExponent,alg);
        log.info(signData);
        boolean isOk = SignAndVerify.verify(data,signData,SignConstants.radix_hex,SignConstants.publicModulus,
                                                                    SignConstants.publicExponent,alg);
        log.info(""+isOk);
    }

    /**
      * @description 先摘要后签名
      * @date: 23:05 2018/7/28
      * @params
      * @return
      * @author viakiba
      */
    @Test
    public void test3() throws Exception{
        String data = "I am vk!";
        String markAlg = SignConstants.MARK_ALGORITHM_MD2;
        String alg = SignConstants.SHA256_WITH_RSA;
        String signData = SignAndVerify.signMark(data, SignConstants.radix_hex,SignConstants.publicModulus,
                                                                    SignConstants.privateExponent,markAlg,alg);
        log.info(signData);
        boolean isOk = SignAndVerify.verifyMarkSign(data,signData,SignConstants.radix_hex,SignConstants.publicModulus,
                                                                    SignConstants.publicExponent,markAlg,alg);
        log.info(""+isOk);
    }

   /**
     * @description MD/SHA 摘要
     * @date: 23:05 2018/7/28
     * @params
     * @return
     * @author viakiba
     */
    @Test
    public void test4() throws Exception{
        String data = "I am vk!";
        String macBaseStr = Base64.getEncoder().encodeToString(SignAndVerify.messageDigest(data,
                                                                    SignConstants.MARK_ALGORITHM_SHA_256));
        log.info("摘要"+macBaseStr);
    }

   /**
     * @description Hmac 摘要
     * @date: 23:05 2018/7/28
     * @params
     * @return
     * @author viakiba
     */
    @Test
    public void test5() throws Exception{
        String data = "I am vk!";
        String macKey = "vk";
        String macBaseStr = Base64.getEncoder().encodeToString(SignAndVerify.messageDigest(data,macKey,
                                                                    SignConstants.MARK_ALGORITHM_HMAC_SHA384));
        log.info("摘要"+macBaseStr);
    }

}
