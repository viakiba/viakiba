package org.viakiba.test.cert;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.vaikiba.cert.CertUtil.*;
import org.vaikiba.cert.CertUtil;

/**
 *  证书工具类 certUtil 测试
 * @author: viakiba
 * @date: 2018/8/9 16:41
 */
@Slf4j
public class CertUtilTest {

    /**
     * CA
     */
    public static String publicRootMudulus = "00F8FE59C1C5A1A51423E937E16F09A3FB9FCBCB2573C6D71343469B9AB5EF8A8662E60D3FCE5DCFCF697C64BCFDC559A3B13BDF195EF20AB9F8A00B37D3D1BFBE214553222007317523E7CB335DF344D23B8FE2A0541A035980680273C0DE0384BA2BDC05B5227F2D46AEDFA09C551C328AB9C348B43DB42483F3B989B5E5981E7CB23FE43B6253EA64F89879BDC8DC7427A6CBA32C11E598DD058376D723B6C5763B6B71C0FD469FC0B3BE3B4FFF50AF4BFB08930FC7BACA804D6D5A1410E44DB59E160D57098D3374F7D221372710F2B0005F040430CB49D4B86B457826A84AD6C3585F327FC70B10F006E595DE9569DACE74A051E6F50824BF8EF4879BFCA5";
    public static String publicRootexpoent = "10001";
    public static String privateRootexpoent = "009EF06D871D8AA37F89B4D370D99A43CCD9221398E2A0A8A5A92A2725C8C111A1DAFB92B58A1BA40D77FE69A7A22E199C3E0443D3442228EAB164280508F738F83AF0AFB276D360A4AFB8C4A31373B818A2E0A3FF47F01AF744DA1FC697F4A0365748ABF810B9E68896380693D57716BAC486F3BB3322B81D1F05B307CECEB21C719171142791F39121896E63DBE0B106BF6E06606764EA304B7A95B9A2F9280D9A93D75392239C0DA29217472EEC87B9DE0EDE6BD8CE368A3582053AE666AAEAA9C2E76A3AAE2E494D76E1ED9FE56CE93D8302DAE64246DDECD2B82A803D9D8B1F882052DE2317DF89CC2A6F6DB28590839659FD6581ADD6EE3EFE1BE118A5C1";

