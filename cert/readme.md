## Key生成流程
OPENSSL 与 keytool
### 生成  test1.key 文件
```
PS C:\Users\Administrator\Desktop> openssl genrsa -des3 -out test1.key 2048
Generating RSA private key, 2048 bit long modulus
...................................+++
.+++
e is 65537 (0x10001)
Enter pass phrase for CA.key:
Verifying - Enter pass phrase for CA.key:
```
### 解析 test1.key 文件
```
openssl rsa -noout -text -in CA.key
```
使用cer 与 key 文件 转 pkcs(p12) 文件
```
openssl pkcs12 -export -clcerts -in .\DEVICE.cer -inkey .\DEVICE.key -out DEVICE.p12
```
pkcs(p12) 转 jks 文件
```
keytool -importkeystore -srckeystore DEVICE.p12 -destkeystore DEVICE.jks -srcstoretype pkcs12 -deststoretype jks
```
解析 jks 文件
```
keytool -list -v -keystore DEVICE.jks
```