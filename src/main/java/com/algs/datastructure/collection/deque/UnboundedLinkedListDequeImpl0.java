package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.queue.UnboundedLinkedListQueueImpl;
import com.algs.util.ObjectUtil;

import java.util.Objects;

public class UnboundedLinkedListDequeImpl0<E> implements IDeque<E> {

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private final Node<E> head = new Node<>(null, null, null);
    private final Node<E> tail = new Node<>(null, null, null);

    public UnboundedLinkedListDequeImpl0() {
        head.next = tail;
        tail.prev = head;
    }

    /**
     * head <-> enquedNode(oldHead) <-> tail
     */
    @Override
    public void enqueHead(E item) {
        ObjectUtil.requireNonNull(item);
        Node<E> next = head.next;
        Node<E> node = new Node<>(item, head, next);
        head.next = node;
        next.prev = node;
        size++;
    }

    /**
     * head <-> dequedNode <-> n2 <-> tail
     */
    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        Node<E> node = head.next;
        node.next.prev = head;
        head.next = node.next;
        size--;
        return node.item;
    }

    /**
     * head <-> ... <-> n2 <-> enqueuedNode <-> tail
     */
    @Override
    public void enqueTail(E item) {
        ObjectUtil.requireNonNull(item);
        Node<E> prev = tail.prev;
        Node<E> node = new Node<>(item, prev, tail);
        prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * head <-> n1 <-> ... <-> prev <-> dequedNode <-> tail
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        Node<E> node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        size--;
        return node.item;
    }

    @Override
    public E peekHead() {
        return head.item;
    }

    @Override
    public E peekTail() {
        return tail.item;
    }

    @Override
    public void enque(E item) {
        enqueTail(item);
    }

    @Override
    public E deque() {
        return dequeHead();
    }

    @Override
    public E peek() {
        return peekHead();
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

    private Node<E> node(E item) {
        Node<E> node = head.next;
        while (Objects.nonNull(node) && Objects.nonNull(node.next)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void add(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public void clear() {
        head.next = null;
        tail.prev = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Node<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node) && Objects.nonNull(node.next)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedListQueueIterator<E> implements Iterator<E> {

        private Node<E> node = (Node<E>) head.next;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(node.next);
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
