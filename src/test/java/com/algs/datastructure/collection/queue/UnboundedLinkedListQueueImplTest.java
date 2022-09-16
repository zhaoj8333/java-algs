package com.algs.datastructure.collection.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnboundedLinkedListQueueImplTest {

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
        IQueue<Integer> q = new UnboundedLinkedListQueueImpl<>();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);

        Assertions.assertTrue(q.contains(5));

    }

    @Test
    void add() {
        IQueue<Integer> q = new UnboundedLinkedListQueueImpl<>();
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
        IQueue<Integer> q = new UnboundedLinkedListQueueImpl<>();
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
        IQueue<Integer> q = new UnboundedLinkedListQueueImpl<>();
        Assertions.assertTrue(q.isEmpty());
        q.enque(1);
        Integer i = q.deque();
        Assertions.assertEquals(1, i);
        Assertions.assertTrue(q.isEmpty());
        q.enque(1);
        Assertions.assertEquals(1, q.size());
        q.enque(2);
        Assertions.assertEquals(2, q.size());
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.enque(6);

        Object[] integers = q.toArray();

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
}