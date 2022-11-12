package com.algs.algo.sort;

import com.algs.util.ArraysUtil;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
//                SelectionSortImpl.class,
                HeapSortImpl.class,
//                BubbleSortImpl.class,
//                InsertionSortImpl.class,
                ShellSortImpl.class
        };

        exec(klasses);
    }

    /**
     * 90000:
     * {@link HeapSortImpl}:  1016 ms
     * {@link ShellSortImpl}: 1249 ms
     */
    private void exec(Class<?>[] klasses) {
        Integer[] array = ArraysUtil.randomIntArray(900000);
        System.out.println("Init done");

       for (Class<?> klass : klasses) {
            SortCompare<Integer> sortCmp = new SortCompare<>(array, klass);
            sortCmp.exec();
        }
    }

}