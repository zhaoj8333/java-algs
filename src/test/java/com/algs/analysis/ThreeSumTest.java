package com.algs.analysis;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.CollectionUtil;
import com.algs.utils.file.FilePath;
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

    private void countK() {
        IList<Integer> array = FileUtil.readInts(FilePath.INT_1K);
        assert array != null;
        Integer[] ints = CollectionUtil.toIntegerArray(array);
        StopWatchTask ts = new ThreeSum(ints, 0l);
        ts.exec(true);
    }

    private void countM() {
        IList<Integer> array = FileUtil.readInts(FilePath.INT_2K);
        assert array != null;
        Integer[] ints = CollectionUtil.toIntegerArray(array);
        StopWatchTask ts = new ThreeSum(ints, 0l);
        ts.exec(true);
    }
}