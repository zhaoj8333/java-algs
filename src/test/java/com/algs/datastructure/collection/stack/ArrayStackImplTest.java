package com.algs.datastructure.collection.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackImplTest {

    @Test
    void test() {
        IStack<Integer> s = new ArrayStackImpl<>();
        Assertions.assertTrue(s.isEmpty());
//        s.pop();
        Assertions.assertThrows(RuntimeException.class, null);
        for (int i = 0; i < 8; i++) {
            s.push(i);
        }
        Assertions.assertFalse(s.isEmpty());
        Assertions.assertEquals(8, s.size());

        Integer pop = s.pop();
        Assertions.assertEquals(7, pop);
        Assertions.assertEquals(6, s.pop());

        Object[] integers = s.toArray();
        Integer[] ints = new Integer[6];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 3;
        ints[4] = 4;
        ints[5] = 5;
        Assertions.assertArrayEquals(ints, integers);

        s.clear();
        Assertions.assertTrue(s.isEmpty());

//        s.pop();
//        Assertions.assertThrows(RuntimeException.class, null);
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
}