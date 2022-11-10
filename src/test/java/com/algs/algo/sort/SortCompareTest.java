package com.algs.algo.sort;

import com.algs.util.ArraysUtil;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
                SelectionSortImpl.class,
                HeapSortImpl.class,
                BubbleSortImpl.class,
                InsertionSortImpl.class
        };

        exec(klasses);
    }

    private void exec(Class<?>[] klasses) {
        Integer[] array = ArraysUtil.randomIntArray(20000);
        System.out.println("Init done");

       for (Class<?> klass : klasses) {
            SortCompare<Integer> sortCmp = new SortCompare<>(array, klass);
            sortCmp.exec();
        }
    }

}