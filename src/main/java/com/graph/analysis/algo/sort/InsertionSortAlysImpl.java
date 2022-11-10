package com.graph.analysis.algo.sort;

import java.util.Comparator;

public class InsertionSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public InsertionSortAlysImpl(E[] data, Comparator<E> comparator) {
        super(data, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len < 2) {
            cost++;
            return;
        }
//        sort0(len);
        sort2(len);
    }

    private void sort2(int len) {
        for (int i = 1; i < len; i++) {
            insert(i, binarySearch(i));
        }
    }

    private int binarySearch(int i) {
        E e = array[i];
        cost++;
        int begin = 0;
        int end = i;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (compareEntry(e, array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
            cost++;
        }
        return begin;
    }

    private void insert(int index, int dest) {
        E tmp = array[index];
        int count = 0;
        for (int i = index; i > dest; i--) {
            array[i] = array[i - 1];
            count++;
        }
        array[dest] = tmp;
        count++;
        swapCount = count / 2;
    }

    private void sort1(int len) {
        for (int i = 0; i < len; i++) {
            int index = i;
            E tmp = array[index];
            int swap = 0;
            while (index > 0 && compareEntry(tmp, array[index - 1]) < 0) {
                array[index] = array[index - 1];
                index--;
                swap ++;
            }
            array[index] = tmp;
            swapCount += swap;
            swapCount++;
            cost++;
        }
    }

    private void sort0(int len) {
        for (int i = 0; i < len; i++) {
            int index = i;
            E tmp = array[index];
            while (index > 0 && compareEntry(tmp, array[index - 1]) < 0) {
                swap(index, index - 1);
                index--;
            }
        }
    }

}
