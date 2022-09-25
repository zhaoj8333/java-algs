package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * Implemented by DoublyLinkedList
 */
@SuppressWarnings("unchecked")
public class LinkedListQueueImpl0<E> implements IQueue<E> {

    private int size;
    private final DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private final DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

    public LinkedListQueueImpl0() {
        head.next = tail;
        tail.prev = head;
    }

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
     * head <-> DoublyLinkNode <-> (newInsertedDoublyLinkNode) <-> tail
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> prev = tail.prev;
        DoublyLinkNode<E> DoublyLinkNode = new DoublyLinkNode<>(item, prev, tail);
        prev.next = DoublyLinkNode;
        tail.prev = DoublyLinkNode;
        size++;
    }

    /**
     * head <-> (newRemovedDoublyLinkNode) <-> DoublyLinkNode <-> tail
     */
    @Override
    public E deque() {
        if (isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
        DoublyLinkNode<E> DoublyLinkNode = head.next;   // removed DoublyLinkNode
        E data = DoublyLinkNode.item;
        head.next = DoublyLinkNode.next;
        DoublyLinkNode.next.prev = head;
        size--;
        return data;
    }

    @Override
    public E peek() {
        return head.next.item;
    }

    @Override
    public void clear() {
//        DoublyLinkNode<E> DoublyLinkNode = head.next;
//        while (Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.data)) {
//            DoublyLinkNode = null;
//        }
//        size = 0;
        // OR
        // OR
        head.next = tail;
        tail.prev = head;
        size = 0;
//        while (!isEmpty()) {
//            deque();
//        }
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        DoublyLinkNode<E> DoublyLinkNode = head.next;
        int index = 0;
        while (Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.item)) {
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
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    private class LinkedListQueueIterator0<E> implements Iterator<E> {

        private DoublyLinkNode<E> next = (DoublyLinkNode<E>) head.next;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(next.next);
        }

        @Override
        public E next() {
            E item = next.item;
            next = next.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator0<>();
    }
}
