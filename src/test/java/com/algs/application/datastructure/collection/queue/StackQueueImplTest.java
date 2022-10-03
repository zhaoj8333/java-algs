package com.algs.application.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackQueueImplTest {

    @Test
    void test() {
        IQueue<Integer> q = new StackQueueImpl<>();
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertEquals(0, q.size());

        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        int ele = 6;
//        assertTrue(q.contains(ele));

        int expectedSize = 7;

        Integer deq3 = q.deque();
        int expectedVal = 1;
        assertEquals((int) deq3, expectedVal);

        q.enque(8);
        q.enque(9);
        expectedSize = 8;

//        assertEquals(2, q.deque());
//        assertEquals(3, q.deque());
//        assertEquals(4, q.deque());
//        assertEquals(5, q.deque());
//        assertEquals(6, q.deque());
//        assertEquals(7, q.deque());
//        assertEquals(8, q.deque());
//        assertEquals(9, q.deque());

        itr = q.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        Object[] array1 = q.toArray();
        Integer[] ints = new Integer[8];
        ints[0] = 2;
        ints[1] = 3;
        ints[2] = 4;
        ints[3] = 5;
        ints[4] = 6;
        ints[5] = 7;
        ints[6] = 8;
        ints[7] = 9;

        assertArrayEquals(ints, array1);
    }

    @Test
    void testReverseIterator() {
        IQueue<Integer> q = new StackQueueImpl<>();
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }

        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    @Test
    void enque() {
    }

    @Test
    void deque() {
    }

    @Test
    void peek() {
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
    void get() {
    }

    @Test
    void add() {
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