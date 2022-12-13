package com.algs.algo.sort.array.cmp_swp;

import com.algs.ImplPerformanceTest;
import com.algs.algo.sort.array.cmp_swp.merge.*;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSort3wayImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl0;
import com.algs.algo.sort.array.cmp_swp.shell.ShellSortImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

class ArraySortCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    private static final Integer[] testArray;

    static {
        testArray = ArrayBuilder.randomIntArray(900000);
    }

    private Class<?>[] targetClasses = new Class<?>[] {
//                SelectionSortImpl.class,
//                HeapSortImpl.class,
//                BubbleSortImpl.class,
//                InsertionSortImpl.class,
//                SentinelInsertionSortImpl.class
//                ShellSortImpl.class,
                MergeSortTdImpl.class,
                MergeSortTdOptmImpl.class,
                MergeSortBuImpl.class,
                MergeSortBuOptmImpl.class,
//                QuickSortImpl.class,
//                QuickSortImpl0.class,
//                QuickSort3wayImpl.class,
        };


//        execRandomArray(klasses, 900000);
//        execRandomArray(klasses, 18);
//        execArrayWith2Value(klasses);

    @Test
    @Override
    public void compare() {
        compare(targetClasses);
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Constructor<?> constructor = null;
        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        try {
            constructor = targetClass.getConstructor(Comparable[].class, Comparator.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ArrayCompareAndSwapSort<Integer> sort = null;
        try {
            Integer[] copy = ArraysUtil.copy(testArray);
            sort = (ArrayCompareAndSwapSort<Integer>) constructor.newInstance(copy, cmp);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return sort;
    }

    @Override
    protected void execEach(Object obj) {
        ArrayCompareAndSwapSort<Integer> sort = (ArrayCompareAndSwapSort) obj;
        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                sort.sort();
                return null;
            }

            @Override
            protected void assertResult() {
                Assertions.assertTrue(ArraySortUtil.isSorted(sort.getArray()));
            }
        };
        sw.exec(true);
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

    /**
     * 90000:
     * {@link SelectionSortImpl}: 15.2 s
     * {@link InsertionSortImpl}: 3.7 s
     */

}