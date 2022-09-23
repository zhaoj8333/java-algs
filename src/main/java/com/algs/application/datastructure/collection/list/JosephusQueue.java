package com.algs.application.datastructure.collection.list;

import com.algs.datastructure.collection.deque.ArrayDequeImpl;
import com.algs.datastructure.collection.queue.IQueue;

public class JosephusQueue {

    public int[] byUsingQueue(int numberOfPeople, int deathNumber) {
        int[] sequence = new int[numberOfPeople];
        IQueue<Integer> q = new ArrayDequeImpl<>(numberOfPeople);
        for (int i = 1; i <= numberOfPeople; i++) {
            q.enque(i);
        }
        int index = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < deathNumber; i++) {
                q.enque(q.deque());
            }
            sequence[index++] = q.deque();
        }
        return sequence;
    }

    public int[] byUsingCircularLinkedList(int numberOfPeople, int deathNumber) {

        return null;
    }

}
