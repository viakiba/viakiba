```
其中消息签名部分不完全搜索，有这些：
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



  // ===============================  BC 扩展实现的一部分  =====================



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

```
