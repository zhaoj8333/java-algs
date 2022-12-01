package com.algs.datastructure.collection.list.linked;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.DoubleLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;

import java.util.Objects;

public class DoubleLinkedListImpl<E> implements ILinkedList<E> {

    private int size;
    private final DoubleLinkNode<E> head = new DoubleLinkNode<>(null, null, null);
    private final DoubleLinkNode<E> tail = new DoubleLinkNode<>(null, null, null);

    public DoubleLinkedListImpl() {
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
        DoubleLinkNode<E> prev = node(index - 1);
        DoubleLinkNode<E> next = prev.next;
        DoubleLinkNode<E> node = new DoubleLinkNode<>(item, prev, next);
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
        DoubleLinkNode<E> node = node(index);
        return Objects.isNull(node) ? null : node.item;
    }

    @Override
    public E set(int index, E item) {
        E oldVal = null;
        DoubleLinkNode<E> node = node(index);
        if (Objects.nonNull(node)) {
            oldVal = node.item;
            node.item = item;
        }
        return oldVal;
    }

    @Override
    public int indexOf(E item) {
        DoubleLinkNode<E> node = head.next;
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
        return DefaultValues.ELEMENT_NOT_FOUND;
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
        return indexOf(item) == DefaultValues.ELEMENT_NOT_FOUND;
    }

    @Override
    public DoubleLinkNode<E> node(int index) {
        DoubleLinkNode<E> node = head;
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
        DoubleLinkNode<E> prev = node(index - 1);
        DoubleLinkNode<E> node = prev.next;
        DoubleLinkNode<E> next = node.next;
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
        return CollectionUtil.toArray(this);
    }

    private class DoublyLinkedListIterator implements Iterator<E> {

        private DoubleLinkNode<E> node = head.next;

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

    @Override
    public final E remove(E item) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public DoubleLinkedListImpl<E> copy() {
        DoubleLinkedListImpl<E> list = new DoubleLinkedListImpl<>();
        Iterator<E> itr = iterator();
        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }

}
