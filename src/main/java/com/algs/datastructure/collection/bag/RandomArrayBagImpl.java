package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.Iterator;
import com.algs.util.CollectionUtil;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")
public class RandomArrayBagImpl<E> extends ArrayBagImpl<E> {

    private class ArrayIterator<E> implements Iterator<E> {

        private int n = 0;
        public int[] accessSequence = new int[size];

        @Override
        public boolean hasNext() {
            return n <= size - 2;
        }

        @Override
        public E next() {
            int seq = accessSequence[n++];
            return (E) entries[seq];
        }
    }

    @Override
    public Iterator<E> iterator() {
        ArrayIterator<E> itr = new ArrayIterator<>();
        for (int i = 0; i < entries.length; i++) {
            itr.accessSequence[i] = i;
        }
        StdRandom.shuffle(itr.accessSequence);
        return itr;
    }
}
