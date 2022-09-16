package com.algs.datastructure.collection.stack;

import com.algs.util.ObjectUtil;

import java.util.Objects;

public class LinkedListStackImpl<E> implements IStack<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private int size;
    private Node<E> top;

    /**
     * newTop -> oldTop -> n1 -> ... -> n
     */
    @Override
    public void push(E item) {
        ObjectUtil.requireNonNull(item);
        top = new Node<>(item, top);
        size++;
    }

    /**
     * oldTop -> newTop -> n1 -> ... -> n
     */
    @Override
    public E pop() {
        ObjectUtil.requireNonEmpty(this);
        Node<E> node = top;
        top = node.next;
        size--;
        return node.item;
    }

    @Override
    public E top() {
        return top.item;
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
        Node<E> node = top;
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
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public E remove(E o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Node<E> node = top;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }
}
