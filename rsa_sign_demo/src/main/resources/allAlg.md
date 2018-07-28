```
[TestNG] Running:
Provider: SUN
  Algorithm  Pattern: SUN: SecureRandom.SHA1PRNG -> sun.security.provider.SecureRandom
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: Signature.SHA1withDSA -> sun.security.provider.DSA$SHA1withDSA
  aliases: [DSA, DSS, SHA/DSA, SHA-1/DSA, SHA1/DSA, SHAwithDSA, DSAWithSHA1, OID.1.2.840.10040.4.3, 1.2.840.10040.4.3, 1.3.14.3.2.13, 1.3.14.3.2.27]
  attributes: {ImplementedIn=Software, KeySize=1024, SupportedKeyClasses=java.security.interfaces.DSAPublicKey|java.security.interfaces.DSAPrivateKey}

  Algorithm  Pattern: SUN: Signature.NONEwithDSA -> sun.security.provider.DSA$RawDSA
  aliases: [RawDSA]
  attributes: {KeySize=1024, SupportedKeyClasses=java.security.interfaces.DSAPublicKey|java.security.interfaces.DSAPrivateKey}

  Algorithm  Pattern: SUN: Signature.SHA224withDSA -> sun.security.provider.DSA$SHA224withDSA
  aliases: [OID.2.16.840.1.101.3.4.3.1, 2.16.840.1.101.3.4.3.1]
  attributes: {KeySize=2048, SupportedKeyClasses=java.security.interfaces.DSAPublicKey|java.security.interfaces.DSAPrivateKey}

  Algorithm  Pattern: SUN: Signature.SHA256withDSA -> sun.security.provider.DSA$SHA256withDSA
  aliases: [OID.2.16.840.1.101.3.4.3.2, 2.16.840.1.101.3.4.3.2]
  attributes: {KeySize=2048, SupportedKeyClasses=java.security.interfaces.DSAPublicKey|java.security.interfaces.DSAPrivateKey}

  Algorithm  Pattern: SUN: KeyPairGenerator.DSA -> sun.security.provider.DSAKeyPairGenerator
  aliases: [OID.1.2.840.10040.4.1, 1.2.840.10040.4.1, 1.3.14.3.2.12]
  attributes: {ImplementedIn=Software, KeySize=2048}

  Algorithm  Pattern: SUN: MessageDigest.MD2 -> sun.security.provider.MD2

  Algorithm  Pattern: SUN: MessageDigest.MD5 -> sun.security.provider.MD5
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: MessageDigest.SHA -> sun.security.provider.SHA
  aliases: [SHA-1, SHA1, 1.3.14.3.2.26, OID.1.3.14.3.2.26]
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: MessageDigest.SHA-224 -> sun.security.provider.SHA2$SHA224
  aliases: [2.16.840.1.101.3.4.2.4, OID.2.16.840.1.101.3.4.2.4]

  Algorithm  Pattern: SUN: MessageDigest.SHA-256 -> sun.security.provider.SHA2$SHA256
  aliases: [2.16.840.1.101.3.4.2.1, OID.2.16.840.1.101.3.4.2.1]

  Algorithm  Pattern: SUN: MessageDigest.SHA-384 -> sun.security.provider.SHA5$SHA384
  aliases: [2.16.840.1.101.3.4.2.2, OID.2.16.840.1.101.3.4.2.2]

  Algorithm  Pattern: SUN: MessageDigest.SHA-512 -> sun.security.provider.SHA5$SHA512
  aliases: [2.16.840.1.101.3.4.2.3, OID.2.16.840.1.101.3.4.2.3]

  Algorithm  Pattern: SUN: AlgorithmParameterGenerator.DSA -> sun.security.provider.DSAParameterGenerator
  attributes: {ImplementedIn=Software, KeySize=2048}

  Algorithm  Pattern: SUN: AlgorithmParameters.DSA -> sun.security.provider.DSAParameters
  aliases: [OID.1.2.840.10040.4.1, 1.2.840.10040.4.1, 1.3.14.3.2.12]
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: KeyFactory.DSA -> sun.security.provider.DSAKeyFactory
  aliases: [OID.1.2.840.10040.4.1, 1.2.840.10040.4.1, 1.3.14.3.2.12]
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: CertificateFactory.X.509 -> sun.security.provider.X509Factory
  aliases: [X509]
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: KeyStore.JKS -> sun.security.provider.JavaKeyStore$DualFormatJKS
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: KeyStore.CaseExactJKS -> sun.security.provider.JavaKeyStore$CaseExactJKS

  Algorithm  Pattern: SUN: KeyStore.DKS -> sun.security.provider.DomainKeyStore$DKS

  Algorithm  Pattern: SUN: Policy.JavaPolicy -> sun.security.provider.PolicySpiFile

  Algorithm  Pattern: SUN: Configuration.JavaLoginConfig -> sun.security.provider.ConfigFile$Spi

  Algorithm  Pattern: SUN: CertPathBuilder.PKIX -> sun.security.provider.certpath.SunCertPathBuilder
  attributes: {ImplementedIn=Software, ValidationAlgorithm=RFC3280}

  Algorithm  Pattern: SUN: CertPathValidator.PKIX -> sun.security.provider.certpath.PKIXCertPathValidator
  attributes: {ImplementedIn=Software, ValidationAlgorithm=RFC3280}

  Algorithm  Pattern: SUN: CertStore.LDAP -> sun.security.provider.certpath.ldap.LDAPCertStore
  attributes: {ImplementedIn=Software, LDAPSchema=RFC2587}

  Algorithm  Pattern: SUN: CertStore.Collection -> sun.security.provider.certpath.CollectionCertStore
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SUN: CertStore.com.sun.security.IndexedCollection -> sun.security.provider.certpath.IndexedCollectionCertStore
  attributes: {ImplementedIn=Software}



Provider: SunRsaSign
  Algorithm  Pattern: SunRsaSign: KeyFactory.RSA -> sun.security.rsa.RSAKeyFactory
  aliases: [1.2.840.113549.1.1, OID.1.2.840.113549.1.1]

  Algorithm  Pattern: SunRsaSign: KeyPairGenerator.RSA -> sun.security.rsa.RSAKeyPairGenerator
  aliases: [1.2.840.113549.1.1, OID.1.2.840.113549.1.1]

  Algorithm  Pattern: SunRsaSign: Signature.MD2withRSA -> sun.security.rsa.RSASignature$MD2withRSA
  aliases: [1.2.840.113549.1.1.2, OID.1.2.840.113549.1.1.2]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunRsaSign: Signature.MD5withRSA -> sun.security.rsa.RSASignature$MD5withRSA
  aliases: [1.2.840.113549.1.1.4, OID.1.2.840.113549.1.1.4]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunRsaSign: Signature.SHA1withRSA -> sun.security.rsa.RSASignature$SHA1withRSA
  aliases: [1.2.840.113549.1.1.5, OID.1.2.840.113549.1.1.5, 1.3.14.3.2.29]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunRsaSign: Signature.SHA224withRSA -> sun.security.rsa.RSASignature$SHA224withRSA
  aliases: [1.2.840.113549.1.1.14, OID.1.2.840.113549.1.1.14]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunRsaSign: Signature.SHA256withRSA -> sun.security.rsa.RSASignature$SHA256withRSA
  aliases: [1.2.840.113549.1.1.11, OID.1.2.840.113549.1.1.11]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunRsaSign: Signature.SHA384withRSA -> sun.security.rsa.RSASignature$SHA384withRSA
  aliases: [1.2.840.113549.1.1.12, OID.1.2.840.113549.1.1.12]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunRsaSign: Signature.SHA512withRSA -> sun.security.rsa.RSASignature$SHA512withRSA
  aliases: [1.2.840.113549.1.1.13, OID.1.2.840.113549.1.1.13]
  attributes: {SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}



Provider: SunEC
  Algorithm  Pattern: SunEC: KeyFactory.EC -> sun.security.ec.ECKeyFactory
  aliases: [EllipticCurve]
  attributes: {ImplementedIn=Software}

  Algorithm  Pattern: SunEC: AlgorithmParameters.EC -> sun.security.ec.ECParameters
  aliases: [EllipticCurve, 1.2.840.10045.2.1]
  attributes: {ImplementedIn=Software, KeySize=256, SupportedCurves=[secp112r1,1.3.132.0.6]|[secp112r2,1.3.132.0.7]|[secp128r1,1.3.132.0.28]|[secp128r2,1.3.132.0.29]|[secp160k1,1.3.132.0.9]|[secp160r1,1.3.132.0.8]|[secp160r2,1.3.132.0.30]|[secp192k1,1.3.132.0.31]|[secp192r1,NIST P-192,X9.62 prime192v1,1.2.840.10045.3.1.1]|[secp224k1,1.3.132.0.32]|[secp224r1,NIST P-224,1.3.132.0.33]|[secp256k1,1.3.132.0.10]|[secp256r1,NIST P-256,X9.62 prime256v1,1.2.840.10045.3.1.7]|[secp384r1,NIST P-384,1.3.132.0.34]|[secp521r1,NIST P-521,1.3.132.0.35]|[X9.62 prime192v2,1.2.840.10045.3.1.2]|[X9.62 prime192v3,1.2.840.10045.3.1.3]|[X9.62 prime239v1,1.2.840.10045.3.1.4]|[X9.62 prime239v2,1.2.840.10045.3.1.5]|[X9.62 prime239v3,1.2.840.10045.3.1.6]|[sect113r1,1.3.132.0.4]|[sect113r2,1.3.132.0.5]|[sect131r1,1.3.132.0.22]|[sect131r2,1.3.132.0.23]|[sect163k1,NIST K-163,1.3.132.0.1]|[sect163r1,1.3.132.0.2]|[sect163r2,NIST B-163,1.3.132.0.15]|[sect193r1,1.3.132.0.24]|[sect193r2,1.3.132.0.25]|[sect233k1,NIST K-233,1.3.132.0.26]|[sect233r1,NIST B-233,1.3.132.0.27]|[sect239k1,1.3.132.0.3]|[sect283k1,NIST K-283,1.3.132.0.16]|[sect283r1,NIST B-283,1.3.132.0.17]|[sect409k1,NIST K-409,1.3.132.0.36]|[sect409r1,NIST B-409,1.3.132.0.37]|[sect571k1,NIST K-571,1.3.132.0.38]|[sect571r1,NIST B-571,1.3.132.0.39]|[X9.62 c2tnb191v1,1.2.840.10045.3.0.5]|[X9.62 c2tnb191v2,1.2.840.10045.3.0.6]|[X9.62 c2tnb191v3,1.2.840.10045.3.0.7]|[X9.62 c2tnb239v1,1.2.840.10045.3.0.11]|[X9.62 c2tnb239v2,1.2.840.10045.3.0.12]|[X9.62 c2tnb239v3,1.2.840.10045.3.0.13]|[X9.62 c2tnb359v1,1.2.840.10045.3.0.18]|[X9.62 c2tnb431r1,1.2.840.10045.3.0.20]}

  Algorithm  Pattern: SunEC: Signature.NONEwithECDSA -> sun.security.ec.ECDSASignature$Raw
  attributes: {ImplementedIn=Software, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: SunEC: Signature.SHA1withECDSA -> sun.security.ec.ECDSASignature$SHA1
  aliases: [OID.1.2.840.10045.4.1, 1.2.840.10045.4.1]
  attributes: {ImplementedIn=Software, KeySize=256, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: SunEC: Signature.SHA224withECDSA -> sun.security.ec.ECDSASignature$SHA224
  aliases: [OID.1.2.840.10045.4.3.1, 1.2.840.10045.4.3.1]
  attributes: {ImplementedIn=Software, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: SunEC: Signature.SHA256withECDSA -> sun.security.ec.ECDSASignature$SHA256
  aliases: [OID.1.2.840.10045.4.3.2, 1.2.840.10045.4.3.2]
  attributes: {ImplementedIn=Software, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: SunEC: Signature.SHA384withECDSA -> sun.security.ec.ECDSASignature$SHA384
  aliases: [OID.1.2.840.10045.4.3.3, 1.2.840.10045.4.3.3]
  attributes: {ImplementedIn=Software, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: SunEC: Signature.SHA512withECDSA -> sun.security.ec.ECDSASignature$SHA512
  aliases: [OID.1.2.840.10045.4.3.4, 1.2.840.10045.4.3.4]
  attributes: {ImplementedIn=Software, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: SunEC: KeyPairGenerator.EC -> sun.security.ec.ECKeyPairGenerator
  aliases: [EllipticCurve]
  attributes: {ImplementedIn=Software, KeySize=256}

  Algorithm  Pattern: SunEC: KeyAgreement.ECDH -> sun.security.ec.ECDHKeyAgreement
  attributes: {ImplementedIn=Software, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}



Provider: SunJSSE
  Algorithm  Pattern: SunJSSE: KeyFactory.RSA -> sun.security.rsa.RSAKeyFactory
  aliases: [1.2.840.113549.1.1, OID.1.2.840.113549.1.1]

  Algorithm  Pattern: SunJSSE: KeyPairGenerator.RSA -> sun.security.rsa.RSAKeyPairGenerator
  aliases: [1.2.840.113549.1.1, OID.1.2.840.113549.1.1]

  Algorithm  Pattern: SunJSSE: Signature.MD2withRSA -> sun.security.rsa.RSASignature$MD2withRSA
  aliases: [1.2.840.113549.1.1.2, OID.1.2.840.113549.1.1.2]

  Algorithm  Pattern: SunJSSE: Signature.MD5withRSA -> sun.security.rsa.RSASignature$MD5withRSA
  aliases: [1.2.840.113549.1.1.4, OID.1.2.840.113549.1.1.4]

  Algorithm  Pattern: SunJSSE: Signature.SHA1withRSA -> sun.security.rsa.RSASignature$SHA1withRSA
  aliases: [1.2.840.113549.1.1.5, OID.1.2.840.113549.1.1.5, 1.3.14.3.2.29, OID.1.3.14.3.2.29]

  Algorithm  Pattern: SunJSSE: Signature.MD5andSHA1withRSA -> sun.security.ssl.RSASignature

  Algorithm  Pattern: SunJSSE: KeyManagerFactory.SunX509 -> sun.security.ssl.KeyManagerFactoryImpl$SunX509

  Algorithm  Pattern: SunJSSE: KeyManagerFactory.NewSunX509 -> sun.security.ssl.KeyManagerFactoryImpl$X509
  aliases: [PKIX]

  Algorithm  Pattern: SunJSSE: TrustManagerFactory.SunX509 -> sun.security.ssl.TrustManagerFactoryImpl$SimpleFactory

  Algorithm  Pattern: SunJSSE: TrustManagerFactory.PKIX -> sun.security.ssl.TrustManagerFactoryImpl$PKIXFactory
  aliases: [SunPKIX, X509, X.509]

  Algorithm  Pattern: SunJSSE: SSLContext.TLSv1 -> sun.security.ssl.SSLContextImpl$TLS10Context
  aliases: [SSLv3]

  Algorithm  Pattern: SunJSSE: SSLContext.TLSv1.1 -> sun.security.ssl.SSLContextImpl$TLS11Context

  Algorithm  Pattern: SunJSSE: SSLContext.TLSv1.2 -> sun.security.ssl.SSLContextImpl$TLS12Context

  Algorithm  Pattern: SunJSSE: SSLContext.TLS -> sun.security.ssl.SSLContextImpl$TLSContext
  aliases: [SSL]

  Algorithm  Pattern: SunJSSE: SSLContext.Default -> sun.security.ssl.SSLContextImpl$DefaultSSLContext

  Algorithm  Pattern: SunJSSE: KeyStore.PKCS12 -> sun.security.pkcs12.PKCS12KeyStore



Provider: SunJCE
  Algorithm  Pattern: SunJCE: Cipher.RSA -> com.sun.crypto.provider.RSACipher
  attributes: {SupportedPaddings=NOPADDING|PKCS1PADDING|OAEPPADDING|OAEPWITHMD5ANDMGF1PADDING|OAEPWITHSHA1ANDMGF1PADDING|OAEPWITHSHA-1ANDMGF1PADDING|OAEPWITHSHA-224ANDMGF1PADDING|OAEPWITHSHA-256ANDMGF1PADDING|OAEPWITHSHA-384ANDMGF1PADDING|OAEPWITHSHA-512ANDMGF1PADDING, SupportedModes=ECB, SupportedKeyClasses=java.security.interfaces.RSAPublicKey|java.security.interfaces.RSAPrivateKey}

  Algorithm  Pattern: SunJCE: Cipher.DES -> com.sun.crypto.provider.DESCipher
  attributes: {SupportedPaddings=NOPADDING|PKCS5PADDING|ISO10126PADDING, SupportedKeyFormats=RAW, SupportedModes=ECB|CBC|PCBC|CTR|CTS|CFB|OFB|CFB8|CFB16|CFB24|CFB32|CFB40|CFB48|CFB56|CFB64|OFB8|OFB16|OFB24|OFB32|OFB40|OFB48|OFB56|OFB64}

  Algorithm  Pattern: SunJCE: Cipher.DESede -> com.sun.crypto.provider.DESedeCipher
  aliases: [TripleDES]
  attributes: {SupportedPaddings=NOPADDING|PKCS5PADDING|ISO10126PADDING, SupportedKeyFormats=RAW, SupportedModes=ECB|CBC|PCBC|CTR|CTS|CFB|OFB|CFB8|CFB16|CFB24|CFB32|CFB40|CFB48|CFB56|CFB64|OFB8|OFB16|OFB24|OFB32|OFB40|OFB48|OFB56|OFB64}

  Algorithm  Pattern: SunJCE: Cipher.DESedeWrap -> com.sun.crypto.provider.DESedeWrapCipher
  attributes: {SupportedPaddings=NOPADDING, SupportedKeyFormats=RAW, SupportedModes=CBC}

  Algorithm  Pattern: SunJCE: Cipher.PBEWithMD5AndDES -> com.sun.crypto.provider.PBEWithMD5AndDESCipher
  aliases: [OID.1.2.840.113549.1.5.3, 1.2.840.113549.1.5.3]

  Algorithm  Pattern: SunJCE: Cipher.PBEWithMD5AndTripleDES -> com.sun.crypto.provider.PBEWithMD5AndTripleDESCipher

  Algorithm  Pattern: SunJCE: Cipher.PBEWithSHA1AndDESede -> com.sun.crypto.provider.PKCS12PBECipherCore$PBEWithSHA1AndDESede
  aliases: [OID.1.2.840.113549.1.12.1.3, 1.2.840.113549.1.12.1.3]

  Algorithm  Pattern: SunJCE: Cipher.PBEWithSHA1AndRC2_40 -> com.sun.crypto.provider.PKCS12PBECipherCore$PBEWithSHA1AndRC2_40
  aliases: [OID.1.2.840.113549.1.12.1.6, 1.2.840.113549.1.12.1.6]

  Algorithm  Pattern: SunJCE: Cipher.PBEWithSHA1AndRC2_128 -> com.sun.crypto.provider.PKCS12PBECipherCore$PBEWithSHA1AndRC2_128
  aliases: [OID.1.2.840.113549.1.12.1.5, 1.2.840.113549.1.12.1.5]

  Algorithm  Pattern: SunJCE: Cipher.PBEWithSHA1AndRC4_40 -> com.sun.crypto.provider.PKCS12PBECipherCore$PBEWithSHA1AndRC4_40
  aliases: [OID.1.2.840.113549.1.12.1.2, 1.2.840.113549.1.12.1.2]

  Algorithm  Pattern: SunJCE: Cipher.PBEWithSHA1AndRC4_128 -> com.sun.crypto.provider.PKCS12PBECipherCore$PBEWithSHA1AndRC4_128
  aliases: [OID.1.2.840.113549.1.12.1.1, 1.2.840.113549.1.12.1.1]

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA1AndAES_128 -> com.sun.crypto.provider.PBES2Core$HmacSHA1AndAES_128

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA224AndAES_128 -> com.sun.crypto.provider.PBES2Core$HmacSHA224AndAES_128

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA256AndAES_128 -> com.sun.crypto.provider.PBES2Core$HmacSHA256AndAES_128

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA384AndAES_128 -> com.sun.crypto.provider.PBES2Core$HmacSHA384AndAES_128

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA512AndAES_128 -> com.sun.crypto.provider.PBES2Core$HmacSHA512AndAES_128

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA1AndAES_256 -> com.sun.crypto.provider.PBES2Core$HmacSHA1AndAES_256

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA224AndAES_256 -> com.sun.crypto.provider.PBES2Core$HmacSHA224AndAES_256

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA256AndAES_256 -> com.sun.crypto.provider.PBES2Core$HmacSHA256AndAES_256

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA384AndAES_256 -> com.sun.crypto.provider.PBES2Core$HmacSHA384AndAES_256

  Algorithm  Pattern: SunJCE: Cipher.PBEWithHmacSHA512AndAES_256 -> com.sun.crypto.provider.PBES2Core$HmacSHA512AndAES_256

  Algorithm  Pattern: SunJCE: Cipher.Blowfish -> com.sun.crypto.provider.BlowfishCipher
  attributes: {SupportedPaddings=NOPADDING|PKCS5PADDING|ISO10126PADDING, SupportedKeyFormats=RAW, SupportedModes=ECB|CBC|PCBC|CTR|CTS|CFB|OFB|CFB8|CFB16|CFB24|CFB32|CFB40|CFB48|CFB56|CFB64|OFB8|OFB16|OFB24|OFB32|OFB40|OFB48|OFB56|OFB64}

  Algorithm  Pattern: SunJCE: Cipher.AES -> com.sun.crypto.provider.AESCipher$General
  aliases: [Rijndael]
  attributes: {SupportedPaddings=NOPADDING|PKCS5PADDING|ISO10126PADDING, SupportedKeyFormats=RAW, SupportedModes=ECB|CBC|PCBC|CTR|CTS|CFB|OFB|CFB8|CFB16|CFB24|CFB32|CFB40|CFB48|CFB56|CFB64|OFB8|OFB16|OFB24|OFB32|OFB40|OFB48|OFB56|OFB64|GCM|CFB72|CFB80|CFB88|CFB96|CFB104|CFB112|CFB120|CFB128|OFB72|OFB80|OFB88|OFB96|OFB104|OFB112|OFB120|OFB128}

  Algorithm  Pattern: SunJCE: Cipher.AES_128/ECB/NoPadding -> com.sun.crypto.provider.AESCipher$AES128_ECB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.1, OID.2.16.840.1.101.3.4.1.1]

  Algorithm  Pattern: SunJCE: Cipher.AES_128/CBC/NoPadding -> com.sun.crypto.provider.AESCipher$AES128_CBC_NoPadding
  aliases: [2.16.840.1.101.3.4.1.2, OID.2.16.840.1.101.3.4.1.2]

  Algorithm  Pattern: SunJCE: Cipher.AES_128/OFB/NoPadding -> com.sun.crypto.provider.AESCipher$AES128_OFB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.3, OID.2.16.840.1.101.3.4.1.3]

  Algorithm  Pattern: SunJCE: Cipher.AES_128/CFB/NoPadding -> com.sun.crypto.provider.AESCipher$AES128_CFB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.4, OID.2.16.840.1.101.3.4.1.4]

  Algorithm  Pattern: SunJCE: Cipher.AES_128/GCM/NoPadding -> com.sun.crypto.provider.AESCipher$AES128_GCM_NoPadding
  aliases: [2.16.840.1.101.3.4.1.6, OID.2.16.840.1.101.3.4.1.6]

  Algorithm  Pattern: SunJCE: Cipher.AES_192/ECB/NoPadding -> com.sun.crypto.provider.AESCipher$AES192_ECB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.21, OID.2.16.840.1.101.3.4.1.21]

  Algorithm  Pattern: SunJCE: Cipher.AES_192/CBC/NoPadding -> com.sun.crypto.provider.AESCipher$AES192_CBC_NoPadding
  aliases: [2.16.840.1.101.3.4.1.22, OID.2.16.840.1.101.3.4.1.22]

  Algorithm  Pattern: SunJCE: Cipher.AES_192/OFB/NoPadding -> com.sun.crypto.provider.AESCipher$AES192_OFB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.23, OID.2.16.840.1.101.3.4.1.23]

  Algorithm  Pattern: SunJCE: Cipher.AES_192/CFB/NoPadding -> com.sun.crypto.provider.AESCipher$AES192_CFB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.24, OID.2.16.840.1.101.3.4.1.24]

  Algorithm  Pattern: SunJCE: Cipher.AES_192/GCM/NoPadding -> com.sun.crypto.provider.AESCipher$AES192_GCM_NoPadding
  aliases: [2.16.840.1.101.3.4.1.26, OID.2.16.840.1.101.3.4.1.26]

  Algorithm  Pattern: SunJCE: Cipher.AES_256/ECB/NoPadding -> com.sun.crypto.provider.AESCipher$AES256_ECB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.41, OID.2.16.840.1.101.3.4.1.41]

  Algorithm  Pattern: SunJCE: Cipher.AES_256/CBC/NoPadding -> com.sun.crypto.provider.AESCipher$AES256_CBC_NoPadding
  aliases: [2.16.840.1.101.3.4.1.42, OID.2.16.840.1.101.3.4.1.42]

  Algorithm  Pattern: SunJCE: Cipher.AES_256/OFB/NoPadding -> com.sun.crypto.provider.AESCipher$AES256_OFB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.43, OID.2.16.840.1.101.3.4.1.43]

  Algorithm  Pattern: SunJCE: Cipher.AES_256/CFB/NoPadding -> com.sun.crypto.provider.AESCipher$AES256_CFB_NoPadding
  aliases: [2.16.840.1.101.3.4.1.44, OID.2.16.840.1.101.3.4.1.44]

  Algorithm  Pattern: SunJCE: Cipher.AES_256/GCM/NoPadding -> com.sun.crypto.provider.AESCipher$AES256_GCM_NoPadding
  aliases: [2.16.840.1.101.3.4.1.46, OID.2.16.840.1.101.3.4.1.46]

  Algorithm  Pattern: SunJCE: Cipher.AESWrap -> com.sun.crypto.provider.AESWrapCipher$General
  attributes: {SupportedPaddings=NOPADDING, SupportedKeyFormats=RAW, SupportedModes=ECB}

  Algorithm  Pattern: SunJCE: Cipher.AESWrap_128 -> com.sun.crypto.provider.AESWrapCipher$AES128
  aliases: [2.16.840.1.101.3.4.1.5, OID.2.16.840.1.101.3.4.1.5]

  Algorithm  Pattern: SunJCE: Cipher.AESWrap_192 -> com.sun.crypto.provider.AESWrapCipher$AES192
  aliases: [2.16.840.1.101.3.4.1.25, OID.2.16.840.1.101.3.4.1.25]

  Algorithm  Pattern: SunJCE: Cipher.AESWrap_256 -> com.sun.crypto.provider.AESWrapCipher$AES256
  aliases: [2.16.840.1.101.3.4.1.45, OID.2.16.840.1.101.3.4.1.45]

  Algorithm  Pattern: SunJCE: Cipher.RC2 -> com.sun.crypto.provider.RC2Cipher
  attributes: {SupportedPaddings=NOPADDING|PKCS5PADDING|ISO10126PADDING, SupportedKeyFormats=RAW, SupportedModes=ECB|CBC|PCBC|CTR|CTS|CFB|OFB|CFB8|CFB16|CFB24|CFB32|CFB40|CFB48|CFB56|CFB64|OFB8|OFB16|OFB24|OFB32|OFB40|OFB48|OFB56|OFB64}

  Algorithm  Pattern: SunJCE: Cipher.ARCFOUR -> com.sun.crypto.provider.ARCFOURCipher
  aliases: [RC4]
  attributes: {SupportedPaddings=NOPADDING, SupportedKeyFormats=RAW, SupportedModes=ECB}

  Algorithm  Pattern: SunJCE: KeyGenerator.DES -> com.sun.crypto.provider.DESKeyGenerator

  Algorithm  Pattern: SunJCE: KeyGenerator.DESede -> com.sun.crypto.provider.DESedeKeyGenerator
  aliases: [TripleDES]

  Algorithm  Pattern: SunJCE: KeyGenerator.Blowfish -> com.sun.crypto.provider.BlowfishKeyGenerator

  Algorithm  Pattern: SunJCE: KeyGenerator.AES -> com.sun.crypto.provider.AESKeyGenerator
  aliases: [Rijndael]

  Algorithm  Pattern: SunJCE: KeyGenerator.RC2 -> com.sun.crypto.provider.KeyGeneratorCore$RC2KeyGenerator

  Algorithm  Pattern: SunJCE: KeyGenerator.ARCFOUR -> com.sun.crypto.provider.KeyGeneratorCore$ARCFOURKeyGenerator
  aliases: [RC4]

  Algorithm  Pattern: SunJCE: KeyGenerator.HmacMD5 -> com.sun.crypto.provider.HmacMD5KeyGenerator

  Algorithm  Pattern: SunJCE: KeyGenerator.HmacSHA1 -> com.sun.crypto.provider.HmacSHA1KeyGenerator
  aliases: [OID.1.2.840.113549.2.7, 1.2.840.113549.2.7]

  Algorithm  Pattern: SunJCE: KeyGenerator.HmacSHA224 -> com.sun.crypto.provider.KeyGeneratorCore$HmacSHA2KG$SHA224
  aliases: [OID.1.2.840.113549.2.8, 1.2.840.113549.2.8]

  Algorithm  Pattern: SunJCE: KeyGenerator.HmacSHA256 -> com.sun.crypto.provider.KeyGeneratorCore$HmacSHA2KG$SHA256
  aliases: [OID.1.2.840.113549.2.9, 1.2.840.113549.2.9]

  Algorithm  Pattern: SunJCE: KeyGenerator.HmacSHA384 -> com.sun.crypto.provider.KeyGeneratorCore$HmacSHA2KG$SHA384
  aliases: [OID.1.2.840.113549.2.10, 1.2.840.113549.2.10]

  Algorithm  Pattern: SunJCE: KeyGenerator.HmacSHA512 -> com.sun.crypto.provider.KeyGeneratorCore$HmacSHA2KG$SHA512
  aliases: [OID.1.2.840.113549.2.11, 1.2.840.113549.2.11]

  Algorithm  Pattern: SunJCE: KeyPairGenerator.DiffieHellman -> com.sun.crypto.provider.DHKeyPairGenerator
  aliases: [DH, OID.1.2.840.113549.1.3.1, 1.2.840.113549.1.3.1]

  Algorithm  Pattern: SunJCE: AlgorithmParameterGenerator.DiffieHellman -> com.sun.crypto.provider.DHParameterGenerator
  aliases: [DH, OID.1.2.840.113549.1.3.1, 1.2.840.113549.1.3.1]

  Algorithm  Pattern: SunJCE: KeyAgreement.DiffieHellman -> com.sun.crypto.provider.DHKeyAgreement
  aliases: [DH, OID.1.2.840.113549.1.3.1, 1.2.840.113549.1.3.1]
  attributes: {SupportedKeyClasses=javax.crypto.interfaces.DHPublicKey|javax.crypto.interfaces.DHPrivateKey}

  Algorithm  Pattern: SunJCE: AlgorithmParameters.DiffieHellman -> com.sun.crypto.provider.DHParameters
  aliases: [DH, OID.1.2.840.113549.1.3.1, 1.2.840.113549.1.3.1]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.DES -> com.sun.crypto.provider.DESParameters

  Algorithm  Pattern: SunJCE: AlgorithmParameters.DESede -> com.sun.crypto.provider.DESedeParameters
  aliases: [TripleDES]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBE -> com.sun.crypto.provider.PBEParameters

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithMD5AndDES -> com.sun.crypto.provider.PBEParameters
  aliases: [OID.1.2.840.113549.1.5.3, 1.2.840.113549.1.5.3]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithMD5AndTripleDES -> com.sun.crypto.provider.PBEParameters

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithSHA1AndDESede -> com.sun.crypto.provider.PBEParameters
  aliases: [OID.1.2.840.113549.1.12.1.3, 1.2.840.113549.1.12.1.3]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithSHA1AndRC2_40 -> com.sun.crypto.provider.PBEParameters
  aliases: [OID.1.2.840.113549.1.12.1.6, 1.2.840.113549.1.12.1.6]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithSHA1AndRC2_128 -> com.sun.crypto.provider.PBEParameters
  aliases: [OID.1.2.840.113549.1.12.1.5, 1.2.840.113549.1.12.1.5]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithSHA1AndRC4_40 -> com.sun.crypto.provider.PBEParameters
  aliases: [OID.1.2.840.113549.1.12.1.2, 1.2.840.113549.1.12.1.2]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithSHA1AndRC4_128 -> com.sun.crypto.provider.PBEParameters
  aliases: [OID.1.2.840.113549.1.12.1.1, 1.2.840.113549.1.12.1.1]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBES2 -> com.sun.crypto.provider.PBES2Parameters$General
  aliases: [OID.1.2.840.113549.1.5.13, 1.2.840.113549.1.5.13]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA1AndAES_128 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA1AndAES_128

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA224AndAES_128 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA224AndAES_128

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA256AndAES_128 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA256AndAES_128

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA384AndAES_128 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA384AndAES_128

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA512AndAES_128 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA512AndAES_128

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA1AndAES_256 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA1AndAES_256

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA224AndAES_256 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA224AndAES_256

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA256AndAES_256 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA256AndAES_256

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA384AndAES_256 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA384AndAES_256

  Algorithm  Pattern: SunJCE: AlgorithmParameters.PBEWithHmacSHA512AndAES_256 -> com.sun.crypto.provider.PBES2Parameters$HmacSHA512AndAES_256

  Algorithm  Pattern: SunJCE: AlgorithmParameters.Blowfish -> com.sun.crypto.provider.BlowfishParameters

  Algorithm  Pattern: SunJCE: AlgorithmParameters.AES -> com.sun.crypto.provider.AESParameters
  aliases: [Rijndael]

  Algorithm  Pattern: SunJCE: AlgorithmParameters.GCM -> com.sun.crypto.provider.GCMParameters

  Algorithm  Pattern: SunJCE: AlgorithmParameters.RC2 -> com.sun.crypto.provider.RC2Parameters

  Algorithm  Pattern: SunJCE: AlgorithmParameters.OAEP -> com.sun.crypto.provider.OAEPParameters

  Algorithm  Pattern: SunJCE: KeyFactory.DiffieHellman -> com.sun.crypto.provider.DHKeyFactory
  aliases: [DH, OID.1.2.840.113549.1.3.1, 1.2.840.113549.1.3.1]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.DES -> com.sun.crypto.provider.DESKeyFactory

  Algorithm  Pattern: SunJCE: SecretKeyFactory.DESede -> com.sun.crypto.provider.DESedeKeyFactory
  aliases: [TripleDES]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithMD5AndDES -> com.sun.crypto.provider.PBEKeyFactory$PBEWithMD5AndDES
  aliases: [OID.1.2.840.113549.1.5.3, 1.2.840.113549.1.5.3, PBE]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithMD5AndTripleDES -> com.sun.crypto.provider.PBEKeyFactory$PBEWithMD5AndTripleDES

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithSHA1AndDESede -> com.sun.crypto.provider.PBEKeyFactory$PBEWithSHA1AndDESede
  aliases: [OID.1.2.840.113549.1.12.1.3, 1.2.840.113549.1.12.1.3]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithSHA1AndRC2_40 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithSHA1AndRC2_40
  aliases: [OID.1.2.840.113549.1.12.1.6, 1.2.840.113549.1.12.1.6]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithSHA1AndRC2_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithSHA1AndRC2_128
  aliases: [OID.1.2.840.113549.1.12.1.5, 1.2.840.113549.1.12.1.5]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithSHA1AndRC4_40 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithSHA1AndRC4_40
  aliases: [OID.1.2.840.113549.1.12.1.2, 1.2.840.113549.1.12.1.2]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithSHA1AndRC4_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithSHA1AndRC4_128
  aliases: [OID.1.2.840.113549.1.12.1.1, 1.2.840.113549.1.12.1.1]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA1AndAES_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA1AndAES_128

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA224AndAES_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA224AndAES_128

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA256AndAES_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA256AndAES_128

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA384AndAES_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA384AndAES_128

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA512AndAES_128 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA512AndAES_128

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA1AndAES_256 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA1AndAES_256

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA224AndAES_256 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA224AndAES_256

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA256AndAES_256 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA256AndAES_256

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA384AndAES_256 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA384AndAES_256

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBEWithHmacSHA512AndAES_256 -> com.sun.crypto.provider.PBEKeyFactory$PBEWithHmacSHA512AndAES_256

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBKDF2WithHmacSHA1 -> com.sun.crypto.provider.PBKDF2Core$HmacSHA1
  aliases: [OID.1.2.840.113549.1.5.12, 1.2.840.113549.1.5.12]

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBKDF2WithHmacSHA224 -> com.sun.crypto.provider.PBKDF2Core$HmacSHA224

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBKDF2WithHmacSHA256 -> com.sun.crypto.provider.PBKDF2Core$HmacSHA256

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBKDF2WithHmacSHA384 -> com.sun.crypto.provider.PBKDF2Core$HmacSHA384

  Algorithm  Pattern: SunJCE: SecretKeyFactory.PBKDF2WithHmacSHA512 -> com.sun.crypto.provider.PBKDF2Core$HmacSHA512

  Algorithm  Pattern: SunJCE: Mac.HmacMD5 -> com.sun.crypto.provider.HmacMD5
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.HmacSHA1 -> com.sun.crypto.provider.HmacSHA1
  aliases: [OID.1.2.840.113549.2.7, 1.2.840.113549.2.7]
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.HmacSHA224 -> com.sun.crypto.provider.HmacCore$HmacSHA224
  aliases: [OID.1.2.840.113549.2.8, 1.2.840.113549.2.8]
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.HmacSHA256 -> com.sun.crypto.provider.HmacCore$HmacSHA256
  aliases: [OID.1.2.840.113549.2.9, 1.2.840.113549.2.9]
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.HmacSHA384 -> com.sun.crypto.provider.HmacCore$HmacSHA384
  aliases: [OID.1.2.840.113549.2.10, 1.2.840.113549.2.10]
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.HmacSHA512 -> com.sun.crypto.provider.HmacCore$HmacSHA512
  aliases: [OID.1.2.840.113549.2.11, 1.2.840.113549.2.11]
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.HmacPBESHA1 -> com.sun.crypto.provider.HmacPKCS12PBESHA1
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.PBEWithHmacSHA1 -> com.sun.crypto.provider.PBMAC1Core$HmacSHA1
  attributes: {SupportedKeyFormatS=RAW}

  Algorithm  Pattern: SunJCE: Mac.PBEWithHmacSHA224 -> com.sun.crypto.provider.PBMAC1Core$HmacSHA224
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.PBEWithHmacSHA256 -> com.sun.crypto.provider.PBMAC1Core$HmacSHA256
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.PBEWithHmacSHA384 -> com.sun.crypto.provider.PBMAC1Core$HmacSHA384
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.PBEWithHmacSHA512 -> com.sun.crypto.provider.PBMAC1Core$HmacSHA512
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.SslMacMD5 -> com.sun.crypto.provider.SslMacCore$SslMacMD5
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: Mac.SslMacSHA1 -> com.sun.crypto.provider.SslMacCore$SslMacSHA1
  attributes: {SupportedKeyFormats=RAW}

  Algorithm  Pattern: SunJCE: KeyStore.JCEKS -> com.sun.crypto.provider.JceKeyStore

  Algorithm  Pattern: SunJCE: KeyGenerator.SunTlsPrf -> com.sun.crypto.provider.TlsPrfGenerator$V10

  Algorithm  Pattern: SunJCE: KeyGenerator.SunTls12Prf -> com.sun.crypto.provider.TlsPrfGenerator$V12

  Algorithm  Pattern: SunJCE: KeyGenerator.SunTlsMasterSecret -> com.sun.crypto.provider.TlsMasterSecretGenerator
  aliases: [SunTls12MasterSecret]

  Algorithm  Pattern: SunJCE: KeyGenerator.SunTlsKeyMaterial -> com.sun.crypto.provider.TlsKeyMaterialGenerator
  aliases: [SunTls12KeyMaterial]

  Algorithm  Pattern: SunJCE: KeyGenerator.SunTlsRsaPremasterSecret -> com.sun.crypto.provider.TlsRsaPremasterSecretGenerator
  aliases: [SunTls12RsaPremasterSecret]



Provider: SunJGSS
  Algorithm  Pattern: SunJGSS: GssApiMechanism.1.2.840.113554.1.2.2 -> sun.security.jgss.krb5.Krb5MechFactory

  Algorithm  Pattern: SunJGSS: GssApiMechanism.1.3.6.1.5.5.2 -> sun.security.jgss.spnego.SpNegoMechFactory



Provider: SunSASL
  Algorithm  Pattern: SunSASL: SaslClientFactory.DIGEST-MD5 -> com.sun.security.sasl.digest.FactoryImpl

  Algorithm  Pattern: SunSASL: SaslClientFactory.NTLM -> com.sun.security.sasl.ntlm.FactoryImpl

  Algorithm  Pattern: SunSASL: SaslClientFactory.GSSAPI -> com.sun.security.sasl.gsskerb.FactoryImpl

  Algorithm  Pattern: SunSASL: SaslClientFactory.EXTERNAL -> com.sun.security.sasl.ClientFactoryImpl

  Algorithm  Pattern: SunSASL: SaslClientFactory.PLAIN -> com.sun.security.sasl.ClientFactoryImpl

  Algorithm  Pattern: SunSASL: SaslClientFactory.CRAM-MD5 -> com.sun.security.sasl.ClientFactoryImpl

  Algorithm  Pattern: SunSASL: SaslServerFactory.CRAM-MD5 -> com.sun.security.sasl.ServerFactoryImpl

  Algorithm  Pattern: SunSASL: SaslServerFactory.GSSAPI -> com.sun.security.sasl.gsskerb.FactoryImpl

  Algorithm  Pattern: SunSASL: SaslServerFactory.DIGEST-MD5 -> com.sun.security.sasl.digest.FactoryImpl

  Algorithm  Pattern: SunSASL: SaslServerFactory.NTLM -> com.sun.security.sasl.ntlm.FactoryImpl



Provider: XMLDSig
  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2006/12/xml-c14n11#WithComments -> org.jcp.xml.dsig.internal.dom.DOMCanonicalXMLC14N11Method
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2000/09/xmldsig#base64 -> org.jcp.xml.dsig.internal.dom.DOMBase64Transform
  aliases: [BASE64]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/TR/1999/REC-xslt-19991116 -> org.jcp.xml.dsig.internal.dom.DOMXSLTTransform
  aliases: [XSLT]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2001/10/xml-exc-c14n# -> org.jcp.xml.dsig.internal.dom.DOMExcC14NMethod
  aliases: [EXCLUSIVE]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments -> org.jcp.xml.dsig.internal.dom.DOMCanonicalXMLC14NMethod
  aliases: [INCLUSIVE_WITH_COMMENTS]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2000/09/xmldsig#enveloped-signature -> org.jcp.xml.dsig.internal.dom.DOMEnvelopedTransform
  aliases: [ENVELOPED]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2002/06/xmldsig-filter2 -> org.jcp.xml.dsig.internal.dom.DOMXPathFilter2Transform
  aliases: [XPATH2]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: XMLSignatureFactory.DOM -> org.jcp.xml.dsig.internal.dom.DOMXMLSignatureFactory

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/TR/2001/REC-xml-c14n-20010315 -> org.jcp.xml.dsig.internal.dom.DOMCanonicalXMLC14NMethod
  aliases: [INCLUSIVE]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2001/10/xml-exc-c14n#WithComments -> org.jcp.xml.dsig.internal.dom.DOMExcC14NMethod
  aliases: [EXCLUSIVE_WITH_COMMENTS]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/2006/12/xml-c14n11 -> org.jcp.xml.dsig.internal.dom.DOMCanonicalXMLC14N11Method
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: TransformService.http://www.w3.org/TR/1999/REC-xpath-19991116 -> org.jcp.xml.dsig.internal.dom.DOMXPathTransform
  aliases: [XPATH]
  attributes: {MechanismType=DOM}

  Algorithm  Pattern: XMLDSig: KeyInfoFactory.DOM -> org.jcp.xml.dsig.internal.dom.DOMKeyInfoFactory



Provider: SunPCSC
  Algorithm  Pattern: SunPCSC: TerminalFactory.PC/SC -> sun.security.smartcardio.SunPCSC$Factory



Provider: SunMSCAPI
  Algorithm  Pattern: SunMSCAPI: SecureRandom.Windows-PRNG -> sun.security.mscapi.PRNG

  Algorithm  Pattern: SunMSCAPI: KeyStore.Windows-MY -> sun.security.mscapi.KeyStore$MY

  Algorithm  Pattern: SunMSCAPI: KeyStore.Windows-ROOT -> sun.security.mscapi.KeyStore$ROOT

  Algorithm  Pattern: SunMSCAPI: Signature.NONEwithRSA -> sun.security.mscapi.RSASignature$Raw
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Signature.SHA1withRSA -> sun.security.mscapi.RSASignature$SHA1
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Signature.SHA256withRSA -> sun.security.mscapi.RSASignature$SHA256
  aliases: [1.2.840.113549.1.1.11, OID.1.2.840.113549.1.1.11]
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Signature.SHA384withRSA -> sun.security.mscapi.RSASignature$SHA384
  aliases: [1.2.840.113549.1.1.12, OID.1.2.840.113549.1.1.12]
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Signature.SHA512withRSA -> sun.security.mscapi.RSASignature$SHA512
  aliases: [1.2.840.113549.1.1.13, OID.1.2.840.113549.1.1.13]
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Signature.MD5withRSA -> sun.security.mscapi.RSASignature$MD5
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Signature.MD2withRSA -> sun.security.mscapi.RSASignature$MD2
  attributes: {SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: KeyPairGenerator.RSA -> sun.security.mscapi.RSAKeyPairGenerator
  attributes: {KeySize=1024}

  Algorithm  Pattern: SunMSCAPI: Cipher.RSA -> sun.security.mscapi.RSACipher
  attributes: {SupportedPaddings=PKCS1PADDING, SupportedModes=ECB, SupportedKeyClasses=sun.security.mscapi.Key}

  Algorithm  Pattern: SunMSCAPI: Cipher.RSA/ECB/PKCS1Padding -> sun.security.mscapi.RSACipher



Provider: BC
  Algorithm  Pattern: BC: MessageDigest.GOST3411 -> org.bouncycastle.jcajce.provider.digest.GOST3411$Digest
  aliases: [GOST, GOST-3411, 1.2.643.2.2.9]

  Algorithm  Pattern: BC: Mac.HMACGOST3411 -> org.bouncycastle.jcajce.provider.digest.GOST3411$HashMac
  aliases: [HMAC-GOST3411, HMAC/GOST3411, 1.2.643.2.2.9]

  Algorithm  Pattern: BC: KeyGenerator.HMACGOST3411 -> org.bouncycastle.jcajce.provider.digest.GOST3411$KeyGenerator
  aliases: [HMAC-GOST3411, HMAC/GOST3411, 1.2.643.2.2.9]

  Algorithm  Pattern: BC: MessageDigest.GOST3411-2012-256 -> org.bouncycastle.jcajce.provider.digest.GOST3411$Digest2012_256
  aliases: [GOST-2012-256, GOST-3411-2012-256, 1.2.643.7.1.1.2.2]

  Algorithm  Pattern: BC: Mac.HMACGOST3411-2012-256 -> org.bouncycastle.jcajce.provider.digest.GOST3411$HashMac2012_256
  aliases: [HMAC-GOST3411-2012-256, HMAC/GOST3411-2012-256, 1.2.643.7.1.1.4.1]

  Algorithm  Pattern: BC: KeyGenerator.HMACGOST3411-2012-256 -> org.bouncycastle.jcajce.provider.digest.GOST3411$KeyGenerator2012_256
  aliases: [HMAC-GOST3411-2012-256, HMAC/GOST3411-2012-256, 1.2.643.7.1.1.4.1]

  Algorithm  Pattern: BC: MessageDigest.GOST3411-2012-512 -> org.bouncycastle.jcajce.provider.digest.GOST3411$Digest2012_512
  aliases: [GOST-2012-512, GOST-3411-2012-512, 1.2.643.7.1.1.2.3]

  Algorithm  Pattern: BC: Mac.HMACGOST3411-2012-512 -> org.bouncycastle.jcajce.provider.digest.GOST3411$HashMac2012_512
  aliases: [HMAC-GOST3411-2012-512, HMAC/GOST3411-2012-512, 1.2.643.7.1.1.4.2]

  Algorithm  Pattern: BC: KeyGenerator.HMACGOST3411-2012-512 -> org.bouncycastle.jcajce.provider.digest.GOST3411$KeyGenerator2012_512
  aliases: [HMAC-GOST3411-2012-512, HMAC/GOST3411-2012-512, 1.2.643.7.1.1.4.2]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHHMACGOST3411 -> org.bouncycastle.jcajce.provider.digest.GOST3411$PBEWithMacKeyFactory
  aliases: [1.2.643.2.2.9]

  Algorithm  Pattern: BC: MessageDigest.KECCAK-224 -> org.bouncycastle.jcajce.provider.digest.Keccak$Digest224

  Algorithm  Pattern: BC: MessageDigest.KECCAK-288 -> org.bouncycastle.jcajce.provider.digest.Keccak$Digest288

  Algorithm  Pattern: BC: MessageDigest.KECCAK-256 -> org.bouncycastle.jcajce.provider.digest.Keccak$Digest256

  Algorithm  Pattern: BC: MessageDigest.KECCAK-384 -> org.bouncycastle.jcajce.provider.digest.Keccak$Digest384

  Algorithm  Pattern: BC: MessageDigest.KECCAK-512 -> org.bouncycastle.jcajce.provider.digest.Keccak$Digest512

  Algorithm  Pattern: BC: Mac.HMACKECCAK224 -> org.bouncycastle.jcajce.provider.digest.Keccak$HashMac224
  aliases: [HMAC-KECCAK224, HMAC/KECCAK224]

  Algorithm  Pattern: BC: KeyGenerator.HMACKECCAK224 -> org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator224
  aliases: [HMAC-KECCAK224, HMAC/KECCAK224]

  Algorithm  Pattern: BC: Mac.HMACKECCAK256 -> org.bouncycastle.jcajce.provider.digest.Keccak$HashMac256
  aliases: [HMAC-KECCAK256, HMAC/KECCAK256]

  Algorithm  Pattern: BC: KeyGenerator.HMACKECCAK256 -> org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator256
  aliases: [HMAC-KECCAK256, HMAC/KECCAK256]

  Algorithm  Pattern: BC: Mac.HMACKECCAK288 -> org.bouncycastle.jcajce.provider.digest.Keccak$HashMac288
  aliases: [HMAC-KECCAK288, HMAC/KECCAK288]

  Algorithm  Pattern: BC: KeyGenerator.HMACKECCAK288 -> org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator288
  aliases: [HMAC-KECCAK288, HMAC/KECCAK288]

  Algorithm  Pattern: BC: Mac.HMACKECCAK384 -> org.bouncycastle.jcajce.provider.digest.Keccak$HashMac384
  aliases: [HMAC-KECCAK384, HMAC/KECCAK384]

  Algorithm  Pattern: BC: KeyGenerator.HMACKECCAK384 -> org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator384
  aliases: [HMAC-KECCAK384, HMAC/KECCAK384]

  Algorithm  Pattern: BC: Mac.HMACKECCAK512 -> org.bouncycastle.jcajce.provider.digest.Keccak$HashMac512
  aliases: [HMAC-KECCAK512, HMAC/KECCAK512]

  Algorithm  Pattern: BC: KeyGenerator.HMACKECCAK512 -> org.bouncycastle.jcajce.provider.digest.Keccak$KeyGenerator512
  aliases: [HMAC-KECCAK512, HMAC/KECCAK512]

  Algorithm  Pattern: BC: MessageDigest.MD2 -> org.bouncycastle.jcajce.provider.digest.MD2$Digest
  aliases: [1.2.840.113549.2.2]

  Algorithm  Pattern: BC: Mac.HMACMD2 -> org.bouncycastle.jcajce.provider.digest.MD2$HashMac
  aliases: [HMAC-MD2, HMAC/MD2]

  Algorithm  Pattern: BC: KeyGenerator.HMACMD2 -> org.bouncycastle.jcajce.provider.digest.MD2$KeyGenerator
  aliases: [HMAC-MD2, HMAC/MD2]

  Algorithm  Pattern: BC: MessageDigest.MD4 -> org.bouncycastle.jcajce.provider.digest.MD4$Digest
  aliases: [1.2.840.113549.2.4]

  Algorithm  Pattern: BC: Mac.HMACMD4 -> org.bouncycastle.jcajce.provider.digest.MD4$HashMac
  aliases: [HMAC-MD4, HMAC/MD4]

  Algorithm  Pattern: BC: KeyGenerator.HMACMD4 -> org.bouncycastle.jcajce.provider.digest.MD4$KeyGenerator
  aliases: [HMAC-MD4, HMAC/MD4]

  Algorithm  Pattern: BC: MessageDigest.MD5 -> org.bouncycastle.jcajce.provider.digest.MD5$Digest
  aliases: [1.2.840.113549.2.5]

  Algorithm  Pattern: BC: Mac.HMACMD5 -> org.bouncycastle.jcajce.provider.digest.MD5$HashMac
  aliases: [HMAC-MD5, HMAC/MD5, 1.3.6.1.5.5.8.1.1]

  Algorithm  Pattern: BC: KeyGenerator.HMACMD5 -> org.bouncycastle.jcajce.provider.digest.MD5$KeyGenerator
  aliases: [HMAC-MD5, HMAC/MD5, 1.3.6.1.5.5.8.1.1]

  Algorithm  Pattern: BC: MessageDigest.SHA-1 -> org.bouncycastle.jcajce.provider.digest.SHA1$Digest
  aliases: [SHA1, SHA, 1.3.14.3.2.26]

  Algorithm  Pattern: BC: Mac.HMACSHA1 -> org.bouncycastle.jcajce.provider.digest.SHA1$HashMac
  aliases: [HMAC-SHA1, HMAC/SHA1, 1.2.840.113549.2.7, 1.3.6.1.5.5.8.1.2]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA1 -> org.bouncycastle.jcajce.provider.digest.SHA1$KeyGenerator
  aliases: [HMAC-SHA1, HMAC/SHA1, 1.2.840.113549.2.7, 1.3.6.1.5.5.8.1.2]

  Algorithm  Pattern: BC: Mac.PBEWITHHMACSHA -> org.bouncycastle.jcajce.provider.digest.SHA1$SHA1Mac
  aliases: [1.3.14.3.2.26]

  Algorithm  Pattern: BC: Mac.PBEWITHHMACSHA1 -> org.bouncycastle.jcajce.provider.digest.SHA1$SHA1Mac

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHHMACSHA1 -> org.bouncycastle.jcajce.provider.digest.SHA1$PBEWithMacKeyFactory
  aliases: [PBEWITHHMACSHA, 1.3.14.3.2.26]

  Algorithm  Pattern: BC: MessageDigest.RIPEMD128 -> org.bouncycastle.jcajce.provider.digest.RIPEMD128$Digest
  aliases: [1.3.36.3.2.2]

  Algorithm  Pattern: BC: Mac.HMACRIPEMD128 -> org.bouncycastle.jcajce.provider.digest.RIPEMD128$HashMac
  aliases: [HMAC-RIPEMD128, HMAC/RIPEMD128]

  Algorithm  Pattern: BC: KeyGenerator.HMACRIPEMD128 -> org.bouncycastle.jcajce.provider.digest.RIPEMD128$KeyGenerator
  aliases: [HMAC-RIPEMD128, HMAC/RIPEMD128]

  Algorithm  Pattern: BC: MessageDigest.RIPEMD160 -> org.bouncycastle.jcajce.provider.digest.RIPEMD160$Digest
  aliases: [1.3.36.3.2.1]

  Algorithm  Pattern: BC: Mac.HMACRIPEMD160 -> org.bouncycastle.jcajce.provider.digest.RIPEMD160$HashMac
  aliases: [HMAC-RIPEMD160, HMAC/RIPEMD160, 1.3.6.1.5.5.8.1.4]

  Algorithm  Pattern: BC: KeyGenerator.HMACRIPEMD160 -> org.bouncycastle.jcajce.provider.digest.RIPEMD160$KeyGenerator
  aliases: [HMAC-RIPEMD160, HMAC/RIPEMD160, 1.3.6.1.5.5.8.1.4]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHHMACRIPEMD160 -> org.bouncycastle.jcajce.provider.digest.RIPEMD160$PBEWithHmacKeyFactory

  Algorithm  Pattern: BC: Mac.PBEWITHHMACRIPEMD160 -> org.bouncycastle.jcajce.provider.digest.RIPEMD160$PBEWithHmac

  Algorithm  Pattern: BC: MessageDigest.RIPEMD256 -> org.bouncycastle.jcajce.provider.digest.RIPEMD256$Digest
  aliases: [1.3.36.3.2.3]

  Algorithm  Pattern: BC: Mac.HMACRIPEMD256 -> org.bouncycastle.jcajce.provider.digest.RIPEMD256$HashMac
  aliases: [HMAC-RIPEMD256, HMAC/RIPEMD256]

  Algorithm  Pattern: BC: KeyGenerator.HMACRIPEMD256 -> org.bouncycastle.jcajce.provider.digest.RIPEMD256$KeyGenerator
  aliases: [HMAC-RIPEMD256, HMAC/RIPEMD256]

  Algorithm  Pattern: BC: MessageDigest.RIPEMD320 -> org.bouncycastle.jcajce.provider.digest.RIPEMD320$Digest

  Algorithm  Pattern: BC: Mac.HMACRIPEMD320 -> org.bouncycastle.jcajce.provider.digest.RIPEMD320$HashMac
  aliases: [HMAC-RIPEMD320, HMAC/RIPEMD320]

  Algorithm  Pattern: BC: KeyGenerator.HMACRIPEMD320 -> org.bouncycastle.jcajce.provider.digest.RIPEMD320$KeyGenerator
  aliases: [HMAC-RIPEMD320, HMAC/RIPEMD320]

  Algorithm  Pattern: BC: MessageDigest.SHA-224 -> org.bouncycastle.jcajce.provider.digest.SHA224$Digest
  aliases: [SHA224, 2.16.840.1.101.3.4.2.4]

  Algorithm  Pattern: BC: Mac.PBEWITHHMACSHA224 -> org.bouncycastle.jcajce.provider.digest.SHA224$HashMac

  Algorithm  Pattern: BC: Mac.HMACSHA224 -> org.bouncycastle.jcajce.provider.digest.SHA224$HashMac
  aliases: [HMAC-SHA224, HMAC/SHA224, 1.2.840.113549.2.8]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA224 -> org.bouncycastle.jcajce.provider.digest.SHA224$KeyGenerator
  aliases: [HMAC-SHA224, HMAC/SHA224, 1.2.840.113549.2.8]

  Algorithm  Pattern: BC: MessageDigest.SHA-256 -> org.bouncycastle.jcajce.provider.digest.SHA256$Digest
  aliases: [SHA256, 2.16.840.1.101.3.4.2.1]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHHMACSHA256 -> org.bouncycastle.jcajce.provider.digest.SHA256$PBEWithMacKeyFactory
  aliases: [PBEWITHHMACSHA-256, 2.16.840.1.101.3.4.2.1]

  Algorithm  Pattern: BC: Mac.PBEWITHHMACSHA256 -> org.bouncycastle.jcajce.provider.digest.SHA256$HashMac

  Algorithm  Pattern: BC: Mac.HMACSHA256 -> org.bouncycastle.jcajce.provider.digest.SHA256$HashMac
  aliases: [HMAC-SHA256, HMAC/SHA256, 1.2.840.113549.2.9, 2.16.840.1.101.3.4.2.1]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA256 -> org.bouncycastle.jcajce.provider.digest.SHA256$KeyGenerator
  aliases: [HMAC-SHA256, HMAC/SHA256, 1.2.840.113549.2.9, 2.16.840.1.101.3.4.2.1]

  Algorithm  Pattern: BC: MessageDigest.SHA-384 -> org.bouncycastle.jcajce.provider.digest.SHA384$Digest
  aliases: [SHA384, 2.16.840.1.101.3.4.2.2]

  Algorithm  Pattern: BC: Mac.OLDHMACSHA384 -> org.bouncycastle.jcajce.provider.digest.SHA384$OldSHA384

  Algorithm  Pattern: BC: Mac.PBEWITHHMACSHA384 -> org.bouncycastle.jcajce.provider.digest.SHA384$HashMac

  Algorithm  Pattern: BC: Mac.HMACSHA384 -> org.bouncycastle.jcajce.provider.digest.SHA384$HashMac
  aliases: [HMAC-SHA384, HMAC/SHA384, 1.2.840.113549.2.10]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA384 -> org.bouncycastle.jcajce.provider.digest.SHA384$KeyGenerator
  aliases: [HMAC-SHA384, HMAC/SHA384, 1.2.840.113549.2.10]

  Algorithm  Pattern: BC: MessageDigest.SHA-512 -> org.bouncycastle.jcajce.provider.digest.SHA512$Digest
  aliases: [SHA512, 2.16.840.1.101.3.4.2.3]

  Algorithm  Pattern: BC: MessageDigest.SHA-512/224 -> org.bouncycastle.jcajce.provider.digest.SHA512$DigestT224
  aliases: [SHA512/224, 2.16.840.1.101.3.4.2.5]

  Algorithm  Pattern: BC: MessageDigest.SHA-512/256 -> org.bouncycastle.jcajce.provider.digest.SHA512$DigestT256
  aliases: [SHA512256, 2.16.840.1.101.3.4.2.6]

  Algorithm  Pattern: BC: Mac.OLDHMACSHA512 -> org.bouncycastle.jcajce.provider.digest.SHA512$OldSHA512

  Algorithm  Pattern: BC: Mac.PBEWITHHMACSHA512 -> org.bouncycastle.jcajce.provider.digest.SHA512$HashMac

  Algorithm  Pattern: BC: Mac.HMACSHA512 -> org.bouncycastle.jcajce.provider.digest.SHA512$HashMac
  aliases: [HMAC-SHA512, HMAC/SHA512, 1.2.840.113549.2.11]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA512 -> org.bouncycastle.jcajce.provider.digest.SHA512$KeyGenerator
  aliases: [HMAC-SHA512, HMAC/SHA512, 1.2.840.113549.2.11]

  Algorithm  Pattern: BC: Mac.HMACSHA512/224 -> org.bouncycastle.jcajce.provider.digest.SHA512$HashMacT224
  aliases: [HMAC-SHA512/224, HMAC/SHA512/224]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA512/224 -> org.bouncycastle.jcajce.provider.digest.SHA512$KeyGeneratorT224
  aliases: [HMAC-SHA512/224, HMAC/SHA512/224]

  Algorithm  Pattern: BC: Mac.HMACSHA512/256 -> org.bouncycastle.jcajce.provider.digest.SHA512$HashMacT256
  aliases: [HMAC-SHA512/256, HMAC/SHA512/256]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA512/256 -> org.bouncycastle.jcajce.provider.digest.SHA512$KeyGeneratorT256
  aliases: [HMAC-SHA512/256, HMAC/SHA512/256]

  Algorithm  Pattern: BC: MessageDigest.SHA3-224 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest224

  Algorithm  Pattern: BC: MessageDigest.SHA3-256 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest256

  Algorithm  Pattern: BC: MessageDigest.SHA3-384 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest384

  Algorithm  Pattern: BC: MessageDigest.SHA3-512 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest512

  Algorithm  Pattern: BC: MessageDigest.2.16.840.1.101.3.4.2.7 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest224

  Algorithm  Pattern: BC: MessageDigest.OID.2.16.840.1.101.3.4.2.7 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest224

  Algorithm  Pattern: BC: MessageDigest.2.16.840.1.101.3.4.2.8 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest256

  Algorithm  Pattern: BC: MessageDigest.OID.2.16.840.1.101.3.4.2.8 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest256

  Algorithm  Pattern: BC: MessageDigest.2.16.840.1.101.3.4.2.9 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest384

  Algorithm  Pattern: BC: MessageDigest.OID.2.16.840.1.101.3.4.2.9 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest384

  Algorithm  Pattern: BC: MessageDigest.2.16.840.1.101.3.4.2.10 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest512

  Algorithm  Pattern: BC: MessageDigest.OID.2.16.840.1.101.3.4.2.10 -> org.bouncycastle.jcajce.provider.digest.SHA3$Digest512

  Algorithm  Pattern: BC: Mac.HMACSHA3-224 -> org.bouncycastle.jcajce.provider.digest.SHA3$HashMac224
  aliases: [HMAC-SHA3-224, HMAC/SHA3-224, 2.16.840.1.101.3.4.2.13]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA3-224 -> org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator224
  aliases: [HMAC-SHA3-224, HMAC/SHA3-224, 2.16.840.1.101.3.4.2.13]

  Algorithm  Pattern: BC: Mac.HMACSHA3-256 -> org.bouncycastle.jcajce.provider.digest.SHA3$HashMac256
  aliases: [HMAC-SHA3-256, HMAC/SHA3-256, 2.16.840.1.101.3.4.2.14]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA3-256 -> org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator256
  aliases: [HMAC-SHA3-256, HMAC/SHA3-256, 2.16.840.1.101.3.4.2.14]

  Algorithm  Pattern: BC: Mac.HMACSHA3-384 -> org.bouncycastle.jcajce.provider.digest.SHA3$HashMac384
  aliases: [HMAC-SHA3-384, HMAC/SHA3-384, 2.16.840.1.101.3.4.2.15]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA3-384 -> org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator384
  aliases: [HMAC-SHA3-384, HMAC/SHA3-384, 2.16.840.1.101.3.4.2.15]

  Algorithm  Pattern: BC: Mac.HMACSHA3-512 -> org.bouncycastle.jcajce.provider.digest.SHA3$HashMac512
  aliases: [HMAC-SHA3-512, HMAC/SHA3-512, 2.16.840.1.101.3.4.2.16]

  Algorithm  Pattern: BC: KeyGenerator.HMACSHA3-512 -> org.bouncycastle.jcajce.provider.digest.SHA3$KeyGenerator512
  aliases: [HMAC-SHA3-512, HMAC/SHA3-512, 2.16.840.1.101.3.4.2.16]

  Algorithm  Pattern: BC: MessageDigest.Skein-256-128 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_128

  Algorithm  Pattern: BC: MessageDigest.Skein-256-160 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_160

  Algorithm  Pattern: BC: MessageDigest.Skein-256-224 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_224

  Algorithm  Pattern: BC: MessageDigest.Skein-256-256 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_256_256

  Algorithm  Pattern: BC: MessageDigest.Skein-512-128 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_128

  Algorithm  Pattern: BC: MessageDigest.Skein-512-160 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_160

  Algorithm  Pattern: BC: MessageDigest.Skein-512-224 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_224

  Algorithm  Pattern: BC: MessageDigest.Skein-512-256 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_256

  Algorithm  Pattern: BC: MessageDigest.Skein-512-384 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_384

  Algorithm  Pattern: BC: MessageDigest.Skein-512-512 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_512_512

  Algorithm  Pattern: BC: MessageDigest.Skein-1024-384 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_1024_384

  Algorithm  Pattern: BC: MessageDigest.Skein-1024-512 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_1024_512

  Algorithm  Pattern: BC: MessageDigest.Skein-1024-1024 -> org.bouncycastle.jcajce.provider.digest.Skein$Digest_1024_1024

  Algorithm  Pattern: BC: Mac.HMACSkein-256-128 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_128
  aliases: [HMAC-Skein-256-128, HMAC/Skein-256-128]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-256-128 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_128
  aliases: [HMAC-Skein-256-128, HMAC/Skein-256-128]

  Algorithm  Pattern: BC: Mac.HMACSkein-256-160 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_160
  aliases: [HMAC-Skein-256-160, HMAC/Skein-256-160]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-256-160 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_160
  aliases: [HMAC-Skein-256-160, HMAC/Skein-256-160]

  Algorithm  Pattern: BC: Mac.HMACSkein-256-224 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_224
  aliases: [HMAC-Skein-256-224, HMAC/Skein-256-224]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-256-224 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_224
  aliases: [HMAC-Skein-256-224, HMAC/Skein-256-224]

  Algorithm  Pattern: BC: Mac.HMACSkein-256-256 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_256_256
  aliases: [HMAC-Skein-256-256, HMAC/Skein-256-256]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-256-256 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_256_256
  aliases: [HMAC-Skein-256-256, HMAC/Skein-256-256]

  Algorithm  Pattern: BC: Mac.HMACSkein-512-128 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_128
  aliases: [HMAC-Skein-512-128, HMAC/Skein-512-128]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-512-128 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_128
  aliases: [HMAC-Skein-512-128, HMAC/Skein-512-128]

  Algorithm  Pattern: BC: Mac.HMACSkein-512-160 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_160
  aliases: [HMAC-Skein-512-160, HMAC/Skein-512-160]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-512-160 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_160
  aliases: [HMAC-Skein-512-160, HMAC/Skein-512-160]

  Algorithm  Pattern: BC: Mac.HMACSkein-512-224 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_224
  aliases: [HMAC-Skein-512-224, HMAC/Skein-512-224]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-512-224 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_224
  aliases: [HMAC-Skein-512-224, HMAC/Skein-512-224]

  Algorithm  Pattern: BC: Mac.HMACSkein-512-256 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_256
  aliases: [HMAC-Skein-512-256, HMAC/Skein-512-256]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-512-256 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_256
  aliases: [HMAC-Skein-512-256, HMAC/Skein-512-256]

  Algorithm  Pattern: BC: Mac.HMACSkein-512-384 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_384
  aliases: [HMAC-Skein-512-384, HMAC/Skein-512-384]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-512-384 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_384
  aliases: [HMAC-Skein-512-384, HMAC/Skein-512-384]

  Algorithm  Pattern: BC: Mac.HMACSkein-512-512 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_512_512
  aliases: [HMAC-Skein-512-512, HMAC/Skein-512-512]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-512-512 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_512_512
  aliases: [HMAC-Skein-512-512, HMAC/Skein-512-512]

  Algorithm  Pattern: BC: Mac.HMACSkein-1024-384 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_1024_384
  aliases: [HMAC-Skein-1024-384, HMAC/Skein-1024-384]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-1024-384 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_1024_384
  aliases: [HMAC-Skein-1024-384, HMAC/Skein-1024-384]

  Algorithm  Pattern: BC: Mac.HMACSkein-1024-512 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_1024_512
  aliases: [HMAC-Skein-1024-512, HMAC/Skein-1024-512]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-1024-512 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_1024_512
  aliases: [HMAC-Skein-1024-512, HMAC/Skein-1024-512]

  Algorithm  Pattern: BC: Mac.HMACSkein-1024-1024 -> org.bouncycastle.jcajce.provider.digest.Skein$HashMac_1024_1024
  aliases: [HMAC-Skein-1024-1024, HMAC/Skein-1024-1024]

  Algorithm  Pattern: BC: KeyGenerator.HMACSkein-1024-1024 -> org.bouncycastle.jcajce.provider.digest.Skein$HMacKeyGenerator_1024_1024
  aliases: [HMAC-Skein-1024-1024, HMAC/Skein-1024-1024]

  Algorithm  Pattern: BC: Mac.Skein-MAC-256-128 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_128
  aliases: [Skein-MAC256/128]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-256-128 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_128
  aliases: [Skein-MAC256/128]

  Algorithm  Pattern: BC: Mac.Skein-MAC-256-160 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_160
  aliases: [Skein-MAC256/160]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-256-160 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_160
  aliases: [Skein-MAC256/160]

  Algorithm  Pattern: BC: Mac.Skein-MAC-256-224 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_224
  aliases: [Skein-MAC256/224]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-256-224 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_224
  aliases: [Skein-MAC256/224]

  Algorithm  Pattern: BC: Mac.Skein-MAC-256-256 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_256_256
  aliases: [Skein-MAC256/256]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-256-256 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_256_256
  aliases: [Skein-MAC256/256]

  Algorithm  Pattern: BC: Mac.Skein-MAC-512-128 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_128
  aliases: [Skein-MAC512/128]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-512-128 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_128
  aliases: [Skein-MAC512/128]

  Algorithm  Pattern: BC: Mac.Skein-MAC-512-160 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_160
  aliases: [Skein-MAC512/160]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-512-160 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_160
  aliases: [Skein-MAC512/160]

  Algorithm  Pattern: BC: Mac.Skein-MAC-512-224 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_224
  aliases: [Skein-MAC512/224]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-512-224 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_224
  aliases: [Skein-MAC512/224]

  Algorithm  Pattern: BC: Mac.Skein-MAC-512-256 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_256
  aliases: [Skein-MAC512/256]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-512-256 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_256
  aliases: [Skein-MAC512/256]

  Algorithm  Pattern: BC: Mac.Skein-MAC-512-384 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_384
  aliases: [Skein-MAC512/384]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-512-384 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_384
  aliases: [Skein-MAC512/384]

  Algorithm  Pattern: BC: Mac.Skein-MAC-512-512 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_512_512
  aliases: [Skein-MAC512/512]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-512-512 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_512_512
  aliases: [Skein-MAC512/512]

  Algorithm  Pattern: BC: Mac.Skein-MAC-1024-384 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_1024_384
  aliases: [Skein-MAC1024/384]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-1024-384 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_1024_384
  aliases: [Skein-MAC1024/384]

  Algorithm  Pattern: BC: Mac.Skein-MAC-1024-512 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_1024_512
  aliases: [Skein-MAC1024/512]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-1024-512 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_1024_512
  aliases: [Skein-MAC1024/512]

  Algorithm  Pattern: BC: Mac.Skein-MAC-1024-1024 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMac_1024_1024
  aliases: [Skein-MAC1024/1024]

  Algorithm  Pattern: BC: KeyGenerator.Skein-MAC-1024-1024 -> org.bouncycastle.jcajce.provider.digest.Skein$SkeinMacKeyGenerator_1024_1024
  aliases: [Skein-MAC1024/1024]

  Algorithm  Pattern: BC: MessageDigest.SM3 -> org.bouncycastle.jcajce.provider.digest.SM3$Digest
  aliases: [SM3, 1.2.156.197.1.401]

  Algorithm  Pattern: BC: MessageDigest.TIGER -> org.bouncycastle.jcajce.provider.digest.Tiger$Digest

  Algorithm  Pattern: BC: Mac.HMACTIGER -> org.bouncycastle.jcajce.provider.digest.Tiger$HashMac
  aliases: [HMAC-TIGER, HMAC/TIGER, 1.3.6.1.5.5.8.1.3]

  Algorithm  Pattern: BC: KeyGenerator.HMACTIGER -> org.bouncycastle.jcajce.provider.digest.Tiger$KeyGenerator
  aliases: [HMAC-TIGER, HMAC/TIGER, 1.3.6.1.5.5.8.1.3]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHHMACTIGER -> org.bouncycastle.jcajce.provider.digest.Tiger$PBEWithMacKeyFactory

  Algorithm  Pattern: BC: MessageDigest.WHIRLPOOL -> org.bouncycastle.jcajce.provider.digest.Whirlpool$Digest

  Algorithm  Pattern: BC: Mac.HMACWHIRLPOOL -> org.bouncycastle.jcajce.provider.digest.Whirlpool$HashMac
  aliases: [HMAC-WHIRLPOOL, HMAC/WHIRLPOOL]

  Algorithm  Pattern: BC: KeyGenerator.HMACWHIRLPOOL -> org.bouncycastle.jcajce.provider.digest.Whirlpool$KeyGenerator
  aliases: [HMAC-WHIRLPOOL, HMAC/WHIRLPOOL]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2B-512 -> org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b512
  aliases: [1.3.6.1.4.1.1722.12.2.1.16]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2B-384 -> org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b384
  aliases: [1.3.6.1.4.1.1722.12.2.1.12]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2B-256 -> org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b256
  aliases: [1.3.6.1.4.1.1722.12.2.1.8]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2B-160 -> org.bouncycastle.jcajce.provider.digest.Blake2b$Blake2b160
  aliases: [1.3.6.1.4.1.1722.12.2.1.5]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2S-256 -> org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s256
  aliases: [1.3.6.1.4.1.1722.12.2.2.8]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2S-224 -> org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s224
  aliases: [1.3.6.1.4.1.1722.12.2.2.7]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2S-160 -> org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s160
  aliases: [1.3.6.1.4.1.1722.12.2.2.5]

  Algorithm  Pattern: BC: MessageDigest.BLAKE2S-128 -> org.bouncycastle.jcajce.provider.digest.Blake2s$Blake2s128
  aliases: [1.3.6.1.4.1.1722.12.2.2.4]

  Algorithm  Pattern: BC: MessageDigest.DSTU7564-256 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest256

  Algorithm  Pattern: BC: MessageDigest.DSTU7564-384 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest384

  Algorithm  Pattern: BC: MessageDigest.DSTU7564-512 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest512

  Algorithm  Pattern: BC: MessageDigest.1.2.804.2.1.1.1.1.2.2.1 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest256

  Algorithm  Pattern: BC: MessageDigest.OID.1.2.804.2.1.1.1.1.2.2.1 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest256

  Algorithm  Pattern: BC: MessageDigest.1.2.804.2.1.1.1.1.2.2.2 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest384

  Algorithm  Pattern: BC: MessageDigest.OID.1.2.804.2.1.1.1.1.2.2.2 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest384

  Algorithm  Pattern: BC: MessageDigest.1.2.804.2.1.1.1.1.2.2.3 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest512

  Algorithm  Pattern: BC: MessageDigest.OID.1.2.804.2.1.1.1.1.2.2.3 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$Digest512

  Algorithm  Pattern: BC: Mac.HMACDSTU7564-256 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$HashMac256
  aliases: [HMAC-DSTU7564-256, HMAC/DSTU7564-256, 1.2.804.2.1.1.1.1.2.2.4]

  Algorithm  Pattern: BC: KeyGenerator.HMACDSTU7564-256 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$KeyGenerator256
  aliases: [HMAC-DSTU7564-256, HMAC/DSTU7564-256, 1.2.804.2.1.1.1.1.2.2.4]

  Algorithm  Pattern: BC: Mac.HMACDSTU7564-384 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$HashMac384
  aliases: [HMAC-DSTU7564-384, HMAC/DSTU7564-384, 1.2.804.2.1.1.1.1.2.2.5]

  Algorithm  Pattern: BC: KeyGenerator.HMACDSTU7564-384 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$KeyGenerator384
  aliases: [HMAC-DSTU7564-384, HMAC/DSTU7564-384, 1.2.804.2.1.1.1.1.2.2.5]

  Algorithm  Pattern: BC: Mac.HMACDSTU7564-512 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$HashMac512
  aliases: [HMAC-DSTU7564-512, HMAC/DSTU7564-512, 1.2.804.2.1.1.1.1.2.2.6]

  Algorithm  Pattern: BC: KeyGenerator.HMACDSTU7564-512 -> org.bouncycastle.jcajce.provider.digest.DSTU7564$KeyGenerator512
  aliases: [HMAC-DSTU7564-512, HMAC/DSTU7564-512, 1.2.804.2.1.1.1.1.2.2.6]

  Algorithm  Pattern: BC: AlgorithmParameters.PBKDF1 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF1$AlgParams
  aliases: [1.2.840.113549.1.5.1, 1.2.840.113549.1.5.3, 1.2.840.113549.1.5.6, 1.2.840.113549.1.5.10, 1.2.840.113549.1.5.11]

  Algorithm  Pattern: BC: AlgorithmParameters.PBKDF2 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$AlgParams
  aliases: [1.2.840.113549.1.5.12]

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withUTF8
  aliases: [PBKDF2WITHHMACSHA1, PBKDF2WITHHMACSHA1ANDUTF8, 1.2.840.113549.1.5.12]

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHASCII -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2with8BIT
  aliases: [PBKDF2WITH8BIT, PBKDF2WITHHMACSHA1AND8BIT]

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA224 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA224

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA256 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA256

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA384 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA384

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA512 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA512

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA3-224 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA3_224

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA3-256 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA3_256

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA3-384 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA3_384

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACSHA3-512 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withSHA3_512

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF2WITHHMACGOST3411 -> org.bouncycastle.jcajce.provider.symmetric.PBEPBKDF2$PBKDF2withGOST3411

  Algorithm  Pattern: BC: AlgorithmParameters.PKCS12PBE -> org.bouncycastle.jcajce.provider.symmetric.PBEPKCS12$AlgParams
  aliases: [PBEWITHSHAAND128BITAES-CBC-BC, PBEWITHSHAAND192BITAES-CBC-BC, PBEWITHSHAAND256BITAES-CBC-BC, PBEWITHSHA256AND128BITAES-CBC-BC, PBEWITHSHA256AND192BITAES-CBC-BC, PBEWITHSHA256AND256BITAES-CBC-BC, PBEWITHSHA1AND128BITAES-CBC-BC, PBEWITHSHA1AND192BITAES-CBC-BC, PBEWITHSHA1AND256BITAES-CBC-BC, PBEWITHSHA-1AND128BITAES-CBC-BC, PBEWITHSHA-1AND192BITAES-CBC-BC, PBEWITHSHA-1AND256BITAES-CBC-BC, PBEWITHSHA-256AND128BITAES-CBC-BC, PBEWITHSHA-256AND192BITAES-CBC-BC, PBEWITHSHA-256AND256BITAES-CBC-BC, 1.3.6.1.4.1.22554.1.1.2.1.2, 1.3.6.1.4.1.22554.1.1.2.1.22, 1.3.6.1.4.1.22554.1.1.2.1.42, 1.3.6.1.4.1.22554.1.2.1.2.1.2, 1.3.6.1.4.1.22554.1.2.1.2.1.22, 1.3.6.1.4.1.22554.1.2.1.2.1.42, 1.2.840.113549.1.12.1.1, 1.2.840.113549.1.12.1.2, PBEWITHSHAAND40BITRC4, PBEWITHSHAAND128BITRC4, PBEWITHSHAANDRC4, PBEWITHSHAAND3-KEYTRIPLEDES, PBEWITHSHAAND2-KEYTRIPLEDES, PBEWITHSHAAND3-KEYTRIPLEDES-CBC, PBEWITHSHAAND2-KEYTRIPLEDES-CBC, PBEWITHSHAANDDES3KEY-CBC, PBEWITHSHAANDDES2KEY-CBC, 1.2.840.113549.1.12.1.3, 1.2.840.113549.1.12.1.4, PBEWITHSHAANDIDEA, PBEWITHSHAANDIDEA-CBC, 1.2.840.113549.1.12.1.5, 1.2.840.113549.1.12.1.6, PBEWithSHAAnd3KeyTripleDES, PBEWITHSHA1ANDRC2, PBEWITHSHAANDRC2, PBEWITHSHA1ANDRC2-CBC, PBEWITHSHAAND40BITRC2-CBC, PBEWITHSHAAND128BITRC2-CBC, PBEWITHSHAANDTWOFISH, PBEWITHSHAANDTWOFISH-CBC]

  Algorithm  Pattern: BC: SecretKeyFactory.TLS10KDF -> org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS10

  Algorithm  Pattern: BC: SecretKeyFactory.TLS11KDF -> org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS11

  Algorithm  Pattern: BC: SecretKeyFactory.TLS12WITHSHA256KDF -> org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12withSHA256

  Algorithm  Pattern: BC: SecretKeyFactory.TLS12WITHSHA384KDF -> org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12withSHA384

  Algorithm  Pattern: BC: SecretKeyFactory.TLS12WITHSHA512KDF -> org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12withSHA512

  Algorithm  Pattern: BC: SecretKeyFactory.SCRYPT -> org.bouncycastle.jcajce.provider.symmetric.SCRYPT$ScryptWithUTF8

  Algorithm  Pattern: BC: SecretKeyFactory.1.3.6.1.4.1.11591.4.11 -> org.bouncycastle.jcajce.provider.symmetric.SCRYPT$ScryptWithUTF8

  Algorithm  Pattern: BC: SecretKeyFactory.OID.1.3.6.1.4.1.11591.4.11 -> org.bouncycastle.jcajce.provider.symmetric.SCRYPT$ScryptWithUTF8

  Algorithm  Pattern: BC: Mac.SIPHASH-2-4 -> org.bouncycastle.jcajce.provider.symmetric.SipHash$Mac24
  aliases: [SIPHASH]

  Algorithm  Pattern: BC: Mac.SIPHASH-4-8 -> org.bouncycastle.jcajce.provider.symmetric.SipHash$Mac48

  Algorithm  Pattern: BC: KeyGenerator.SIPHASH -> org.bouncycastle.jcajce.provider.symmetric.SipHash$KeyGen
  aliases: [SIPHASH-2-4, SIPHASH-4-8]

  Algorithm  Pattern: BC: Mac.POLY1305 -> org.bouncycastle.jcajce.provider.symmetric.Poly1305$Mac

  Algorithm  Pattern: BC: KeyGenerator.POLY1305 -> org.bouncycastle.jcajce.provider.symmetric.Poly1305$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.AES -> org.bouncycastle.jcajce.provider.symmetric.AES$AlgParams
  aliases: [2.16.840.1.101.3.4.2, 2.16.840.1.101.3.4.22, 2.16.840.1.101.3.4.42, 2.16.840.1.101.3.4.1.2, 2.16.840.1.101.3.4.1.22, 2.16.840.1.101.3.4.1.42]

  Algorithm  Pattern: BC: AlgorithmParameters.GCM -> org.bouncycastle.jcajce.provider.symmetric.AES$AlgParamsGCM
  aliases: [2.16.840.1.101.3.4.1.6, 2.16.840.1.101.3.4.1.26, 2.16.840.1.101.3.4.1.46]

  Algorithm  Pattern: BC: AlgorithmParameters.CCM -> org.bouncycastle.jcajce.provider.symmetric.AES$AlgParamsCCM
  aliases: [2.16.840.1.101.3.4.1.7, 2.16.840.1.101.3.4.1.27, 2.16.840.1.101.3.4.1.47]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.AES -> org.bouncycastle.jcajce.provider.symmetric.AES$AlgParamGen
  aliases: [2.16.840.1.101.3.4.2, 2.16.840.1.101.3.4.22, 2.16.840.1.101.3.4.42, 2.16.840.1.101.3.4.1.2, 2.16.840.1.101.3.4.1.22, 2.16.840.1.101.3.4.1.42]

  Algorithm  Pattern: BC: Cipher.AES -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB
  aliases: [2.16.840.1.101.3.4.2, 2.16.840.1.101.3.4.22, 2.16.840.1.101.3.4.42]
  attributes: {SupportedKeyFormats=RAW, SupportedKeyClasses=javax.crypto.SecretKey}

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.1 -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.1 -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.21 -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.21 -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.41 -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.41 -> org.bouncycastle.jcajce.provider.symmetric.AES$ECB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.2 -> org.bouncycastle.jcajce.provider.symmetric.AES$CBC

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.2 -> org.bouncycastle.jcajce.provider.symmetric.AES$CBC

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.22 -> org.bouncycastle.jcajce.provider.symmetric.AES$CBC

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.22 -> org.bouncycastle.jcajce.provider.symmetric.AES$CBC

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.42 -> org.bouncycastle.jcajce.provider.symmetric.AES$CBC

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.42 -> org.bouncycastle.jcajce.provider.symmetric.AES$CBC

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.3 -> org.bouncycastle.jcajce.provider.symmetric.AES$OFB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.3 -> org.bouncycastle.jcajce.provider.symmetric.AES$OFB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.23 -> org.bouncycastle.jcajce.provider.symmetric.AES$OFB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.23 -> org.bouncycastle.jcajce.provider.symmetric.AES$OFB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.43 -> org.bouncycastle.jcajce.provider.symmetric.AES$OFB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.43 -> org.bouncycastle.jcajce.provider.symmetric.AES$OFB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.4 -> org.bouncycastle.jcajce.provider.symmetric.AES$CFB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.4 -> org.bouncycastle.jcajce.provider.symmetric.AES$CFB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.24 -> org.bouncycastle.jcajce.provider.symmetric.AES$CFB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.24 -> org.bouncycastle.jcajce.provider.symmetric.AES$CFB

  Algorithm  Pattern: BC: Cipher.2.16.840.1.101.3.4.1.44 -> org.bouncycastle.jcajce.provider.symmetric.AES$CFB

  Algorithm  Pattern: BC: Cipher.OID.2.16.840.1.101.3.4.1.44 -> org.bouncycastle.jcajce.provider.symmetric.AES$CFB

  Algorithm  Pattern: BC: Cipher.AESWRAP -> org.bouncycastle.jcajce.provider.symmetric.AES$Wrap
  aliases: [2.16.840.1.101.3.4.1.5, OID.2.16.840.1.101.3.4.1.5, 2.16.840.1.101.3.4.1.25, OID.2.16.840.1.101.3.4.1.25, 2.16.840.1.101.3.4.1.45, OID.2.16.840.1.101.3.4.1.45, AESKW]
  attributes: {SupportedKeyFormats=RAW, SupportedKeyClasses=javax.crypto.SecretKey}

  Algorithm  Pattern: BC: Cipher.AESWRAPPAD -> org.bouncycastle.jcajce.provider.symmetric.AES$WrapPad
  aliases: [2.16.840.1.101.3.4.1.8, OID.2.16.840.1.101.3.4.1.8, 2.16.840.1.101.3.4.1.28, OID.2.16.840.1.101.3.4.1.28, 2.16.840.1.101.3.4.1.48, OID.2.16.840.1.101.3.4.1.48, AESKWP]
  attributes: {SupportedKeyFormats=RAW, SupportedKeyClasses=javax.crypto.SecretKey}

  Algorithm  Pattern: BC: Cipher.AESRFC3211WRAP -> org.bouncycastle.jcajce.provider.symmetric.AES$RFC3211Wrap

  Algorithm  Pattern: BC: Cipher.AESRFC5649WRAP -> org.bouncycastle.jcajce.provider.symmetric.AES$RFC5649Wrap

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.CCM -> org.bouncycastle.jcajce.provider.symmetric.AES$AlgParamGenCCM
  aliases: [2.16.840.1.101.3.4.1.7, 2.16.840.1.101.3.4.1.27, 2.16.840.1.101.3.4.1.47, 1.2.410.200046.1.1.37, 1.2.410.200046.1.1.38, 1.2.410.200046.1.1.39]

  Algorithm  Pattern: BC: Cipher.CCM -> org.bouncycastle.jcajce.provider.symmetric.AES$CCM
  aliases: [2.16.840.1.101.3.4.1.7, OID.2.16.840.1.101.3.4.1.7, 2.16.840.1.101.3.4.1.27, OID.2.16.840.1.101.3.4.1.27, 2.16.840.1.101.3.4.1.47, OID.2.16.840.1.101.3.4.1.47, 1.2.410.200046.1.1.37, OID.1.2.410.200046.1.1.37, 1.2.410.200046.1.1.38, OID.1.2.410.200046.1.1.38, 1.2.410.200046.1.1.39, OID.1.2.410.200046.1.1.39]
  attributes: {SupportedKeyFormats=RAW, SupportedKeyClasses=javax.crypto.SecretKey}

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.GCM -> org.bouncycastle.jcajce.provider.symmetric.AES$AlgParamGenGCM
  aliases: [2.16.840.1.101.3.4.1.6, 2.16.840.1.101.3.4.1.26, 2.16.840.1.101.3.4.1.46, 1.2.410.200046.1.1.34, 1.2.410.200046.1.1.35, 1.2.410.200046.1.1.36]

  Algorithm  Pattern: BC: Cipher.GCM -> org.bouncycastle.jcajce.provider.symmetric.AES$GCM
  aliases: [2.16.840.1.101.3.4.1.6, OID.2.16.840.1.101.3.4.1.6, 2.16.840.1.101.3.4.1.26, OID.2.16.840.1.101.3.4.1.26, 2.16.840.1.101.3.4.1.46, OID.2.16.840.1.101.3.4.1.46, 1.2.410.200046.1.1.34, OID.1.2.410.200046.1.1.34, 1.2.410.200046.1.1.35, OID.1.2.410.200046.1.1.35, 1.2.410.200046.1.1.36, OID.1.2.410.200046.1.1.36]
  attributes: {SupportedKeyFormats=RAW, SupportedKeyClasses=javax.crypto.SecretKey}

  Algorithm  Pattern: BC: KeyGenerator.AES -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.2 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.22 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.42 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.1 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.1 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.2 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.2 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.3 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.3 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.4 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.4 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.21 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.21 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.22 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.22 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.23 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.23 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.24 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.24 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.41 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.41 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.42 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.42 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.43 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.43 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.44 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.44 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.AESWRAP -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.5 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.5 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.25 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.25 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.45 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.45 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.6 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.6 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.26 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.26 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.46 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.46 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.7 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.7 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.27 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.27 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.47 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.47 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.AESWRAPPAD -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.8 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.8 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.28 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.28 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.2.16.840.1.101.3.4.1.48 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.2.16.840.1.101.3.4.1.48 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen256

  Algorithm  Pattern: BC: Mac.AESCMAC -> org.bouncycastle.jcajce.provider.symmetric.AES$AESCMAC

  Algorithm  Pattern: BC: Mac.AESCCMMAC -> org.bouncycastle.jcajce.provider.symmetric.AES$AESCCMMAC
  aliases: [2.16.840.1.101.3.4.1.7, 2.16.840.1.101.3.4.1.27, 2.16.840.1.101.3.4.1.47]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND128BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA1AESCBC128
  aliases: [1.3.6.1.4.1.22554.1.1.2.1.2, OID.1.3.6.1.4.1.22554.1.1.2.1.2, PBEWITHSHA1AND128BITAES-CBC-BC, PBEWITHSHA-1AND128BITAES-CBC-BC, PBEWITHSHAAND128BITAES-BC, PBEWITHSHA1AND128BITAES-BC, PBEWITHSHA-1AND128BITAES-BC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND192BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA1AESCBC192
  aliases: [1.3.6.1.4.1.22554.1.1.2.1.22, OID.1.3.6.1.4.1.22554.1.1.2.1.22, PBEWITHSHA1AND192BITAES-CBC-BC, PBEWITHSHA-1AND192BITAES-CBC-BC, PBEWITHSHAAND192BITAES-BC, PBEWITHSHA1AND192BITAES-BC, PBEWITHSHA-1AND192BITAES-BC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND256BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA1AESCBC256
  aliases: [1.3.6.1.4.1.22554.1.1.2.1.42, OID.1.3.6.1.4.1.22554.1.1.2.1.42, PBEWITHSHA1AND256BITAES-CBC-BC, PBEWITHSHA-1AND256BITAES-CBC-BC, PBEWITHSHAAND256BITAES-BC, PBEWITHSHA1AND256BITAES-BC, PBEWITHSHA-1AND256BITAES-BC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHA256AND128BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA256AESCBC128
  aliases: [1.3.6.1.4.1.22554.1.2.1.2.1.2, OID.1.3.6.1.4.1.22554.1.2.1.2.1.2, PBEWITHSHA-256AND128BITAES-CBC-BC, PBEWITHSHA256AND128BITAES-BC, PBEWITHSHA-256AND128BITAES-BC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHA256AND192BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA256AESCBC192
  aliases: [1.3.6.1.4.1.22554.1.2.1.2.1.22, OID.1.3.6.1.4.1.22554.1.2.1.2.1.22, PBEWITHSHA-256AND192BITAES-CBC-BC, PBEWITHSHA256AND192BITAES-BC, PBEWITHSHA-256AND192BITAES-BC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHA256AND256BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA256AESCBC256
  aliases: [1.3.6.1.4.1.22554.1.2.1.2.1.42, OID.1.3.6.1.4.1.22554.1.2.1.2.1.42, PBEWITHSHA-256AND256BITAES-CBC-BC, PBEWITHSHA256AND256BITAES-BC, PBEWITHSHA-256AND256BITAES-BC]

  Algorithm  Pattern: BC: Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithAESCBC

  Algorithm  Pattern: BC: Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithAESCBC

  Algorithm  Pattern: BC: Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithAESCBC

  Algorithm  Pattern: BC: SecretKeyFactory.AES -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyFactory

  Algorithm  Pattern: BC: SecretKeyFactory.2.16.840.1.101.3.4.1 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyFactory

  Algorithm  Pattern: BC: SecretKeyFactory.OID.2.16.840.1.101.3.4.1 -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyFactory

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithMD5And128BitAESCBCOpenSSL

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithMD5And192BitAESCBCOpenSSL

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithMD5And256BitAESCBCOpenSSL

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHAAnd128BitAESBC
  aliases: [PBEWITHSHA1AND128BITAES-CBC-BC, PBEWITHSHA-1AND128BITAES-CBC-BC, 1.3.6.1.4.1.22554.1.1.2.1.2, OID.1.3.6.1.4.1.22554.1.1.2.1.2]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHAAnd192BitAESBC
  aliases: [PBEWITHSHA1AND192BITAES-CBC-BC, PBEWITHSHA-1AND192BITAES-CBC-BC, 1.3.6.1.4.1.22554.1.1.2.1.22, OID.1.3.6.1.4.1.22554.1.1.2.1.22]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHAAnd256BitAESBC
  aliases: [PBEWITHSHA1AND256BITAES-CBC-BC, PBEWITHSHA-1AND256BITAES-CBC-BC, 1.3.6.1.4.1.22554.1.1.2.1.42, OID.1.3.6.1.4.1.22554.1.1.2.1.42]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA256And128BitAESBC
  aliases: [PBEWITHSHA-256AND128BITAES-CBC-BC, PBEWITHSHA-256AND128BITAES-BC, 1.3.6.1.4.1.22554.1.2.1.2.1.2, OID.1.3.6.1.4.1.22554.1.2.1.2.1.2]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA256And192BitAESBC
  aliases: [PBEWITHSHA-256AND192BITAES-CBC-BC, PBEWITHSHA-256AND192BITAES-BC, 1.3.6.1.4.1.22554.1.2.1.2.1.22, OID.1.3.6.1.4.1.22554.1.2.1.2.1.22]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC -> org.bouncycastle.jcajce.provider.symmetric.AES$PBEWithSHA256And256BitAESBC
  aliases: [PBEWITHSHA-256AND256BITAES-CBC-BC, PBEWITHSHA-256AND256BITAES-BC, 1.3.6.1.4.1.22554.1.2.1.2.1.42, OID.1.3.6.1.4.1.22554.1.2.1.2.1.42]

  Algorithm  Pattern: BC: Mac.AES-GMAC -> org.bouncycastle.jcajce.provider.symmetric.AES$AESGMAC
  aliases: [AESGMAC]

  Algorithm  Pattern: BC: KeyGenerator.AES-GMAC -> org.bouncycastle.jcajce.provider.symmetric.AES$KeyGen128
  aliases: [AESGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-AES -> org.bouncycastle.jcajce.provider.symmetric.AES$Poly1305
  aliases: [POLY1305AES]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-AES -> org.bouncycastle.jcajce.provider.symmetric.AES$Poly1305KeyGen
  aliases: [POLY1305AES]

  Algorithm  Pattern: BC: Cipher.ARC4 -> org.bouncycastle.jcajce.provider.symmetric.ARC4$Base
  aliases: [1.2.840.113549.3.4, OID.1.2.840.113549.3.4, ARCFOUR, RC4]

  Algorithm  Pattern: BC: KeyGenerator.ARC4 -> org.bouncycastle.jcajce.provider.symmetric.ARC4$KeyGen
  aliases: [RC4, 1.2.840.113549.3.4]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND128BITRC4 -> org.bouncycastle.jcajce.provider.symmetric.ARC4$PBEWithSHAAnd128BitKeyFactory
  aliases: [1.2.840.113549.1.12.1.1, OID.1.2.840.113549.1.12.1.1]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND40BITRC4 -> org.bouncycastle.jcajce.provider.symmetric.ARC4$PBEWithSHAAnd40BitKeyFactory
  aliases: [1.2.840.113549.1.12.1.2, OID.1.2.840.113549.1.12.1.2]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND128BITRC4 -> org.bouncycastle.jcajce.provider.symmetric.ARC4$PBEWithSHAAnd128Bit
  aliases: [PBEWITHSHA1AND128BITRC4, 1.2.840.113549.1.12.1.1, OID.1.2.840.113549.1.12.1.1]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND40BITRC4 -> org.bouncycastle.jcajce.provider.symmetric.ARC4$PBEWithSHAAnd40Bit
  aliases: [PBEWITHSHA1AND40BITRC4, 1.2.840.113549.1.12.1.2, OID.1.2.840.113549.1.12.1.2]

  Algorithm  Pattern: BC: AlgorithmParameters.ARIA -> org.bouncycastle.jcajce.provider.symmetric.ARIA$AlgParams
  aliases: [1.2.410.200046.1.1.2, OID.1.2.410.200046.1.1.2, 1.2.410.200046.1.1.7, OID.1.2.410.200046.1.1.7, 1.2.410.200046.1.1.12, OID.1.2.410.200046.1.1.12]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.ARIA -> org.bouncycastle.jcajce.provider.symmetric.ARIA$AlgParamGen
  aliases: [1.2.410.200046.1.1.2, OID.1.2.410.200046.1.1.2, 1.2.410.200046.1.1.7, OID.1.2.410.200046.1.1.7, 1.2.410.200046.1.1.12, OID.1.2.410.200046.1.1.12, 1.2.410.200046.1.1.4, OID.1.2.410.200046.1.1.4, 1.2.410.200046.1.1.9, OID.1.2.410.200046.1.1.9, 1.2.410.200046.1.1.14, OID.1.2.410.200046.1.1.14, 1.2.410.200046.1.1.3, OID.1.2.410.200046.1.1.3, 1.2.410.200046.1.1.8, OID.1.2.410.200046.1.1.8, 1.2.410.200046.1.1.13, OID.1.2.410.200046.1.1.13]

  Algorithm  Pattern: BC: Cipher.ARIA -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.1 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.1 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.6 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.6 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.11 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.11 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$ECB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CBC

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.7 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.7 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CBC

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.12 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.12 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CBC

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CFB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CFB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.8 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CFB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.8 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CFB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.13 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CFB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.13 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$CFB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$OFB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$OFB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.9 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$OFB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.9 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$OFB

  Algorithm  Pattern: BC: Cipher.1.2.410.200046.1.1.14 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$OFB

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200046.1.1.14 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$OFB

  Algorithm  Pattern: BC: Cipher.ARIARFC3211WRAP -> org.bouncycastle.jcajce.provider.symmetric.ARIA$RFC3211Wrap

  Algorithm  Pattern: BC: Cipher.ARIAWRAP -> org.bouncycastle.jcajce.provider.symmetric.ARIA$Wrap
  aliases: [1.2.410.200046.1.1.40, OID.1.2.410.200046.1.1.40, 1.2.410.200046.1.1.41, OID.1.2.410.200046.1.1.41, 1.2.410.200046.1.1.42, OID.1.2.410.200046.1.1.42, ARIAKW]

  Algorithm  Pattern: BC: Cipher.ARIAWRAPPAD -> org.bouncycastle.jcajce.provider.symmetric.ARIA$WrapPad
  aliases: [1.2.410.200046.1.1.43, OID.1.2.410.200046.1.1.43, 1.2.410.200046.1.1.44, OID.1.2.410.200046.1.1.44, 1.2.410.200046.1.1.45, OID.1.2.410.200046.1.1.45, ARIAKWP]

  Algorithm  Pattern: BC: KeyGenerator.ARIA -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.40 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.40 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.41 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.41 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.42 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.42 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.43 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.43 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.44 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.44 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.45 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.45 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.1 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.1 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.6 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.6 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.11 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.11 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.7 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.7 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.12 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.12 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.8 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.8 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.13 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.13 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.9 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.9 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.14 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.14 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.37 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.37 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.38 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.38 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.39 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.39 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.34 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.34 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.35 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.35 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200046.1.1.36 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200046.1.1.36 -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen256

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.ARIACCM -> org.bouncycastle.jcajce.provider.symmetric.ARIA$AlgParamGenCCM

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.ARIAGCM -> org.bouncycastle.jcajce.provider.symmetric.ARIA$AlgParamGenGCM

  Algorithm  Pattern: BC: Mac.ARIA-GMAC -> org.bouncycastle.jcajce.provider.symmetric.ARIA$GMAC
  aliases: [ARIAGMAC]

  Algorithm  Pattern: BC: KeyGenerator.ARIA-GMAC -> org.bouncycastle.jcajce.provider.symmetric.ARIA$KeyGen
  aliases: [ARIAGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-ARIA -> org.bouncycastle.jcajce.provider.symmetric.ARIA$Poly1305
  aliases: [POLY1305ARIA]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-ARIA -> org.bouncycastle.jcajce.provider.symmetric.ARIA$Poly1305KeyGen
  aliases: [POLY1305ARIA]

  Algorithm  Pattern: BC: Mac.BLOWFISHCMAC -> org.bouncycastle.jcajce.provider.symmetric.Blowfish$CMAC

  Algorithm  Pattern: BC: Cipher.BLOWFISH -> org.bouncycastle.jcajce.provider.symmetric.Blowfish$ECB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.3029.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.Blowfish$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.3029.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.Blowfish$CBC

  Algorithm  Pattern: BC: KeyGenerator.BLOWFISH -> org.bouncycastle.jcajce.provider.symmetric.Blowfish$KeyGen
  aliases: [1.3.6.1.4.1.3029.1.1.2, OID.1.3.6.1.4.1.3029.1.1.2]

  Algorithm  Pattern: BC: AlgorithmParameters.BLOWFISH -> org.bouncycastle.jcajce.provider.symmetric.Blowfish$AlgParams
  aliases: [1.3.6.1.4.1.3029.1.1.2, OID.1.3.6.1.4.1.3029.1.1.2]

  Algorithm  Pattern: BC: AlgorithmParameters.CAMELLIA -> org.bouncycastle.jcajce.provider.symmetric.Camellia$AlgParams
  aliases: [1.2.392.200011.61.1.1.1.2, OID.1.2.392.200011.61.1.1.1.2, 1.2.392.200011.61.1.1.1.3, OID.1.2.392.200011.61.1.1.1.3, 1.2.392.200011.61.1.1.1.4, OID.1.2.392.200011.61.1.1.1.4]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.CAMELLIA -> org.bouncycastle.jcajce.provider.symmetric.Camellia$AlgParamGen
  aliases: [1.2.392.200011.61.1.1.1.2, OID.1.2.392.200011.61.1.1.1.2, 1.2.392.200011.61.1.1.1.3, OID.1.2.392.200011.61.1.1.1.3, 1.2.392.200011.61.1.1.1.4, OID.1.2.392.200011.61.1.1.1.4]

  Algorithm  Pattern: BC: Cipher.CAMELLIA -> org.bouncycastle.jcajce.provider.symmetric.Camellia$ECB

  Algorithm  Pattern: BC: Cipher.1.2.392.200011.61.1.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.392.200011.61.1.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$CBC

  Algorithm  Pattern: BC: Cipher.1.2.392.200011.61.1.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.392.200011.61.1.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$CBC

  Algorithm  Pattern: BC: Cipher.1.2.392.200011.61.1.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.392.200011.61.1.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$CBC

  Algorithm  Pattern: BC: Cipher.CAMELLIARFC3211WRAP -> org.bouncycastle.jcajce.provider.symmetric.Camellia$RFC3211Wrap

  Algorithm  Pattern: BC: Cipher.CAMELLIAWRAP -> org.bouncycastle.jcajce.provider.symmetric.Camellia$Wrap
  aliases: [1.2.392.200011.61.1.1.3.2, OID.1.2.392.200011.61.1.1.3.2, 1.2.392.200011.61.1.1.3.3, OID.1.2.392.200011.61.1.1.3.3, 1.2.392.200011.61.1.1.3.4, OID.1.2.392.200011.61.1.1.3.4]

  Algorithm  Pattern: BC: KeyGenerator.CAMELLIA -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.1.2.392.200011.61.1.1.3.2 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.392.200011.61.1.1.3.2 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.392.200011.61.1.1.3.3 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.392.200011.61.1.1.3.3 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.392.200011.61.1.1.3.4 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.392.200011.61.1.1.3.4 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.392.200011.61.1.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.392.200011.61.1.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.392.200011.61.1.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.392.200011.61.1.1.1.3 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen192

  Algorithm  Pattern: BC: KeyGenerator.1.2.392.200011.61.1.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.392.200011.61.1.1.1.4 -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen256

  Algorithm  Pattern: BC: Mac.CAMELLIA-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Camellia$GMAC
  aliases: [CAMELLIAGMAC]

  Algorithm  Pattern: BC: KeyGenerator.CAMELLIA-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Camellia$KeyGen
  aliases: [CAMELLIAGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-CAMELLIA -> org.bouncycastle.jcajce.provider.symmetric.Camellia$Poly1305
  aliases: [POLY1305CAMELLIA]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-CAMELLIA -> org.bouncycastle.jcajce.provider.symmetric.Camellia$Poly1305KeyGen
  aliases: [POLY1305CAMELLIA]

  Algorithm  Pattern: BC: AlgorithmParameters.CAST5 -> org.bouncycastle.jcajce.provider.symmetric.CAST5$AlgParams
  aliases: [1.2.840.113533.7.66.10]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.CAST5 -> org.bouncycastle.jcajce.provider.symmetric.CAST5$AlgParamGen
  aliases: [1.2.840.113533.7.66.10]

  Algorithm  Pattern: BC: Cipher.CAST5 -> org.bouncycastle.jcajce.provider.symmetric.CAST5$ECB

  Algorithm  Pattern: BC: Cipher.1.2.840.113533.7.66.10 -> org.bouncycastle.jcajce.provider.symmetric.CAST5$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.840.113533.7.66.10 -> org.bouncycastle.jcajce.provider.symmetric.CAST5$CBC

  Algorithm  Pattern: BC: KeyGenerator.CAST5 -> org.bouncycastle.jcajce.provider.symmetric.CAST5$KeyGen
  aliases: [1.2.840.113533.7.66.10, OID.1.2.840.113533.7.66.10]

  Algorithm  Pattern: BC: Cipher.CAST6 -> org.bouncycastle.jcajce.provider.symmetric.CAST6$ECB

  Algorithm  Pattern: BC: KeyGenerator.CAST6 -> org.bouncycastle.jcajce.provider.symmetric.CAST6$KeyGen

  Algorithm  Pattern: BC: Mac.CAST6-GMAC -> org.bouncycastle.jcajce.provider.symmetric.CAST6$GMAC
  aliases: [CAST6GMAC]

  Algorithm  Pattern: BC: KeyGenerator.CAST6-GMAC -> org.bouncycastle.jcajce.provider.symmetric.CAST6$KeyGen
  aliases: [CAST6GMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-CAST6 -> org.bouncycastle.jcajce.provider.symmetric.CAST6$Poly1305
  aliases: [POLY1305CAST6]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-CAST6 -> org.bouncycastle.jcajce.provider.symmetric.CAST6$Poly1305KeyGen
  aliases: [POLY1305CAST6]

  Algorithm  Pattern: BC: Cipher.CHACHA -> org.bouncycastle.jcajce.provider.symmetric.ChaCha$Base

  Algorithm  Pattern: BC: KeyGenerator.CHACHA -> org.bouncycastle.jcajce.provider.symmetric.ChaCha$KeyGen

  Algorithm  Pattern: BC: Cipher.CHACHA7539 -> org.bouncycastle.jcajce.provider.symmetric.ChaCha$Base7539

  Algorithm  Pattern: BC: KeyGenerator.CHACHA7539 -> org.bouncycastle.jcajce.provider.symmetric.ChaCha$KeyGen7539

  Algorithm  Pattern: BC: Cipher.DES -> org.bouncycastle.jcajce.provider.symmetric.DES$ECB

  Algorithm  Pattern: BC: Cipher.1.3.14.3.2.7 -> org.bouncycastle.jcajce.provider.symmetric.DES$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.3.14.3.2.7 -> org.bouncycastle.jcajce.provider.symmetric.DES$CBC

  Algorithm  Pattern: BC: KeyGenerator.DES -> org.bouncycastle.jcajce.provider.symmetric.DES$KeyGenerator
  aliases: [1.3.14.3.2.7]

  Algorithm  Pattern: BC: Cipher.DESRFC3211WRAP -> org.bouncycastle.jcajce.provider.symmetric.DES$RFC3211

  Algorithm  Pattern: BC: SecretKeyFactory.DES -> org.bouncycastle.jcajce.provider.symmetric.DES$KeyFactory

  Algorithm  Pattern: BC: Mac.DESCMAC -> org.bouncycastle.jcajce.provider.symmetric.DES$CMAC

  Algorithm  Pattern: BC: Mac.DESMAC -> org.bouncycastle.jcajce.provider.symmetric.DES$CBCMAC
  aliases: [DES]

  Algorithm  Pattern: BC: Mac.DESMAC/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.DES$DESCFB8
  aliases: [DES/CFB8]

  Algorithm  Pattern: BC: Mac.DESMAC64 -> org.bouncycastle.jcajce.provider.symmetric.DES$DES64
  aliases: [DES64]

  Algorithm  Pattern: BC: Mac.DESMAC64WITHISO7816-4PADDING -> org.bouncycastle.jcajce.provider.symmetric.DES$DES64with7816d4
  aliases: [DES64WITHISO7816-4PADDING, DESISO9797ALG1MACWITHISO7816-4PADDING, DESISO9797ALG1WITHISO7816-4PADDING]

  Algorithm  Pattern: BC: Mac.DESWITHISO9797 -> org.bouncycastle.jcajce.provider.symmetric.DES$DES9797Alg3
  aliases: [DESISO9797MAC]

  Algorithm  Pattern: BC: Mac.ISO9797ALG3MAC -> org.bouncycastle.jcajce.provider.symmetric.DES$DES9797Alg3
  aliases: [ISO9797ALG3]

  Algorithm  Pattern: BC: Mac.ISO9797ALG3WITHISO7816-4PADDING -> org.bouncycastle.jcajce.provider.symmetric.DES$DES9797Alg3with7816d4
  aliases: [ISO9797ALG3MACWITHISO7816-4PADDING]

  Algorithm  Pattern: BC: AlgorithmParameters.DES -> org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters
  aliases: [1.3.14.3.2.7, OID.1.3.14.3.2.7]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.DES -> org.bouncycastle.jcajce.provider.symmetric.DES$AlgParamGen
  aliases: [1.3.14.3.2.7]

  Algorithm  Pattern: BC: Cipher.PBEWITHMD2ANDDES -> org.bouncycastle.jcajce.provider.symmetric.DES$PBEWithMD2
  aliases: [1.2.840.113549.1.5.1, OID.1.2.840.113549.1.5.1, PBEWITHMD2ANDDES-CBC]

  Algorithm  Pattern: BC: Cipher.PBEWITHMD5ANDDES -> org.bouncycastle.jcajce.provider.symmetric.DES$PBEWithMD5
  aliases: [1.2.840.113549.1.5.3, OID.1.2.840.113549.1.5.3, PBEWITHMD5ANDDES-CBC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHA1ANDDES -> org.bouncycastle.jcajce.provider.symmetric.DES$PBEWithSHA1
  aliases: [1.2.840.113549.1.5.10, OID.1.2.840.113549.1.5.10, PBEWITHSHA1ANDDES-CBC]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD2ANDDES -> org.bouncycastle.jcajce.provider.symmetric.DES$PBEWithMD2KeyFactory
  aliases: [PBEWITHMD2ANDDES-CBC, 1.2.840.113549.1.5.1]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD5ANDDES -> org.bouncycastle.jcajce.provider.symmetric.DES$PBEWithMD5KeyFactory
  aliases: [PBEWITHMD5ANDDES-CBC, 1.2.840.113549.1.5.3]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHA1ANDDES -> org.bouncycastle.jcajce.provider.symmetric.DES$PBEWithSHA1KeyFactory
  aliases: [PBEWITHSHA1ANDDES-CBC, 1.2.840.113549.1.5.10]

  Algorithm  Pattern: BC: Cipher.DESEDE -> org.bouncycastle.jcajce.provider.symmetric.DESede$ECB
  aliases: [TDEA]

  Algorithm  Pattern: BC: Cipher.1.2.840.113549.3.7 -> org.bouncycastle.jcajce.provider.symmetric.DESede$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.840.113549.3.7 -> org.bouncycastle.jcajce.provider.symmetric.DESede$CBC

  Algorithm  Pattern: BC: Cipher.DESEDEWRAP -> org.bouncycastle.jcajce.provider.symmetric.DESede$Wrap
  aliases: [DESEDERFC3217WRAP, TDEAWRAP]

  Algorithm  Pattern: BC: Cipher.1.2.840.113549.1.9.16.3.6 -> org.bouncycastle.jcajce.provider.symmetric.DESede$Wrap

  Algorithm  Pattern: BC: Cipher.OID.1.2.840.113549.1.9.16.3.6 -> org.bouncycastle.jcajce.provider.symmetric.DESede$Wrap

  Algorithm  Pattern: BC: Cipher.DESEDERFC3211WRAP -> org.bouncycastle.jcajce.provider.symmetric.DESede$RFC3211

  Algorithm  Pattern: BC: KeyGenerator.DESEDE -> org.bouncycastle.jcajce.provider.symmetric.DESede$KeyGenerator
  aliases: [TDEA]

  Algorithm  Pattern: BC: AlgorithmParameters.DESEDE -> org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters
  aliases: [TDEA, 1.2.840.113549.3.7]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.DESEDE -> org.bouncycastle.jcajce.provider.symmetric.DESede$AlgParamGen
  aliases: [TDEA, 1.2.840.113549.3.7]

  Algorithm  Pattern: BC: SecretKeyFactory.DESEDE -> org.bouncycastle.jcajce.provider.symmetric.DESede$KeyFactory
  aliases: [TDEA]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$PBEWithSHAAndDES3Key
  aliases: [1.2.840.113549.1.12.1.3, OID.1.2.840.113549.1.12.1.3, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1AND3-KEYTRIPLEDES-CBC, PBEWITHSHAAND3-KEYDESEDE-CBC, PBEWITHSHA1AND3-KEYDESEDE-CBC, PBEWITHSHA1ANDDESEDE-CBC, PBEWithSHAAnd3KeyTripleDES]

  Algorithm  Pattern: BC: Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$BrokePBEWithSHAAndDES3Key

  Algorithm  Pattern: BC: Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$OldPBEWithSHAAndDES3Key

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$PBEWithSHAAndDES2Key
  aliases: [1.2.840.113549.1.12.1.4, OID.1.2.840.113549.1.12.1.4, PBEWITHSHA1AND2-KEYTRIPLEDES-CBC, PBEWITHSHAAND2-KEYDESEDE-CBC, PBEWITHSHA1AND2-KEYDESEDE-CBC]

  Algorithm  Pattern: BC: Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$BrokePBEWithSHAAndDES2Key

  Algorithm  Pattern: BC: KeyGenerator.1.2.840.113549.3.7 -> org.bouncycastle.jcajce.provider.symmetric.DESede$KeyGenerator3

  Algorithm  Pattern: BC: KeyGenerator.DESEDEWRAP -> org.bouncycastle.jcajce.provider.symmetric.DESede$KeyGenerator

  Algorithm  Pattern: BC: SecretKeyFactory.1.3.14.3.2.17 -> org.bouncycastle.jcajce.provider.symmetric.DESede$KeyFactory

  Algorithm  Pattern: BC: SecretKeyFactory.OID.1.3.14.3.2.17 -> org.bouncycastle.jcajce.provider.symmetric.DESede$KeyFactory

  Algorithm  Pattern: BC: Mac.DESEDECMAC -> org.bouncycastle.jcajce.provider.symmetric.DESede$CMAC

  Algorithm  Pattern: BC: Mac.DESEDEMAC -> org.bouncycastle.jcajce.provider.symmetric.DESede$CBCMAC
  aliases: [DESEDE]

  Algorithm  Pattern: BC: Mac.DESEDEMAC/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.DESede$DESedeCFB8
  aliases: [DESEDE/CFB8]

  Algorithm  Pattern: BC: Mac.DESEDEMAC64 -> org.bouncycastle.jcajce.provider.symmetric.DESede$DESede64
  aliases: [DESEDE64]

  Algorithm  Pattern: BC: Mac.DESEDEMAC64WITHISO7816-4PADDING -> org.bouncycastle.jcajce.provider.symmetric.DESede$DESede64with7816d4
  aliases: [DESEDE64WITHISO7816-4PADDING, DESEDEISO9797ALG1MACWITHISO7816-4PADDING, DESEDEISO9797ALG1WITHISO7816-4PADDING]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$PBEWithSHAAndDES3KeyFactory
  aliases: [1.2.840.113549.1.12.1.3, PBEWithSHAAnd3KeyTripleDES]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC -> org.bouncycastle.jcajce.provider.symmetric.DESede$PBEWithSHAAndDES2KeyFactory
  aliases: [1.2.840.113549.1.12.1.4]

  Algorithm  Pattern: BC: Cipher.GOST28147 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$ECB
  aliases: [GOST, GOST-28147]

  Algorithm  Pattern: BC: Cipher.1.2.643.2.2.21 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$GCFB

  Algorithm  Pattern: BC: KeyGenerator.GOST28147 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$KeyGen
  aliases: [GOST, GOST-28147, 1.2.643.2.2.21]

  Algorithm  Pattern: BC: AlgorithmParameters.GOST28147 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$AlgParams
  aliases: [1.2.643.2.2.21]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.GOST28147 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$AlgParamGen
  aliases: [1.2.643.2.2.21]

  Algorithm  Pattern: BC: Cipher.1.2.643.2.2.13.1 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$CryptoProWrap

  Algorithm  Pattern: BC: Cipher.1.2.643.2.2.13.0 -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$GostWrap

  Algorithm  Pattern: BC: Mac.GOST28147MAC -> org.bouncycastle.jcajce.provider.symmetric.GOST28147$Mac
  aliases: [GOST28147]

  Algorithm  Pattern: BC: Cipher.Grainv1 -> org.bouncycastle.jcajce.provider.symmetric.Grainv1$Base

  Algorithm  Pattern: BC: KeyGenerator.Grainv1 -> org.bouncycastle.jcajce.provider.symmetric.Grainv1$KeyGen

  Algorithm  Pattern: BC: Cipher.Grain128 -> org.bouncycastle.jcajce.provider.symmetric.Grain128$Base

  Algorithm  Pattern: BC: KeyGenerator.Grain128 -> org.bouncycastle.jcajce.provider.symmetric.Grain128$KeyGen

  Algorithm  Pattern: BC: Cipher.HC128 -> org.bouncycastle.jcajce.provider.symmetric.HC128$Base

  Algorithm  Pattern: BC: KeyGenerator.HC128 -> org.bouncycastle.jcajce.provider.symmetric.HC128$KeyGen

  Algorithm  Pattern: BC: Cipher.HC256 -> org.bouncycastle.jcajce.provider.symmetric.HC256$Base

  Algorithm  Pattern: BC: KeyGenerator.HC256 -> org.bouncycastle.jcajce.provider.symmetric.HC256$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.IDEA -> org.bouncycastle.jcajce.provider.symmetric.IDEA$AlgParamGen

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$AlgParamGen

  Algorithm  Pattern: BC: AlgorithmParameters.IDEA -> org.bouncycastle.jcajce.provider.symmetric.IDEA$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$AlgParams

  Algorithm  Pattern: BC: Cipher.IDEA -> org.bouncycastle.jcajce.provider.symmetric.IDEA$ECB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.188.7.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.188.7.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$CBC

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAANDIDEA-CBC -> org.bouncycastle.jcajce.provider.symmetric.IDEA$PBEWithSHAAndIDEA

  Algorithm  Pattern: BC: KeyGenerator.IDEA -> org.bouncycastle.jcajce.provider.symmetric.IDEA$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.1.3.6.1.4.1.188.7.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.OID.1.3.6.1.4.1.188.7.1.1.2 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$KeyGen

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAANDIDEA-CBC -> org.bouncycastle.jcajce.provider.symmetric.IDEA$PBEWithSHAAndIDEAKeyGen

  Algorithm  Pattern: BC: Mac.IDEAMAC -> org.bouncycastle.jcajce.provider.symmetric.IDEA$Mac
  aliases: [IDEA]

  Algorithm  Pattern: BC: Mac.IDEAMAC/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.IDEA$CFB8Mac
  aliases: [IDEA/CFB8]

  Algorithm  Pattern: BC: AlgorithmParameters.NOEKEON -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.NOEKEON -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$AlgParamGen

  Algorithm  Pattern: BC: Cipher.NOEKEON -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$ECB

  Algorithm  Pattern: BC: KeyGenerator.NOEKEON -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$KeyGen

  Algorithm  Pattern: BC: Mac.NOEKEON-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$GMAC
  aliases: [NOEKEONGMAC]

  Algorithm  Pattern: BC: KeyGenerator.NOEKEON-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$KeyGen
  aliases: [NOEKEONGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-NOEKEON -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$Poly1305
  aliases: [POLY1305NOEKEON]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-NOEKEON -> org.bouncycastle.jcajce.provider.symmetric.Noekeon$Poly1305KeyGen
  aliases: [POLY1305NOEKEON]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.RC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$AlgParamGen

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.1.2.840.113549.3.2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$AlgParamGen

  Algorithm  Pattern: BC: KeyGenerator.RC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$KeyGenerator

  Algorithm  Pattern: BC: KeyGenerator.1.2.840.113549.3.2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$KeyGenerator

  Algorithm  Pattern: BC: AlgorithmParameters.RC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.1.2.840.113549.3.2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$AlgParams

  Algorithm  Pattern: BC: Cipher.RC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$ECB

  Algorithm  Pattern: BC: Cipher.RC2WRAP -> org.bouncycastle.jcajce.provider.symmetric.RC2$Wrap
  aliases: [1.2.840.113549.1.9.16.3.7, OID.1.2.840.113549.1.9.16.3.7]

  Algorithm  Pattern: BC: Cipher.1.2.840.113549.3.2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.840.113549.3.2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$CBC

  Algorithm  Pattern: BC: Mac.RC2MAC -> org.bouncycastle.jcajce.provider.symmetric.RC2$CBCMAC
  aliases: [RC2]

  Algorithm  Pattern: BC: Mac.RC2MAC/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.RC2$CFB8MAC
  aliases: [RC2/CFB8]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD2ANDRC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithMD2KeyFactory
  aliases: [PBEWITHMD2ANDRC2-CBC, 1.2.840.113549.1.5.4, OID.1.2.840.113549.1.5.4]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHMD5ANDRC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithMD5KeyFactory
  aliases: [PBEWITHMD5ANDRC2-CBC, 1.2.840.113549.1.5.6, OID.1.2.840.113549.1.5.6]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHA1ANDRC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHA1KeyFactory
  aliases: [PBEWITHSHA1ANDRC2-CBC, 1.2.840.113549.1.5.11, OID.1.2.840.113549.1.5.11]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHAAnd128BitKeyFactory
  aliases: [1.2.840.113549.1.12.1.5]

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHAAnd40BitKeyFactory
  aliases: [1.2.840.113549.1.12.1.6]

  Algorithm  Pattern: BC: Cipher.PBEWITHMD5ANDRC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithMD5AndRC2
  aliases: [1.2.840.113549.1.5.6, OID.1.2.840.113549.1.5.6, PBEWITHMD5ANDRC2-CBC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHA1ANDRC2 -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHA1AndRC2
  aliases: [1.2.840.113549.1.5.11, OID.1.2.840.113549.1.5.11, PBEWITHSHAANDRC2-CBC, PBEWITHSHA1ANDRC2-CBC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND128BITRC2-CBC -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHAAnd128BitRC2
  aliases: [1.2.840.113549.1.12.1.5, OID.1.2.840.113549.1.12.1.5, PBEWITHSHA1AND128BITRC2-CBC]

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAAND40BITRC2-CBC -> org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHAAnd40BitRC2
  aliases: [1.2.840.113549.1.12.1.6, OID.1.2.840.113549.1.12.1.6, PBEWITHSHA1AND40BITRC2-CBC]

  Algorithm  Pattern: BC: Cipher.RC5 -> org.bouncycastle.jcajce.provider.symmetric.RC5$ECB32
  aliases: [RC5-32]

  Algorithm  Pattern: BC: Cipher.RC5-64 -> org.bouncycastle.jcajce.provider.symmetric.RC5$ECB64

  Algorithm  Pattern: BC: KeyGenerator.RC5 -> org.bouncycastle.jcajce.provider.symmetric.RC5$KeyGen32
  aliases: [RC5-32]

  Algorithm  Pattern: BC: KeyGenerator.RC5-64 -> org.bouncycastle.jcajce.provider.symmetric.RC5$KeyGen64

  Algorithm  Pattern: BC: AlgorithmParameters.RC5 -> org.bouncycastle.jcajce.provider.symmetric.RC5$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.RC5-64 -> org.bouncycastle.jcajce.provider.symmetric.RC5$AlgParams

  Algorithm  Pattern: BC: Mac.RC5MAC -> org.bouncycastle.jcajce.provider.symmetric.RC5$Mac32
  aliases: [RC5]

  Algorithm  Pattern: BC: Mac.RC5MAC/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.RC5$CFB8Mac32
  aliases: [RC5/CFB8]

  Algorithm  Pattern: BC: Cipher.RC6 -> org.bouncycastle.jcajce.provider.symmetric.RC6$ECB

  Algorithm  Pattern: BC: KeyGenerator.RC6 -> org.bouncycastle.jcajce.provider.symmetric.RC6$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.RC6 -> org.bouncycastle.jcajce.provider.symmetric.RC6$AlgParams

  Algorithm  Pattern: BC: Mac.RC6-GMAC -> org.bouncycastle.jcajce.provider.symmetric.RC6$GMAC
  aliases: [RC6GMAC]

  Algorithm  Pattern: BC: KeyGenerator.RC6-GMAC -> org.bouncycastle.jcajce.provider.symmetric.RC6$KeyGen
  aliases: [RC6GMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-RC6 -> org.bouncycastle.jcajce.provider.symmetric.RC6$Poly1305
  aliases: [POLY1305RC6]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-RC6 -> org.bouncycastle.jcajce.provider.symmetric.RC6$Poly1305KeyGen
  aliases: [POLY1305RC6]

  Algorithm  Pattern: BC: Cipher.RIJNDAEL -> org.bouncycastle.jcajce.provider.symmetric.Rijndael$ECB

  Algorithm  Pattern: BC: KeyGenerator.RIJNDAEL -> org.bouncycastle.jcajce.provider.symmetric.Rijndael$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.RIJNDAEL -> org.bouncycastle.jcajce.provider.symmetric.Rijndael$AlgParams

  Algorithm  Pattern: BC: Cipher.SALSA20 -> org.bouncycastle.jcajce.provider.symmetric.Salsa20$Base

  Algorithm  Pattern: BC: KeyGenerator.SALSA20 -> org.bouncycastle.jcajce.provider.symmetric.Salsa20$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.SEED -> org.bouncycastle.jcajce.provider.symmetric.SEED$AlgParams
  aliases: [1.2.410.200004.1.4]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.SEED -> org.bouncycastle.jcajce.provider.symmetric.SEED$AlgParamGen
  aliases: [1.2.410.200004.1.4]

  Algorithm  Pattern: BC: Cipher.SEED -> org.bouncycastle.jcajce.provider.symmetric.SEED$ECB

  Algorithm  Pattern: BC: Cipher.1.2.410.200004.1.4 -> org.bouncycastle.jcajce.provider.symmetric.SEED$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.2.410.200004.1.4 -> org.bouncycastle.jcajce.provider.symmetric.SEED$CBC

  Algorithm  Pattern: BC: Cipher.SEEDWRAP -> org.bouncycastle.jcajce.provider.symmetric.SEED$Wrap
  aliases: [1.2.410.200004.7.1.1.1, OID.1.2.410.200004.7.1.1.1, SEEDKW]

  Algorithm  Pattern: BC: KeyGenerator.SEED -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200004.1.4 -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200004.1.4 -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.1.2.410.200004.7.1.1.1 -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.410.200004.7.1.1.1 -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen

  Algorithm  Pattern: BC: Mac.SEED-CMAC -> org.bouncycastle.jcajce.provider.symmetric.SEED$CMAC
  aliases: [SEEDCMAC]

  Algorithm  Pattern: BC: KeyGenerator.SEED-CMAC -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen
  aliases: [SEEDCMAC]

  Algorithm  Pattern: BC: Mac.SEED-GMAC -> org.bouncycastle.jcajce.provider.symmetric.SEED$GMAC
  aliases: [SEEDGMAC]

  Algorithm  Pattern: BC: KeyGenerator.SEED-GMAC -> org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen
  aliases: [SEEDGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-SEED -> org.bouncycastle.jcajce.provider.symmetric.SEED$Poly1305
  aliases: [POLY1305SEED]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-SEED -> org.bouncycastle.jcajce.provider.symmetric.SEED$Poly1305KeyGen
  aliases: [POLY1305SEED]

  Algorithm  Pattern: BC: Cipher.Serpent -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: KeyGenerator.Serpent -> org.bouncycastle.jcajce.provider.symmetric.Serpent$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.Serpent -> org.bouncycastle.jcajce.provider.symmetric.Serpent$AlgParams

  Algorithm  Pattern: BC: Cipher.Tnepres -> org.bouncycastle.jcajce.provider.symmetric.Serpent$TECB

  Algorithm  Pattern: BC: KeyGenerator.Tnepres -> org.bouncycastle.jcajce.provider.symmetric.Serpent$TKeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.Tnepres -> org.bouncycastle.jcajce.provider.symmetric.Serpent$TAlgParams

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.1 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.1 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.21 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.21 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.41 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.41 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.2 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.2 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.22 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.22 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.42 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.42 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.4 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.4 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.24 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.24 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.44 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.44 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.3 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.3 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.23 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.23 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB

  Algorithm  Pattern: BC: Cipher.1.3.6.1.4.1.11591.13.2.43 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB

  Algorithm  Pattern: BC: Cipher.OID.1.3.6.1.4.1.11591.13.2.43 -> org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB

  Algorithm  Pattern: BC: Mac.SERPENT-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Serpent$SerpentGMAC
  aliases: [SERPENTGMAC]

  Algorithm  Pattern: BC: KeyGenerator.SERPENT-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Serpent$KeyGen
  aliases: [SERPENTGMAC]

  Algorithm  Pattern: BC: Mac.TNEPRES-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Serpent$TSerpentGMAC
  aliases: [TNEPRESGMAC]

  Algorithm  Pattern: BC: KeyGenerator.TNEPRES-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Serpent$TKeyGen
  aliases: [TNEPRESGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-SERPENT -> org.bouncycastle.jcajce.provider.symmetric.Serpent$Poly1305
  aliases: [POLY1305SERPENT]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-SERPENT -> org.bouncycastle.jcajce.provider.symmetric.Serpent$Poly1305KeyGen
  aliases: [POLY1305SERPENT]

  Algorithm  Pattern: BC: Mac.Shacal-2CMAC -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$CMAC

  Algorithm  Pattern: BC: Cipher.Shacal2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$ECB

  Algorithm  Pattern: BC: Cipher.SHACAL-2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$ECB

  Algorithm  Pattern: BC: KeyGenerator.Shacal2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.Shacal2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$AlgParamGen

  Algorithm  Pattern: BC: AlgorithmParameters.Shacal2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$AlgParams

  Algorithm  Pattern: BC: KeyGenerator.SHACAL-2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.SHACAL-2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$AlgParamGen

  Algorithm  Pattern: BC: AlgorithmParameters.SHACAL-2 -> org.bouncycastle.jcajce.provider.symmetric.Shacal2$AlgParams

  Algorithm  Pattern: BC: Cipher.SKIPJACK -> org.bouncycastle.jcajce.provider.symmetric.Skipjack$ECB

  Algorithm  Pattern: BC: KeyGenerator.SKIPJACK -> org.bouncycastle.jcajce.provider.symmetric.Skipjack$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.SKIPJACK -> org.bouncycastle.jcajce.provider.symmetric.Skipjack$AlgParams

  Algorithm  Pattern: BC: Mac.SKIPJACKMAC -> org.bouncycastle.jcajce.provider.symmetric.Skipjack$Mac
  aliases: [SKIPJACK]

  Algorithm  Pattern: BC: Mac.SKIPJACKMAC/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.Skipjack$MacCFB8
  aliases: [SKIPJACK/CFB8]

  Algorithm  Pattern: BC: AlgorithmParameters.SM4 -> org.bouncycastle.jcajce.provider.symmetric.SM4$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.SM4 -> org.bouncycastle.jcajce.provider.symmetric.SM4$AlgParamGen

  Algorithm  Pattern: BC: Cipher.SM4 -> org.bouncycastle.jcajce.provider.symmetric.SM4$ECB

  Algorithm  Pattern: BC: KeyGenerator.SM4 -> org.bouncycastle.jcajce.provider.symmetric.SM4$KeyGen

  Algorithm  Pattern: BC: Mac.SM4-CMAC -> org.bouncycastle.jcajce.provider.symmetric.SM4$CMAC
  aliases: [SM4CMAC]

  Algorithm  Pattern: BC: KeyGenerator.SM4-CMAC -> org.bouncycastle.jcajce.provider.symmetric.SM4$KeyGen
  aliases: [SM4CMAC]

  Algorithm  Pattern: BC: Mac.SM4-GMAC -> org.bouncycastle.jcajce.provider.symmetric.SM4$GMAC
  aliases: [SM4GMAC]

  Algorithm  Pattern: BC: KeyGenerator.SM4-GMAC -> org.bouncycastle.jcajce.provider.symmetric.SM4$KeyGen
  aliases: [SM4GMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-SM4 -> org.bouncycastle.jcajce.provider.symmetric.SM4$Poly1305
  aliases: [POLY1305SM4]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-SM4 -> org.bouncycastle.jcajce.provider.symmetric.SM4$Poly1305KeyGen
  aliases: [POLY1305SM4]

  Algorithm  Pattern: BC: Cipher.TEA -> org.bouncycastle.jcajce.provider.symmetric.TEA$ECB

  Algorithm  Pattern: BC: KeyGenerator.TEA -> org.bouncycastle.jcajce.provider.symmetric.TEA$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.TEA -> org.bouncycastle.jcajce.provider.symmetric.TEA$AlgParams

  Algorithm  Pattern: BC: Cipher.Twofish -> org.bouncycastle.jcajce.provider.symmetric.Twofish$ECB

  Algorithm  Pattern: BC: KeyGenerator.Twofish -> org.bouncycastle.jcajce.provider.symmetric.Twofish$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.Twofish -> org.bouncycastle.jcajce.provider.symmetric.Twofish$AlgParams

  Algorithm  Pattern: BC: Cipher.PBEWITHSHAANDTWOFISH-CBC -> org.bouncycastle.jcajce.provider.symmetric.Twofish$PBEWithSHA

  Algorithm  Pattern: BC: SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC -> org.bouncycastle.jcajce.provider.symmetric.Twofish$PBEWithSHAKeyFactory

  Algorithm  Pattern: BC: Mac.Twofish-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Twofish$GMAC
  aliases: [TwofishGMAC]

  Algorithm  Pattern: BC: KeyGenerator.Twofish-GMAC -> org.bouncycastle.jcajce.provider.symmetric.Twofish$KeyGen
  aliases: [TwofishGMAC]

  Algorithm  Pattern: BC: Mac.POLY1305-Twofish -> org.bouncycastle.jcajce.provider.symmetric.Twofish$Poly1305
  aliases: [POLY1305Twofish]

  Algorithm  Pattern: BC: KeyGenerator.POLY1305-Twofish -> org.bouncycastle.jcajce.provider.symmetric.Twofish$Poly1305KeyGen
  aliases: [POLY1305Twofish]

  Algorithm  Pattern: BC: Mac.Threefish-256CMAC -> org.bouncycastle.jcajce.provider.symmetric.Threefish$CMAC_256

  Algorithm  Pattern: BC: Mac.Threefish-512CMAC -> org.bouncycastle.jcajce.provider.symmetric.Threefish$CMAC_512

  Algorithm  Pattern: BC: Mac.Threefish-1024CMAC -> org.bouncycastle.jcajce.provider.symmetric.Threefish$CMAC_1024

  Algorithm  Pattern: BC: Cipher.Threefish-256 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$ECB_256

  Algorithm  Pattern: BC: Cipher.Threefish-512 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$ECB_512

  Algorithm  Pattern: BC: Cipher.Threefish-1024 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$ECB_1024

  Algorithm  Pattern: BC: KeyGenerator.Threefish-256 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$KeyGen_256

  Algorithm  Pattern: BC: KeyGenerator.Threefish-512 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$KeyGen_512

  Algorithm  Pattern: BC: KeyGenerator.Threefish-1024 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$KeyGen_1024

  Algorithm  Pattern: BC: AlgorithmParameters.Threefish-256 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$AlgParams_256

  Algorithm  Pattern: BC: AlgorithmParameters.Threefish-512 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$AlgParams_512

  Algorithm  Pattern: BC: AlgorithmParameters.Threefish-1024 -> org.bouncycastle.jcajce.provider.symmetric.Threefish$AlgParams_1024

  Algorithm  Pattern: BC: Cipher.VMPC -> org.bouncycastle.jcajce.provider.symmetric.VMPC$Base

  Algorithm  Pattern: BC: KeyGenerator.VMPC -> org.bouncycastle.jcajce.provider.symmetric.VMPC$KeyGen

  Algorithm  Pattern: BC: Mac.VMPCMAC -> org.bouncycastle.jcajce.provider.symmetric.VMPC$Mac
  aliases: [VMPC, VMPC-MAC]

  Algorithm  Pattern: BC: Cipher.VMPC-KSA3 -> org.bouncycastle.jcajce.provider.symmetric.VMPCKSA3$Base

  Algorithm  Pattern: BC: KeyGenerator.VMPC-KSA3 -> org.bouncycastle.jcajce.provider.symmetric.VMPCKSA3$KeyGen

  Algorithm  Pattern: BC: Cipher.XTEA -> org.bouncycastle.jcajce.provider.symmetric.XTEA$ECB

  Algorithm  Pattern: BC: KeyGenerator.XTEA -> org.bouncycastle.jcajce.provider.symmetric.XTEA$KeyGen

  Algorithm  Pattern: BC: AlgorithmParameters.XTEA -> org.bouncycastle.jcajce.provider.symmetric.XTEA$AlgParams

  Algorithm  Pattern: BC: Cipher.XSALSA20 -> org.bouncycastle.jcajce.provider.symmetric.XSalsa20$Base

  Algorithm  Pattern: BC: KeyGenerator.XSALSA20 -> org.bouncycastle.jcajce.provider.symmetric.XSalsa20$KeyGen

  Algorithm  Pattern: BC: SecretKeyFactory.PBKDF-OPENSSL -> org.bouncycastle.jcajce.provider.symmetric.OpenSSLPBKDF$PBKDF

  Algorithm  Pattern: BC: AlgorithmParameters.DSTU7624 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams128

  Algorithm  Pattern: BC: AlgorithmParameters.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.OID.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.OID.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameters.OID.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParams

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.DSTU7624 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen128

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen128

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.OID.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen128

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen256

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.OID.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen256

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen512

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.OID.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$AlgParamGen512

  Algorithm  Pattern: BC: Cipher.DSTU7624 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_128

  Algorithm  Pattern: BC: Cipher.DSTU7624-128 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_128

  Algorithm  Pattern: BC: Cipher.DSTU7624-256 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_256

  Algorithm  Pattern: BC: Cipher.DSTU7624-512 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_512

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.1.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB128

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.1.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB128

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.1.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB256

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.1.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB256

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.1.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB512

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.1.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB512

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC128

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC128

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC256

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC256

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC512

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC512

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.6.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB128

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.6.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB128

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.6.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB256

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.6.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB256

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.6.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB512

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.6.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB512

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.3.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB128

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.3.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB128

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.3.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB256

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.3.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB256

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.3.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB512

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.3.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB512

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.2.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR128

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.2.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR128

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.2.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR256

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.2.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR256

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.2.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR512

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.2.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR512

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.8.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM128

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.8.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM128

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.8.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM256

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.8.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM256

  Algorithm  Pattern: BC: Cipher.1.2.804.2.1.1.1.1.1.3.8.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM512

  Algorithm  Pattern: BC: Cipher.OID.1.2.804.2.1.1.1.1.1.3.8.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM512

  Algorithm  Pattern: BC: Cipher.DSTU7624KW -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap
  aliases: [DSTU7624WRAP]

  Algorithm  Pattern: BC: Cipher.DSTU7624-128KW -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap128
  aliases: [1.2.804.2.1.1.1.1.1.3.10.1, DSTU7624-128WRAP]

  Algorithm  Pattern: BC: Cipher.DSTU7624-256KW -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap256
  aliases: [1.2.804.2.1.1.1.1.1.3.10.2, DSTU7624-256WRAP]

  Algorithm  Pattern: BC: Cipher.DSTU7624-512KW -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap512
  aliases: [1.2.804.2.1.1.1.1.1.3.10.3, DSTU7624-512WRAP]

  Algorithm  Pattern: BC: Mac.DSTU7624GMAC -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC

  Algorithm  Pattern: BC: Mac.DSTU7624-128GMAC -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC128
  aliases: [1.2.804.2.1.1.1.1.1.3.7.1]

  Algorithm  Pattern: BC: Mac.DSTU7624-256GMAC -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC256
  aliases: [1.2.804.2.1.1.1.1.1.3.7.2]

  Algorithm  Pattern: BC: Mac.DSTU7624-512GMAC -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC512
  aliases: [1.2.804.2.1.1.1.1.1.3.7.3]

  Algorithm  Pattern: BC: KeyGenerator.DSTU7624 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.10.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.10.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.10.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.10.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.10.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.10.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.1.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.1.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.1.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.1.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.1.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.1.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.5.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.5.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.5.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.6.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.6.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.6.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.6.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.6.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.6.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.3.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.3.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.3.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.3.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.3.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.3.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.2.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.2.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.2.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.2.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.2.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.2.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.8.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.8.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.8.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.8.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.8.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.8.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.7.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.7.1 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen128

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.7.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.7.2 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen256

  Algorithm  Pattern: BC: KeyGenerator.1.2.804.2.1.1.1.1.1.3.7.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: KeyGenerator.OID.1.2.804.2.1.1.1.1.1.3.7.3 -> org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen512

  Algorithm  Pattern: BC: Cipher.GOST3412-2015 -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$ECB

  Algorithm  Pattern: BC: Cipher.GOST3412-2015/CFB -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$GCFB

  Algorithm  Pattern: BC: Cipher.GOST3412-2015/CFB8 -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$GCFB8

  Algorithm  Pattern: BC: Cipher.GOST3412-2015/OFB -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$OFB

  Algorithm  Pattern: BC: Cipher.GOST3412-2015/CBC -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$CBC

  Algorithm  Pattern: BC: Cipher.GOST3412-2015/CTR -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$CTR

  Algorithm  Pattern: BC: KeyGenerator.GOST3412-2015 -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$KeyGen

  Algorithm  Pattern: BC: Mac.GOST3412MAC -> org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$Mac
  aliases: [GOST3412-2015]

  Algorithm  Pattern: BC: KeyFactory.X.509 -> org.bouncycastle.jcajce.provider.asymmetric.x509.KeyFactory
  aliases: [X509]

  Algorithm  Pattern: BC: CertificateFactory.X.509 -> org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory
  aliases: [X509]

  Algorithm  Pattern: BC: AlgorithmParameters.IES -> org.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi

  Algorithm  Pattern: BC: AlgorithmParameters.ECIES -> org.bouncycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi

  Algorithm  Pattern: BC: AlgorithmParameters.DSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi
  aliases: [1.2.840.10040.4.1, 1.3.14.3.2.27, 1.2.840.10040.4.3]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.DSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi
  aliases: [1.2.840.10040.4.1, 1.3.14.3.2.27, 1.2.840.10040.4.3]

  Algorithm  Pattern: BC: KeyPairGenerator.DSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi
  aliases: [1.2.840.10040.4.1, 1.3.14.3.2.27, 1.2.840.10040.4.3]

  Algorithm  Pattern: BC: KeyFactory.DSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi
  aliases: [1.2.840.10040.4.1, 1.3.14.3.2.27, 1.2.840.10040.4.3]

  Algorithm  Pattern: BC: Signature.DSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA
  aliases: [SHA/DSA, SHA1withDSA, SHA1WITHDSA, 1.3.14.3.2.26with1.2.840.10040.4.1, 1.3.14.3.2.26with1.2.840.10040.4.3, DSAwithSHA1, DSAWITHSHA1, SHA1WithDSA, DSAWithSHA1, 1.2.840.10040.4.1, 1.3.14.3.2.27, 1.2.840.10040.4.3]

  Algorithm  Pattern: BC: Signature.NONEWITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA
  aliases: [RAWDSA]

  Algorithm  Pattern: BC: Signature.DETDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA

  Algorithm  Pattern: BC: Signature.SHA1WITHDETDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA

  Algorithm  Pattern: BC: Signature.SHA224WITHDETDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224

  Algorithm  Pattern: BC: Signature.SHA256WITHDETDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256

  Algorithm  Pattern: BC: Signature.SHA384WITHDETDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384

  Algorithm  Pattern: BC: Signature.SHA512WITHDETDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512

  Algorithm  Pattern: BC: Signature.DDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA

  Algorithm  Pattern: BC: Signature.SHA1WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA

  Algorithm  Pattern: BC: Signature.SHA224WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224

  Algorithm  Pattern: BC: Signature.SHA256WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256

  Algorithm  Pattern: BC: Signature.SHA384WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384

  Algorithm  Pattern: BC: Signature.SHA512WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512

  Algorithm  Pattern: BC: Signature.SHA3-224WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_224

  Algorithm  Pattern: BC: Signature.SHA3-256WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_256

  Algorithm  Pattern: BC: Signature.SHA3-384WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_384

  Algorithm  Pattern: BC: Signature.SHA3-512WITHDDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_512

  Algorithm  Pattern: BC: Signature.SHA224WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224
  aliases: [SHA224withDSA, SHA224WithDSA, SHA224/DSA, 2.16.840.1.101.3.4.3.1, OID.2.16.840.1.101.3.4.3.1]

  Algorithm  Pattern: BC: Signature.SHA256WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256
  aliases: [SHA256withDSA, SHA256WithDSA, SHA256/DSA, 2.16.840.1.101.3.4.3.2, OID.2.16.840.1.101.3.4.3.2]

  Algorithm  Pattern: BC: Signature.SHA384WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384
  aliases: [SHA384withDSA, SHA384WithDSA, SHA384/DSA, 2.16.840.1.101.3.4.3.3, OID.2.16.840.1.101.3.4.3.3]

  Algorithm  Pattern: BC: Signature.SHA512WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512
  aliases: [SHA512withDSA, SHA512WithDSA, SHA512/DSA, 2.16.840.1.101.3.4.3.4, OID.2.16.840.1.101.3.4.3.4]

  Algorithm  Pattern: BC: Signature.SHA3-224WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_224
  aliases: [SHA3-224withDSA, SHA3-224WithDSA, SHA3-224/DSA, 2.16.840.1.101.3.4.3.5, OID.2.16.840.1.101.3.4.3.5]

  Algorithm  Pattern: BC: Signature.SHA3-256WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_256
  aliases: [SHA3-256withDSA, SHA3-256WithDSA, SHA3-256/DSA, 2.16.840.1.101.3.4.3.6, OID.2.16.840.1.101.3.4.3.6]

  Algorithm  Pattern: BC: Signature.SHA3-384WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_384
  aliases: [SHA3-384withDSA, SHA3-384WithDSA, SHA3-384/DSA, 2.16.840.1.101.3.4.3.7, OID.2.16.840.1.101.3.4.3.7]

  Algorithm  Pattern: BC: Signature.SHA3-512WITHDSA -> org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512
  aliases: [SHA3-512withDSA, SHA3-512WithDSA, SHA3-512/DSA, 2.16.840.1.101.3.4.3.8, OID.2.16.840.1.101.3.4.3.8]

  Algorithm  Pattern: BC: KeyPairGenerator.DH -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi
  aliases: [DIFFIEHELLMAN, 1.2.840.113549.1.3.1, 1.2.840.10046.2.1]

  Algorithm  Pattern: BC: KeyAgreement.DH -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi
  aliases: [DIFFIEHELLMAN]
  attributes: {SupportedKeyFormats=PKCS#8|X.509, SupportedKeyClasses=javax.crypto.interfaces.DHPublicKey|javax.crypto.interfaces.DHPrivateKey}

  Algorithm  Pattern: BC: KeyAgreement.1.2.840.113549.1.9.16.3.5 -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF

  Algorithm  Pattern: BC: KeyAgreement.OID.1.2.840.113549.1.9.16.3.5 -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF

  Algorithm  Pattern: BC: KeyAgreement.1.2.840.113549.1.9.16.3.10 -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF

  Algorithm  Pattern: BC: KeyAgreement.OID.1.2.840.113549.1.9.16.3.10 -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF

  Algorithm  Pattern: BC: KeyFactory.DH -> org.bouncycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi
  aliases: [DIFFIEHELLMAN, 1.2.840.113549.1.3.1, 1.2.840.10046.2.1]

  Algorithm  Pattern: BC: AlgorithmParameters.DH -> org.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi
  aliases: [DIFFIEHELLMAN]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.DH -> org.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi
  aliases: [DIFFIEHELLMAN]

  Algorithm  Pattern: BC: Cipher.IES -> org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES

  Algorithm  Pattern: BC: Cipher.IESwithAES-CBC -> org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC

  Algorithm  Pattern: BC: Cipher.IESWITHDESEDE-CBC -> org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC

  Algorithm  Pattern: BC: Cipher.DHIES -> org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES

  Algorithm  Pattern: BC: Cipher.DHIESwithAES-CBC -> org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC

  Algorithm  Pattern: BC: Cipher.DHIESWITHDESEDE-CBC -> org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC

  Algorithm  Pattern: BC: AlgorithmParameters.EC -> org.bouncycastle.jcajce.provider.asymmetric.ec.AlgorithmParametersSpi
  aliases: [1.2.840.10045.2.1, 1.3.133.16.840.63.0.2, 1.3.133.16.840.63.0.3, 1.3.132.1.11.0, 1.3.132.1.14.0, 1.3.132.1.11.1, 1.3.132.1.14.1, 1.3.132.1.11.2, 1.3.132.1.14.2, 1.3.132.1.11.3, 1.3.132.1.14.3, 1.3.133.16.840.63.0.16, 1.3.132.1.15.1, 1.3.132.1.15.0, 1.3.132.1.15.2, 1.3.132.1.15.3]

  Algorithm  Pattern: BC: KeyAgreement.ECDH -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DH
  attributes: {SupportedKeyFormats=PKCS#8|X.509, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: BC: KeyAgreement.ECDHC -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC
  attributes: {SupportedKeyFormats=PKCS#8|X.509, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: BC: KeyAgreement.ECCDH -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHC
  attributes: {SupportedKeyFormats=PKCS#8|X.509, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: BC: KeyAgreement.ECCDHU -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUC
  attributes: {SupportedKeyFormats=PKCS#8|X.509, SupportedKeyClasses=java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey}

  Algorithm  Pattern: BC: KeyAgreement.ECDHWITHSHA1KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA1KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECDHWITHSHA224KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA224KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECDHWITHSHA256KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA256KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECDHWITHSHA384KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA384KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECDHWITHSHA512KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA512KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.133.16.840.63.0.2 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.133.16.840.63.0.3 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.11.0 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.14.0 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.11.1 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.14.1 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.11.2 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.14.2 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.11.3 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.14.3 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA1CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA1CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA256CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA256CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA384CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA384CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHWITHSHA512CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHwithSHA512CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHUWITHSHA1CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA1CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHUWITHSHA224CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA224CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHUWITHSHA256CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA256CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHUWITHSHA384CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA384CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECCDHUWITHSHA512CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$DHUwithSHA512CKDF

  Algorithm  Pattern: BC: KeyFactory.EC -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$EC
  aliases: [1.2.840.10045.2.1, 1.3.133.16.840.63.0.3, 1.3.132.1.11.0, 1.3.132.1.14.0, 1.3.132.1.11.1, 1.3.132.1.14.1, 1.3.132.1.11.2, 1.3.132.1.14.2, 1.3.132.1.11.3, 1.3.132.1.14.3, 1.3.133.16.840.63.0.2]

  Algorithm  Pattern: BC: KeyPairGenerator.EC -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$EC
  aliases: [1.2.840.10045.2.1, 1.3.133.16.840.63.0.3, 1.3.132.1.11.0, 1.3.132.1.14.0, 1.3.132.1.11.1, 1.3.132.1.14.1, 1.3.132.1.11.2, 1.3.132.1.14.2, 1.3.132.1.11.3, 1.3.132.1.14.3, 1.3.133.16.840.63.0.2]

  Algorithm  Pattern: BC: KeyFactory.ECMQV -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECMQV
  aliases: [1.3.133.16.840.63.0.16, 1.3.132.1.15.0, 1.3.132.1.15.1, 1.3.132.1.15.2, 1.3.132.1.15.3]

  Algorithm  Pattern: BC: KeyPairGenerator.ECMQV -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECMQV
  aliases: [1.3.133.16.840.63.0.16, 1.3.132.1.15.0, 1.3.132.1.15.1, 1.3.132.1.15.2, 1.3.132.1.15.3]

  Algorithm  Pattern: BC: KeyAgreement.ECMQV -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQV

  Algorithm  Pattern: BC: KeyAgreement.ECMQVWITHSHA1CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECMQVWITHSHA224CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECMQVWITHSHA256CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECMQVWITHSHA384CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384CKDF

  Algorithm  Pattern: BC: KeyAgreement.ECMQVWITHSHA512CKDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512CKDF

  Algorithm  Pattern: BC: KeyAgreement.1.3.133.16.840.63.0.16 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA1KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.15.0 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA224KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.15.1 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.15.2 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyAgreement.1.3.132.1.15.3 -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo

  Algorithm  Pattern: BC: KeyFactory.ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDSA

  Algorithm  Pattern: BC: KeyFactory.ECDH -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDH

  Algorithm  Pattern: BC: KeyFactory.ECDHC -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi$ECDHC

  Algorithm  Pattern: BC: KeyPairGenerator.ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDSA

  Algorithm  Pattern: BC: KeyPairGenerator.ECDH -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH

  Algorithm  Pattern: BC: KeyPairGenerator.ECDHWITHSHA1KDF -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH

  Algorithm  Pattern: BC: KeyPairGenerator.ECDHC -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDHC

  Algorithm  Pattern: BC: KeyPairGenerator.ECIES -> org.bouncycastle.jcajce.provider.asymmetric.ec.KeyPairGeneratorSpi$ECDH

  Algorithm  Pattern: BC: Cipher.ECIES -> org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIES

  Algorithm  Pattern: BC: Cipher.ECIESwithAES-CBC -> org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithAESCBC

  Algorithm  Pattern: BC: Cipher.ECIESwithDESEDE-CBC -> org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher$ECIESwithDESedeCBC

  Algorithm  Pattern: BC: Signature.ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA
  aliases: [SHA1withECDSA, ECDSAwithSHA1, SHA1WITHECDSA, ECDSAWITHSHA1, SHA1WithECDSA, ECDSAWithSHA1, 1.2.840.10045.4.1, 1.3.36.3.3.2.1]

  Algorithm  Pattern: BC: Signature.NONEwithECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone

  Algorithm  Pattern: BC: Signature.ECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA
  aliases: [DETECDSA]

  Algorithm  Pattern: BC: Signature.SHA1WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA
  aliases: [SHA1WITHDETECDSA]

  Algorithm  Pattern: BC: Signature.SHA224WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA224
  aliases: [SHA224WITHDETECDSA]

  Algorithm  Pattern: BC: Signature.SHA256WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA256
  aliases: [SHA256WITHDETECDSA]

  Algorithm  Pattern: BC: Signature.SHA384WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA384
  aliases: [SHA384WITHDETECDSA]

  Algorithm  Pattern: BC: Signature.SHA512WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA512
  aliases: [SHA512WITHDETECDSA]

  Algorithm  Pattern: BC: Signature.SHA3-224WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_224

  Algorithm  Pattern: BC: Signature.SHA3-256WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_256

  Algorithm  Pattern: BC: Signature.SHA3-384WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_384

  Algorithm  Pattern: BC: Signature.SHA3-512WITHECDDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_512

  Algorithm  Pattern: BC: Signature.SHA224WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224
  aliases: [SHA224withECDSA, SHA224WithECDSA, SHA224/ECDSA, 1.2.840.10045.4.3.1, OID.1.2.840.10045.4.3.1]

  Algorithm  Pattern: BC: Signature.SHA256WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256
  aliases: [SHA256withECDSA, SHA256WithECDSA, SHA256/ECDSA, 1.2.840.10045.4.3.2, OID.1.2.840.10045.4.3.2]

  Algorithm  Pattern: BC: Signature.SHA384WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384
  aliases: [SHA384withECDSA, SHA384WithECDSA, SHA384/ECDSA, 1.2.840.10045.4.3.3, OID.1.2.840.10045.4.3.3]

  Algorithm  Pattern: BC: Signature.SHA512WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512
  aliases: [SHA512withECDSA, SHA512WithECDSA, SHA512/ECDSA, 1.2.840.10045.4.3.4, OID.1.2.840.10045.4.3.4]

  Algorithm  Pattern: BC: Signature.SHA3-224WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_224
  aliases: [SHA3-224withECDSA, SHA3-224WithECDSA, SHA3-224/ECDSA, 2.16.840.1.101.3.4.3.9, OID.2.16.840.1.101.3.4.3.9]

  Algorithm  Pattern: BC: Signature.SHA3-256WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_256
  aliases: [SHA3-256withECDSA, SHA3-256WithECDSA, SHA3-256/ECDSA, 2.16.840.1.101.3.4.3.10, OID.2.16.840.1.101.3.4.3.10]

  Algorithm  Pattern: BC: Signature.SHA3-384WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_384
  aliases: [SHA3-384withECDSA, SHA3-384WithECDSA, SHA3-384/ECDSA, 2.16.840.1.101.3.4.3.11, OID.2.16.840.1.101.3.4.3.11]

  Algorithm  Pattern: BC: Signature.SHA3-512WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_512
  aliases: [SHA3-512withECDSA, SHA3-512WithECDSA, SHA3-512/ECDSA, 2.16.840.1.101.3.4.3.12, OID.2.16.840.1.101.3.4.3.12]

  Algorithm  Pattern: BC: Signature.RIPEMD160WITHECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160
  aliases: [RIPEMD160withECDSA, RIPEMD160WithECDSA, RIPEMD160/ECDSA, 1.3.36.3.3.2.2, OID.1.3.36.3.3.2.2]

  Algorithm  Pattern: BC: Signature.SHA1WITHECNR -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR

  Algorithm  Pattern: BC: Signature.SHA224WITHECNR -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224

  Algorithm  Pattern: BC: Signature.SHA256WITHECNR -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256

  Algorithm  Pattern: BC: Signature.SHA384WITHECNR -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384

  Algorithm  Pattern: BC: Signature.SHA512WITHECNR -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512

  Algorithm  Pattern: BC: Signature.SHA1WITHCVC-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA
  aliases: [SHA1withCVC-ECDSA, SHA1WithCVC-ECDSA, SHA1/CVC-ECDSA, 0.4.0.127.0.7.2.2.2.2.1, OID.0.4.0.127.0.7.2.2.2.2.1]

  Algorithm  Pattern: BC: Signature.SHA224WITHCVC-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224
  aliases: [SHA224withCVC-ECDSA, SHA224WithCVC-ECDSA, SHA224/CVC-ECDSA, 0.4.0.127.0.7.2.2.2.2.2, OID.0.4.0.127.0.7.2.2.2.2.2]

  Algorithm  Pattern: BC: Signature.SHA256WITHCVC-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256
  aliases: [SHA256withCVC-ECDSA, SHA256WithCVC-ECDSA, SHA256/CVC-ECDSA, 0.4.0.127.0.7.2.2.2.2.3, OID.0.4.0.127.0.7.2.2.2.2.3]

  Algorithm  Pattern: BC: Signature.SHA384WITHCVC-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384
  aliases: [SHA384withCVC-ECDSA, SHA384WithCVC-ECDSA, SHA384/CVC-ECDSA, 0.4.0.127.0.7.2.2.2.2.4, OID.0.4.0.127.0.7.2.2.2.2.4]

  Algorithm  Pattern: BC: Signature.SHA512WITHCVC-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512
  aliases: [SHA512withCVC-ECDSA, SHA512WithCVC-ECDSA, SHA512/CVC-ECDSA, 0.4.0.127.0.7.2.2.2.2.5, OID.0.4.0.127.0.7.2.2.2.2.5]

  Algorithm  Pattern: BC: Signature.SHA1WITHPLAIN-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA
  aliases: [SHA1withPLAIN-ECDSA, SHA1WithPLAIN-ECDSA, SHA1/PLAIN-ECDSA, 0.4.0.127.0.7.1.1.4.1.1, OID.0.4.0.127.0.7.1.1.4.1.1]

  Algorithm  Pattern: BC: Signature.SHA224WITHPLAIN-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224
  aliases: [SHA224withPLAIN-ECDSA, SHA224WithPLAIN-ECDSA, SHA224/PLAIN-ECDSA, 0.4.0.127.0.7.1.1.4.1.2, OID.0.4.0.127.0.7.1.1.4.1.2]

  Algorithm  Pattern: BC: Signature.SHA256WITHPLAIN-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256
  aliases: [SHA256withPLAIN-ECDSA, SHA256WithPLAIN-ECDSA, SHA256/PLAIN-ECDSA, 0.4.0.127.0.7.1.1.4.1.3, OID.0.4.0.127.0.7.1.1.4.1.3]

  Algorithm  Pattern: BC: Signature.SHA384WITHPLAIN-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384
  aliases: [SHA384withPLAIN-ECDSA, SHA384WithPLAIN-ECDSA, SHA384/PLAIN-ECDSA, 0.4.0.127.0.7.1.1.4.1.4, OID.0.4.0.127.0.7.1.1.4.1.4]

  Algorithm  Pattern: BC: Signature.SHA512WITHPLAIN-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512
  aliases: [SHA512withPLAIN-ECDSA, SHA512WithPLAIN-ECDSA, SHA512/PLAIN-ECDSA, 0.4.0.127.0.7.1.1.4.1.5, OID.0.4.0.127.0.7.1.1.4.1.5]

  Algorithm  Pattern: BC: Signature.RIPEMD160WITHPLAIN-ECDSA -> org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecPlainDSARP160
  aliases: [RIPEMD160withPLAIN-ECDSA, RIPEMD160WithPLAIN-ECDSA, RIPEMD160/PLAIN-ECDSA, 0.4.0.127.0.7.1.1.4.1.6, OID.0.4.0.127.0.7.1.1.4.1.6]

  Algorithm  Pattern: BC: AlgorithmParameters.OAEP -> org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP
  aliases: [1.2.840.113549.1.1.7]

  Algorithm  Pattern: BC: AlgorithmParameters.PSS -> org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS
  aliases: [RSAPSS, RSASSA-PSS, SHA224withRSA/PSS, SHA256withRSA/PSS, SHA384withRSA/PSS, SHA512withRSA/PSS, SHA224WITHRSAANDMGF1, SHA256WITHRSAANDMGF1, SHA384WITHRSAANDMGF1, SHA512WITHRSAANDMGF1, SHA3-224WITHRSAANDMGF1, SHA3-256WITHRSAANDMGF1, SHA3-384WITHRSAANDMGF1, SHA3-512WITHRSAANDMGF1, RAWRSAPSS, NONEWITHRSAPSS, NONEWITHRSASSA-PSS, NONEWITHRSAANDMGF1, 1.2.840.113549.1.1.10, SHA1withRSA/PSS, SHA1WITHRSAANDMGF1]

  Algorithm  Pattern: BC: Cipher.RSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding
  aliases: [RSA//RAW, RSA//NOPADDING]
  attributes: {SupportedKeyFormats=PKCS#8|X.509, SupportedKeyClasses=javax.crypto.interfaces.RSAPublicKey|javax.crypto.interfaces.RSAPrivateKey}

  Algorithm  Pattern: BC: Cipher.RSA/RAW -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding

  Algorithm  Pattern: BC: Cipher.RSA/PKCS1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding
  aliases: [RSA//PKCS1PADDING]

  Algorithm  Pattern: BC: Cipher.1.2.840.113549.1.1.1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding

  Algorithm  Pattern: BC: Cipher.OID.1.2.840.113549.1.1.1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding

  Algorithm  Pattern: BC: Cipher.2.5.8.1.1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding

  Algorithm  Pattern: BC: Cipher.OID.2.5.8.1.1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding

  Algorithm  Pattern: BC: Cipher.RSA/1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly

  Algorithm  Pattern: BC: Cipher.RSA/2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly

  Algorithm  Pattern: BC: Cipher.RSA/OAEP -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding
  aliases: [RSA//OAEPPADDING]

  Algorithm  Pattern: BC: Cipher.1.2.840.113549.1.1.7 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding

  Algorithm  Pattern: BC: Cipher.OID.1.2.840.113549.1.1.7 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding

  Algorithm  Pattern: BC: Cipher.RSA/ISO9796-1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding
  aliases: [RSA//ISO9796-1PADDING]

  Algorithm  Pattern: BC: KeyFactory.RSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi
  aliases: [1.2.840.113549.1.1.1, 2.5.8.1.1, 1.2.840.113549.1.1.7, 1.2.840.113549.1.1.10]

  Algorithm  Pattern: BC: KeyPairGenerator.RSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi
  aliases: [1.2.840.113549.1.1.1, 2.5.8.1.1, 1.2.840.113549.1.1.7, 1.2.840.113549.1.1.10]

  Algorithm  Pattern: BC: Signature.RSASSA-PSS -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA
  aliases: [RSAPSS]

  Algorithm  Pattern: BC: Signature.1.2.840.113549.1.1.10 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA

  Algorithm  Pattern: BC: Signature.OID.1.2.840.113549.1.1.10 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA

  Algorithm  Pattern: BC: Signature.RSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA
  aliases: [RAWRSA, NONEWITHRSA]

  Algorithm  Pattern: BC: Signature.RAWRSASSA-PSS -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS
  aliases: [RAWRSAPSS, NONEWITHRSAPSS, NONEWITHRSASSA-PSS, NONEWITHRSAANDMGF1]

  Algorithm  Pattern: BC: Signature.SHA224WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA
  aliases: [SHA224withRSA/PSS, SHA224WithRSA/PSS, SHA224withRSAandMGF1, SHA224WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA256WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA
  aliases: [SHA256withRSA/PSS, SHA256WithRSA/PSS, SHA256withRSAandMGF1, SHA256WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA384WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA
  aliases: [SHA384withRSA/PSS, SHA384WithRSA/PSS, SHA384withRSAandMGF1, SHA384WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA512WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA
  aliases: [SHA512withRSA/PSS, SHA512WithRSA/PSS, SHA512withRSAandMGF1, SHA512WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA512(224)WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA
  aliases: [SHA512(224)withRSA/PSS, SHA512(224)WithRSA/PSS, SHA512(224)withRSAandMGF1, SHA512(224)WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA512(256)WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA
  aliases: [SHA512(256)withRSA/PSS, SHA512(256)WithRSA/PSS, SHA512(256)withRSAandMGF1, SHA512(256)WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA3-224WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSA
  aliases: [SHA3-224withRSA/PSS, SHA3-224WithRSA/PSS, SHA3-224withRSAandMGF1, SHA3-224WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA3-256WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSA
  aliases: [SHA3-256withRSA/PSS, SHA3-256WithRSA/PSS, SHA3-256withRSAandMGF1, SHA3-256WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA3-384WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSA
  aliases: [SHA3-384withRSA/PSS, SHA3-384WithRSA/PSS, SHA3-384withRSAandMGF1, SHA3-384WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA3-512WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSA
  aliases: [SHA3-512withRSA/PSS, SHA3-512WithRSA/PSS, SHA3-512withRSAandMGF1, SHA3-512WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.MD2WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2
  aliases: [MD2withRSA, MD2WithRSA, MD2WITHRSAENCRYPTION, MD2withRSAEncryption, MD2WithRSAEncryption, MD2/RSA, 1.2.840.113549.1.1.2, OID.1.2.840.113549.1.1.2]

  Algorithm  Pattern: BC: Signature.MD4WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4
  aliases: [MD4withRSA, MD4WithRSA, MD4WITHRSAENCRYPTION, MD4withRSAEncryption, MD4WithRSAEncryption, MD4/RSA, 1.2.840.113549.1.1.3, OID.1.2.840.113549.1.1.3]

  Algorithm  Pattern: BC: Signature.MD5WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5
  aliases: [MD5withRSA, MD5WithRSA, MD5WITHRSAENCRYPTION, MD5withRSAEncryption, MD5WithRSAEncryption, MD5/RSA, 1.2.840.113549.1.1.4, OID.1.2.840.113549.1.1.4]

  Algorithm  Pattern: BC: Signature.MD5WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption
  aliases: [MD5withRSA/ISO9796-2, MD5WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA1WITHRSAANDMGF1 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA
  aliases: [SHA1withRSA/PSS, SHA1WithRSA/PSS, SHA1withRSAandMGF1, SHA1WithRSAAndMGF1]

  Algorithm  Pattern: BC: Signature.SHA1WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1
  aliases: [SHA1withRSA, SHA1WithRSA, SHA1WITHRSAENCRYPTION, SHA1withRSAEncryption, SHA1WithRSAEncryption, SHA1/RSA, 1.2.840.113549.1.1.5, OID.1.2.840.113549.1.1.5, 1.3.14.3.2.29, OID.1.3.14.3.2.29]

  Algorithm  Pattern: BC: Signature.SHA1WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption
  aliases: [SHA1withRSA/ISO9796-2, SHA1WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA1WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption
  aliases: [SHA1withRSA/X9.31, SHA1WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.SHA224WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224
  aliases: [SHA224withRSA, SHA224WithRSA, SHA224WITHRSAENCRYPTION, SHA224withRSAEncryption, SHA224WithRSAEncryption, SHA224/RSA, 1.2.840.113549.1.1.14, OID.1.2.840.113549.1.1.14]

  Algorithm  Pattern: BC: Signature.SHA256WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256
  aliases: [SHA256withRSA, SHA256WithRSA, SHA256WITHRSAENCRYPTION, SHA256withRSAEncryption, SHA256WithRSAEncryption, SHA256/RSA, 1.2.840.113549.1.1.11, OID.1.2.840.113549.1.1.11]

  Algorithm  Pattern: BC: Signature.SHA384WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384
  aliases: [SHA384withRSA, SHA384WithRSA, SHA384WITHRSAENCRYPTION, SHA384withRSAEncryption, SHA384WithRSAEncryption, SHA384/RSA, 1.2.840.113549.1.1.12, OID.1.2.840.113549.1.1.12]

  Algorithm  Pattern: BC: Signature.SHA512WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512
  aliases: [SHA512withRSA, SHA512WithRSA, SHA512WITHRSAENCRYPTION, SHA512withRSAEncryption, SHA512WithRSAEncryption, SHA512/RSA, 1.2.840.113549.1.1.13, OID.1.2.840.113549.1.1.13]

  Algorithm  Pattern: BC: Signature.SHA512(224)WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224
  aliases: [SHA512(224)withRSA, SHA512(224)WithRSA, SHA512(224)WITHRSAENCRYPTION, SHA512(224)withRSAEncryption, SHA512(224)WithRSAEncryption, SHA512(224)/RSA, 1.2.840.113549.1.1.15, OID.1.2.840.113549.1.1.15]

  Algorithm  Pattern: BC: Signature.SHA512(256)WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256
  aliases: [SHA512(256)withRSA, SHA512(256)WithRSA, SHA512(256)WITHRSAENCRYPTION, SHA512(256)withRSAEncryption, SHA512(256)WithRSAEncryption, SHA512(256)/RSA, 1.2.840.113549.1.1.16, OID.1.2.840.113549.1.1.16]

  Algorithm  Pattern: BC: Signature.SHA3-224WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_224
  aliases: [SHA3-224withRSA, SHA3-224WithRSA, SHA3-224WITHRSAENCRYPTION, SHA3-224withRSAEncryption, SHA3-224WithRSAEncryption, SHA3-224/RSA, 2.16.840.1.101.3.4.3.13, OID.2.16.840.1.101.3.4.3.13]

  Algorithm  Pattern: BC: Signature.SHA3-256WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_256
  aliases: [SHA3-256withRSA, SHA3-256WithRSA, SHA3-256WITHRSAENCRYPTION, SHA3-256withRSAEncryption, SHA3-256WithRSAEncryption, SHA3-256/RSA, 2.16.840.1.101.3.4.3.14, OID.2.16.840.1.101.3.4.3.14]

  Algorithm  Pattern: BC: Signature.SHA3-384WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384
  aliases: [SHA3-384withRSA, SHA3-384WithRSA, SHA3-384WITHRSAENCRYPTION, SHA3-384withRSAEncryption, SHA3-384WithRSAEncryption, SHA3-384/RSA, 2.16.840.1.101.3.4.3.15, OID.2.16.840.1.101.3.4.3.15]

  Algorithm  Pattern: BC: Signature.SHA3-512WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_512
  aliases: [SHA3-512withRSA, SHA3-512WithRSA, SHA3-512WITHRSAENCRYPTION, SHA3-512withRSAEncryption, SHA3-512WithRSAEncryption, SHA3-512/RSA, 2.16.840.1.101.3.4.3.16, OID.2.16.840.1.101.3.4.3.16]

  Algorithm  Pattern: BC: Signature.SHA224WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption
  aliases: [SHA224withRSA/ISO9796-2, SHA224WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA256WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption
  aliases: [SHA256withRSA/ISO9796-2, SHA256WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA384WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption
  aliases: [SHA384withRSA/ISO9796-2, SHA384WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA512WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption
  aliases: [SHA512withRSA/ISO9796-2, SHA512WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA512(224)WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption
  aliases: [SHA512(224)withRSA/ISO9796-2, SHA512(224)WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA512(256)WITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption
  aliases: [SHA512(256)withRSA/ISO9796-2, SHA512(256)WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.SHA224WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption
  aliases: [SHA224withRSA/X9.31, SHA224WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.SHA256WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption
  aliases: [SHA256withRSA/X9.31, SHA256WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.SHA384WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption
  aliases: [SHA384withRSA/X9.31, SHA384WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.SHA512WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption
  aliases: [SHA512withRSA/X9.31, SHA512WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.SHA512(224)WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption
  aliases: [SHA512(224)withRSA/X9.31, SHA512(224)WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.SHA512(256)WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption
  aliases: [SHA512(256)withRSA/X9.31, SHA512(256)WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.RIPEMD128WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128
  aliases: [RIPEMD128withRSA, RIPEMD128WithRSA, RIPEMD128WITHRSAENCRYPTION, RIPEMD128withRSAEncryption, RIPEMD128WithRSAEncryption, RIPEMD128/RSA, 1.3.36.3.3.1.3, OID.1.3.36.3.3.1.3]

  Algorithm  Pattern: BC: Signature.RMD128WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128
  aliases: [RMD128withRSA, RMD128WithRSA, RMD128WITHRSAENCRYPTION, RMD128withRSAEncryption, RMD128WithRSAEncryption, RMD128/RSA]

  Algorithm  Pattern: BC: Signature.RMD128WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption
  aliases: [RMD128withRSA/X9.31, RMD128WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.RIPEMD128WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption
  aliases: [RIPEMD128withRSA/X9.31, RIPEMD128WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.RIPEMD160WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160
  aliases: [RIPEMD160withRSA, RIPEMD160WithRSA, RIPEMD160WITHRSAENCRYPTION, RIPEMD160withRSAEncryption, RIPEMD160WithRSAEncryption, RIPEMD160/RSA, 1.3.36.3.3.1.2, OID.1.3.36.3.3.1.2]

  Algorithm  Pattern: BC: Signature.RMD160WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160
  aliases: [RMD160withRSA, RMD160WithRSA, RMD160WITHRSAENCRYPTION, RMD160withRSAEncryption, RMD160WithRSAEncryption, RMD160/RSA]

  Algorithm  Pattern: BC: Signature.RIPEMD160withRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption
  aliases: [RIPEMD160WithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.RMD160WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption
  aliases: [RMD160withRSA/X9.31, RMD160WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.RIPEMD160WITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption
  aliases: [RIPEMD160withRSA/X9.31, RIPEMD160WithRSA/X9.31]

  Algorithm  Pattern: BC: Signature.RIPEMD256WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256
  aliases: [RIPEMD256withRSA, RIPEMD256WithRSA, RIPEMD256WITHRSAENCRYPTION, RIPEMD256withRSAEncryption, RIPEMD256WithRSAEncryption, RIPEMD256/RSA, 1.3.36.3.3.1.4, OID.1.3.36.3.3.1.4]

  Algorithm  Pattern: BC: Signature.RMD256WITHRSA -> org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256
  aliases: [RMD256withRSA, RMD256WithRSA, RMD256WITHRSAENCRYPTION, RMD256withRSAEncryption, RMD256WithRSAEncryption, RMD256/RSA]

  Algorithm  Pattern: BC: Signature.WhirlpoolWITHRSA/ISO9796-2 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption
  aliases: [WhirlpoolwithRSA/ISO9796-2, WhirlpoolWithRSA/ISO9796-2, WHIRLPOOLwithRSA/ISO9796-2, WHIRLPOOLWithRSA/ISO9796-2]

  Algorithm  Pattern: BC: Signature.WhirlpoolWITHRSA/X9.31 -> org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption
  aliases: [WhirlpoolwithRSA/X9.31, WhirlpoolWithRSA/X9.31, WHIRLPOOLwithRSA/X9.31, WHIRLPOOLWithRSA/X9.31]

  Algorithm  Pattern: BC: KeyPairGenerator.GOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi
  aliases: [GOST-3410, GOST-3410-94, 1.2.643.2.2.20]

  Algorithm  Pattern: BC: KeyFactory.GOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi
  aliases: [GOST-3410, GOST-3410-94, 1.2.643.2.2.20]

  Algorithm  Pattern: BC: AlgorithmParameters.GOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi
  aliases: [1.2.643.2.2.20, GOST-3410]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.GOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi
  aliases: [1.2.643.2.2.20, GOST-3410]

  Algorithm  Pattern: BC: Signature.GOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.gost.SignatureSpi
  aliases: [GOST-3410, GOST-3410-94, GOST3411withGOST3410, GOST3411WITHGOST3410, GOST3411WithGOST3410, 1.2.643.2.2.4]

  Algorithm  Pattern: BC: KeyFactory.ECGOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi
  aliases: [GOST-3410-2001, ECGOST-3410, 1.2.643.2.2.19, 1.2.643.2.2.98]

  Algorithm  Pattern: BC: KeyPairGenerator.ECGOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi
  aliases: [1.2.643.2.2.19, 1.2.643.2.2.98, ECGOST-3410, GOST-3410-2001]

  Algorithm  Pattern: BC: AlgorithmParameters.ECGOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost.AlgorithmParametersSpi
  aliases: [1.2.643.2.2.19, GOST-3410-2001]

  Algorithm  Pattern: BC: Signature.ECGOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi
  aliases: [ECGOST-3410, GOST-3410-2001]

  Algorithm  Pattern: BC: KeyAgreement.ECGOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi$ECVKO
  aliases: [1.2.643.2.2.19, GOST-3410-2001, 1.2.643.2.2.96]

  Algorithm  Pattern: BC: Signature.GOST3411WITHECGOST3410 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi
  aliases: [GOST3411withECGOST3410, GOST3411WithECGOST3410, GOST3411/ECGOST3410, 1.2.643.2.2.3, OID.1.2.643.2.2.3]

  Algorithm  Pattern: BC: KeyFactory.ECGOST3410-2012 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi
  aliases: [GOST-3410-2012, ECGOST-3410-2012, 1.2.643.7.1.1.1.1, 1.2.643.7.1.1.6.1, 1.2.643.7.1.1.1.2, 1.2.643.7.1.1.6.2]

  Algorithm  Pattern: BC: KeyPairGenerator.ECGOST3410-2012 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyPairGeneratorSpi
  aliases: [1.2.643.7.1.1.1.1, 1.2.643.7.1.1.6.1, 1.2.643.7.1.1.1.2, 1.2.643.7.1.1.6.2, ECGOST3410-2012, GOST-3410-2012]

  Algorithm  Pattern: BC: Signature.ECGOST3410-2012-256 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256
  aliases: [ECGOST3410-2012-256, GOST-3410-2012-256]

  Algorithm  Pattern: BC: Signature.GOST3411-2012-256WITHECGOST3410-2012-256 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256
  aliases: [GOST3411-2012-256withECGOST3410-2012-256, GOST3411-2012-256WithECGOST3410-2012-256, GOST3411-2012-256/ECGOST3410-2012-256, 1.2.643.7.1.1.3.2, OID.1.2.643.7.1.1.3.2]

  Algorithm  Pattern: BC: Signature.ECGOST3410-2012-512 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512
  aliases: [ECGOST3410-2012-512, GOST-3410-2012-512]

  Algorithm  Pattern: BC: Signature.GOST3411-2012-512WITHECGOST3410-2012-512 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512
  aliases: [GOST3411-2012-512withECGOST3410-2012-512, GOST3411-2012-512WithECGOST3410-2012-512, GOST3411-2012-512/ECGOST3410-2012-512, 1.2.643.7.1.1.3.3, OID.1.2.643.7.1.1.3.3]

  Algorithm  Pattern: BC: KeyAgreement.ECGOST3410-2012-256 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO256
  aliases: [1.2.643.7.1.1.6.1, 1.2.643.7.1.1.1.1]

  Algorithm  Pattern: BC: KeyAgreement.ECGOST3410-2012-512 -> org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO512
  aliases: [1.2.643.7.1.1.6.2, 1.2.643.7.1.1.1.2]

  Algorithm  Pattern: BC: AlgorithmParameterGenerator.ELGAMAL -> org.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi
  aliases: [1.3.14.7.2.1.1]

  Algorithm  Pattern: BC: AlgorithmParameters.ELGAMAL -> org.bouncycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi
  aliases: [1.3.14.7.2.1.1]

  Algorithm  Pattern: BC: Cipher.ELGAMAL -> org.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding
  aliases: [ELGAMAL/NONE/NOPADDING]

  Algorithm  Pattern: BC: Cipher.ELGAMAL/PKCS1 -> org.bouncycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$PKCS1v1_5Padding
  aliases: [ELGAMAL/ECB/PKCS1PADDING, ELGAMAL/NONE/PKCS1PADDING]

  Algorithm  Pattern: BC: KeyFactory.ELGAMAL -> org.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi
  aliases: [1.3.14.7.2.1.1]

  Algorithm  Pattern: BC: KeyPairGenerator.ELGAMAL -> org.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi
  aliases: [1.3.14.7.2.1.1]

  Algorithm  Pattern: BC: KeyFactory.DSTU4145 -> org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi
  aliases: [DSTU-4145-2002, DSTU4145-3410, 1.2.804.2.1.1.1.1.3.1.1, 1.2.804.2.1.1.1.1.3.1.1.1.1]

  Algorithm  Pattern: BC: KeyPairGenerator.DSTU4145 -> org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi
  aliases: [1.2.804.2.1.1.1.1.3.1.1, 1.2.804.2.1.1.1.1.3.1.1.1.1, DSTU-4145, DSTU-4145-2002]

  Algorithm  Pattern: BC: Signature.DSTU4145 -> org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi
  aliases: [DSTU-4145, DSTU-4145-2002]

  Algorithm  Pattern: BC: Signature.GOST3411WITHDSTU4145LE -> org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe
  aliases: [GOST3411withDSTU4145LE, GOST3411WithDSTU4145LE, GOST3411/DSTU4145LE, 1.2.804.2.1.1.1.1.3.1.1, OID.1.2.804.2.1.1.1.1.3.1.1]

  Algorithm  Pattern: BC: Signature.GOST3411WITHDSTU4145 -> org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi
  aliases: [GOST3411withDSTU4145, GOST3411WithDSTU4145, GOST3411/DSTU4145, 1.2.804.2.1.1.1.1.3.1.1.1.1, OID.1.2.804.2.1.1.1.1.3.1.1.1.1]

  Algorithm  Pattern: BC: Signature.SM3WITHSM2 -> org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sm3WithSM2
  aliases: [1.2.156.10197.1.501]

  Algorithm  Pattern: BC: KeyStore.BKS -> org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Std

  Algorithm  Pattern: BC: KeyStore.BKS-V1 -> org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Version1

  Algorithm  Pattern: BC: KeyStore.BouncyCastle -> org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$BouncyCastleStore
  aliases: [UBER, BOUNCYCASTLE, bouncycastle]

  Algorithm  Pattern: BC: KeyStore.BCFKS -> org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Std

  Algorithm  Pattern: BC: KeyStore.BCFKS-DEF -> org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Def

  Algorithm  Pattern: BC: KeyStore.PKCS12 -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore

  Algorithm  Pattern: BC: KeyStore.BCPKCS12 -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore

  Algorithm  Pattern: BC: KeyStore.PKCS12-DEF -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore

  Algorithm  Pattern: BC: KeyStore.PKCS12-3DES-40RC2 -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore

  Algorithm  Pattern: BC: KeyStore.PKCS12-3DES-3DES -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore3DES

  Algorithm  Pattern: BC: KeyStore.PKCS12-DEF-3DES-40RC2 -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore

  Algorithm  Pattern: BC: KeyStore.PKCS12-DEF-3DES-3DES -> org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore3DES

  Algorithm  Pattern: BC: SecureRandom.DEFAULT -> org.bouncycastle.jcajce.provider.drbg.DRBG$Default

  Algorithm  Pattern: BC: SecureRandom.NONCEANDIV -> org.bouncycastle.jcajce.provider.drbg.DRBG$NonceAndIV

  Algorithm  Pattern: BC: X509Store.CERTIFICATE/COLLECTION -> org.bouncycastle.jce.provider.X509StoreCertCollection

  Algorithm  Pattern: BC: X509Store.ATTRIBUTECERTIFICATE/COLLECTION -> org.bouncycastle.jce.provider.X509StoreAttrCertCollection

  Algorithm  Pattern: BC: X509Store.CRL/COLLECTION -> org.bouncycastle.jce.provider.X509StoreCRLCollection

  Algorithm  Pattern: BC: X509Store.CERTIFICATEPAIR/COLLECTION -> org.bouncycastle.jce.provider.X509StoreCertPairCollection

  Algorithm  Pattern: BC: X509Store.CERTIFICATE/LDAP -> org.bouncycastle.jce.provider.X509StoreLDAPCerts

  Algorithm  Pattern: BC: X509Store.CRL/LDAP -> org.bouncycastle.jce.provider.X509StoreLDAPCRLs

  Algorithm  Pattern: BC: X509Store.ATTRIBUTECERTIFICATE/LDAP -> org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts

  Algorithm  Pattern: BC: X509Store.CERTIFICATEPAIR/LDAP -> org.bouncycastle.jce.provider.X509StoreLDAPCertPairs

  Algorithm  Pattern: BC: X509StreamParser.CERTIFICATE -> org.bouncycastle.jce.provider.X509CertParser

  Algorithm  Pattern: BC: X509StreamParser.ATTRIBUTECERTIFICATE -> org.bouncycastle.jce.provider.X509AttrCertParser

  Algorithm  Pattern: BC: X509StreamParser.CRL -> org.bouncycastle.jce.provider.X509CRLParser

  Algorithm  Pattern: BC: X509StreamParser.CERTIFICATEPAIR -> org.bouncycastle.jce.provider.X509CertPairParser

  Algorithm  Pattern: BC: Cipher.BROKENPBEWITHMD5ANDDES -> org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES

  Algorithm  Pattern: BC: Cipher.BROKENPBEWITHSHA1ANDDES -> org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES

  Algorithm  Pattern: BC: Cipher.OLDPBEWITHSHAANDTWOFISH-CBC -> org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish

  Algorithm  Pattern: BC: CertPathValidator.RFC3281 -> org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi

  Algorithm  Pattern: BC: CertPathBuilder.RFC3281 -> org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi

  Algorithm  Pattern: BC: CertPathValidator.RFC3280 -> org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi

  Algorithm  Pattern: BC: CertPathBuilder.RFC3280 -> org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi

  Algorithm  Pattern: BC: CertPathValidator.PKIX -> org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi

  Algorithm  Pattern: BC: CertPathBuilder.PKIX -> org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi

  Algorithm  Pattern: BC: CertStore.Collection -> org.bouncycastle.jce.provider.CertStoreCollectionSpi

  Algorithm  Pattern: BC: CertStore.LDAP -> org.bouncycastle.jce.provider.X509LDAPCertStoreSpi
  aliases: [X509LDAP]

  Algorithm  Pattern: BC: CertStore.Multi -> org.bouncycastle.jce.provider.MultiCertStoreSpi




===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================


Process finished with exit code 0

```