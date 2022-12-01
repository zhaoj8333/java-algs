package com.algs.algo.sort.array.cmp_swp.shell.sequence;

import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.deque.LinkedListDequeImpl;

public class N3Plus1 extends SequenceGenerator {

    public IDeque<Integer> generate(int max) {
        IDeque<Integer> stepSeq = new LinkedListDequeImpl<>();
        int seq = 1;
        while (seq < max) {
            stepSeq.enque(seq);
            seq = seq * 3 + 1;
        }
        return stepSeq;
    }

}
