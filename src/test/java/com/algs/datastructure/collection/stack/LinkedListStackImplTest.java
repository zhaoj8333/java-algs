package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListStackImplTest {

    @Test
    void test() {
        IStack<Integer> s = new LinkedListStackImpl<>();
        Assertions.assertTrue(s.isEmpty());
        Assertions.assertEquals(0, s.size());

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        Assertions.assertFalse(s.isEmpty());
        Assertions.assertEquals(5, s.size());

        Integer top = s.top();
        Assertions.assertEquals(5, top);

        Integer pop = s.pop();
        Assertions.assertEquals(top, pop);
        Assertions.assertEquals(4, s.size());

        Object[] array = s.toArray();
        Integer[] integers = new Integer[4];
        integers[0] = 4;
        integers[1] = 3;
        integers[2] = 2;
        integers[3] = 1;
        Assertions.assertArrayEquals(integers, array);

        Iterator<Integer> itr = s.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }

        s.clear();
        Assertions.assertTrue(s.isEmpty());

    }

    @Test
    void push() {
    }

    @Test
    void pop() {
    }

    @Test
    void top() {
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
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void iterator() {
        IStack<Integer> s = new LinkedListStackImpl<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        Iterator<Integer> itr = s.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    void reverseIterator() {
        IStack<Integer> s = new LinkedListStackImpl<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        Iterator<Integer> itr = s.reverseIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}