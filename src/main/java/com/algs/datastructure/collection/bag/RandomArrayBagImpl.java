package com.algs.datastructure.collection.bag;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.utils.array.ArraysUtil;

@SuppressWarnings("unchecked")
public class RandomArrayBagImpl<E> extends ArrayBagImpl<E> {

    public RandomArrayBagImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public RandomArrayBagImpl(int size) {
        super(size);
    }

    private class RandomArrayBagIterator<E> implements Iterator<E> {

        private int n = 0;
        public Integer[] seq = new Integer[size];

        @Override
        public boolean hasNext() {
            return n < size;
        }

        @Override
        public E next() {
            int seq = this.seq[n++];
            return (E) entries[seq];
        }
    }

    @Override
    public Iterator<E> iterator() {
        RandomArrayBagIterator<E> itr = new RandomArrayBagIterator<>();
        for (int i = 0; i < size; i++) {
            itr.seq[i] = i;
        }
        ArraysUtil.shuffle(itr.seq);
        return itr;
    }

}
