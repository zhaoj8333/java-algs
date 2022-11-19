package com.algs.algo.sort.cmp_swp.shellsort;

import com.algs.algo.sort.cmp_swp.CompareAndSwapSort;
import com.algs.algo.sort.cmp_swp.InsertionSortImpl;
import com.algs.algo.sort.cmp_swp.shellsort.sequence.SedgeWick;
import com.algs.algo.sort.cmp_swp.shellsort.sequence.SequenceGenerator;
import com.algs.datastructure.collection.Iterator;

import java.util.Comparator;

/**
 * Diminishing Increment Sort
 *
 * {@link ShellSortImpl}: reduce the number of Inversion, is improved version of {@link InsertionSortImpl}
 */
public class ShellSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    private final SequenceGenerator sg;

    public ShellSortImpl(E[] array, Comparator<E> comparator, SequenceGenerator sg) {
        super(array, comparator);
        this.sg = sg;
    }

    public ShellSortImpl(E[] array, Comparator<E> comparator) {
        this(array, comparator, new SedgeWick());
    }

    @Override
    public void sort() {
        Iterator<Integer> itr = this.sg.getIterator(array.length);
        int len = array.length;
        while (!itr.hasNext()) {
            Integer step = itr.next();
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
