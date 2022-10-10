package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.util.CollectionUtil;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

@SuppressWarnings("unchecked")
public class RandomArrayQueueImpl<E> extends ArrayQueueImpl<E> {

    @Override
    public E deque() {
        int randomIndex = randomIndex();
        int lastIndex = (headIndex + size - 1) % entries.length;
        E randomEntry = entries[randomIndex];
        entries[randomIndex] = entries[lastIndex];
        entries[lastIndex] = null;
        size--;
        return randomEntry;
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
        public int[] randomSequence = new int[size];

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
        StdRandom.shuffle(itr.randomSequence);
        return itr;
    }
}
