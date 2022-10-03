package com.algs.datastructure.collection.list;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.SinglyLinkNode;
import com.algs.util.ObjectUtil;
import com.algs.util.RangeUtil;

import java.util.Arrays;
import java.util.Objects;

public class SinglyLinkedListImpl<E> implements ILinkedList<E> {

    private int size;
    private final SinglyLinkNode<E> head = new SinglyLinkNode<>(null, null);

    /**
     * prev -> newSinglyLinkNode -> next
     */
    @Override
    public void add(int index, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        SinglyLinkNode<E> prev = node(index - 1);
        prev.next = new SinglyLinkNode<>(item, prev.next);
        size++;
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public E get(int index) {
        SinglyLinkNode<E> node = node(index);
        return Objects.isNull(node) ? null : node.item;
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
    public int indexOf(E item) {
        SinglyLinkNode<E> node = head.next;
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
    public void reverse() {
//        head.next = reverse(head.next);
//        head.next = reverse0x(head.next);
        head.next = reverse0(head.next);
    }

    /**
     *  head
     *   |   next
     *  \/   \|/
     *  n1 -> n2 -> n3 .... -> n*
     *
     * newHead
     *
     *  have to remember three sequential node: newHead, node, next(node.next)
     *  in each iteration, get the node(firstSinglyLinkNode) and insert it to the newHead,
     *  keep node(first) point to the first node of the rest of previous linkedlist
     *
     *  but essentially, iterate reverse is {@link com.algs.datastructure.collection.bag.LinkedListBagImpl#linkHead(Object)}
     *
     * @param node oldHead
     * @return newHead
     */
    private SinglyLinkNode<E> reverse0(SinglyLinkNode<E> node) {
        SinglyLinkNode<E> first = node;
        SinglyLinkNode<E> newHead = null;
        while (Objects.nonNull(first)) {
            SinglyLinkNode<E> second = first.next;
            first.next = newHead;
            newHead = first;
            first = second;
        }
        return newHead;
    }

    /**
     *
     * n1 -> n2 -> n3 .... -> n*
     *
     * equals to {@link com.algs.datastructure.collection.bag.LinkedListBagImpl#linkHead(Object)}
     * Side effect： use brand new {@link SinglyLinkNode} to replace old {@link SinglyLinkNode}
     */
    private SinglyLinkNode<E> reverse0x(SinglyLinkNode<E> node) {
        SinglyLinkNode<E> newHead = null;
        while (Objects.nonNull(node)) {
            newHead = new SinglyLinkNode<>(node.item, newHead);
            node = node.next;
        }
        return newHead;
    }

    /**
     * n1 -> n2 -> n3 .... n9 -> n10 -> null
     *      --------------------------------
     * null <- n1 <- n2 <- n3 .... n9 <- n10
     */
    private SinglyLinkNode<E> reverse(SinglyLinkNode<E> node) {
        if (Objects.isNull(node) || Objects.isNull(node.next)) {
            return node;
        }
        SinglyLinkNode<E> newHead = reverse(node.next);
        SinglyLinkNode<E> next = node.next;
        next.next = node;
        node.next = null;
        return newHead;
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

    private SinglyLinkNode<E> node(int index) {
        SinglyLinkNode<E> node = head;
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
        SinglyLinkNode<E> prev = node(index - 1);
        SinglyLinkNode<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.item;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        SinglyLinkNode<E> node = head.next;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private class SinglyLinkedListIterator implements Iterator<E> {

        private SinglyLinkNode<E> node = head;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(node.next);
        }

        @Override
        public E next() {
            E item = node.next.item;
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
        throw new UnsupportedOperationException("unsupported operation");
    }

}
