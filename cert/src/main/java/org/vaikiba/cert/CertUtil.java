package org.vaikiba.cert;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStrictStyle;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.*;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.testng.annotations.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 *  证书生成
 * @author: viakiba
 * @date: 2018/8/8 11:47
 */
public class CertUtil {

    public static final String KEY_ALGORITHM = "RSA";

    public static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 存储公私钥信息
     */
    static Map<String, Object> keyMap = new HashMap<String, Object>(2);

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static Map genKey() throws NoSuchAlgorithmException {
        //获得对象 KeyPairGenerator 参数 RSA 1024个字节
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(2048);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //公私钥对象存入map中
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * X509Certificate 对象封装
     * @param serialNumber 证书编号
     * @param notBefore 起始日期
     * @param notAfter 解之日期
     * @param issuer 发行者
     * @param reqSubject 请求者主体
     * @param privateKey 发行者私钥
     * @param publicKey 请求者公钥
     * @return
     * @throws SignatureException
     * @throws InvalidKeyException
     * @throws OperatorCreationException
     * @throws IOException
     * @throws CertificateException
     */
    public static X509Certificate genX509Certificate(BigInteger serialNumber,Date notBefore, Date notAfter,X500Name issuer,X500Name reqSubject,PrivateKey privateKey,PublicKey publicKey) throws SignatureException, InvalidKeyException, OperatorCreationException, IOException, CertificateException {
        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder
                (issuer, serialNumber, notBefore, notAfter, reqSubject, SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
        JcaContentSignerBuilder builder = new JcaContentSignerBuilder("SHA256withRSA");

        if(issuer == reqSubject){
            BasicConstraints constraint = new BasicConstraints(1);
            certBuilder.addExtension(Extension.basicConstraints, false, constraint);
        }

        ContentSigner signer = builder.build(privateKey);
        byte[] certBytes = certBuilder.build(signer).getEncoded();
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate)certificateFactory.generateCertificate(new ByteArrayInputStream(certBytes));
        return certificate;
    }

    /**
     *  生成PFX证书文件
     * @param certificate 证书
     *             建议 CertUtil#genX509Certificate(java.math.BigInteger, java.util.Date, java.util.Date, org.bouncycastle.asn1.x500.X500Name, org.bouncycastle.asn1.x500.X500Name, java.security.PrivateKey, java.security.PublicKey)()
     * @param privateKey
     *              请求者私钥
     * @param passWord
     *              pfx生成后的密码
     * @param certPath
     *              pfx存储路径
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws KeyStoreException
     */
    public static void genPfx(Certificate certificate,PrivateKey privateKey,String passWord, String certPath) throws CertificateException, NoSuchAlgorithmException, IOException, KeyStoreException {
        KeyStore store = KeyStore.getInstance("PKCS12");
        store.load(null, null);
        store.setKeyEntry("", privateKey,
                passWord.toCharArray(), new Certificate[] { certificate });

        FileOutputStream fout =new FileOutputStream(certPath);
        store.store(fout, passWord.toCharArray());
        fout.close();
    }

    /**
     *  获取 pfx 对应的公私钥以及证书Certificate 解析
     * @param fileInputStream pxf读取的文件输入流
     * @param passWord pfx文件对应的密码
     * @return
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws UnrecoverableKeyException
     */
    public static HashMap<Object, Object> pfxAnalze(FileInputStream fileInputStream, String passWord ) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        char[] nPassword = passWord.toCharArray();
        ks.load(fileInputStream, nPassword);
        fileInputStream.close();
        Enumeration<String> enums = ks.aliases();
        String keyAlias = null;
        if (enums.hasMoreElements()){
            keyAlias = enums.nextElement();
        }
        PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias, nPassword);
        Certificate cert = ks.getCertificate(keyAlias);
        PublicKey pubkey = cert.getPublicKey();
        HashMap<Object, Object> hashMap = new HashMap(3);
        hashMap.put(PrivateKey.class, privateKey);
        hashMap.put(PublicKey.class, pubkey);
        hashMap.put(Certificate.class, cert);
        return hashMap;
    }

    /**
     *  获取CSR包含的公钥 10进制
     * @param pkcs10CertificationRequest  参考 com.laser.allalgimpl.util.CertUtil#csrAnalyze(java.lang.String)
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws IOException
     */
    public static PublicKey csrGetPublicKeyByX509(PKCS10CertificationRequest pkcs10CertificationRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pkcs10CertificationRequest.getSubjectPublicKeyInfo().toASN1Primitive().getEncoded());
        PublicKey publicKey =KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        return publicKey;
    }

    /**
     *  获取包含的公钥 16进制
     * @param pkcs10CertificationRequest
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static PublicKey csrGetPublicKeyByPKCS(PKCS10CertificationRequest pkcs10CertificationRequest) throws NoSuchAlgorithmException, InvalidKeyException {
        JcaPKCS10CertificationRequest jcaPKCS10CertificationRequest = new JcaPKCS10CertificationRequest(pkcs10CertificationRequest);
        X500Name subject = jcaPKCS10CertificationRequest.getSubject();
        PublicKey publicKey = jcaPKCS10CertificationRequest.getPublicKey();
        return publicKey;
    }

    /**
     *  根据csr文件字符串生成对应的PKCS10CertificationRequest对象
     * @param csrStr
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     */
    public static PKCS10CertificationRequest csrAnalyze(String csrStr) throws UnsupportedEncodingException, IOException {
        if( !csrStr.startsWith("-----BEGIN CERTIFICATE REQUEST-----") || !csrStr.endsWith("-----END CERTIFICATE REQUEST-----")){
            throw new IOException("csr 信息不合法");
        }
        csrStr = csrStr.replace("-----BEGIN CERTIFICATE REQUEST-----"+"\n","");
        csrStr = csrStr.replace("-----END CERTIFICATE REQUEST-----","");
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bArray = decoder.decodeBuffer(csrStr);
        PKCS10CertificationRequest csr = new PKCS10CertificationRequest(bArray);
        System.out.println(csr);
        return csr;
    }

    /**
     *  读取jks文件输入流中的私钥
     * @param inputStream jks文件输入流 FileInputStream
     * @param password jks 对应的密码
     * @return
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws CertificateException
     */
    public static HashMap jksAnalyze(InputStream inputStream,String password) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, CertificateException {
        KeyStore keystore = KeyStore.getInstance("jks");
        keystore.load(inputStream, password.toCharArray());
        Enumeration<String> enumeration = keystore.aliases();
        String keyAlias = null;
        if (enumeration.hasMoreElements()) {
            keyAlias = enumeration.nextElement();
        }
        PrivateKey privateKey = (PrivateKey) keystore.getKey(keyAlias, password.toCharArray());
        Certificate certificate = keystore.getCertificate(keyAlias);

        HashMap hashMap = new HashMap();
        hashMap.put(PrivateKey.class,privateKey);
        hashMap.put(Certificate.class,certificate);

        return hashMap;
    }

    /**
     *  cert cer后缀 证书字符串转对象
     * @param certStr
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws CertificateException
     */
    public static X509Certificate certAnalyze(String certStr) throws UnsupportedEncodingException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if( !certStr.startsWith("-----BEGIN CERTIFICATE-----") || !certStr.endsWith("-----END CERTIFICATE-----")){
            throw new IOException("cert 信息不合法");
        }
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\DEVICE.key"), "123456".toCharArray());
        System.out.println("success");

        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        X509Certificate x509Certificate = (X509Certificate) certFactory.generateCertificate(
                new ByteArrayInputStream(certStr.getBytes()));
        return x509Certificate;
    }

    /**
     *  生成 CSR 请求文件
     * @param reqName 请求者主体信息
     * @param userPublicKey 用户公钥
     * @param userPrivateKey 用户私钥
     * @return
     * @throws OperatorCreationException
     * @throws CertificateException
     * @throws IOException
     */
    public static String csrBuilder(X500Name reqName, PublicKey userPublicKey, PrivateKey userPrivateKey) throws OperatorCreationException, IOException {

        PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder(reqName,userPublicKey );
        JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withRSA");
        ContentSigner csrSigner = csBuilder.build(userPrivateKey);
        PKCS10CertificationRequest csr = p10Builder.build(csrSigner);

        //处理证书 ANS.I DER 编码 =》 String Base64编码
        BASE64Encoder base64 = new BASE64Encoder();
        ByteArrayOutputStream cerFormat = new ByteArrayOutputStream();
        base64.encodeBuffer(csr.getEncoded(), cerFormat);

        StringBuilder sb = new StringBuilder();
        sb.append("-----BEGIN CERTIFICATE REQUEST-----"+"\n");
        sb.append(new String (cerFormat.toByteArray()));
        sb.append("-----END CERTIFICATE REQUEST-----");
        return sb.toString();
    }

    /**
     *  根据如下参数获取对应base64编码格式的证书文件字符串
     *      issuerName 与 reqName 对象是同一个则认为生成的是CA证书
     * @param issuerName 颁发者信息
     * @param reqName   请求证主题信息
     *                  <br> issuerName == reqName ---> CA
     * @param serial 证书序列号
     *                 <br>eg: BigInteger serial = BigInteger.valueOf(System.currentTimeMillis() / 1000);
     * @param notBefore 有效期开始时间  2018-08-01 00:00:00
     * @param notAfter 有效期截至时间   2028-08-01 00:00:00
     * @param userPublicKey 请求者主题公钥信息
     * @param rootPrivateKey   颁发者私钥信息
     * @return String
     * @throws OperatorCreationException
     * @throws CertificateException
     * @throws IOException
     */
    public static String certBuilder(X500Name issuerName, X500Name reqName, BigInteger serial, Date notBefore, Date notAfter, PublicKey userPublicKey, PrivateKey rootPrivateKey) throws OperatorCreationException, CertificateException, IOException {
        JcaX509v3CertificateBuilder x509v3CertificateBuilder = new JcaX509v3CertificateBuilder(
                issuerName, serial, notBefore, notAfter, reqName, userPublicKey);
        // 签发者 与 使用者 信息一致则是CA证书生成，开展增加CA标识
        if(issuerName == reqName){
            BasicConstraints constraint = new BasicConstraints(1);
            x509v3CertificateBuilder.addExtension(Extension.basicConstraints, false, constraint);
        }
        //签名的工具
        ContentSigner signer = new JcaContentSignerBuilder("SHA256WITHRSA").setProvider("BC").build(rootPrivateKey);
        //触发签名产生用户证书
        X509CertificateHolder x509CertificateHolder = x509v3CertificateBuilder.build(signer);
        JcaX509CertificateConverter certificateConverter = new JcaX509CertificateConverter();
        certificateConverter.setProvider("BC");
        Certificate userCertificate = certificateConverter.getCertificate(x509CertificateHolder);
        String certStr = genCert(userCertificate);
        return certStr;
    }

    /**
     *  Certificate ==》 CertStr
     * @param certificate
     * @return
     * @throws IOException
     * @throws CertificateEncodingException
     */
    public static String genCert(Certificate certificate) throws IOException, CertificateEncodingException {
        //处理证书 ANS.I DER 编码 =》 String Base64编码
        BASE64Encoder base64 = new BASE64Encoder();
        ByteArrayOutputStream cerFormat = new ByteArrayOutputStream();
        base64.encodeBuffer(certificate.getEncoded(), cerFormat);

        StringBuilder sb = new StringBuilder();
        sb.append("-----BEGIN CERTIFICATE-----"+"\n");
        sb.append(new String (cerFormat.toByteArray()));
        sb.append("-----END CERTIFICATE-----");
        return sb.toString();
    }

    /**
     *  颁发者 或者 申请者 信息封装
     * @param CN 公用名
     *              对于 SSL 证书，一般为网站域名；而对于代码签名证书则为申请单位名称；而对于客户端证书则为证书申请者的姓名
     * @param O 组织
     *              对于 SSL 证书，一般为网站域名；而对于代码签名证书则为申请单位名称；而对于客户端单位证书则为证书申请者所在单位名称；
     * @param L 城市
     * @param ST 省/ 市/ 自治区名
     * @param C 国家
     * @param OU 组织单位/显示其他内容
     * @return
     */
    public static X500Name getX500Name(String CN,String O,String L,String ST,String C ,String OU) {
        X500NameBuilder rootIssueMessage = new X500NameBuilder(
                BCStrictStyle.INSTANCE);
        rootIssueMessage.addRDN(BCStyle.CN, CN);
        rootIssueMessage.addRDN(BCStyle.O, O);
        rootIssueMessage.addRDN(BCStyle.L, L);
        rootIssueMessage.addRDN(BCStyle.ST, ST);
        rootIssueMessage.addRDN(BCStyle.C, C);
        rootIssueMessage.addRDN(BCStyle.OU, OU);
        return rootIssueMessage.build();
    }

    /**
     *  封装对应的私钥通过下列参数
     * @param radix 参数进制
     * @param publicMudulusStr 公钥 mudulus
     * @param privateExponentStr 私钥 expoent
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static PrivateKey getPrivateKey(int radix, String publicMudulusStr, String privateExponentStr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        BigInteger privateModulus = new BigInteger(publicMudulusStr, radix);
        BigInteger privateExponent = new BigInteger(privateExponentStr, radix);
        RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(privateModulus,privateExponent);
        PrivateKey rootPrivateKey = keyFactory.generatePrivate(rsaPrivateKeySpec);
        return rootPrivateKey;
    }

    /**
     *  封装对应的公钥通过下列参数
     * @param radix 参数进制
     * @param publicMudulusStr 公钥mudulus
     * @param publicExpoentStr 公钥expoent
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static PublicKey getPublicKey(int radix, String publicMudulusStr, String publicExpoentStr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        BigInteger publicModulus = new BigInteger(publicMudulusStr, radix);
        BigInteger publicExponent = new BigInteger(publicExpoentStr, radix);
        RSAPublicKeySpec keySpecPublic = new RSAPublicKeySpec( publicModulus, publicExponent) ;
        PublicKey publicKey = keyFactory.generatePublic(keySpecPublic);
        return publicKey;
    }

}
