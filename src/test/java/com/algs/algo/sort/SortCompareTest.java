package com.algs.algo.sort;

import com.algs.util.ArraysUtil;
import org.junit.jupiter.api.Test;

class SortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
                SelectionSortImpl.class,
//                HeapSortImpl.class,
//                BubbleSortImpl.class,
                InsertionSortImpl.class,
//                SentinelInsertionSortImpl.class
//                ShellSortImpl.class
        };

//        execRandomArray(klasses);
        execArrayWith2Value(klasses);
    }

    /**
     * 90000:
     * {@link InsertionSortImpl}: 10845 ms
     * {@link SentinelInsertionSortImpl}: 14345 ms, {@link InsertionSortImpl} is faster than {@link SentinelInsertionSortImpl}
     *
     * {@link HeapSortImpl}:  1016 ms
     * {@link ShellSortImpl}: 55 ms
     */
    private void execRandomArray(Class<?>[] klasses) {
        Integer[] array = ArraysUtil.randomIntArray(90000);
        System.out.println("Init done");

        execute(klasses, array);

    }

    /**
     * 90000:
     * {@link SelectionSortImpl}: 15.2 s
     * {@link InsertionSortImpl}: 3.7 s
     */
    private void execArrayWith2Value(Class<?>[] klasses) {
        Integer[] array = ArraysUtil.randomArrayWith2Values(90000, 2, 4);
        System.out.println("Init done");

//        execute(klasses);
        execute(klasses, array);
    }

    private void execute(Class<?>[] klasses, Integer[] array) {
        for (Class<?> klass : klasses) {
            SortCompare<Integer> sortCmp = new SortCompare<>(array, klass);
            sortCmp.exec(false);
        }
    }

}