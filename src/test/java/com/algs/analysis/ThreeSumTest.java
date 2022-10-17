package com.algs.analysis;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.CollectionUtil;
import com.algs.util.FileUtil;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

    @Test
    void test() {
        long i = (long) Integer.MAX_VALUE + (long) Integer.MAX_VALUE;
        System.out.println(i);

        countK();
        countM();
    }

    void countK() {
        IList<Integer> array = FileUtil.readInts("pairs/1Kints.txt");
        assert array != null;
        int[] ints = CollectionUtil.toPrimitive(array);
        StopWatchTask ts = new ThreeSum(ints, 0l);
        ts.exec();
    }

    void countM() {
        IList<Integer> array = FileUtil.readInts("pairs/32Kints.txt");
        assert array != null;
        int[] ints = CollectionUtil.toPrimitive(array);
        StopWatchTask ts = new ThreeSum(ints, 0l);
        ts.exec();
    }
}