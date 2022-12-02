package com.algs.datastructure.collection.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinglyQueuesTest {

    IQueue<Integer> arrayQ = new ArrayQueueImpl<>(10);
    IQueue<Integer> llQ = new LinkedListQueueImpl<>();
    IQueue<Integer> llQ0 = new LinkedListQueueImpl0<>();

    @Test
    void test() {
        for (int i = 1; i <= 7; i++) {
            arrayQ.enque(i);
            llQ.enque(i);
            llQ0.enque(i);
        }

        int ele = 6;
        Assertions.assertTrue(arrayQ.contains(ele));
        Assertions.assertTrue(llQ.contains(ele));
        Assertions.assertTrue(llQ0.contains(ele));

        int expectedSize = 7;
        Assertions.assertTrue(arrayQ.size() == llQ.size() && llQ.size() == llQ0.size() && arrayQ.size() == expectedSize);

        Integer deq1 = arrayQ.deque();
        Integer deq2 = llQ.deque();
        Integer deq3 = llQ0.deque();
        int expectedVal = 1;
        Assertions.assertTrue(deq1 == expectedVal && deq2 == expectedVal && deq3 == expectedVal);

        arrayQ.enque(8);
        arrayQ.enque(9);
        llQ.enque(8);
        llQ.enque(9);
        llQ0.enque(8);
        llQ0.enque(9);
        expectedSize = 8;
        Assertions.assertTrue(arrayQ.size() == llQ.size() && llQ.size() == llQ0.size() && arrayQ.size() == expectedSize);

        Object[] array1 = arrayQ.toArray();
        Integer[] ints = new Integer[8];
        ints[0] = 2;
        ints[1] = 3;
        ints[2] = 4;
        ints[3] = 5;
        ints[4] = 6;
        ints[5] = 7;
        ints[6] = 8;
        ints[7] = 9;

        Assertions.assertArrayEquals(ints, array1);

    }

}
