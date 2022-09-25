package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * Implemented by DoublyLinkedList
 */
@SuppressWarnings("unchecked")
public class LinkedListQueueImpl<E> implements IQueue<E> {

    private int size;
    private DoublyLinkNode<E> head;
    private DoublyLinkNode<E> tail;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        return Objects.nonNull(DoublyLinkNode(item));
    }

    private DoublyLinkNode<E> DoublyLinkNode(E item) {
        if (Objects.isNull(item)) {
            return null;
        }
        DoublyLinkNode<E> DoublyLinkNode = head;
        while (Objects.nonNull(DoublyLinkNode)) {
            if (Objects.equals(DoublyLinkNode.item, item)) {
                return DoublyLinkNode;
            }
            DoublyLinkNode = DoublyLinkNode.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * head <-> n1 <-> n2 <-> ... <-> oldTail <-> enqueuedDoublyLinkNode
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> DoublyLinkNode = new DoublyLinkNode<>(item, tail, null);
        if (Objects.nonNull(tail)) {
            tail.next = DoublyLinkNode;
        } else {
            head = DoublyLinkNode;
        }
        tail = DoublyLinkNode;
        size++;
    }

    /**
     * head(dequedDoublyLinkNode) <-> null
     * head(dequedDoublyLinkNode) <-> n1 <-> n2 <-> ... <-> tail
     */
    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> DoublyLinkNode = head;
        DoublyLinkNode<E> next = DoublyLinkNode.next;
        if (Objects.nonNull(next)) {
            next.prev = null;
        } else {
            tail = null;
        }
        head = next;
        size--;
        return DoublyLinkNode.item;
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
//        DoublyLinkNode<E> DoublyLinkNode = head.next;
//        while (Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.data)) {
//            DoublyLinkNode = null;
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
        DoublyLinkNode<E> DoublyLinkNode = head;
        int index = 0;
        while (Objects.nonNull(DoublyLinkNode)) {
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
    public void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    private class LinkedListQueueIterator<E> implements Iterator<E> {

        private DoublyLinkNode<E> DoublyLinkNode = (DoublyLinkNode<E>) head;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(DoublyLinkNode);
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
