package com.algs.datastructure.collection.deque;

import com.algs.util.ObjectUtil;

import java.util.Objects;

public class UnboundedLinkedListDequeImpl<E> implements IDeque<E> {

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
    private Node<E> head;
    private Node<E> tail;

    /**
     * enquedHead(newHead) <-> head <-> n1 <-> ... tail
     * [enqueuedNode (newTail)] <-> null
     */
    @Override
    public void enqueHead(E item) {
        Node<E> node = new Node<>(item, null, head);
        if (Objects.nonNull(head)) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
        size++;
    }

    /**
     * head <-> n1 <-> n2 <-> tail
     */
    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        Node<E> node = head;
        Node<E> next = node.next;
        if (Objects.nonNull(next)) {
            next.prev = null;
        }
        head = next;
        size--;
        return node.item;
    }

    /**
     * head <-> n1 <-> n2 <-> ... <-> tail <-> enqueuedNode (newTail)
     * null [enqueuedNode (newTail)]
     */
    @Override
    public void enqueTail(E item) {
        Node<E> node = new Node<>(item, tail, null);
        if (Objects.nonNull(tail)) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * head <-> n1 <-> ... <-> prev <-> tail(dequeuedNode (newTail))
     * null [enqueuedNode (newTail)]
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        Node<E> node = tail;
        Node<E> prev = tail.prev;
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

    private Node<E> node(E item) {
        Node<E> node = head;
        while (Objects.nonNull(node)) {
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
    public E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
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
        Node<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }
}
