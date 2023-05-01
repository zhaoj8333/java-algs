package com.algs.datastructure.collection.deque;

import com.algs.datastructure.Iterator;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircularLinkedDequeImplTest {

    @Test
    void test() {
        IDeque<Integer> q = new CircularLinkedDequeImpl<>();
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
    void hasCircle() {
        CircularLinkedDequeImpl<Integer> q = new CircularLinkedDequeImpl<>();
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