package com.algs.algo.sort;

import com.algs.algo.sort.cmp_swp.*;
import com.algs.algo.sort.cmp_swp.shellsort.ShellSortImpl;
import com.algs.util.ArraysUtil;
import org.junit.jupiter.api.Test;

class SortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
//                SelectionSortImpl.class,
//                HeapSortImpl.class,
//                BubbleSortImpl.class,
//                InsertionSortImpl.class,
//                SentinelInsertionSortImpl.class
//                ShellSortImpl.class,
//                MergeSortImpl.class
                MergeSortTopdownImpl.class,
                MergeSortBottomupImpl.class,
        };

        execRandomArray(klasses);
//        execArrayWith2Value(klasses);
    }

    /**
     * 90000:
     * {@link SelectionSortImpl}: 16615 ms
     * {@link InsertionSortImpl}: 10287 ms
     * {@link SentinelInsertionSortImpl}: 14345 ms,
     *  {@link InsertionSortImpl} is faster than {@link SentinelInsertionSortImpl}
     *
     * {@link HeapSortImpl}:  47 ms
     *
     * {@link ShellSortImpl}: 52 ms
     *  In theory, no one has been able to prove that {@link ShellSortImpl} is linearithmic for random data
     *  the asymptotic growth of the average-case performance of {@link ShellSortImpl} is higher
     *
     * {@link MergeSortImpl}: 101 ms
     *
     * When 900000:
     *  {@link MergeSortImpl} is twice faster than {@link ShellSortImpl} and {@link HeapSortImpl}
     *
     *  {@link MergeSortBottomupImpl} is slightly faster than {@link MergeSortTopdownImpl}, because
     *  {@link MergeSortBottomupImpl} don't use recursion, other than that, they don't have differences
     *  in number of compares and array access
     */
    private void execRandomArray(Class<?>[] klasses) {
//        Integer[] array = ArraysUtil.randomIntArray(2000000);
        Integer[] array = ArraysUtil.randomIntArray(39);
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
            sortCmp.exec(true);
        }
    }

}