package com.algs.datastructure.collection.steque;

import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * Implemented by DoublyLinkedList
 */
@SuppressWarnings("unchecked")
public class UnboundedLinkedListStequeImpl<E> implements ISteque<E> {

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.item = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        return Objects.nonNull(node(item));
    }

    private Node<E> node(E item) {
        if (Objects.isNull(item)) {
            return null;
        }
        Node<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * enquedFirst <-> oldHead <-> n1 <-> n2 <-> ... <-> n*
     */
    @Override
    public void enqueFirst(E item) {
        ObjectUtil.requireNonNull(item);
        Node<E> oldHead = head;
        head = new Node<>(item, null, oldHead);
        oldHead.prev = head;
        size++;
    }

    /**
     * head <-> n1 <-> n2 <-> ... <-> oldTail <-> enqueuedNode
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        Node<E> node = new Node<>(item, tail, null);
        if (Objects.nonNull(tail)) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * head(dequedNode) <-> null
     * head(dequedNode) <-> n1 <-> n2 <-> ... <-> tail
     */
    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        Node<E> node = head;
        Node<E> next = node.next;
        if (Objects.nonNull(next)) {
            next.prev = null;
        } else {
            tail = null;
        }
        head = next;
        size--;
        return node.item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.item;
    }

    @Override
    public void clear() {
//        Node<E> node = head.next;
//        while (Objects.nonNull(node) && Objects.nonNull(node.data)) {
//            node = null;
//        }
//        size = 0;
        // OR
        while (!isEmpty()) {
            deque();
        }
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Node<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedListQueueIterator<E> implements Iterator<E> {

        private Node<E> node = (Node<E>) head;

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
        return new LinkedListQueueIterator<>();
    }
}
