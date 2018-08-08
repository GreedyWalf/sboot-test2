package com.sboot.utils;

import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 测试：使用RSA加密算法生成公钥、私钥；
 *
 * 公钥加密，私钥解密；
 */
public class RsaEncryptUtils {
    private static Logger logger = LoggerFactory.getLogger(RsaEncryptUtils.class);

    private static String KEY_ALGORITHM = "RSA";
    private static int KEY_SIZE = 1024;

    public static void main(String[] args) throws Exception {

        System.out.println("--------测试使用RSA加密算法生成公钥、私钥-------");
        KeyPair keyPair = generateKeyPair(KEY_SIZE);
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("私钥：" + Base64.encodeToString(privateKey.getEncoded()));
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("公钥：" + Base64.encodeToString(publicKey.getEncoded()));

        System.out.println("------测试公钥、私钥字符串还原公钥私钥-------");
        privateKey = getPrivateKeyFromStr(Base64.encodeToString(privateKey.getEncoded()));
        System.out.println("私钥：" + Base64.encodeToString(privateKey.getEncoded()));
        publicKey = getPublicKeyFromStr(Base64.encodeToString(publicKey.getEncoded()));
        System.out.println("公钥：" + Base64.encodeToString(publicKey.getEncoded()));

        System.out.println("-------公钥加密，私钥解密--------");
        //公钥加密
        byte[] encryptData = encrypt(publicKey, "123".getBytes());
        //私钥解密
        byte[] decryptData = decrypt(privateKey, encryptData);
        System.out.println("私钥解密：" + new String(decryptData));



    }


    /**
     * 生成RAS密钥对（包含公钥和私钥）
     * 使用rsa加密算法，需要设置所占字节大小
     */
    public static KeyPair generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.generateKeyPair();
    }


    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥经过Base64编码后生成的字符串
     * @return 返回公钥对象
     */
    public static RSAPublicKey getPublicKeyFromStr(String publicKeyStr) {
        byte[] buff = Base64.decode(publicKeyStr);
        KeyFactory keyFactory = null;
        PublicKey publicKey = null;
        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            //私钥使用的keySpec和公钥不一样
            publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(buff));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("指定算法不存在~");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            logger.error("公钥非法~");
        }

        return (RSAPublicKey) publicKey;
    }

    /**
     * 通过私钥字符串获取私钥
     *
     * @param privateKeyStr 私钥字符串
     * @return
     */
    public static RSAPrivateKey getPrivateKeyFromStr(String privateKeyStr) {
        byte[] buff = Base64.decode(privateKeyStr);
        KeyFactory keyFactory = null;
        PrivateKey privateKey = null;
        try {
            keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            //私钥使用的keySpec和公钥不一样
            privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(buff));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("指定算法不存在~");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            logger.error("公钥非法~");
        }

        return (RSAPrivateKey) privateKey;
    }


    /**
     * 使用公钥加密，获得加密后的字节数组
     *
     * @param publicKey     公钥
     * @param plainTextData 加密字节
     * @return
     */
    public static byte[] encrypt(PublicKey publicKey, byte[] plainTextData) throws Exception {
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainTextData);
    }


    /**
     * 使用私钥解密
     *
     * @param privateKey 私钥
     * @param cipherData 加密后的明文
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] cipherData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(cipherData);
    }

}
