package com.algs.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArraysUtilTest {

    @Test
    void shuffle() {
        int[] array = new int[10];
        for (int i = 1; i <= 10; i++) {
            array[i - 1] = i * 10;
        }

    }

    @Test
    void copy() {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 10;
        }
        System.out.println(ArraysUtil.toString(array));

        int[] copy = ArraysUtil.copy(array);
        Assertions.assertArrayEquals(array, copy);

        array[0] -= 10;
        Assertions.assertNotEquals(array, copy);

    }
}