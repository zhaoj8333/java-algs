package com.algs.utils.list;

import com.algs.datastructure.collection.list.linked.DoubleLinkedListImpl;
import com.algs.datastructure.collection.list.linked.SingleLinkedListImpl;
import com.algs.utils.array.ArrayGenerator;

public class ListUtil {

    public static SingleLinkedListImpl<Integer> randomSingleLinkedList(int len) {
        Integer[] array = ArrayGenerator.randomIntArray(len);
        SingleLinkedListImpl<Integer> list = new SingleLinkedListImpl<>();
        for (Integer integer : array) {
            list.add(integer);
        }
        return list;
    }

    public static DoubleLinkedListImpl<Integer> randomDoubleLinkedList(int len) {
        Integer[] array = ArrayGenerator.randomIntArray(len);
        DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<>();
        for (Integer integer : array) {
            list.add(integer);
        }
        return list;
    }

}
