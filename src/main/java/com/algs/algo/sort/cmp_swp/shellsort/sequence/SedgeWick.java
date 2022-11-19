package com.algs.algo.sort.cmp_swp.sequence;

import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.deque.LinkedListDequeImpl;

/**
 * The best step sequence evaluated: the worst complexity O(n^(4/3))
 * 1, 5, 19, 41, 109
 */
public class SedgeWick extends SequenceGenerator {

    @Override
    public IDeque<Integer> generate(int max) {
        IDeque<Integer> stepSeq = new LinkedListDequeImpl<>();
        int k = 0, step;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= max) {
                break;
            }
            stepSeq.enque(step);
            k++;
        }
        return stepSeq;
    }

}
