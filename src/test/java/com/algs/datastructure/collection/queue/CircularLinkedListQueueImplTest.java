package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CircularLinkedListQueueImplTest {

    @Test
    void test() {
        IQueue<Integer> q = new CircularLinkedListQueueImpl<>();
        Assertions.assertTrue(q.isEmpty());

        q.enque(1);
        Assertions.assertEquals(1, q.size());
        q.enque(2);
        q.enque(3);
        q.enque(4);

//        Assertions.assertEquals(4, q.get(3));
//        Assertions.assertTrue(q.contains(4));

        /*
         *  1 2 3 4
         */
        Object[] integers = q.toArray();
        System.out.println(Arrays.toString(integers));

        Integer deque = q.deque();
        Assertions.assertEquals(1, deque);
        deque = q.deque();
        Assertions.assertEquals(2, deque);
        deque = q.deque();
        Assertions.assertEquals(3, deque);
        deque = q.deque();
        Assertions.assertEquals(4, deque);

        Assertions.assertTrue(q.isEmpty());

        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);

        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + " ");
        }
        System.out.println();

    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void reverse() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
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
    void hasCircle() {

    }

    @Test
    void toArray() {
    }

    @Test
    void iterator() {
    }
}