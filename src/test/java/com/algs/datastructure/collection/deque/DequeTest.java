package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DequeTest {

    @Test
    void test() {

        IDeque<Integer> q = new ArrayDequeImpl<>();
        IDeque<Integer> q1 = new LinkedListDequeImpl<>();
        IDeque<Integer> q2 = new LinkedListDequeImpl0<>();
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertTrue(q1.isEmpty());
        for (int i = 0; i < 3; i++) {
            q.enque(i);
            q1.enque(i);
            q2.enque(i);
        }
        for (int i = 3; i < 5; i++) {
            q.enqueHead(i);
            q1.enqueHead(i);
            q2.enqueHead(i);
        }

        Assertions.assertEquals(5, q.size());
        Assertions.assertEquals(5, q1.size());
        Assertions.assertEquals(5, q2.size());
        Object[] array1 = q1.toArray();
        Assertions.assertEquals(4, array1[0]);
        Object[] array = q.toArray();
        Assertions.assertEquals(4, array[0]);
        Assertions.assertArrayEquals(array, array1);
        Object[] array2 = q2.toArray();
        Assertions.assertEquals(4, array2[0]);
        Assertions.assertArrayEquals(array, array2);

        Assertions.assertTrue(q.contains(0));
        Assertions.assertTrue(q1.contains(0));
        Assertions.assertTrue(q2.contains(0));

        Assertions.assertFalse(q.contains(10));
        Assertions.assertFalse(q1.contains(10));
        Assertions.assertFalse(q2.contains(10));

        Integer d = q.deque();
        Assertions.assertEquals(4, d);
        Integer d1 = q1.deque();
        Assertions.assertEquals(4, d1);
        Integer d2 = q2.deque();
        Assertions.assertEquals(4, d2);

        d = q.dequeTail();
        Assertions.assertEquals(2, d);
        d1 = q1.dequeTail();
        Assertions.assertEquals(2, d1);
        d2 = q2.dequeTail();
        Assertions.assertEquals(2, d2);

    }

    @Test
    void iterate() {
        IDeque<Integer> q2 = new LinkedListDequeImpl0<>();
        for (int i = 0; i < 5; i++) {
            q2.enque(i);
        }
        Iterator<Integer> itr = q2.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }
    }

}
