package com.algs.util;

public class RangeUtil {

    private RangeUtil() {
        throw new AssertionError("No " + RangeUtil.class.getName() + " Instance for you");
    }

    public static void requireRange(int index, int min, int max) {
        if (index < min || index >= max) {
            throw new IndexOutOfBoundsException("require index range [" + min + ", " + max + ")");
        }
    }

    public static void requireRangeWhenAdd(int index, int min, int max) {
        if (index < min || index > max) {
            throw new IndexOutOfBoundsException("require index range [" + min + ", " + max + "]");
        }
    }

}
