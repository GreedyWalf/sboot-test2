package com.sboot.utils;

import java.math.BigInteger;

public class StringUtils {

    public static void main(String[] args) {
//        test();
//        test2();
//        test3();

//        String s = parseByte2HexStr(new byte[]{1, -1, 10, -128});
//        System.out.println(s);
//        System.out.println(Integer.toHexString(-1 & 0xff));
//        System.out.println(Integer.toHexString(10 & 0xff));

//        byte[] ffs = parseHexStr2Byte("FF");
//        System.out.println(ffs[0]);

//        boolean a_b_c = isEmpty("  b c");
//        System.out.println(a_b_c);
    }

    //将对应进制的数转换为十进制数
    public static void test() {
        System.out.println(Integer.valueOf("15", 16));  // =1*16+5=21
        System.out.println(Integer.valueOf("77", 8)); // =7*8+7=63
        System.out.println(Integer.valueOf("1010", 2)); // =1*2^3+1*2=10

        System.out.println(Integer.parseInt("15", 16)); //21
        System.out.println(Integer.parseInt("77", 8)); //63
        System.out.println(Integer.parseInt("1010", 2)); //10
    }

    //将十进制数转换为对应进制字符串形式(十进制转化为多少进制，使用除法取余，拼接字符串即可)
    public static void test2() {
        System.out.println(Integer.toBinaryString(-1));
        //转换为二进制 11111111
        System.out.println(Integer.toBinaryString(255));
        //转换为二进制 1010
        System.out.println(Integer.toBinaryString(10));
        //转换为八进制 11
        System.out.println(Integer.toOctalString(9));
        //转化为16进制 14
        System.out.println(Integer.toHexString(20));
    }

    /**
     * byte取值范围和强制转换
     */
    public static void test3() {
        System.out.println(Byte.MIN_VALUE); //-128
        System.out.println(Byte.MAX_VALUE);  //127

        int num = 255;
        byte b = (byte) num;
        System.out.println(b); //-1
        System.out.println((int) b); //-1
    }


    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }

        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }

        return result;
    }

    public static boolean isEmpty(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0) {
            return true;
        }

        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
