package com.csw.utils;

import java.util.Random;

public class Number10 {

    //给定一个字符串
    static String str = "0123456789";

    public static String getNum() {
        StringBuffer salt = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            salt.append(str.charAt(new Random().nextInt(10)));
        }
        return salt.toString();
    }

}

