package com.algs.analysis;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.CollectionUtil;
import com.algs.util.FileUtil;
import com.algs.util.Task;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

    @Test
    void test() {
        count();
    }

    void count() {
        IList<Integer> array = FileUtil.readInts("data/1Kints.txt");
        assert array != null;
        int[] ints = CollectionUtil.toPrimitive(array);
        Task ts = new ThreeSum(ints, 0);
        ts.exec();
    }
}