package com.algs.util;

import com.algs.datastructure.collection.ICollection;

import java.lang.reflect.Field;
import java.util.Objects;

public final class ObjectUtil<E> {

    private ObjectUtil() {
        throw new AssertionError("No " + ObjectUtil.class.getName() + " Instance for you");
    }

    public static void requireNonEmpty(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            throw new IllegalArgumentException("require String non empty");
        }
    }

    public static void requireNonNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("require Object non empty");
        }
    }

    public static <E> void requireNonEmpty(ICollection<E> collection) {
        if (collection.isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
    }

    public static String getGetterMethodName(Field field) {
        String fieldName = field.getName();
        char[] chars = fieldName.toCharArray();
        chars[0] = (char) (chars[0] - ('a' - 'A'));
        return "get" + new String(chars);
    }

}
