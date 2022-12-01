package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.node.DoubleLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

/**
 * Implemented by DoubleLinkedList
 */
@SuppressWarnings("unchecked")
public class LinkedListQueueImpl0<E> implements IQueue<E> {

    private int size;
    private final DoubleLinkNode<E> head = new DoubleLinkNode<>(null, null, null);
    private final DoubleLinkNode<E> tail = new DoubleLinkNode<>(null, null, null);

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
        return Objects.nonNull(node(item));
    }

    private DoubleLinkNode<E> node(E item) {
        if (Objects.isNull(item)) {
            return null;
        }
        DoubleLinkNode<E> node = head;
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
     * head <-> DoubleLinkNode <-> (newInsertedDoubleLinkNode) <-> tail
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        DoubleLinkNode<E> prev = tail.prev;
        DoubleLinkNode<E> node = new DoubleLinkNode<>(item, prev, tail);
        prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * head <-> (newRemovedDoubleLinkNode) <-> DoubleLinkNode <-> tail
     */
    @Override
    public E deque() {
        if (isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
        DoubleLinkNode<E> node = head.next;   // removed DoubleLinkNode
        E data = node.item;
        head.next = node.next;
        node.next.prev = head;
        size--;
        return data;
    }

    @Override
    public E peek() {
        return head.next.item;
    }

    @Override
    public void clear() {
//        DoubleLinkNode<E> DoubleLinkNode = head.next;
//        while (Objects.nonNull(DoubleLinkNode) && Objects.nonNull(DoubleLinkNode.data)) {
//            DoubleLinkNode = null;
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
        DoubleLinkNode<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node) && Objects.nonNull(node.item)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedListQueueIterator0<E> implements Iterator<E> {

        private DoubleLinkNode<E> next = (DoubleLinkNode<E>) head.next;

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

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
