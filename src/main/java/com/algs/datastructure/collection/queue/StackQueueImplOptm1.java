package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedListStackImpl;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

/**
 * Use {@link IStack}
 * to implement {@link IQueue}, assure constant time of {@link IQueue#deque()}
 * // TODO: 10/4/22 {@link com.algs.datastructure.collection.queue.StackQueueImplOpt1Test}
 */
public class StackQueueImplOptm1<E> implements IQueue<E> {

    private final IStack<E> h  = new ArrayStackImpl<>();
    private final IStack<E> t  = new LinkedListStackImpl<>();

    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        t.push(item);
        h.push(t.pop());
    }

    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        return h.pop();
    }

    @Override
    public E peek() {
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

    private class StackQueueOpt1Iterator<E> implements Iterator<E> {

        private final Iterator<E> itr1 = (Iterator<E>) h.reverseIterator();
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
        return new StackQueueOpt1Iterator<>();
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
