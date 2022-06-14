package com.algs.util;

import java.util.Objects;

public final class AlgsUtil {

    private AlgsUtil() {
        throw new AssertionError("No AlgsUtil Instance for you");
    }

    public static void requireStringNonEmpty(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            throw new IllegalArgumentException("require String non empty");
        }
    }


}
