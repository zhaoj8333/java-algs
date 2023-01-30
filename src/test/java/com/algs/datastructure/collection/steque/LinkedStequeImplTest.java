package com.algs.datastructure.collection.steque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LinkedStequeImplTest {

    @Test
    void test() {
        ISteque<Integer> q = new LinkedStequeImpl<>();
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

        q.enqueFirst(10000);
        Integer peek = q.peek();
        Assertions.assertEquals(10000, peek);

        q.clear();
        Integer peek1 = q.peek();
        Assertions.assertNull(peek1);
        Assertions.assertTrue(q.isEmpty());

        Object[] integers = q.toArray();
        System.out.println(Arrays.toString(integers));

    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
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
    void size() {
    }

    @Test
    void enqueFirst() {
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
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void iterator() {
    }
}