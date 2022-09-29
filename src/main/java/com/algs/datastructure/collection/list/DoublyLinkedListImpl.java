package com.algs.datastructure.collection.list;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.DoublyLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class DoublyLinkedListImpl<E> implements ILinkedList<E> {

    private int size;
    private final DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private final DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

    public DoublyLinkedListImpl() {
        head.next = tail;
        tail.prev = head;
    }

    /**
     * prev -> newDoublyLinkNode -> next
     */
    @Override
    public void add(int index, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        DoublyLinkNode<E> prev = node(index - 1);
        DoublyLinkNode<E> next = prev.next;
        DoublyLinkNode<E> node = new DoublyLinkNode<>(item, prev, next);
        prev.next = node;
        next.prev = node;
        size++;
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public E get(int index) {
        DoublyLinkNode<E> node = node(index);
        return Objects.isNull(node) ? null : node.item;
    }

    @Override
    public E set(int index, E item) {
        E oldVal = null;
        DoublyLinkNode<E> node = node(index);
        if (Objects.nonNull(node)) {
            oldVal = node.item;
            node.item = item;
        }
        return oldVal;
    }

    @Override
    public int indexOf(E item) {
        DoublyLinkNode<E> node = head.next;
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

    private DoublyLinkNode<E> node(int index) {
        DoublyLinkNode<E> node = head;
        for (int i = -1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * head <->n0 <-> prev <-> removedDoublyLinkNode <-> next <-> n*
     */
    @Override
    public E remove(int index) {
        DoublyLinkNode<E> prev = node(index - 1);
        DoublyLinkNode<E> node = prev.next;
        DoublyLinkNode<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return node.item;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        DoublyLinkNode<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node) && Objects.nonNull(node.next)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public final E remove(E item) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

    private class DoublyLinkedListIterator implements Iterator<E> {

        private DoublyLinkNode<E> node = head.next;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(node) && Objects.nonNull(node.next);
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
        return new DoublyLinkedListIterator();
    }

}
