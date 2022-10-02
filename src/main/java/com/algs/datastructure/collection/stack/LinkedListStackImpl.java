package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.SinglyLinkNode;
import com.algs.util.ObjectUtil;

import java.util.Arrays;
import java.util.Objects;

public class LinkedListStackImpl<E> implements IStack<E> {

    private int size;
    private SinglyLinkNode<E> top;

    /**
     * newTop -> oldTop -> n1 -> ... -> n
     */
    @Override
    public void push(E item) {
        ObjectUtil.requireNonNull(item);
        top = new SinglyLinkNode<>(item, top);
        size++;
    }

    /**
     * oldTop -> newTop -> n1 -> ... -> n
     */
    @Override
    public E pop() {
        ObjectUtil.requireNonEmpty(this);
        SinglyLinkNode<E> node = top;
        top = node.next;
        size--;
        return node.item;
    }

    @Override
    public E top() {
        return top.item;
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
        return Objects.nonNull(node(item));
    }

    private SinglyLinkNode<E> node(E item) {
        SinglyLinkNode<E> node = top;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        SinglyLinkNode<E> node = top;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    private class LinkedListStackIterator<E> implements Iterator<E> {

        private SinglyLinkNode<E> node = (SinglyLinkNode<E>) top;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(node);
        }

        @Override
        public E next() {
            E item = node.item;
            node = node.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator<>();
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
