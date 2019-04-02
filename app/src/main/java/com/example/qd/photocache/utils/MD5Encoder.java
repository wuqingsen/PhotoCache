package com.example.qd.photocache.utils;

import java.security.MessageDigest;

/**
 * author: wu
 * date: on 2019/4/2.
 * describe:MD5加密
 */
public class MD5Encoder {
    /**
     * Md5Encoder
     * @param string
     */
    public static String encode(String string) throws Exception {
        byte[] hash = MessageDigest.getInstance("MD5").digest(
                string.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}
