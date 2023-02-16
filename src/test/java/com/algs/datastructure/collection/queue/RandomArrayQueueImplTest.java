package com.algs.datastructure.collection.queue;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.queue.array.RandomArrayQueueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RandomArrayQueueImplTest {

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

}