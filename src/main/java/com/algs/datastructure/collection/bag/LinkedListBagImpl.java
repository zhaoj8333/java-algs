package com.algs.datastructure.collection.bag;

import java.util.Objects;

public class LinkedListBagImpl<E> implements IBag<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;

    @Override
    public void add(E item) {
        linkHead(item);
        size++;
    }

    private void linkHead(E item) {
        head = new Node<>(item, head);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int numberOf(E item) {
        int number = 0;
        Node<E> node = this.head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(item, node.data)) {
                number ++;
            }
            node = node.next;
        }
        return number;
    }

    @Override
    public boolean contains(E item) {
        return Objects.nonNull(node(item));
    }

    private Node<E> node(E item) {
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
    public E remove() {
        return remove(head.data);
    }

    /**
     * use the first to replace the {@link #node(Object)}
     */
    @Override
    public E remove(E item) {
        if (isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
        Node<E> node = node(item);
        if (Objects.isNull(node)) {
            return null;
        }
        E data = node.data;
        Node<E> oldhead = head;
        head = head.next;
        node.data = oldhead.data;
        size --;
        return data;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Node<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = (E) node.data;
            node = node.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;
        while (Objects.nonNull(node)) {
            sb.append("(").append(node.data.toString()).append(") -> ");
            node = node.next;
        }
        return sb.toString();
    }
}
