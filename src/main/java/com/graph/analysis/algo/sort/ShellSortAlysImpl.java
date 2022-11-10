package com.graph.analysis.algo.sort;

import java.util.Comparator;

public class ShellSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public ShellSortAlysImpl(E[] data, Comparator<E> comparator) {
        super(data, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len < 2) {
            cost++;
            return;
        }
        sort0(len);
    }

    private int generateH(int len) {
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
            cost++;
        }
        return h;
    }

    private void sort0(int len) {
        int h = generateH(len);
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int index = i;
                E tmp = array[index];
                cost++;
                while ((index - h >= 0) && compareEntry(tmp, array[index - h]) > 0) {
                    swap(index, index - h);
                    index -= h;
                }
            }
            h /= 3;
        }
    }

}
