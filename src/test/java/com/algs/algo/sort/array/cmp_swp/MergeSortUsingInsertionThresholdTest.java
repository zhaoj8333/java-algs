package com.algs.algo.sort.array.cmp_swp;

import com.algs.algo.sort.array.cmp_swp.merge.MergeSortBuOptmImpl;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.array.ArraySortUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The best @{@link MergeSortImpl#insertionSortThreshold} might be 15, 16 ?
 *
 * {@link MergeSortBuOptmImpl}: 16
 */
class MergeSortUsingInsertionThresholdTest {

    @Test
    void test() {
        Integer[] array = ArrayBuilder.randomIntArray(900000);
        long min = Long.MAX_VALUE;
        int theThreshold = 0;

        for (int i = 2; i < 64; i++) {
            Integer[] copy = ArraysUtil.copy(array);
//            MergeSortImpl<Integer> sort = new MergeSortTdOptmImpl<>(copy, Integer::compareTo);
            MergeSortImpl<Integer> sort = new MergeSortBuOptmImpl<>(copy, Integer::compareTo);
            int threshold = i;
            StopWatchTask<Object> st = new StopWatchTask<>() {
                @Override
                protected Object profileTask() {
                    sort.setInsertionSortThreshold(threshold);
                    long start = System.currentTimeMillis();
                    sort.sort();
                    long end = System.currentTimeMillis();
                    return end - start;
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
        }
        System.out.println(Thread.currentThread().getName() + ", min time: " + min + ", threshold: " + theThreshold);
    }

}
