package com.algs.algo.sort.array.cmp_swp;

import com.algs.ImplPerformanceTest;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortBuImpl;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortBuOptmImpl;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortImpl;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortTdImpl;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortTdOptmImpl;
import com.algs.algo.sort.array.cmp_swp.merge.NaturalMergeSortImpl;
import com.algs.algo.sort.array.cmp_swp.quick.NonRecursiveQuickSortImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSort3wayImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl0;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortRandomSelectImpl0;
import com.algs.algo.sort.array.cmp_swp.quick.QuickSortRandomizeArrayImpl0;
import com.algs.algo.sort.array.cmp_swp.shell.ShellSortImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraySortCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    protected static final Integer[] testArray;

    static {
        testArray = ArrayBuilder.randomIntArray(900000);
//        testArray = ArrayBuilder.randomArrayWithSeveralValues(900000, 10);
    }

    /**
     * {@link QuickSortRandomSelectImpl0} is better than {@link QuickSortRandomizeArrayImpl0}
     */
    private final Class<?>[] targetClasses = new Class<?>[] {
//            SelectionSortImpl.class,
//            HeapSortImpl.class,
//            BubbleSortImpl.class,
//            InsertionSortImpl.class,
//            SentinelInsertionSortImpl.class
//            ShellSortImpl.class,
//            MergeSortTdImpl.class,
//            MergeSortTdOptmImpl.class,
//            MergeSortBuImpl.class,
//            MergeSortBuOptmImpl.class,
//            NaturalMergeSortImpl.class,
//            QuickSortImpl.class,
//            QuickSortImpl0.class,
//            QuickSortIgnoreSmallArrayImpl0.class,
//            QuickSort3wayImpl.class,
//            NoSentinelQuickSortImpl.class,
//            KMedianQuickSortImpl.class,
//            NonRecursiveQuickSortImpl.class,

//            QuickSortRandomSelectImpl0.class,
//            QuickSortRandomizeArrayImpl0.class,
//            QuickSampleSortImpl.class
    };

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
            Integer[] copy = ArraysUtil.copyAll(testArray);
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
            protected void assertInput() {
                Assertions.assertFalse(ArraySortUtil.isSorted(sort.getArray()));
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
     *  {@link MergeSortBuOptmImpl}: 644 ms (@link {@link MergeSortImpl#insertionCutoff} == 8)
     *  {@link NaturalMergeSortImpl}: almost same as {@link MergeSortBuImpl}
     *
     *  {@link MergeSortBuImpl} is slightly faster than {@link MergeSortTdImpl}, it don't use recursion,
     *  other than that, they don't have differences in number of compares and array access
     *
     * 900000:
     * {@link ShellSortImpl}: 1351 ms
     * {@link MergeSortTdImpl}: 718 ms
     * {@link QuickSortImpl0}: 711 ms
     * {@link NonRecursiveQuickSortImpl}: 461 ms, {@link NonRecursiveQuickSortImpl} is faster,
     *  the height of recursive tree is low, but the recursive calls is very large
     * {@link QuickSort3wayImpl}: 673, but this can hugely improve performance when there are k numbers
     */

    /**
     * 90000:
     * {@link SelectionSortImpl}: 15.2 s
     * {@link InsertionSortImpl}: 3.7 s
     */

    /**
     * The best @{@link MergeSortImpl#insertionCutoff} might be 15, 16 ?
     */
    @Test
    void getThresholdOfMergeSort() {
        Integer[] array = ArrayBuilder.randomIntArray(100000);
        long min = Long.MAX_VALUE;
        int theThreshold = 0;

        for (int i = 1024 * 128 / 32; i < 1024 * 1024 * 3; i *= 2) {
            Integer[] copy = ArraysUtil.copyAll(array);
//            MergeSortImpl<Integer> sort = new MergeSortTdOptmImpl<>(copy, Integer::compareTo);
            MergeSortImpl<Integer> sort = new MergeSortBuOptmImpl<>(copy, Integer::compareTo);
            int threshold = i;
            StopWatchTask<Object> st = new StopWatchTask<>() {
                @Override
                protected Object profileTask() {
                    sort.setInsertionCutoff(threshold);
                    long start = System.currentTimeMillis();
                    sort.sort();
                    long end = System.currentTimeMillis();
                    return end - start;
                }

                @Override
                protected void assertInput() {
                    Assertions.assertFalse(ArraySortUtil.isSorted(copy));
                }

                @Override
                protected void assertResult() {
                    Assertions.assertTrue(ArraySortUtil.isSorted(copy));
                }
            };
            long dur = st.exec(false);
            if (dur < min) {
                min = dur;
                theThreshold = i;
            }
            System.out.println(i + ", dur: " + dur);
        }
        System.out.println(Thread.currentThread().getName() + ", min time: " + min + ", threshold: " + theThreshold);
    }

}