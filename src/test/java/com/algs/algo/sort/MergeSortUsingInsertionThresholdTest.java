package com.algs.algo.sort;

import com.algs.algo.sort.cmp_swp.merge.MergeSortBuOptmImpl;
import com.algs.algo.sort.cmp_swp.merge.MergeSortImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.util.ArrayGenerator;
import com.algs.util.ArraysUtil;
import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The best @{@link MergeSortImpl#useInsertThreshold} might be 15, 16 ?
 *
 * {@link MergeSortBuOptmImpl}: 16
 */
public class MergeSortUsingInsertionThresholdTest {

    @Test
    void test() {
        Integer[] array = ArrayGenerator.randomIntArray(900000);

        for (int i = 2; i < 64; i++) {
            Integer[] copy = ArraysUtil.copy(array);
//            MergeSortImpl<Integer> sort = new MergeSortTdOptmImpl<>(copy, Integer::compareTo);
            MergeSortImpl<Integer> sort = new MergeSortBuOptmImpl<>(copy, Integer::compareTo);
            int threshold = i;
            StopWatchTask<Object> st = new StopWatchTask<>() {
                @Override
                protected Object profileTask() {
                    sort.setUseInsertThreshold(threshold);
                    long start = System.currentTimeMillis();
                    sort.sort();
                    long end = System.currentTimeMillis();
                    return end - start;
                }

                @Override
                protected void assertResult() {
                    Assertions.assertTrue(SortUtil.isSorted(copy));
                }
            };
            st.exec(true);
        }
    }

}
