package com.algs.datastructure.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class ArrayUtilTest {

    @Test
    void histogram() {
        int[] ints = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            ints[i] = r.nextInt(10);
        }
        System.out.println(Arrays.toString(ints));
        int[] histogram = ArrayUtil.histogram(ints, 10);
        System.out.println(Arrays.toString(histogram));

    }

    @Test
    void transpos() {
        int[][] ints = new int[10][5];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = (i + 1) * i;
            }
        }
        print(ints);
        int[][] transpos = ArrayUtil.transpos(ints);
        System.out.println();
        print(transpos);
    }


    void print(int[][] array) {
        for (int[] anInt : array) {
            System.out.println(Arrays.toString(anInt));
        }

    }

}