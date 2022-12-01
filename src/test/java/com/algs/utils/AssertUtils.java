package com.algs.utils;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;

public class AssertUtils {

    public static void assertArrayEquals(Integer[] ints, IList<Integer> integerIList) {
        int[] b = new int[integerIList.size()];
        Iterator<Integer> itr = integerIList.iterator();
        int index = 0;
        while (itr.hasNext()) {
            b[index++] = itr.next();
        }
    }

}
