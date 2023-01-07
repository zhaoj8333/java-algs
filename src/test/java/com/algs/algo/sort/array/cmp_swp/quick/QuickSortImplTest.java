package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.ISortable;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.CompareUtil;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import com.graph.analysis.algo.sort.quick.BestCaseOfQuickSortGenerator;
import com.graph.analysis.algo.sort.quick.MaximumSwapOfLargestElement;
import com.graph.analysis.algo.sort.quick.QuickSortAlysImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortImplTest {

    private final Character[] array = new Character[] {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    private final Integer[] worstCase = new Integer[] {11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//    private final Integer[] worstCase = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    private final Character[] duplicatedCase = new Character[] {'B', 'A', 'B', 'A', 'B', 'A', 'B', 'A', 'C', 'A', 'D', 'A', 'B', 'R', 'A'};

    /**
     * E:  {E, A, S, Y, Q, U, E, S, T, I, O, N}
     *
     * E:  {E, A, E, Y, Q, U, S, S, T, I, O, N}
     * E:  {A, E, E, Y, Q, U, S, S, T, I, O, N}
     * Y:  {A, E, E, N, Q, U, S, S, T, I, O, Y}
     * N:  {A, E, E, I, N, U, S, S, T, Q, O, Y}
     * U:  {A, E, E, I, N, O, S, S, T, Q, U, Y}
     * O:  {A, E, E, I, N, O, S, S, T, Q, U, Y}
     * S:  {A, E, E, I, N, O, Q, S, T, S, U, Y}
     * T:  {A, E, E, I, N, O, Q, S, S, T, U, Y}
     *
     * {A, E, E, I, N, O, Q, S, S, T, U, Y}
     */
    @Test
    void _2_3_1() {
        ArraysUtil.println(array);

        sort(array, 0, array.length - 1);

        ArraysUtil.println(array);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * [begin, mid - 1], mid, [mid + 1, end]
     *
     *  i                                 j
     */
    private void sort(Character[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = partition(array, begin, end);
        sort(array, begin, mid - 1);
        sort(array, mid + 1, end);
    }

    private int partition(Character[] array, int begin, int end) {
        int i = begin, j = end + 1;
        char pivot = array[begin];
        while (true) {
            // find array[i] greater than entry
            do {
                i++;
            } while (i <= end && CompareUtil.less(array[i], pivot));

            // find array[j] smaller than entry
            do {
                j--;
            } while (j > begin && CompareUtil.more(array[j], pivot));

            if (i >= j) {
                break;
            }
            ArraySortUtil.swap(array, i, j);
        }
        ArraySortUtil.swap(array, begin, j);

        System.out.print(pivot + ":  ");
        ArraysUtil.println(array);

        return j;
    }

    /**
     * Look like the maximum number of swap of biggest element is floor(N/2)
     * Scenario:
     * {2, 10, 4, 1, 7, 5, 3, 9, 6, 8}
     */
    @Test
    void _2_3_3() {
        int retry = 5000000;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < retry; i++) {
            ArraysUtil.shuffle(worstCase);
            Integer[] copy = ArraysUtil.copy(worstCase);
            MaximumSwapOfLargestElement<Integer> msle = new MaximumSwapOfLargestElement<>(copy, false);
            int swap = msle.get();
            if (swap > max) {
                max = swap;
                if (max == 5) {
                    ArraysUtil.println(worstCase);
                }
//                if (max == 8) {
//                    ArraysUtil.display(worstCase);
//                }
            }
        }
        System.out.println(max);
    }

    /**
     * After swap: [1, 11], index: [1, 4]
     * After swap: [4, 11], index: [4, 6]
     * After swap: [6, 11], index: [6, 8]
     * After swap: [8, 11], index: [8, 9]
     */
    @Test
    void testMostSwapScenario() {
        Integer[] array = new Integer[]{2, 11, 5, 3, 1, 7, 4, 9, 6, 8, 10};
        MaximumSwapOfLargestElement<Integer> msle = new MaximumSwapOfLargestElement<>(array, true);
        int i = msle.get();
        System.out.println(i);
    }

    /**
     * {6, 5, 4, 1, 2, 3, 9, 11, 10, 7, 8}
     * {6, 4, 5, 2, 1, 3, 9, 11, 10, 8, 7}
     * {6, 4, 5, 2, 1, 3, 9, 11, 10, 7, 8}
     * {6, 4, 5, 1, 2, 3, 9, 11, 10, 8, 7}
     * {6, 4, 5, 1, 2, 3, 9, 11, 10, 7, 8}
     * swapCount: 32
     */
    @Test
    void _2_3_4() {
        testMostCmp();
    }

    private void testMostCmp() {
        int retry = 6000000;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < retry; i++) {
            ArraysUtil.shuffle(worstCase);
            Integer[] copy = ArraysUtil.copy(worstCase);
            CompareAndSwapSortAlys<Integer> sort = new QuickSortAlysImpl<>(copy);
            sort.sort();
            if (sort.getSwapCount() > max) {
                max = sort.getSwapCount();
                ArraysUtil.println(worstCase);
                System.out.println("swapCount: " + max);
            }
        }
    }

    @Test
    void _2_3_5() {
        Integer[] array = ArrayBuilder.randomArrayWithSeveralValues(100000, 2);

        Integer[] copy = ArraysUtil.copy(array);
        Integer[] finalCopy = copy;
        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                ISortable<Integer> sort = new QuickSortImpl0<>(finalCopy);
                sort.sort();
                return QuickSortImpl0.class.getName();
            }

            @Override
            protected void assertInput() {

            }

            @Override
            protected void assertResult() {
            }
        };
        sw.exec(true);

        Integer[] copy1 = ArraysUtil.copy(array);
        sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                ISortable<Integer> sort = new QuickSort3wayImpl<>(copy1);
                sort.sort();
                return QuickSort3wayImpl.class.getName();
            }

            @Override
            protected void assertInput() {

            }

            @Override
            protected void assertResult() {
            }
        };
        sw.exec(true);
    }

    /**
     * The smaller subarray, the more, so switch to insertion sort for small arrays is very necessary
     *
     * total size: 100000
     * number of 0 sized subarray is 33367
     * number of 1 sized subarray is 33317
     * number of 2 sized subarray is 16591
     * number of 3 sized subarray is 9999
     * number of 4 sized subarray is 6687
     * number of 5 sized subarray is 4766
     * number of 6 sized subarray is 3593
     * number of 7 sized subarray is 2844
     * number of 8 sized subarray is 2205
     * number of 9 sized subarray is 1765
     * number of 10 sized subarray is 1604
     * number of 11 sized subarray is 1268
     * number of 12 sized subarray is 1037
     * number of 13 sized subarray is 955
     * number of 14 sized subarray is 843
     * number of 15 sized subarray is 732
     */
    @Test
    void _2_3_7() {
        for (int size = 100000; size < 200000; size *= 2) {
            Integer[] integers = ArrayBuilder.randomUniqueArray(size);
            QuickSortAlysImpl<Integer> sort = new QuickSortAlysImpl<>(integers);
            sort.sort();
            System.out.println("total size: " + size);
            int[] subarraySizes = sort.getSubarraySizes();
            for (int i = 0; i < subarraySizes.length; i++) {
                System.out.println("number of " + i + " sized subarray is " + subarraySizes[i]);
            }
            System.out.println();
        }
    }

    /**
     * size: 10000, cmp: 121034
     * size: 20000, cmp: 262058
     * size: 40000, cmp: 564106
     * size: 80000, cmp: 1208202
     * size: 160000, cmp: 2576394
     * size: 320000, cmp: 5472778
     * size: 640000, cmp: 11585546
     *
     * N * log N
     */
    @Test
    void _2_3_8() {
        for (int size = 10000; size < 1000000; size *= 2) {
            Integer[] integers = ArrayBuilder.randomArrayWithSeveralValues(size, 1);
            QuickSortAlysImpl<Integer> sort = new QuickSortAlysImpl<>(integers);
            sort.sort();
            int cmp = sort.getCmpCount();
            System.out.println("size: " + size + ", cmp: " + cmp);
        }

    }

    @Test
    void _2_3_12() {
        ArraysUtil.println(duplicatedCase);
        System.out.println();

        sort0(duplicatedCase);

        Assertions.assertTrue(ArraySortUtil.isSorted(duplicatedCase));
        System.out.println();
        ArraysUtil.println(duplicatedCase);
    }

    private void sort0(Character[] array) {
        sort0(array, 0, array.length - 1);
    }

    /**
     *  [------|-------------|-----]
     * begin  lo  <   i  =  gt < end
     */
    private void sort0(Character[] array, int begin, int end) {
        if (end - begin < 1) {
            return;
        }
        int lo = begin, i = begin + 1, gt = end;
        Character pivot = array[begin];
        while (i <= gt) {
            int cmp = CompareUtil.compare(pivot, array[i]);
            if (cmp > 0) {
                ArraySortUtil.swap(array, i++, lo++);
            } else if (cmp < 0) {
                ArraySortUtil.swap(array, i, gt--);
            } else {
                i++;
            }
        }

        System.out.print(pivot + ": ");
        ArraysUtil.println(array);

        sort0(array, begin, lo);
        sort0(array, gt + 1, end);
    }

    @Test
    void _2_3_16() {
        Character[] chars = BestCaseOfQuickSortGenerator.getChars(20);
        ArraysUtil.println(chars);
    }

    @Test
    void _2_3_17() {
        NoSentinelQuickSortImpl<Integer> sort = new NoSentinelQuickSortImpl<>(FileUtil.readIntsAsArray(FilePath.INT_1K));
        sort.sort();
        Assertions.assertTrue(ArraySortUtil.isSorted(sort.getArray()));
        System.out.println(sort);
    }

}