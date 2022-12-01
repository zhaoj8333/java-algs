package com.algs.algo.sort.linkedlist;

import com.algs.algo.sort.array.cmp_swp.quick.QuickSort3wayImpl;
import com.algs.datastructure.collection.list.linked.ILinkedList;
import com.algs.utils.list.ListUtil;
import org.junit.jupiter.api.Test;

class LinkedListSortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
                QuickSort3wayImpl.class,
        };

        execRandomArray(klasses, 900000);
//        execRandomArray(klasses, 18);
//        execArrayWith2Value(klasses);
    }

    private void execRandomArray(Class<?>[] klasses, int size) {
        ILinkedList<Integer> list = ListUtil.randomSingleLinkedList(size);
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