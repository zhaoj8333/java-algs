package com.algs.datastructure.collection.deque;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DequeImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
            ArrayDequeImpl.class,
            CircularLinkedDequeImpl.class,
            LinkedDequeImpl.class,
            LinkedDequeImpl0.class,
    };

    @Override
    protected Class<?>[] getConstructorParameters() {
        return null;
    }

    @Override
    protected void testEach(Object obj) {
        IDeque<Integer> q = (IDeque<Integer>) obj;
        Assertions.assertTrue(q.isEmpty());
        for (int i = 0; i < 3; i++) {
            q.enque(i);
        }
        for (int i = 3; i < 5; i++) {
            q.enqueHead(i);
        }
        Assertions.assertEquals(5, q.size());
        Object[] array = q.toArray();
        Assertions.assertEquals(4, array[0]);

        Assertions.assertTrue(q.contains(0));
        Assertions.assertFalse(q.contains(10));

        Integer d1 = q.deque();
        Assertions.assertEquals(4, d1);

        Integer d2 = q.dequeTail();
        Assertions.assertEquals(2, d2);

        enqueueHead(q);
        dequeueTail(q);
        enqueueHead(q);
        dequeue(q);
        iterate(q);
        enqueue(q);
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    public void enqueueHead(IDeque<Integer> q) {
        q.enque(-1);
        q.enque(-2);
        for (int i = 0; i < 3; i++) {
            q.enqueHead(i);
        }

        Object[] array = q.toArray();
        Integer first = q.peek();
        Assertions.assertEquals(array[0], first);

    }

    public void dequeueTail(IDeque<Integer> q) {
        q.enque(-1);
        q.enque(-2);
        for (int i = 0; i < 3; i++) {
            q.enqueHead(i);
        }

        Object last = q.peekTail();
        Object deq = q.dequeTail();
        Assertions.assertEquals(last, deq);

        Object[] array = q.toArray();
        Integer first = q.peek();
        Assertions.assertEquals(array[0], first);

        while (!q.isEmpty()) {
            q.dequeTail();
        }
        Assertions.assertTrue(q.isEmpty());
    }

    public void enqueue(IDeque<Integer> q) {
        for (int i = 0; i < 10; i++) {
            q.enque(i);
        }
        IDeque<Integer> q1 = q;
        Assertions.assertEquals(10, q.size());
        Assertions.assertEquals(0, q.peek());

        q.enque(11);
        Assertions.assertThrows(RuntimeException.class, null);
    }

    public void dequeue(IDeque<Integer> q) {
        for (int i = 0; i < 10; i++) {
            q.enque(i);
        }
        Integer d1 = q.deque();
        Assertions.assertEquals(0, d1);
        Assertions.assertEquals(9, q.size());
        Integer d2 = q.deque();
        Assertions.assertEquals(1, d2);
        Assertions.assertEquals(8, q.size());

        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        Assertions.assertTrue(q.isEmpty());
        q.clear();
        Assertions.assertTrue(q.isEmpty());

    }

    public void iterate(IDeque<Integer> q) {
        for (int i = 0; i < 10; i++) {
            q.enque(i);
        }
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }
    }

}