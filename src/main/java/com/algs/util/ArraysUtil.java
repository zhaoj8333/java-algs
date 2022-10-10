package com.algs.util;

import org.apache.commons.lang.math.RandomUtils;

public class ArraysUtil {

    public static int [] randomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = RandomUtils.nextInt();
        }
        return array;
    }

    public static void fill(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

}
