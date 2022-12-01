package com.algs.algo.sort;

import com.algs.algo.sort.array.SortCompare;
import com.algs.algo.sort.array.cmp_swp.HeapSortImpl;
import com.algs.algo.sort.array.cmp_swp.InsertionSortImpl;
import com.algs.algo.sort.array.cmp_swp.SelectionSortImpl;
import com.algs.algo.sort.array.cmp_swp.SentinelInsertionSortImpl;
import com.algs.algo.sort.array.cmp_swp.merge.*;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSort3wayImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl0;
import com.algs.algo.sort.array.cmp_swp.shell.ShellSortImpl;
import com.algs.utils.array.ArrayGenerator;
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
//                MergeSortTdImpl.class,
                MergeSortTdOptmImpl.class,
//                MergeSortBuImpl.class,
                MergeSortBuOptmImpl.class,
//                QuickSortImpl.class,
//                QuickSortImpl0.class,
//                QuickSort3wayImpl.class,
        };

        execRandomArray(klasses, 900000);
//        execRandomArray(klasses, 18);
//        execArrayWith2Value(klasses);
    }

    /**
     * 90000:
     * {@link SelectionSortImpl}: 16615 ms
     * {@link InsertionSortImpl}: 10287 ms
     * {@link SentinelInsertionSortImpl}: 14345 ms,
     * {@link InsertionSortImpl} is faster than {@link SentinelInsertionSortImpl}
     *
     * {@link HeapSortImpl}:  47 ms
     *
     * {@link ShellSortImpl}: 52 ms
     *  In theory, no one has been able to prove that {@link ShellSortImpl} is linearithmic for random data
     *  the asymptotic growth of the average-case performance of {@link ShellSortImpl} is higher
     *
     * {@link MergeSortTdImpl}: 117 ms
     *
     * {@link QuickSortImpl}: 140 ms
     * {@link QuickSortImpl0}: 125 ms
     * {@link QuickSort3wayImpl}: 159 ms
     */

    /**
     * 900000 in {@link MergeSortImpl}:
     *  {@link MergeSortImpl} is twice faster than {@link ShellSortImpl} and {@link HeapSortImpl}
     *
     *  {@link MergeSortTdImpl}: 652 ms
     *  {@link MergeSortTdOptmImpl}: 457 ms, can be much faster than {@link MergeSortTdImpl}, even near half
     *
     *  {@link MergeSortBuImpl}: 990 ms
     *  {@link MergeSortBuOptmImpl}:
     *      644 ms (@link {@link MergeSortImpl#insertionSortThreshold} == 8)
     *
     *  {@link MergeSortBuImpl} is slightly faster than {@link MergeSortTdImpl}, it don't use recursion,
     *  other than that, they don't have differences in number of compares and array access
     *
     * 900000:
     * {@link ShellSortImpl}: 1525 ms
     * {@link MergeSortTdImpl}: 643 ms
     * {@link QuickSortImpl}: 400 ms
     */
    private void execRandomArray(Class<?>[] klasses, int size) {
        Integer[] array = ArrayGenerator.randomIntArray(size);
        System.out.println("Init done");

        execute(klasses, array);

    }

    /**
     * 90000:
     * {@link SelectionSortImpl}: 15.2 s
     * {@link InsertionSortImpl}: 3.7 s
     */
    private void execArrayWith2Value(Class<?>[] klasses) {
        Integer[] array = ArrayGenerator.randomArrayWith2Values(90000, 2, 4);
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