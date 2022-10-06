package com.algs.util;

public class StringUtil {

    public static String uppercaseFirst(String name) {
        char c = (char) (name.charAt(0) - 32);
        return c + name.substring(1);
    }

}
