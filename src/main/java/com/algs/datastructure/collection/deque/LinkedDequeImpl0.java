package com.algs.datastructure.collection.deque;

import com.algs.datastructure.node.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class LinkedDequeImpl0<E> implements IDeque<E> {

    private int size;
    private final DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private final DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

    public LinkedDequeImpl0() {
        head.next = tail;
        tail.prev = head;
    }

    /**
     * head <-> enquedDoublyLinkNode(oldHead) <-> tail
     */
    @Override
    public void enqueHead(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> next = head.next;
        DoublyLinkNode<E> node = new DoublyLinkNode<>(item, head, next);
        head.next = node;
        next.prev = node;
        size++;
    }

    /**
     * head <-> dequedDoublyLinkNode <-> n2 <-> tail
     */
    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = head.next;
        node.next.prev = head;
        head.next = node.next;
        size--;
        return node.item;
    }

    /**
     * head <-> ... <-> n2 <-> enqueuedDoublyLinkNode <-> tail
     */
    @Override
    public void enqueTail(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> prev = tail.prev;
        DoublyLinkNode<E> node = new DoublyLinkNode<>(item, prev, tail);
        prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * head <-> n1 <-> ... <-> prev <-> dequedDoublyLinkNode <-> tail
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = tail.prev;
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

    private DoublyLinkNode<E> node(E item) {
        DoublyLinkNode<E> node = head.next;
        while (Objects.nonNull(node) && Objects.nonNull(node.next)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
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
        DoublyLinkNode<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node) && Objects.nonNull(node.next)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedQueueIterator<E> implements Iterator<E> {

        private DoublyLinkNode<E> node = (DoublyLinkNode<E>) head.next;

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
        return new LinkedQueueIterator<>();
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
