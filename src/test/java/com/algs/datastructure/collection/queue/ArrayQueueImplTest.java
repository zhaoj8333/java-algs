package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayQueueImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void enqueue() {
        IQueue<Integer> q = new ArrayQueueImpl<>(10);
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
//        System.out.println(q);
        Integer i1 = q.deque();
//        Assertions.assertEquals(1, i1);
        Integer i2 = q.deque();
//        Assertions.assertEquals(2, i2);
        Integer i3 = q.deque();
        Integer i4 = q.deque();
        Integer i5 = q.deque();

        q.enque(8);
        q.enque(9);

        Object[] array = q.toArray();
        Integer[] ints = new Integer[4];
        ints[0] = 6;
        ints[1] = 7;
        ints[2] = 8;
        ints[3] = 9;

        Assertions.assertArrayEquals(ints, array);
    }

    @Test
    void dequeue() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Integer item = q.peek();
        Integer de = q.deque();
        Assertions.assertEquals(item, de);
        Assertions.assertEquals(6, q.size());
    }

    @Test
    void isEmpty() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Integer item = q.peek();

        Assertions.assertFalse(q.isEmpty());
    }

    @Test
    void contains() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Assertions.assertTrue(q.contains(1));
        Assertions.assertTrue(q.contains(7));
        Assertions.assertFalse(q.contains(10));
    }


    @Test
    void size() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Integer item = q.peek();

        Assertions.assertFalse(q.isEmpty());
    }

    @Test
    void peek() {
    }

    @Test
    void clear() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        q.clear();
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertNull(q.peek());
        Assertions.assertNull(q.deque());
    }

    @Test
    void toArray() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Object[] integers = q.toArray();
        Integer first = (Integer) integers[0];
        Integer peek = q.peek();
        Assertions.assertEquals(peek, first);
        Assertions.assertEquals(q.size(), integers.length);
    }

    @Test
    void iterate() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }

    }
}