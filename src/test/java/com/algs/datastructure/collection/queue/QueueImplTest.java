package com.algs.datastructure.collection.queue;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.deque.ArrayDequeImpl;
import com.algs.datastructure.collection.queue.array.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.link.CircularLinkedQueueImpl;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueImplTest extends ImplFunctionalityTest {

    protected final Class<?>[] targetClasses = new Class[]{
            ArrayDequeImpl.class,
            CircularLinkedQueueImpl.class,
            LinkedQueueImpl.class,
            LinkedQueueImpl0.class,
            QueuePqImpl.class,
            StackQueueImpl.class,
            StackQueueImplOptm.class
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        return null;
    }

    @Override
    protected void testEach(Object obj) {

    }

    void enqueue() {
        IQueue<Integer> q = new ArrayQueueImpl<>(10);
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
//        System.out.println(q);
        Integer i1 = q.deque();
//        Assertions.assertEquals(1, i1);
        Integer i2 = q.deque();
//        Assertions.assertEquals(2, i2);
        Integer i3 = q.deque();
        Integer i4 = q.deque();
        Integer i5 = q.deque();

        q.enque(8);
        q.enque(9);

        Object[] array = q.toArray();
        Integer[] ints = new Integer[4];
        ints[0] = 6;
        ints[1] = 7;
        ints[2] = 8;
        ints[3] = 9;

        Assertions.assertArrayEquals(ints, array);
    }

    void dequeue() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Integer item = q.peek();
        Integer de = q.deque();
        Assertions.assertEquals(item, de);
        Assertions.assertEquals(6, q.size());
    }

    void isEmpty() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Integer item = q.peek();

        Assertions.assertFalse(q.isEmpty());
    }

    void contains() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Assertions.assertTrue(q.contains(1));
        Assertions.assertTrue(q.contains(7));
        Assertions.assertFalse(q.contains(10));
    }


    void size() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Integer item = q.peek();

        Assertions.assertFalse(q.isEmpty());
    }

    void clear() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        q.clear();
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertNull(q.peek());
        Assertions.assertNull(q.deque());
    }

    void toArray() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        Assertions.assertTrue(q.isEmpty());
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Object[] integers = q.toArray();
        Integer first = (Integer) integers[0];
        Integer peek = q.peek();
        Assertions.assertEquals(peek, first);
        Assertions.assertEquals(q.size(), integers.length);
    }

    void iterate() {
        IQueue<Integer> q = new ArrayQueueImpl<>(7);
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }

    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }
}
