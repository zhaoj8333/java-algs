package com.algs.issues.datastructure.collection.list;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.utils.CollectionUtil;
import com.algs.utils.array.ArrayBuilder;
import org.junit.Test;

public class ArrayAndLinkedList {

    @Test
    public void iteratePerformance() {
        Integer[] array = ArrayBuilder.randomArray(100000000);
        SinglyLinkedListImpl<Integer> list = CollectionUtil.toSinglyLinkedList(array);

        // compare
        long start = System.currentTimeMillis();
        Integer ele = null;
        for (int i = 0; i < array.length; i++) {
            ele = array[i];
        }
        System.out.println(ele);
        long end = System.currentTimeMillis();
        System.out.println("array iterate: " + (end - start));

        start = System.currentTimeMillis();
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            ele = itr.next();
        }
        System.out.println(ele);
        end = System.currentTimeMillis();
        System.out.println("linked list iterate: " + (end - start));

    }

}
