package com.gongsunfusu.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String passwordToMD5(String password,String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //password+salt
        String passwordSalt = salt + password;
        //加密后的字符串
        String newPassword = base64en.encode(md5.digest(passwordSalt.getBytes("utf-8")));
        //返回加密后的密码
        return newPassword;
    }
}
