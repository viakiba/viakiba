package org.vk.pkg;

/**
 * @author viakiba
 * @description
 * @date Create in 12:49 2018/7/28
 */
public class SignConstants {

    public static String RSA = "RSA";

    public static String UTF_8 = "UTF-8";

    public static int radix_hex = 16;
    public static String publicModulus = "00c6a2d057f4067dd43a14a4db8589039f817e97aaf89191fdb0db5cebb0ea6027224ae1226626a73cf15fc8d4defb264a90568abd24d10182dbe191b8eae49c21900258a35761208f4146df4238f1dd3fb9ae47e50653656919b40a3edfb4d1fae7b111b3cd78c913ee60ce50b3e749d693f9bf7577d1ef0001f8b04a6f5a10b07106efcca1c69f280e152327f6744ba7d0e11dbbb8031f35c8838ea49c6fa9ac2f6992c605f3272b0edf445116b6d27606d471a026c4bf1aa3382c8ab20d2d161f6d188f415006deb8529738aa2c2ce343815e59bffc1ba23293d5aae06a523d30692d96fa669794733a5fb280bc20a0f08aada2e8d5a47e4104ea4db65cd11f";
    public static String publicExponent = "10001";
    public static String privateExponent = "00a2eb7d88f63cb0cdf60962a22ee78f522f8b1e68fbd1a1f57b2ea10b2ba340d4383b4466cb741ead4ca8ac7774a077eaa67264fef808797dd44d3211828f9943a9f352b23e840a899517c51c72ca6616d37c0fb9d83364b50c80effa5bcfda7e39b4b0f951a924fbb5042f945fca6f7491104229ddea116667378b98b1b62482afcc3633f50602e4f3d2e8a50e14636518fed11f7bc79a9ad9ffd40c1a69a423de5de3316601a344efb4b4a86944fd13d1d4409bc4a1a57238f8d2bf9c756349c5e8c9cc51832661eca3fc51ecffd7a42273262f5e3c6405284fff565ccc67e348dc94cfd4043dc670497c39e967c4a4d5fc1458ac1965d92068fb951a7729d1";

    // RSA 相关的 签名算法
    public static String MD2_WITH_RSA = "MD2withRSA";
    public static String MD5_WITH_RSA = "MD5withRSA";
    public static String SHA1_WITH_RSA = "SHA1withRSA";
    public static String SHA224_WITH_RSA = "SHA224withRSA";
    public static String SHA256_WITH_RSA = "SHA256withRSA";
    public static String SHA384_WITH_RSA = "SHA384withRSA";
    public static String SHA512_WITH_RSA = "SHA512withRSA";

    // 摘要算法 MD/SHA/HMAC 三大系列 常用的是SHA系列 MD与SHA摘要一致，hmac 需要一个key参与计算，一般情况下这个key需要双方妥善保存
    public static final String MARK_ALGORITHM_MD2 = "MD2";
    public static final String MARK_ALGORITHM_MD4 = "MD4";
    public static final String MARK_ALGORITHM_MD5 = "MD5";

    public static final String MARK_ALGORITHM_SHA = "SHA";
    public static final String MARK_ALGORITHM_SHA_224 = "SHA-224";
    public static final String MARK_ALGORITHM_SHA_256 = "SHA-256";
    public static final String MARK_ALGORITHM_SHA_384 = "SHA-384";
    public static final String MARK_ALGORITHM_SHA_512 = "SHA-512";
    public static final String MARK_ALGORITHM_SHA3_224 = "SHA3-224";
    public static final String MARK_ALGORITHM_SHA3_256 = "SHA3-256";
    public static final String MARK_ALGORITHM_SHA3_384 = "SHA3-384";
    public static final String MARK_ALGORITHM_SHA3_512 = "SHA3-512";

    public static final String MARK_ALGORITHM_HMAC_SHA1 = "HmacSHA1";
    public static final String MARK_ALGORITHM_HMAC_SHA224 = "HmacSHA224";
    public static final String MARK_ALGORITHM_HMAC_SHA256 = "HmacSHA256";
    public static final String MARK_ALGORITHM_HMAC_SHA384 = "HmacSHA384";
    public static final String MARK_ALGORITHM_HMAC_SHA512 = "HmacSHA512";
}
