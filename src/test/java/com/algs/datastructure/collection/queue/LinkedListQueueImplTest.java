package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LinkedListQueueImplTest {

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
        IQueue<Integer> q = new LinkedListQueueImpl<>();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);

        Assertions.assertTrue(q.contains(5));

    }

    @Test
    void add() {
        IQueue<Integer> q = new LinkedListQueueImpl<>();
        q.add(1);
        Assertions.assertThrowsExactly(RuntimeException.class, null);
    }

    @Test
    void remove() {
    }

    @Test
    void size() {
    }

    @Test
    void enqueue() {
        IQueue<Integer> q = new LinkedListQueueImpl<>();
        Assertions.assertTrue(q.isEmpty());
        q.enque(1);
        Assertions.assertFalse(q.isEmpty());
        Assertions.assertEquals(1, q.size());
        q.enque(2);
        Assertions.assertEquals(2, q.size());
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.enque(6);

        Object[] integers = q.toArray();
        for (int i = 1; i <= integers.length; i++) {
            Assertions.assertEquals(i, (Integer) integers[i - 1]);
        }
    }

    @Test
    void dequeue() {
        IQueue<Integer> q = new LinkedListQueueImpl0<>();
        Assertions.assertTrue(q.isEmpty());
        q.enque(1);
        q.deque();
        Assertions.assertTrue(q.isEmpty());
        q.enque(1);
        Assertions.assertEquals(1, q.size());
        q.enque(2);
        Assertions.assertEquals(2, q.size());
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.enque(6);

        Assertions.assertEquals(6, q.size());

        q.deque();
        Assertions.assertEquals(5, q.size());
        Assertions.assertEquals(2, q.peek());
        q.deque();
        q.deque();
        q.deque();

        for (int i = 0; i < 4; i++) {
            q.enque((i + 1) * 1000);
        }

        Integer peek = q.peek();
        Assertions.assertEquals(5, peek);

        q.clear();
        Integer peek1 = q.peek();
        Assertions.assertNull(peek1);
        Assertions.assertTrue(q.isEmpty());

        Object[] integers = q.toArray();
        System.out.println(Arrays.toString(integers));

    }

    @Test
    void peek() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void iterate() {
        IQueue<Integer> q = new LinkedListQueueImpl<>();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.enque(6);

        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }
    }
}