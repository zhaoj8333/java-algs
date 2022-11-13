package com.algs.algo.sort;

import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.deque.LinkedListDequeImpl;

import java.util.Comparator;

/**
 * Diminishing Increment Sort
 *
 * {@link ShellSortImpl}: reduce the number of Inversion, is improved version of {@link InsertionSortImpl}
 */
public class ShellSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public ShellSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    /**
     * The best step sequence evaluated: the worst complexity O(n^(4/3))
     * 1, 5, 19, 41, 109
     */
    private IDeque<Integer> getSequence() {
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
            if (step >= array.length) {
                break;
            }
            stepSeq.enque(step);
            k++;
        }
        return stepSeq;
    }

    @Override
    public void sort() {
        IDeque<Integer> seq = getSequence();
        int len = array.length;
        while (!seq.isEmpty()) {
            Integer step = seq.dequeTail();
            for (int i = step; i < len; i++) {
                int index = i;
                E e = array[index];
                while ((index - step >= 0) && compareEntry(e, array[index - step]) < 0) {
                    array[index] = array[index - step];
                    index -= step;
                }
                array[index] = e;
            }
        }
    }

}
