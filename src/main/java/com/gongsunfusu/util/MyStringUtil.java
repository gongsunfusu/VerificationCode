package com.gongsunfusu.util;

import javax.servlet.http.HttpServletRequest;

public class MyStringUtil {
    /**
     * 比较验证码
     * @param verification_1
     * @param verification_2
     * @return
     */
    public static Boolean verificationJudge(String verification_1, String verification_2){
        if (isEmpty_String(verification_1) || isEmpty_String(verification_2)) return false;
        verification_1 = verification_1.toLowerCase();
        verification_2 = verification_2.toLowerCase();
        if (verification_1.equals(verification_2)) return true;
        return false;
    }

    /**
     * 判断字符串是否为空，true表示为空
     * @param str
     * @return
     */
    public static Boolean isEmpty_String(String str){
        if (str == null){
            return true;
        }
        str = str.trim();
        if (str.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 获取根目录
     * @return
     */
    public static String getPath(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        return basePath;
    }
}
