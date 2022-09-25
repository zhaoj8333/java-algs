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
        DoublyLinkNode<E> prev = DoublyLinkNode(index - 1);
        DoublyLinkNode<E> next = prev.next;
        DoublyLinkNode<E> DoublyLinkNode = new DoublyLinkNode<>(item, prev, next);
        prev.next = DoublyLinkNode;
        next.prev = DoublyLinkNode;
        size++;
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public E get(int index) {
        DoublyLinkNode<E> DoublyLinkNode = DoublyLinkNode(index);
        return Objects.isNull(DoublyLinkNode) ? null : DoublyLinkNode.item;
    }

    @Override
    public void set(int index, E item) {
        DoublyLinkNode<E> DoublyLinkNode = DoublyLinkNode(index);
        if (Objects.nonNull(DoublyLinkNode)) {
            DoublyLinkNode.item = item;
        }
    }

    @Override
    public int indexOf(E item) {
        DoublyLinkNode<E> DoublyLinkNode = head.next;
        if (Objects.isNull(item)) {
            for (int i = 0; i < size; i++) {
                if (Objects.isNull(DoublyLinkNode)) {
                    return i;
                }
                DoublyLinkNode = DoublyLinkNode.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(DoublyLinkNode.item, item)) {
                    return i;
                }
                DoublyLinkNode = DoublyLinkNode.next;
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

    private DoublyLinkNode<E> DoublyLinkNode(int index) {
        DoublyLinkNode<E> DoublyLinkNode = head;
        for (int i = -1; i < index; i++) {
            DoublyLinkNode = DoublyLinkNode.next;
        }
        return DoublyLinkNode;
    }

    /**
     * head <->n0 <-> prev <-> removedDoublyLinkNode <-> next <-> n*
     */
    @Override
    public E remove(int index) {
        DoublyLinkNode<E> prev = DoublyLinkNode(index - 1);
        DoublyLinkNode<E> DoublyLinkNode = prev.next;
        DoublyLinkNode<E> next = DoublyLinkNode.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return DoublyLinkNode.item;
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
        DoublyLinkNode<E> DoublyLinkNode = head.next;
        int index = 0;
        while (Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.next)) {
            array[index++] = DoublyLinkNode.item;
            DoublyLinkNode = DoublyLinkNode.next;
        }
        return array;
    }

    @Override
    public boolean hasCircle() {
        return false;
    }

    @Override
    public E remove(E item) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

    private class DoublyLinkedListIterator implements Iterator<E> {

        private DoublyLinkNode<E> DoublyLinkNode = head.next;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(DoublyLinkNode) && Objects.nonNull(DoublyLinkNode.next);
        }

        @Override
        public E next() {
            E item = DoublyLinkNode.item;
            DoublyLinkNode = DoublyLinkNode.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

}
