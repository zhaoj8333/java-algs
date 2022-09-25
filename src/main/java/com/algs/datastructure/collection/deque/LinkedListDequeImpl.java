package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

public class LinkedListDequeImpl<E> implements IDeque<E> {

    private int size;
    private DoublyLinkNode<E> head;
    private DoublyLinkNode<E> tail;

    /**
     * enquedHead(newHead) <-> head <-> n1 <-> ... tail
     * [enqueuedDoublyLinkNode (newTail)] <-> null
     */
    @Override
    public void enqueHead(E item) {
        DoublyLinkNode<E> DoublyLinkNode = new DoublyLinkNode<>(item, null, head);
        if (Objects.nonNull(head)) {
            head.prev = DoublyLinkNode;
        } else {
            tail = DoublyLinkNode;
        }
        head = DoublyLinkNode;
        size++;
    }

    /**
     * head <-> n1 <-> n2 <-> tail
     */
    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = head;
        DoublyLinkNode<E> next = node.next;
        if (Objects.nonNull(next)) {
            next.prev = null;
        }
        head = next;
        size--;
        return node.item;
    }

    /**
     * head <-> n1 <-> n2 <-> ... <-> tail <-> enqueuedDoublyLinkNode (newTail)
     * null [enqueuedDoublyLinkNode (newTail)]
     */
    @Override
    public void enqueTail(E item) {
        DoublyLinkNode<E> node = new DoublyLinkNode<>(item, tail, null);
        if (Objects.nonNull(tail)) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * head <-> n1 <-> ... <-> prev <-> tail(dequeuedDoublyLinkNode (newTail))
     * null [enqueuedDoublyLinkNode (newTail)]
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = tail;
        DoublyLinkNode<E> prev = tail.prev;
        if (Objects.nonNull(prev)) {
            prev.next = null;
        }
        tail = prev;
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
        DoublyLinkNode<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        DoublyLinkNode<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
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

    private class LinkedListDequeIterator<E> implements Iterator<E> {

        private DoublyLinkNode<E> node = (DoublyLinkNode<E>) head;

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
        return new LinkedListDequeIterator<>();
    }
}
