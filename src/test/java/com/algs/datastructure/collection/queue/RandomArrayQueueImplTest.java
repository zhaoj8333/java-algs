package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RandomArrayQueueImplTest {

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
    void enque() {
    }

    @Test
    void deque() {
        IQueue<Integer> q = new RandomArrayQueueImpl<>();
        Integer[] ints = new Integer[10];
        for (int i = 0; i < 10; i++) {
            q.enque(i);
            ints[i] = i;
        }
        Object[] array = q.toArray();
        Assertions.assertArrayEquals(ints, array);

        for (int i = 0; i < 4; i++) {
            q.enque((i + 1) * 9);
        }
        q.enque(88);
        q.enque(77);

        for (int i = 0; i < 10; i++) {
            Integer peek = q.peek();
//            System.out.println(peek);
        }
        Object[] integers = q.toArray();

        System.out.println(Arrays.toString(integers));
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + ", ");
        }
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

    @Test
    void testDeque() {
    }

    @Test
    void testPeek() {
    }

    @Test
    void testIterator() {
    }

    @Test
    void testIsEmpty() {
    }

    @Test
    void testContains() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove1() {
    }

    @Test
    void testRemove2() {
    }

    @Test
    void testSize() {
    }

    @Test
    void testEnque() {
    }

    @Test
    void testDeque1() {
    }

    @Test
    void testPeek1() {
    }

    @Test
    void testClear() {
    }

    @Test
    void testToArray() {
    }

    @Test
    void testIterator1() {
    }

    @Test
    void testDeque2() {
    }

    @Test
    void testPeek2() {
    }

    @Test
    void testIterator2() {
    }
}