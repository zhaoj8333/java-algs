package com.algs.datastructure.collection.stack;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.array.ArrayQueueImpl;
import com.algs.utils.CollectionUtil;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraysUtil;
import org.apache.commons.lang.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackImplTest extends ImplFunctionalityTest {

    protected final Class<?>[] targetClasses = new Class[]{
//            ArrayStackImpl.class,
//            DestackImplByDeque.class,
            LinkedStackImpl.class,
//            StackPqImpl.class
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        return null;
    }

    @Override
    protected Class<?>[] getConstructorParameters() {
        return new Class[0];
    }

    @Override
    protected void testEach(Object obj) {
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
        ArraysUtil.reverse(ints);
        Assertions.assertArrayEquals(ints, integers);

        s.clear();
        Assertions.assertTrue(s.isEmpty());

        testReverse();
//        s.pop();
//        Assertions.assertThrows(RuntimeException.class, null);


    }

    @Test
    void testReverse() {
        Integer[] array = ArrayBuilder.randomIntArrayBetween(10, 0, 10);
        IStack<Integer> s = new LinkedStackImpl<>();

        for (Integer i : array) {
            s.push(i);
        }

        CollectionUtil.println(s);

//        s.reverse();

        CollectionUtil.println(s);
    }

    @Test
    void reverseIterator() {
        IStack<Integer> s = new ArrayStackImpl<>();
        for (int i = 0; i < 8; i++) {
            s.push(i);
        }
        Iterator<Integer> itr = s.reverseIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

    @Test
    void _1_3_5() {
        IStack<Integer> s = new ArrayStackImpl<>();
        int n = 50;
        while (n > 0) {
            int i = n % 2;
            s.push(i);
            n = n / 2;
        }
        Iterator<Integer> itr = s.iterator();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            Integer next = itr.next();
            sb.append(next);
        }
        System.out.println(sb);
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }

    @Test
    void _1_3_6() {
        IQueue<Integer> q = new ArrayQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            q.enque(i);
        }
        // q: 0 1 2 3 4 5 6 7 8 9

        IStack<Integer> s = new ArrayStackImpl<>();
        while (!q.isEmpty()) {
            s.push(q.deque());
        }
        while (!s.isEmpty()) {
            q.enque(s.pop());
        }
        System.out.println(q);

    }

    @Test
    void testUnmodifiableIterator() {
        IStack<Integer> s = new ArrayStackImpl<>();
        for (int i = 10; i > 0; i--) {
            s.push(i);
        }
        Iterator<Integer> itr = s.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

}
