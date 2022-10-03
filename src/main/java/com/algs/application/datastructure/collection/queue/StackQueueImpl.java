package com.algs.application.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedListStackImpl;
import com.algs.util.CollectionUtil;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * Use {@link com.algs.datastructure.collection.stack.IStack}
 * to implement {@link com.algs.datastructure.collection.queue.IQueue}
 */
public class StackQueueImpl<E> implements IQueue<E> {

    private final IStack<E> h = new ArrayStackImpl<>();
    private final IStack<E> t = new LinkedListStackImpl<>();

    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        t.push(item);
    }

    /**
     * Worst complexity is O(n)
     */
    @Override
    public E deque() {
        if (h.isEmpty()) {
            while (!t.isEmpty()) {
                h.push(t.pop());
            }
        }
        return h.pop();
    }

    @Override
    public E peek() {
        if (h.isEmpty()) {
            while (!t.isEmpty()) {
                h.push(t.pop());
            }
        }
        return h.top();
    }

    @Override
    public int size() {
        return h.size() + t.size();
    }

    @Override
    public boolean isEmpty() {
        return h.size() + t.size() == 0;
    }

    @Override
    public boolean contains(E item) {
        Iterator<E> itr = h.iterator();
        while (itr.hasNext()) {
            if (Objects.equals(itr.next(), item)) {
                return true;
            }
        }
        itr = t.iterator();
        while (itr.hasNext()) {
            if (Objects.equals(itr.next(), item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        h.clear();
        t.clear();
    }

    @Override
    public E[] toArray() {
        int size = h.size() + t.size();
        E[] array = (E[]) new Object[size];
        Iterator<E> itr = h.iterator();
        int index = 0;
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }
        itr = t.reverseIterator();
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }
        return array;
    }

    @Override
    public String toString() {
        return CollectionUtil.toString(this);
    }

    private class StackQueueIterator<E> implements Iterator<E> {

        private final Iterator<E> itr1 = (Iterator<E>) h.iterator();
        private final Iterator<E> itr2 = (Iterator<E>) t.reverseIterator();

        @Override
        public boolean hasNext() {
            return itr1.hasNext() || itr2.hasNext();
        }

        @Override
        public E next() {
            if (itr1.hasNext()) {
                return itr1.next();
            }
            if (itr2.hasNext()) {
                return itr2.next();
            }
            return null;
        }
    }

    @Override
    public final Iterator<E> iterator() {
        return new StackQueueIterator<>();
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void add(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final E remove(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

}
