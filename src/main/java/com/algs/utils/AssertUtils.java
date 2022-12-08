package com.algs.utils;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;

// TODO: 12/2/22  
public class AssertUtils {

    public static void assertArrayEquals(Integer[] ints, IList<Integer> list) {
        int[] b = new int[list.size()];
        Iterator<Integer> itr = list.iterator();
        int index = 0;
        while (itr.hasNext()) {
            b[index++] = itr.next();
        }
    }

}
