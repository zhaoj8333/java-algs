package com.algs.datastructure.collection.list;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.SinglyLinkNode;
import com.algs.util.ObjectUtil;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class SinglyLinkedListImpl0<E> implements ILinkedList<E> {

    private int size;
    private SinglyLinkNode<E> head;

    @Override
    public void add(E item) {
        add(size, item);
    }

    /**
     * head -> prev -> newInsertedNode -> next -> n*
     * (head)newInsertedNode -> next -> n*
     */
    @Override
    public void add(int index, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        SinglyLinkNode<E> prev = head;
        SinglyLinkNode<E> node = new SinglyLinkNode<>(item, null);
        if (Objects.isNull(prev) || index == 0) {
            node.next = head;
            head = node;
        } else {
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }

    @Override
    public E set(int index, E item) {
        E oldVal = null;
        SinglyLinkNode<E> node = node(index);
        if (Objects.nonNull(node)) {
            oldVal = node.item;
            node.item = item;
        }
        return oldVal;
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
    public E get(int index) {
        SinglyLinkNode<E> node = node(index);
        return Objects.isNull(node) ? null : node.item;
    }

    private SinglyLinkNode<E> node(int index) {
        RangeUtil.requireIndexRange(index, 0, size);
        SinglyLinkNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) > DefaultValues.ELEMENT_NOT_FOUND;
    }

    public int indexOf(E item) {
        SinglyLinkNode<E> node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, node.item)) {
                return i;
            }
            node = node.next;
        }
        return DefaultValues.ELEMENT_NOT_FOUND;
    }

    @Override
    public E remove(int index) {
        SinglyLinkNode<E> prev = node(index - 1);
        SinglyLinkNode<E> node = prev.next;
        E item = node.item;
        node.item = null;
        size--;
        return item;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        SinglyLinkNode<E> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public void reverse() {
        head = reverse(head);
    }

    /**
     * newHead
     *   |
     * head -> n1 -> n2 -> n3 -> ... -> n*
     *
     * head <- n1 <- n2 <- n3 <- ... <- n*
     */
    private SinglyLinkNode<E> reverse(SinglyLinkNode<E> node) {
        if (Objects.isNull(node) || Objects.isNull(node.next)) {
            return node;
        }
        SinglyLinkNode<E> newHead = null;
        while (Objects.nonNull(node)) {
            SinglyLinkNode<E> temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        return newHead;
    }

    private class SinglyLinkedListIterator implements Iterator<E> {

        private SinglyLinkNode<E> node = head;

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
        return new SinglyLinkedListIterator();
    }

    @Override
    public final E remove(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

}
