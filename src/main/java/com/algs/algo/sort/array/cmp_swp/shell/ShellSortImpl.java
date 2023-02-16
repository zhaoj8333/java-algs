package com.algs.algo.sort.array.cmp_swp.shell;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;
import com.algs.algo.sort.array.cmp_swp.InsertionSortImpl;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.SedgeWick;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.SequenceGenerator;
import com.algs.datastructure.Iterator;

import java.util.Comparator;

/**
 * Diminishing Increment Sort
 *
 * {@link ShellSortImpl}: reduce the number of Inversion, is improved version of {@link InsertionSortImpl}
 */
public class ShellSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    private final SequenceGenerator sg;

    public ShellSortImpl(E[] array, Comparator<E> comparator, SequenceGenerator sg) {
        super(array, comparator);
        this.sg = sg;
    }

    public ShellSortImpl(E[] array, Comparator<E> comparator) {
        this(array, comparator, new SedgeWick());
    }

    public ShellSortImpl(E[] array) {
        this(array, null);
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
