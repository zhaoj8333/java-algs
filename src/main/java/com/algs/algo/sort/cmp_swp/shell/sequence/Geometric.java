package com.algs.algo.sort.cmp_swp.shell.sequence;

import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.deque.LinkedListDequeImpl;

public class Geometric extends SequenceGenerator {

    public int step;

    public IDeque<Integer> generate(int max) {
        IDeque<Integer> stepSeq = new LinkedListDequeImpl<>();
        int from = 1;
        while (from < max) {
            stepSeq.enque(from);
            from = from * step;
        }
        return stepSeq;
    }

}
