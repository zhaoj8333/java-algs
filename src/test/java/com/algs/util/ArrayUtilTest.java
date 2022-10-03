package com.algs.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrayUtilTest {

    @Test
    void shuffle() {
        int[] array = new int[10];
        for (int i = 1; i <= 10; i++) {
            array[i - 1] = i * 10;
        }
        System.out.println(Arrays.toString(array));
        CollectionUtil.shuffle(array);
        System.out.println(Arrays.toString(array));

    }
}