    /**
     *  USER
     **/
    public static String publicUserMudulus = "00B2C22D4997146374438623265AF1FA92AFE7AE4A4435D79F33D5155D823DD3B201E1BFEB0D1661B587397384473CE90DB90F816E65A1563E322D0BB590685A3345017AAA7F8FB6023CDA787A380CDD07213CEBDDE4C12B15D656ACDD3043B4D6A147500FB7056201EB179EB268F003ADEC6C7272671FF7A8B2411B1E6B7862D11177FBB4078FC47FBDF57C1720E973B3FF9648E0F8D1A213AF64C5742109D6ED0F75AF430688A78A6196E906F681E537DCA33CBC2B0CC358ECB79EF84F1599F68395FDCBA776A32195EF599A777C6EB807D58A59CE59576D2FC2A39447D58B7FED38B14417457B80E29E927990CF1B3524062DB0E763B71BAA38E83F442FF9B5";
    public static String publicUserexpoent = "10001";
    public static String privateUserexpoent = "0083A18EFDA89D9FDAA63A6939BE307FA67297B4F505236CC2D3C52DF56C89A0906CE8528D8056A1DEAD53B5E78B19A437B1B56446E9D9930B3BA18604CDF0B9B3153650A0AA4C25E7A1EDF257755CAB89AB8513DE92AB57D1BDC2978A4D171E5C09E8DC60A611F5A899F80BA92EB2C6D2D4CCCABDC98875B32887DEB358CA0E60D0223A0F946BF4F3B032E933D3A4BFFF7F792CBE0B11BEBC2DAA06BDF530CD11CA07B73F07540A812E6A26B43E41E1D7AF6F20511BA355AD68D49E3F4EE8BA282866900B2407B0C92325A091D75ADE455F987618E7DFA50A1010C51B7141354CB4B3C79C77C60906FE05229BCE77D51824862E8EC74C26E98C672047CFD2D761";


    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 产生公私钥
     *      这就是产生公私钥的方法，其中核心参数是三个值：
     *          公钥 模
     *          公钥 指数
     *          私钥 指数
     */
    @Test
    public void genRsaKeyPair() throws NoSuchAlgorithmException {
        Map map = CertUtil.genKey();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) map.get(PUBLIC_KEY);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) map.get(PRIVATE_KEY);

        //公钥 模
        String publicMudulus = rsaPublicKey.getModulus().toString(16);
        //公钥 指数
        String publicExpoent = rsaPublicKey.getPublicExponent().toString(16);
        //私钥 指数
        String privateExpoent = rsaPrivateKey.getPrivateExponent().toString(16);
        //公钥 模
        String publicMuduluss = rsaPrivateKey.getModulus().toString(16);

        System.out.println(publicMudulus);
        System.out.println(publicExpoent);
        System.out.println(privateExpoent);
        System.out.println(publicMuduluss);

        System.out.println(publicMudulus.equals(publicMuduluss));
    }

    /**
     *  生成 证书请求文件
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws OperatorCreationException
     * @throws CertificateException
     */
    @Test
    public void genUserCsrTest() throws InvalidKeySpecException, NoSuchAlgorithmException,IOException,OperatorCreationException,CertificateException {
        X500Name reqName = getX500Name("TicPay", "Laser", "BeiJing", "BeiJing", "CN", "R&D");
        //构建 用户证书 对应的公钥
        PublicKey userPublicKey = getPublicKey(16,publicUserMudulus,publicUserexpoent);
        //构建CAroot证书 对应的私钥
        PrivateKey userPrivateKey = getPrivateKey(16,publicUserMudulus,privateRootexpoent);
        String s = csrBuilder(reqName, userPublicKey, userPrivateKey);
        System.out.println("\n"+s);
    }

    /**
     * 签发CA证书
     */
    @Test
    public void genCaCertTest() throws Exception{
        //根证书Issue基本信息
        X500Name issuerName = getX500Name("Dev", "VK", "BeiJing", "BeiJing", "CN", "R&D");
        // 证书序列号
        BigInteger serial = BigInteger.valueOf(System.currentTimeMillis() / 1000);
        //证书有 起始日期 与 结束日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date notBefore = sdf.parse("2018-08-01 00:00:00");
        Date notAfter = sdf.parse("2028-08-01 00:00:00");

        //构建 用户证书 对应的公钥
        PublicKey userPublicKey = getPublicKey(16,publicRootMudulus,publicRootexpoent);
        //构建CAroot证书 对应的私钥
        PrivateKey rootPrivateKey = getPrivateKey(16,publicRootMudulus,publicRootexpoent);
        //构建证书的build
        String cert = certBuilder(issuerName, issuerName, serial, notBefore, notAfter, userPublicKey, rootPrivateKey);
        System.out.println("\n"+cert);
    }

    /**
     *  生成 根PFX证书
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SecurityException
     * @throws SignatureException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws IOException
     */
    @Test
    public void genRootPfxTest() throws NoSuchAlgorithmException,
            InvalidKeyException, SecurityException, SignatureException,
            KeyStoreException, CertificateException, IOException, OperatorCreationException, InvalidKeySpecException {

        String certPath = "D:/pfxGenRoot.pfx";
        PrivateKey rootPrivateKey = getPrivateKey(16,publicRootMudulus,privateRootexpoent);
        PublicKey rootPublicKey = getPublicKey(16,publicRootMudulus,publicRootexpoent);

        String passWord = "12345678";

        X500Name issuer = getX500Name("huangpeng", "Laser", "BeiJing", "BeiJing", "CN", "R&D");

        X509Certificate x509Certificate = genX509Certificate(
                new BigInteger("11121",10),(new Date(System.currentTimeMillis() - 500000)), (new Date(System.currentTimeMillis() + 500000)),
                issuer, issuer, rootPrivateKey,rootPublicKey);

        genPfx(x509Certificate,rootPrivateKey,passWord,certPath);

    }

    @Test
    public void genCaTestAll(){

    }

    /**
     * 生成用户证书
     *  签发证书的颁发者信息 要与生成ca证书时的签发信息一致，不然会出错。证书链验证不过。
     */
    @Test
    public void genUserCertTest() throws Exception{
        //根证书Issue基本信息
        X500Name issuerName = getX500Name("bjleisen", "Laser", "BeiJing", "BeiJing", "CN", "R&D");
        // 用户证书 基本使用者
        X500Name reqName = getX500Name("TicPay", "Laser", "BeiJing", "BeiJing", "CN", "R&D");
        // 证书序列号
        BigInteger serial = BigInteger.valueOf(System.currentTimeMillis() / 1000);
        //证书 起始日期 与 结束日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date notBefore = sdf.parse("2018-08-02 00:00:00");
        Date notAfter = sdf.parse("2028-07-01 00:00:00");

        //构建 用户证书 对应的公钥
        PublicKey userPublicKey = getPublicKey(16,publicUserMudulus,publicUserexpoent);
        //构建CAroot证书 对应的私钥
        PrivateKey rootPrivateKey = getPrivateKey(16,publicRootMudulus,privateRootexpoent);
        //构建证书的build
        String cert = certBuilder(issuerName, reqName, serial, notBefore, notAfter, userPublicKey, rootPrivateKey);

        System.out.println("\n"+cert);
    }

    /**
     *  生成 用户PFX证书
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SecurityException
     * @throws SignatureException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws IOException
     */
    @Test
    public void genUserPfxTest() throws NoSuchAlgorithmException,
            InvalidKeyException, SecurityException, SignatureException,
            KeyStoreException, CertificateException, IOException, OperatorCreationException, InvalidKeySpecException {

        String certPath = "D:/pfxGenUser.pfx";
        PrivateKey rootPrivateKey = getPrivateKey(16,publicRootMudulus,privateRootexpoent);
        PrivateKey userPrivateKey = getPrivateKey(16,publicUserMudulus,privateUserexpoent);
        PublicKey userPublicKey = getPublicKey(16,publicUserMudulus,publicUserexpoent);

        String passWord = "12345678";

        X500Name issuer = getX500Name("huangpeng", "Laser", "BeiJing", "BeiJing", "CN", "R&D");
        X500Name reqSubject = getX500Name("huang1", "Laser", "BeiJing", "BeiJing", "CN", "R&D");

        X509Certificate x509Certificate = genX509Certificate(
                new BigInteger("111",10),(new Date(System.currentTimeMillis() - 500000)), (new Date(System.currentTimeMillis() + 500000)),
        issuer, reqSubject, rootPrivateKey,userPublicKey);

        genPfx(x509Certificate,userPrivateKey,passWord,certPath);

    }

    /**
     *      pfx 解析
     */
    @Test
    public void pfxAnalyzeTest() {
        final String KEYSTORE_FILE = "D:/pfxGenUser.pfx";
        final String password = "12345678";
        try {
            FileInputStream fis = new FileInputStream(KEYSTORE_FILE);
            HashMap<Object, Object> objectObjectHashMap = CertUtil.pfxAnalze(fis, password);
            System.out.println(objectObjectHashMap.get(PrivateKey.class));
            System.out.println(objectObjectHashMap.get(PublicKey.class));
            System.out.println(objectObjectHashMap.get(Certificate.class));
            //pfx ==> cert
            System.out.println(CertUtil.genCert((Certificate) objectObjectHashMap.get(Certificate.class)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     *  csr解析
     * @throws IOException
     */
    @Test
    public void csrAnalyzeTest() throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        PKCS10CertificationRequest pkcs10CertificationRequest = csrAnalyze("-----BEGIN CERTIFICATE REQUEST-----\n" +
                "MIICpTCCAY0CAQAwYDEPMA0GA1UEAwwGVGljUGF5MQ4wDAYDVQQKDAVMYXNlcjEQMA4GA1UEBwwH\n" +
                "QmVpSmluZzEQMA4GA1UECAwHQmVpSmluZzELMAkGA1UEBhMCQ04xDDAKBgNVBAsMA1ImRDCCASIw\n" +
                "DQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALLCLUmXFGN0Q4YjJlrx+pKv565KRDXXnzPVFV2C\n" +
                "PdOyAeG/6w0WYbWHOXOERzzpDbkPgW5loVY+Mi0LtZBoWjNFAXqqf4+2AjzaeHo4DN0HITzr3eTB\n" +
                "KxXWVqzdMEO01qFHUA+3BWIB6xeesmjwA63sbHJyZx/3qLJBGx5reGLREXf7tAePxH+99XwXIOlz\n" +
                "s/+WSOD40aITr2TFdCEJ1u0Pda9DBoinimGW6Qb2geU33KM8vCsMw1jst574TxWZ9oOV/cundqMh\n" +
                "le9Zmnd8brgH1YpZzllXbS/Co5RH1Yt/7TixRBdFe4DinpJ5kM8bNSQGLbDnY7cbqjjoP0Qv+bUC\n" +
                "AwEAAaAAMA0GCSqGSIb3DQEBCwUAA4IBAQA2AthulFYt9oB+oBYfqSetdQhfFXSEa/MyafCBuh+z\n" +
                "Z6o3fHNAfNyfytSnIX87DjxH8at9NrhDqrs53tMO9sdOjxSgCbGJeypcWpjI+v26ZiNN8MENAuRM\n" +
                "DKms0uyJCCV7wC3Rlnj2RkHpE4U6CaqYWBT28/WIRNy29nAqk2/WSE3w6BMPXTvhKRVkU3n48WO6\n" +
                "6VNnI9QbHW8SdXPWQRkzGYD4/U1+foREQ7drpr097aBSc+y60vpsD0FqWMWqL3U4vk4H5KpYYLMt\n" +
                "X7wSzrcnpAK9ZdiwVLZAmWj/1D1QougMZZHvA5b3BeA3RWhahnPEwaIl+GBUlsNpAExMCD/f\n" +
                "-----END CERTIFICATE REQUEST-----");

        System.out.println(csrGetPublicKeyByX509(pkcs10CertificationRequest));
        System.out.println(csrGetPublicKeyByPKCS(pkcs10CertificationRequest));
    }

    /**
     *  cer解析
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws IOException
     */
    @Test
    public void certAnalyzeTest() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        certAnalyze("-----BEGIN CERTIFICATE-----\n" +
                "MIIDVTCCAj2gAwIBAgIEW2qU5zANBgkqhkiG9w0BAQsFADBiMQwwCgYDVQQLDANSJkQxCzAJBgNV\n" +
                "BAYTAkNOMRAwDgYDVQQIDAdCZWlKaW5nMRAwDgYDVQQHDAdCZWlKaW5nMQ4wDAYDVQQKDAVMYXNl\n" +
                "cjERMA8GA1UEAwwIYmpsZWlzZW4wHhcNMTgwODAxMDEwMTAxWhcNMjgwODAxMDEwMTAxWjBiMQww\n" +
                "CgYDVQQLDANSJkQxCzAJBgNVBAYTAkNOMRAwDgYDVQQIDAdCZWlKaW5nMRAwDgYDVQQHDAdCZWlK\n" +
                "aW5nMQ4wDAYDVQQKDAVMYXNlcjERMA8GA1UEAwwIYmpsZWlzZW4wggEiMA0GCSqGSIb3DQEBAQUA\n" +
                "A4IBDwAwggEKAoIBAQD4/lnBxaGlFCPpN+FvCaP7n8vLJXPG1xNDRpuate+KhmLmDT/OXc/PaXxk\n" +
                "vP3FWaOxO98ZXvIKufigCzfT0b++IUVTIiAHMXUj58szXfNE0juP4qBUGgNZgGgCc8DeA4S6K9wF\n" +
                "tSJ/LUau36CcVRwyirnDSLQ9tCSD87mJteWYHnyyP+Q7YlPqZPiYeb3I3HQnpsujLBHlmN0Fg3bX\n" +
                "I7bFdjtrccD9Rp/As747T/9Qr0v7CJMPx7rKgE1tWhQQ5E21nhYNVwmNM3T30iE3JxDysABfBAQw\n" +
                "y0nUuGtFeCaoStbDWF8yf8cLEPAG5ZXelWnaznSgUeb1CCS/jvSHm/ylAgMBAAGjEzARMA8GA1Ud\n" +
                "EwQIMAYBAf8CAQEwDQYJKoZIhvcNAQELBQADggEBALmoIYvM0sKOY7xKI7wOmdLJeTtWSVVu+eLQ\n" +
                "imbsQbar5jHuspYPwQEuy9bDDIBWnqH2Hi9V3bq0T77R0dYy7KSkHZBmBQRqr0SNFQNQQzWYMxRa\n" +
                "1Xzpait5eeLw7fqtjX+sRBq52XPh9cYSFLy+EK0ktp8ULBnJ6UdQzElWEixQWpO2IRGlazf0mHA9\n" +
                "9K3sFuoxS2vhlC6CXucXCEiqncXy9GudRHs7lN19uKXLRuiQoIa4ChT0WI6XV/N97830PXDktBga\n" +
                "tNt4nvRzRbjiVanHG/IAiDTTzlBDRjEocukJ2rv+14siUGf/ypRT5XpX8NVJOOiLnxAG4CKH0rS9\n" +
                "iSk=\n" +
                "-----END CERTIFICATE-----");
    }

    /**
     *  jks文件解析
     * @throws IOException
     * @throws UnrecoverableKeyException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     */
    @Test
    public void jksAnalyzeTest() throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException {
        final String KEYSTORE_FILE = "D:/device.jks";
        final String password = "12345678";
        FileInputStream fis = new FileInputStream(KEYSTORE_FILE);
        HashMap hashmap= jksAnalyze(fis, password);
        System.out.println(hashmap.get(Certificate.class));
        System.out.println(hashmap.get(PrivateKey.class));

        //jks ==> cert
        System.out.println(genCert( (Certificate) hashmap.get(Certificate.class)));

        //jks ==> pfx
        genPfx((Certificate) hashmap.get(Certificate.class), (PrivateKey) hashmap.get(PrivateKey.class), "12345678","D:/sss.pfx");
    }
}
