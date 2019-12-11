package com.cimc.utils;

public class StringUtil {
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

}
