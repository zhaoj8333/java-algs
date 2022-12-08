package com.algs.utils.array;

import com.algs.utils.RandomUtil;

import java.util.Random;

public final class ArrayGenerator {

    public enum ARRAY_TYPE {
        RANDOM,
        Singly_VALUE,
        DUAL_VALUE_RANDOM,
        TERNARY_VALUE_RANDOM,
        DUAL_VALUE_ASCEND,
        TERNARY_VALUE_ASCEND,
        DUAL_VALUE_DESCEND,
        TERNARY_VALUE_DESCEND,
        PARTIAL_ASCEND,
        PARTIAL_DESCEND,
    }

    private static final Random r = new Random();

    public static Comparable[] randomArray(int length) {
        Comparable[] array = new Comparable[length];
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(length);
        }
        return array;
    }

    public static Integer[] randomIntArray(int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(length);
        }
        return array;
    }

    public static Integer randomNumberLessThan(int max) {
        while (true) {
            int number = r.nextInt(max);
            if (number < max) {
                return number;
            }
        }
    }

    public static Integer[] randomUniqueArray(int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        RandomUtil.shuffle(array);
        return array;
    }

    public static Integer[] randomIntArrayBetween(int length, int min, int max) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(max - min) + min;
        }
        return array;
    }

    public static Character[] randomPrintableCharArray(int length) {
        Character[] array = new Character[length];
        for (int i = 0; i < length; i++) {
            array[i] = (char)(0X20 + r.nextInt(95));
        }
        return array;
    }

    public static Integer[] randomArrayWith2Values(int length, int val1, int val2) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            int m = r.nextInt(length);
            if (m % 2 == 0) {
                array[i] = val1;
            } else {
                array[i] = val2;
            }
        }
        return array;
    }

}
