package com.algs.algo.sort;

import com.algs.algo.sort.cmp_swp.merge.MergeSortImpl;
import com.algs.algo.sort.cmp_swp.merge.MergeSortTopdownOptImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.util.ArrayGenerator;
import com.algs.util.ArraysUtil;
import org.junit.jupiter.api.Test;

/**
 * The best @{@link MergeSortImpl#useInsertThreshold} might be 15, 16 ?
 */
public class MergeSortUsingInsertionThresholdTest {

    @Test
    void test() {
        Integer[] array = ArrayGenerator.randomIntArray(900000);

        for (int i = 2; i < 64; i++) {
            MergeSortImpl<Integer> sort = new MergeSortTopdownOptImpl<>(ArraysUtil.copy(array), Integer::compareTo);
            int finalI = i;
            StopWatchTask<Object> st = new StopWatchTask<>() {
                @Override
                protected Object profileTask() {
                    sort.setUseInsertThreshold(finalI);
                    long start = System.currentTimeMillis();
                    sort.sort();
                    long end = System.currentTimeMillis();
                    return end - start;
                };
            };
            st.exec(true);
        }
    }

}
