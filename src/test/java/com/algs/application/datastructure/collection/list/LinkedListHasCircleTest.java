package com.algs.application.datastructure.collection.list;

import com.algs.datastructure.collection.queue.CircularLinkedQueueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListHasCircleTest {

    @Test
    void hasCircle() {
        CircularLinkedQueueImpl<Integer> q = new CircularLinkedQueueImpl<>();
        Assertions.assertTrue(q.hasCircle());

        q.enque(1);
        q.enque(2);
        q.enque(3);

        Assertions.assertTrue(q.hasCircle());

    }
}