package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.Iterator;

import java.util.Objects;

public class LinkedListBagImpl<E> implements IBag<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.item = data;
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
            if (Objects.equals(item, node.item)) {
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
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public E remove() {
        return remove(head.item);
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
        E data = node.item;
        Node<E> oldhead = head;
        head = head.next;
        node.item = oldhead.item;
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
            array[index++] = (E) node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;
        while (Objects.nonNull(node)) {
            sb.append("(").append(node.item.toString()).append(") -> ");
            node = node.next;
        }
        return sb.toString();
    }

    private class LinkedListBagIterator<E> implements Iterator<E> {

        private Node<E> node = (Node<E>) head;

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
        return new LinkedListBagIterator<>();
    }
}
