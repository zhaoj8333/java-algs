package com.algs.util;

import java.util.Objects;
import java.util.Random;

public class ArrayUtil {

    public static void shuffle(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        Random r = new Random();
        for (int i = array.length; i > 1; i--) {
            int n = r.nextInt(i);
            int m = i - 1;
            int tmp = array[n];
            array[n] = array[m];
            array[m] = tmp;
        }
    }


}
