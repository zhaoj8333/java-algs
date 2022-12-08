package com.algs.datastructure.collection.list.linked;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.DoublyLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;

import java.util.Objects;

public class DoublyLinkedListImpl<E> implements ISequentialAccessList<E> {

    private int size;
    private DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

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
        DoublyLinkNode<E> prev = tail.prev;
        DoublyLinkNode<E> next = tail;
        if (index != size) {
            prev = node(index - 1);
            next = prev.next;
        }
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.item, item)) {
                return i;
            }
            node = node.next;
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
        return indexOf(item) > DefaultValues.ELEMENT_NOT_FOUND;
    }

    @Override
    public DoublyLinkNode<E> node(int index) {
        DoublyLinkNode<E> node;
        if (index < size >> 1) {
            node = head;
            for (int i = -1; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size; i > index; i--) {
                node = node.prev;
            }
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
        E item = node.item;
        node.item = null;
        size--;
        return item;
    }

    @Override
    public final E remove(E item) {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = head.next;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                break;
            }
            node = node.next;
        }
        if (Objects.isNull(node)) {
            return null;
        }
        DoublyLinkNode<E> prev = node.prev;
        DoublyLinkNode<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return item;
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

    /**
     * head <-> 7 <-> 6 <-> 5 <-> 4 <-> 3 <-> tail
     */
    @Override
    public final void reverse() {
        DoublyLinkNode<E> oldHead = head;
        DoublyLinkNode<E> prev = head;
        DoublyLinkNode<E> node = prev.next;
        while (Objects.nonNull(node)) {
            DoublyLinkNode<E> next = node.next;
            node.next = prev;
            node.prev = next;
            prev = node;
            node = next;
        }
        head = prev;
        tail = oldHead;
        tail.prev = oldHead.next;
        tail.next = null;
    }

    @Override
    public DoublyLinkedListImpl<E> copy() {
        DoublyLinkedListImpl<E> list = new DoublyLinkedListImpl<>();
        Iterator<E> itr = iterator();
        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }

}
