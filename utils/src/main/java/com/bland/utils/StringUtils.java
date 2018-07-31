package com.bland.utils;

public class StringUtils {

    public static boolean isEmpty(String string){
        return string == null || string.equals("");
    }

    public static String asString(String string){
        return isEmpty(string) ? "" : string;
    }

    public static boolean verifyStringLength(String s, int min, int max) {
        if (null == s || s.trim().length() < 1) {
            return false;
        }
        return s.trim().length() >= min && s.trim().length() <= max;
    }
}
