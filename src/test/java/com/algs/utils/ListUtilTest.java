package com.algs.utils;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.linked.SingleLinkedListImpl;
import com.algs.utils.list.ListUtil;
import org.junit.jupiter.api.Test;

class ListUtilTest {

    @Test
    void randomSingleLinkedList() {
        SingleLinkedListImpl<Integer> list = ListUtil.randomSingleLinkedList(10);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void randomDoubleLinkedList() {
    }
}