package com.algs.analysis;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.CollectionUtil;
import com.algs.utils.file.FileUtil;
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
        IList<Integer> array = FileUtil.readInts("data/1Kints.txt");
        assert array != null;
        Integer[] ints = CollectionUtil.toIntegerArray(array);
        StopWatchTask ts = new ThreeSum(ints, 0l);
        ts.exec(true);
    }

    void countM() {
        IList<Integer> array = FileUtil.readInts("data/32Kints.txt");
        assert array != null;
        Integer[] ints = CollectionUtil.toIntegerArray(array);
        StopWatchTask ts = new ThreeSum(ints, 0l);
        ts.exec(true);
    }
}