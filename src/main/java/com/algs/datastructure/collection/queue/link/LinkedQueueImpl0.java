package com.algs.datastructure.collection.queue.link;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.node.DoublyLinkNode;
import com.algs.utils.ObjectUtil;
import java.util.Objects;

/**
 * Implemented by DoublyLinkedList
 */
@SuppressWarnings("unchecked")
public class LinkedQueueImpl0<E> implements IQueue<E> {

    private int size;
    private final DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private final DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

    public LinkedQueueImpl0() {
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

    private DoublyLinkNode<E> node(E item) {
        if (Objects.isNull(item)) {
            return null;
        }
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
     * head <-> DoublyLinkNode <-> (newInsertedDoublyLinkNode) <-> tail
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> prev = tail.prev;
        DoublyLinkNode<E> node = new DoublyLinkNode<>(item, prev, tail);
        prev.next = node;
        tail.prev = node;
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
        DoublyLinkNode<E> node = head.next;   // removed DoublyLinkNode
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
        DoublyLinkNode<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node) && Objects.nonNull(node.item)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedQueueIterator0<E> implements Iterator<E> {

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
        return new LinkedQueueIterator0<>();
    }

    @Override
    public final E get(int i) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public final E remove(int i) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

//    @Override
//    public final void reverse() {
//        throw new UnsupportedOperationException("UnsupportedOperation");
//    }

}
