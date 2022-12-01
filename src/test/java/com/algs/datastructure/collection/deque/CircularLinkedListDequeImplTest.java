package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CircularLinkedListDequeImplTest {

    @Test
    void test() {
        IDeque<Integer> q = new CircularLinkedListDequeImpl<>();
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertEquals(0, q.size());

        q.enque(1);
        Assertions.assertEquals(1, q.size());

        q.enque(2);
        q.enque(3);
        Assertions.assertEquals(3, q.size());

        Integer deque = q.deque();
        Assertions.assertEquals(2, q.size());
        Assertions.assertEquals(1, deque);

        // head 1 2 tail
        q.enqueHead(0);
        Assertions.assertEquals(0, q.peek());
        Assertions.assertEquals(0, q.peekHead());
        Assertions.assertEquals(3, q.peekTail());

        // head 0 2 3 tail
        Integer integer = q.dequeTail();
        Assertions.assertEquals(3, integer);
        q.enque(4);
        q.enque(5);
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        Object[] integers = q.toArray();
        System.out.println(Arrays.toString(integers));

        q.clear();
        Assertions.assertTrue(q.isEmpty());

    }

    @Test
    void enqueHead() {
    }

    @Test
    void dequeHead() {
    }

    @Test
    void enqueTail() {
    }

    @Test
    void dequeTail() {
    }

    @Test
    void peekHead() {
    }

    @Test
    void peekTail() {
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
    void get() {
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

    @Test
    void hasCircle() {
        CircularLinkedListDequeImpl<Integer> q = new CircularLinkedListDequeImpl<>();
        Assertions.assertTrue(q.hasCircle());

        q.enque(1);
        Assertions.assertTrue(q.hasCircle());
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);

        q.deque();
        Assertions.assertTrue(q.hasCircle());

        q.dequeTail();
        Assertions.assertTrue(q.hasCircle());

        q.enqueHead(10);
        q.enqueHead(20);
        Assertions.assertTrue(q.hasCircle());

        q.dequeTail();
        Assertions.assertTrue(q.hasCircle());


    }
}