package com.algs.datastructure.collection.heap;

import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.collection.heap.pq.IPriorityQueue;

import java.util.Random;

public class ArrayBinaryPqPerformance extends StopWatchTask {

    private final int size;
    private final IPriorityQueue<Integer> pq;
    private final Random r = new Random();

    public ArrayBinaryPqPerformance(int size, IPriorityQueue<Integer> pq) {
        this.size = size;
        this.pq = pq;
    }

    @Override
    protected Object profileTask() {
//        return _36();
        return _37();
    }

    private Object _37() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            pq.remove();
            pq.add(r.nextInt(1000000000));
            count++;
        }
        return count;
    }

    private Object _36() {
        for (int i = 0; i < size; i++) {
            pq.add(i);
        }
        for (int i = 0; i < size / 2; i++) {
            pq.remove();
        }
        for (int i = size / 2; i < size; i++) {
            pq.add(i);
        }
        for (int i = 0; i < size; i++) {
            pq.remove();
        }
        return null;
    }

    @Override
    protected void assertResult() {

    }
}
