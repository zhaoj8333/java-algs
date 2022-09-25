package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.ILinkedList;

public class CircularLinkedListDequeImpl<E> implements ILinkedList<E> {

    private int size;
    private DoublyLinkNode<E> head;
    private DoublyLinkNode<E> tail;

    @Override
    public void add(int index, E item) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E item) {

    }

    @Override
    public int indexOf(E item) {
        return 0;
    }

    @Override
    public void reverse() {

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
    public boolean hasCircle() {
        return false;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    private static class CircularDoublyLinkedListIterator<E> implements Iterator<E> {

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
        return new CircularDoublyLinkedListIterator<>();
    }
}
