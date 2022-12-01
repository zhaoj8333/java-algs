package com.algs.datastructure.collection.heap.pq;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IPriorityQueueTest {

    @Test
    void test() {
        IList<Integer> ints8 = FileUtil.readInts("data/ints/8ints.txt");
        assert ints8 != null;

        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl<>(ints8);
//        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl0<>(ints8);

        test1(pq);

//        ints8 = FileUtil.readInts("data/ints/8ints.txt");
//        assert ints8 != null;
        pq = new ArrayBinaryPqImpl0<>(ints8, (o1, o2) -> o2 - o1);

        test2(pq);

//        LinkedBinaryPqImpl<Integer> linkedPq = new LinkedBinaryPqImpl<>(ints8);
//        test1(linkedPq);
//        linkedPq = new LinkedBinaryPqImpl<>();
//        test2(linkedPq);

    }

    void test1(IPriorityQueue<Integer> pq) {
        Assertions.assertEquals(40, pq.get());
        Assertions.assertEquals(pq.get(), pq.remove());
        Assertions.assertFalse(pq.contains(40));

        pq.replace(31);
        Assertions.assertEquals(31, pq.get());

        pq.add(33);
        Assertions.assertEquals(33, pq.get());

        Integer remove = pq.remove();
        Assertions.assertEquals(33, remove);
        Integer remove1 = pq.remove();
        Assertions.assertEquals(31, remove1);
        Integer remove2 = pq.remove();
        Assertions.assertEquals(15, remove2);
        Integer remove3 = pq.remove();
        Assertions.assertEquals(10, remove3);
        Integer remove4 = pq.remove();
        Assertions.assertEquals(8, remove4);
        Integer remove5 = pq.remove();
        Assertions.assertEquals(0, remove5);
        Integer remove6 = pq.remove();
        Assertions.assertEquals(-10, remove6);
        Integer remove7 = pq.remove();
        Assertions.assertEquals(-20, remove7);
        Integer remove8 = pq.remove();
        Assertions.assertEquals(-30, remove8);

    }

    void test2(IPriorityQueue<Integer> pq) {
        Assertions.assertEquals(-30, pq.get());
        Assertions.assertEquals(pq.get(), pq.remove());
        Assertions.assertFalse(pq.contains(-30));

        pq.replace(-21);
        Assertions.assertEquals(-21, pq.get());

        pq.add(-33);
        Assertions.assertEquals(-33, pq.get());
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void replace() {
    }
}