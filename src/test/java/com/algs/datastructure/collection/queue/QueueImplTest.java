package com.algs.datastructure.collection.queue;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.deque.ArrayDequeImpl;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.collection.queue.array.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.array.ArrayQueueImpl0;
import com.algs.datastructure.collection.queue.link.CircularLinkedQueueImpl;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueImplTest extends ImplFunctionalityTest {

    protected final Class<?>[] targetClasses = new Class[]{
//            ArrayDequeImpl.class,
            ArrayQueueImpl.class,
            ArrayQueueImpl0.class,
//            CircularLinkedQueueImpl.class,
//            LinkedQueueImpl.class,
//            LinkedQueueImpl0.class,
//            QueuePqImpl.class,
//            StackQueueImpl.class,
//            StackQueueImplOptm.class
    };

    @Override
    protected Class<?>[] getConstructorParameters() {
        return null;
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    @Override
    protected void testEach(Object obj) {
        IQueue<Integer> q = (IQueue<Integer>) obj;
        Assertions.assertTrue(q.isEmpty());
        // 1,2,3,4,5,6,7
        for (int i = 1; i <= 7; i++) {
            q.enque(i);
        }
        Assertions.assertFalse(q.isEmpty());

        Assertions.assertEquals(7, q.size());
        q.deque();
        Assertions.assertEquals(6, q.size());
        q.deque();
        Assertions.assertEquals(5, q.size());
        q.enque(8);
        q.enque(9);
        // 3,4,5,6,7,8,9
        Assertions.assertEquals(7, q.size());

        Object[] array = q.toArray();
        Integer[] ints = new Integer[7];
        ints[0] = 3;
        ints[1] = 4;
        ints[2] = 5;
        ints[3] = 6;
        ints[4] = 7;
        ints[5] = 8;
        ints[6] = 9;
        Assertions.assertArrayEquals(ints, array);

        Iterator<Integer> itr = q.iterator();
        IList<Integer> list = new ResizableArrayImpl<>();
        while (itr.hasNext()) {
            Integer next = itr.next();
            list.add(next);
            System.out.println(next);
        }

        Integer top = q.peek();
        Assertions.assertEquals(3, top);

        Integer p = q.deque();
        Assertions.assertEquals(top, p);
        Assertions.assertEquals(6, q.size());

        q.clear();
        Assertions.assertTrue(q.isEmpty());
        p = q.peek();
        Assertions.assertNull(p);

    }

}
