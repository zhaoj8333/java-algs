package com.algs.datastructure.collection.list;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class SinglyLinkedListImpl<E> implements List<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private int size;
    private final Node<E> head = new Node<>(null, null);

    /**
     * prev -> newNode -> next
     */
    @Override
    public void add(int index, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        Node<E> prev = node(index - 1);
        prev.next = new Node<>(item, prev.next);
        size++;
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public E get(int index) {
        Node<E> node = node(index);
        return Objects.isNull(node) ? null : node.item;
    }

    @Override
    public void set(int index, E item) {
        Node<E> node = node(index);
        if (Objects.nonNull(node)) {
            node.item = item;
        }
    }

    @Override
    public int indexOf(E item) {
        Node<E> node = head.next;
        if (Objects.isNull(item)) {
            for (int i = 0; i < size; i++) {
                if (Objects.isNull(node)) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(node.item, item)) {
                    return i;
                }
                node = node.next;
            }
        }
        return CollectionDefaultValues.ELEMENT_NOT_FOUND;
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
        return indexOf(item) == CollectionDefaultValues.ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        Node<E> node = head;
        for (int i = -1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * prev -> node -> next
     */
    @Override
    public E remove(int index) {
        Node<E> prev = node(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.item;
    }

    @Override
    public E remove(E item) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        Node<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class SinglyLinkedListIterator implements Iterator<E> {

        private Node<E> node = head.next;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(node.next);
        }

        @Override
        public E next() {
            Node<E> next = node.next;
            next = next.next;
            return next.item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

}
