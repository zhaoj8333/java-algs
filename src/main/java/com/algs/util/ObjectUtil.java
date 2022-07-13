package com.algs.util;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;

public final class ObjectUtil {

    private ObjectUtil() {
        throw new AssertionError("No " + ObjectUtil.class.getName() + " Instance for you");
    }

    public static void requireNonEmpty(String string) {
        if (StringUtils.isEmpty(string)) {
            throw new IllegalArgumentException("require String non empty");
        }
    }

    public static void requireNonNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("require Object non empty");
        }
    }


}
