package com.algs.utils;

public class RangeUtil {

    private RangeUtil() {
        throw new AssertionError("No " + RangeUtil.class.getName() + " Instance for you");
    }

    public static void requireGreaterThan(int capacity, int threshold) {
        if (capacity <= threshold) {
            throw new RuntimeException("capacity should greater than " + threshold);
        }
    }

    public static void requireIntRange(int intVal, int min, int max) {
        if (intVal < min || intVal >= max) {
            throw new IndexOutOfBoundsException(String.format("require range [%d, %d)", min, max));
        }
    }

    /**
     * [min, max]
     */
    public static void requireRangeWhenAdd(int intVal, int min, int max) {
        if (intVal < min || intVal > max) {
            throw new IndexOutOfBoundsException(String.format("require range [%d, %d]", min, max));
        }
    }

    public static void requireNumberRange(double number, double min, double max) {
        if (number <= min || number >= max) {
            throw new RuntimeException(String.format("require number range (%f, %f)", min, max));
        }
    }

    public static void requireNumberRange(float number, float min, float max) {
        if (number <= min || number >= max) {
            throw new RuntimeException(String.format("require number range (%f, %f)", min, max));
        }
    }
}
