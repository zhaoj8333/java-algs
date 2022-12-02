package com.algs.algo.sort.linkedlist;

import com.algs.datastructure.collection.list.linked.ILinkedList;
import com.algs.utils.list.ListUtil;
import org.junit.jupiter.api.Test;

class LinkedListSortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {

        };

        execRandomList(klasses, 900000);
//        execRandomArray(klasses, 18);
//        execArrayWith2Value(klasses);
    }

    private void execRandomList(Class<?>[] klasses, int size) {
        ILinkedList<Integer> list = ListUtil.randomSinglyLinkedList(size);
        System.out.println("Init done");

        execute(klasses, list);

    }

    private void execute(Class<?>[] klasses, ILinkedList<Integer> list) {
        for (Class<?> klass : klasses) {
            LinkedListSortCompare<Integer> sortCmp = new LinkedListSortCompare<>(list, klass);
            sortCmp.exec(true);
        }
    }

}