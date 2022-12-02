package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.node.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

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
        return Objects.nonNull(node(item));
    }

    private DoublyLinkNode<E> node(E item) {
        if (Objects.isNull(item)) {
            return null;
        }
        ObjectUtil.requireNonNull(item);
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
    public int size() {
        return size;
    }

    /**
     * head <-> n1 <-> n2 <-> ... <-> oldTail <-> enqueuedDoublyLinkNode
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
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
     * head(dequedDoublyLinkNode) <-> null
     * head(dequedDoublyLinkNode) <-> n1 <-> n2 <-> ... <-> tail
     */
    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = head;
        DoublyLinkNode<E> next = node.next;
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
        DoublyLinkNode<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedListQueueIterator<E> implements Iterator<E> {

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
        return new LinkedListQueueIterator<>();
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
