package com.algs.utils.list;

import com.algs.datastructure.collection.list.linked.DoublyLinkedListImpl;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.utils.array.ArrayBuilder;

public class ListUtil {

    public static SinglyLinkedListImpl<Integer> randomSinglyLinkedList(int len) {
        Integer[] array = ArrayBuilder.randomIntArray(len);
        SinglyLinkedListImpl<Integer> list = new SinglyLinkedListImpl<>();
        for (Integer integer : array) {
            list.add(integer);
        }
        return list;
    }

    public static DoublyLinkedListImpl<Integer> randomDoublyLinkedList(int len) {
        Integer[] array = ArrayBuilder.randomIntArray(len);
        DoublyLinkedListImpl<Integer> list = new DoublyLinkedListImpl<>();
        for (Integer integer : array) {
            list.add(integer);
        }
        return list;
    }

}
