package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.SinglyLinkNode;

public class CircularLinkedListQueueImpl<E> implements IQueue<E> {

    private int size;
    private SinglyLinkNode<E> head;
    private SinglyLinkNode<E> tail;

    @Override
    public void enque(E item) {

    }

    @Override
    public E deque() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public void add(E item) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E remove(E item) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public void reverse() {

    }

    private static class CircularSinglyLinkedListIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularSinglyLinkedListIterator<>();
    }
}
