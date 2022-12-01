package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.SingleLinkNode;

import java.util.Objects;

public class LinkedListBagImpl<E> implements IBag<E> {

    private int size;
    private SingleLinkNode<E> head;

    @Override
    public void add(E item) {
        linkHead(item);
        size++;
    }

    private void linkHead(E item) {
        head = new SingleLinkNode<>(item, head);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int numberOf(E item) {
        int number = 0;
        SingleLinkNode<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(item, node.item)) {
                number ++;
            }
            node = node.next;
        }
        return number;
    }

    @Override
    public boolean contains(E item) {
        return Objects.nonNull(node(item));
    }

    private SingleLinkNode<E> node(E item) {
        SingleLinkNode<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public E remove() {
        return remove(head.item);
    }

    /**
     * use the first to replace the {@link #node(Object)}
     */
    @Override
    public E remove(E item) {
        if (isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
        SingleLinkNode<E> node = node(item);
        if (Objects.isNull(node)) {
            return null;
        }
        E data = node.item;
        SingleLinkNode<E> oldhead = head;
        head = head.next;
        node.item = oldhead.item;
        size --;
        return data;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        SingleLinkNode<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = (E) node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SingleLinkNode<E> node = head;
        while (Objects.nonNull(node)) {
            sb.append("(").append(node.item.toString()).append(") -> ");
            node = node.next;
        }
        return sb.toString();
    }

    private class LinkedListBagIterator<E> implements Iterator<E> {

        private SingleLinkNode<E> node = (SingleLinkNode<E>) head;

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
        return new LinkedListBagIterator<>();
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
