package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

public class LinkedListDequeImpl0<E> implements IDeque<E> {

    private int size;
    private final DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private final DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

    public LinkedListDequeImpl0() {
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
        DoublyLinkNode<E> DoublyLinkNode = new DoublyLinkNode<>(item, head, next);
        head.next = DoublyLinkNode;
        next.prev = DoublyLinkNode;
        size++;
    }

    /**
     * head <-> dequedDoublyLinkNode <-> n2 <-> tail
     */
    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> DoublyLinkNode = head.next;
        DoublyLinkNode.next.prev = head;
        head.next = DoublyLinkNode.next;
        size--;
        return DoublyLinkNode.item;
    }

    /**
     * head <-> ... <-> n2 <-> enqueuedDoublyLinkNode <-> tail
     */
    @Override
    public void enqueTail(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> prev = tail.prev;
        DoublyLinkNode<E> DoublyLinkNode = new DoublyLinkNode<>(item, prev, tail);
        prev.next = DoublyLinkNode;
        tail.prev = DoublyLinkNode;
        size++;
    }

    /**
     * head <-> n1 <-> ... <-> prev <-> dequedDoublyLinkNode <-> tail
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> DoublyLinkNode = tail.prev;
        DoublyLinkNode.prev.next = tail;
        tail.prev = DoublyLinkNode.prev;
        size--;
        return DoublyLinkNode.item;
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
        DoublyLinkNode<E> DoublyLinkNode = head.next;
        while (Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.next)) {
            if (Objects.equals(DoublyLinkNode.item, item)) {
                return DoublyLinkNode;
            }
            DoublyLinkNode = DoublyLinkNode.next;
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
        DoublyLinkNode<E> DoublyLinkNode = head.next;
        int index = 0;
        while (Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.next)) {
            array[index++] = DoublyLinkNode.item;
            DoublyLinkNode = DoublyLinkNode.next;
        }
        return array;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
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
    public void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    private class LinkedListQueueIterator<E> implements Iterator<E> {

        private DoublyLinkNode<E> DoublyLinkNode = (DoublyLinkNode<E>) head.next;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(DoublyLinkNode.next);
        }

        @Override
        public E next() {
            E item = DoublyLinkNode.item;
            DoublyLinkNode = DoublyLinkNode.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator<>();
    }
}
