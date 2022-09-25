package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;

public class CircularLinkedListDequeImpl<E> implements IDeque<E> {

    private int size;
    private DoublyLinkNode<E> head;
    private DoublyLinkNode<E> tail;

    @Override
    public void enqueHead(E item) {

    }

    @Override
    public E dequeHead() {
        return null;
    }

    @Override
    public void enqueTail(E item) {

    }

    @Override
    public E dequeTail() {
        return null;
    }

    @Override
    public E peekHead() {
        return null;
    }

    @Override
    public E peekTail() {
        return null;
    }

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
