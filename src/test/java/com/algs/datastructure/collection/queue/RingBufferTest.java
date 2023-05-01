package com.algs.datastructure.collection.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RingBufferTest {

    @Test
    void test() {
        RingBuffer<Integer> bf = new RingBuffer<Integer>(10);
        Assertions.assertTrue(bf.isEmpty());
        Assertions.assertEquals(0, bf.size());

        bf.write(0);
        Assertions.assertFalse(bf.isEmpty());
        Assertions.assertEquals(1, bf.size());

        bf.read();

        Assertions.assertEquals(0, bf.size());

        for (int i = 0; i < 10; i++) {
            bf.write(i);
        }
//        bf.write(9);
//        bf.write(10);
        Integer read = bf.read();
        Assertions.assertEquals(0, read);

    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void isFull() {
    }

    @Test
    void read() {
    }
}