package com.algs.utils;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.list.IList;

public class AssertUtils {

    public static void assertArrayListEquals(Integer[] ints, IList<Integer> list) {
        int[] b = new int[list.size()];
        Iterator<Integer> itr = list.iterator();
        int index = 0;
        while (itr.hasNext()) {
            b[index++] = itr.next();
        }
    }

}
