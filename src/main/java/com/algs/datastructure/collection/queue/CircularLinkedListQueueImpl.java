package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.SinglyLinkNode;
import com.algs.datastructure.collection.list.ILinkedList;

import java.util.Objects;

public class CircularLinkedListQueueImpl<E> implements ILinkedList<E> {

    private int size;
    private SinglyLinkNode<E> head;
    private SinglyLinkNode<E> tail;

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public void add(int index, E item) {
        SinglyLinkNode<E> prev = node(index - 1);

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
        return -1;
    }

    private SinglyLinkNode<E> node(int index) {
        if (index < -1) {
            return null;
        }
        return null;
    }

    @Override
    public void reverse() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) > CollectionDefaultValues.ELEMENT_NOT_FOUND;
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
