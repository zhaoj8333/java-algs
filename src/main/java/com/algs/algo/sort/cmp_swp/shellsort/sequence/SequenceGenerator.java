package com.algs.algo.sort.cmp_swp.sequence;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.deque.IDeque;

public abstract class SequenceGenerator {

    abstract IDeque<Integer> generate(int max);

    class SequenceIterator implements Iterator<Integer> {

        private final IDeque<Integer> seq;

        public SequenceIterator(int max) {
            this.seq = generate(max);
        }

        @Override
        public boolean hasNext() {
            return seq.isEmpty();
        }

        @Override
        public Integer next() {
            return seq.dequeTail();
        }

    }

    public final Iterator<Integer> getIterator(int max) {
        return new SequenceIterator(max);
    }

}
