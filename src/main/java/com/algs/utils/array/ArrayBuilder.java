package com.algs.utils.array;

import com.algs.utils.RandomUtil;

import java.util.Random;

public final class ArrayBuilder {

    public enum ARRAY_TYPE {
        RANDOM,
        SINGLE_VALUE,
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
            array[i] = r.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }

    public static Integer[] randomIntArray(int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(Integer.MAX_VALUE) - (Integer.MAX_VALUE >> 1);
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

    public static Short[] randomShortArray(int length) {
        Short[] array = new Short[length];
        for (int i = 0; i < length; i++) {
            array[i] = (short) ((r.nextInt(Short.MAX_VALUE) >> 16) - (Short.MAX_VALUE >> 1));
        }
        return array;
    }

    public static Short randomShortLessThan(short max) {
        while (true) {
            short number = (short) (r.nextInt(max) >> 16);
            if (number < max) {
                return number;
            }
        }
    }

    public static Short[] randomUniqueShortArray(int length) {
        Short[] array = new Short[length];
        for (int i = 0; i < length; i++) {
            array[i] = (short) (i >> 16);
        }
        RandomUtil.shuffle(array);
        return array;
    }

    public static Short[] randomShortsBetween(int length, short min, short max) {
        Short[] array = new Short[length];
        for (short i = 0; i < length; i++) {
            array[i] = (short) ((r.nextInt(max - min) >> 16) + min);
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

    public static Integer[] randomArrayWithSeveralValues(int length, int num) {
        Integer[] array = new Integer[length];
        Integer[] values = new Integer[num];
        for (int i = 0; i < num; i++) {
            values[i] = r.nextInt(Integer.MAX_VALUE);
        }
        for (int i = 0; i < length; i++) {
            array[i] = values[r.nextInt(num)];
        }
        return array;
    }

}
