package com.algs.datastructure.collection.list.linked;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.SinglyLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;

import java.util.Arrays;
import java.util.Objects;

public class SinglyLinkedListImpl0<E> implements ISequentialAccessList<E> {

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

    @Override
    public SinglyLinkNode<E> node(int index) {
        RangeUtil.requireIndexRange(index, 0, size);
        SinglyLinkNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public ISequentialAccessList<E> copy() {
        SinglyLinkedListImpl0<E> list = new SinglyLinkedListImpl0<E>();
        Iterator<E> itr = iterator();
        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
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
        prev.next = node.next;
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
        return CollectionUtil.toArray(this);
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

    @Override
    public final E remove(E item) {
        ObjectUtil.requireNonNull(item);
        SinglyLinkNode<E> prev = null;
        SinglyLinkNode<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(item, node.item)) {
                break;
            }
            prev = node;
            node = node.next;
        }
        E ret = node.item;
        node.item = null;
        prev.next = node.next;
        size--;
        return ret;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
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

}
