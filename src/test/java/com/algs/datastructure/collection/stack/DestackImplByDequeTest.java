package com.algs.datastructure.collection.stack;

import com.algs.datastructure.Iterator;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DestackImplByDequeTest {

    @Test
    void test() {
        DestackImplByDeque<Integer> destack = new DestackImplByDeque<>();
        assertEmpty(destack);
        assertSize(destack, 0, 0);
        for (int i = 4; i > 0; i--) {
            destack.pushLeft(i);
        }
        destack.popLeft();
        assertSize(destack, 3, 0);
        assertLeftNonEmpty(destack);

        for (int i = 500; i > 0; i-= 100) {
            destack.pushRight(i);
        }
        assertSize(destack, 3, 5);
        assertRightNonEmpty(destack);

        Assertions.assertEquals(2, destack.topLeft());
        Assertions.assertEquals(100, destack.topRight());

        destack.pushLeft(1);
        Object[] integers = destack.toArray();
        System.out.println(Arrays.toString(integers));

        Iterator<Integer> itr = destack.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

    }

    void assertSize(DestackImplByDeque<Integer> destack, int leftSize, int rightSize) {
        Assertions.assertEquals(leftSize + rightSize, destack.size());
        Assertions.assertEquals(leftSize, destack.leftSize());
        Assertions.assertEquals(rightSize, destack.rightSize());
    }

    void assertEmpty(DestackImplByDeque<Integer> destack) {
        Assertions.assertTrue(destack.isEmpty());
        Assertions.assertTrue(destack.isLeftEmpty());
        Assertions.assertTrue(destack.isRightEmpty());
    }

    void assertLeftNonEmpty(DestackImplByDeque<Integer> destack) {
        Assertions.assertFalse(destack.isEmpty());
        Assertions.assertFalse(destack.isLeftEmpty());
    }

    void assertRightNonEmpty(DestackImplByDeque<Integer> destack) {
        Assertions.assertFalse(destack.isEmpty());
        Assertions.assertFalse(destack.isRightEmpty());
    }
}