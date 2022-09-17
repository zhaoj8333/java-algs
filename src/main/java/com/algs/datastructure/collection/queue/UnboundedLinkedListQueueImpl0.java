package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * Implemented by DoublyLinkedList
 */
@SuppressWarnings("unchecked")
public class UnboundedLinkedListQueueImpl0<E> implements IQueue<E> {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private final Node<E> head = new Node<>(null, null, null);
    private final Node<E> tail = new Node<>(null, null, null);

    public UnboundedLinkedListQueueImpl0() {
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

    private Node<E> node(E item) {
        if (Objects.isNull(item)) {
            return null;
        }
        Node<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.data, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupport this operation");
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * head <-> node <-> (newInsertedNode) <-> tail
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        Node<E> prev = tail.prev;
        Node<E> node = new Node<>(item, prev, tail);
        prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     *
     * head <-> (newRemovedNode) <-> node <-> tail
     */
    @Override
    public E deque() {
        if (isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
        Node<E> node = head.next;   // removed node
        E data = node.data;
        head.next = node.next;
        node.next.prev = head;
        size--;
        return data;
    }

    @Override
    public E peek() {
        return head.next.data;
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
        Node<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node) && Objects.nonNull(node.data)) {
            array[index++] = node.data;
            node = node.next;
        }
        return array;
    }

}
