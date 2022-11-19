package com.algs.algo.sort;

import com.algs.util.ArraysUtil;
import jdk.jfr.Label;

import java.util.Comparator;

@Label("Very Slow")
public class DequeueSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public DequeueSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        System.out.println("-: " + ArraysUtil.toString(array));

        for (int i = 0; i < len; i++) {
            if (compareIndex(0, 1) < 0) {
                swap(0, 1);
            }
            pushFirstToBottom();
        }

        System.out.println("-: " + ArraysUtil.toString(array));
    }

    private void pushFirstToBottom() {
        E first = array[0];
        for (int j = 0; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        array[array.length - 1] = first;
    }
}
