package com.algs.datastructure.collection.list.linked;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.linked.ILinkedList;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedListImpl0Test {

    @Test
    void test() {
        ILinkedList<Integer> sll = new SinglyLinkedListImpl0<>();
        Assertions.assertTrue(sll.isEmpty());
        Assertions.assertEquals(0, sll.size());
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);
        sll.add(2, 20);
        Assertions.assertEquals(20, sll.get(2));
        sll.add(0, 0);
        // 1 2 20 3 4 5

        Assertions.assertFalse(sll.isEmpty());
        Assertions.assertEquals(7, sll.size());

        Assertions.assertTrue(sll.contains(1));
        Assertions.assertTrue(sll.contains(3));
        Assertions.assertTrue(sll.contains(20));

        Assertions.assertEquals(0, sll.get(0));
        Assertions.assertEquals(1, sll.get(1));
        Assertions.assertEquals(2, sll.get(2));
        Assertions.assertEquals(20, sll.get(3));

        sll.set(2, 2000);
        Assertions.assertEquals(2000, sll.get(2));

        System.out.println();

        Iterator<Integer> itr = sll.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + " ");
        }
        System.out.println();

        Object[] integers = sll.toArray();
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + " ");
        }
        System.out.println();


    }

    @Test
    void hasCircle() {
    }

    @Test
    void add() {
    }

    @Test
    void set() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void reverse() {
    }

    @Test
    void iterator() {
    }
}