package com.algs.datastructure.collection.queue.array;

import com.algs.datastructure.collection.Iterator;
import com.algs.utils.array.ArraysUtil;

import java.util.Random;

@SuppressWarnings("unchecked")
public class RandomArrayQueueImpl<E> extends ArrayQueueImpl<E> {

    @Override
    public E deque() {
        int ri = randomIndex();
        int li = (headIndex + size - 1) % entries.length;
        E entry = entries[ri];
        entries[ri] = entries[li];
        entries[li] = null;
        size--;
        return entry;
    }

    private int randomIndex() {
        Random r = new Random();
        return (headIndex + r.nextInt(size)) % entries.length;
    }

    @Override
    public E peek() {
        return entries[randomIndex()];
    }

    private class RandomArrayQueueIterator<E> implements Iterator<E> {

        private int n = 0;
        public Integer[] randomSequence = new Integer[size];

        @Override
        public boolean hasNext() {
            return n < size;
        }

        @Override
        public E next() {
            return (E) entries[randomSequence[n++]];
        }
    }

    @Override
    public Iterator<E> iterator() {
        RandomArrayQueueIterator<E> itr = new RandomArrayQueueIterator<>();
        for (int i = 0; i < size; i++) {
            itr.randomSequence[i] = i;
        }
        ArraysUtil.shuffle(itr.randomSequence);
        return itr;
    }
}
