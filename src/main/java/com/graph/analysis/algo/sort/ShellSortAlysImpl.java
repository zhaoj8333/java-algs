package com.graph.analysis.algo.sort;

import com.algs.algo.sort.cmp_swp.shellsort.sequence.SedgeWick;
import com.algs.algo.sort.cmp_swp.shellsort.sequence.SequenceGenerator;
import com.algs.datastructure.collection.Iterator;

import java.util.Comparator;

public class ShellSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    private final SequenceGenerator sg;

    public ShellSortAlysImpl(E[] data) {
        this(data, null, new SedgeWick());
    }

    public ShellSortAlysImpl(E[] data, Comparator<E> comparator, SequenceGenerator sg) {
        super(data, comparator);
        this.sg = sg;
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

    private void sort0(int len) {
        Iterator<Integer> itr = sg.getIterator(len);
        while (!itr.hasNext()) {
            Integer h = itr.next();
            for (int i = h; i < len; i++) {
                int index = i;
                E tmp = array[index];
                cost++;
                while ((index - h >= 0) && compareEntry(tmp, array[index - h]) < 0) {
                    swap(index, index - h);
                    index -= h;
                }
            }
            h /= 3;
        }
    }

}
