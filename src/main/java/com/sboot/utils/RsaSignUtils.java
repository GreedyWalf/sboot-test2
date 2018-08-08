package com.sboot.utils;

import org.apache.shiro.codec.Base64;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 测试：使用RSA加密算法获的公钥、私钥；使用SHA1WithRSA签名算法，使用私钥给待签名数据进行签名，使用公钥验证签名；
 */
public class RsaSignUtils {

    //加密算法
    private static String KEY_ALGORITHM = "RSA";

    //签名算法
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";


    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        //私钥签名
        String content = "这是待签名数据";
        String sign = sign(content, Base64.encodeToString(privateKey.getEncoded()), "utf-8");
        System.out.println("使用私钥签名后数据：" + sign);

        //公钥验证签名
        boolean accessSigned = checkSign(content, sign, Base64.encodeToString(publicKey.getEncoded()), "utf-8");
        System.out.println("校验签名" + (accessSigned ? "通过" : "失败"));

    }

    /**
     * 使用私钥签名
     *
     * @param content       待签名的数据
     * @param privateKeyStr 私钥字符串
     * @param charset       字符集
     * @return 将待签名的数据签名，并返回签名
     */
    public static String sign(String content, String privateKeyStr, String charset) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decode(privateKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initSign(privateKey);
        signature.update(content.getBytes(charset));
        byte[] sign = signature.sign();
        return Base64.encodeToString(sign);
    }

    /**
     * 签名检查（使用公钥匹配签名，检查）
     *
     * @param content      待签名数据
     * @param sign         使用私钥生成的签名
     * @param publicKeyStr 公钥字符串
     * @param charset      字符集
     * @return true表示校验通过
     */
    public static boolean checkSign(String content, String sign, String publicKeyStr, String charset) throws Exception {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decode(publicKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
        signature.initVerify(publicKey);
        signature.update(content.getBytes(charset));
        return signature.verify(Base64.decode(sign));
    }
}
