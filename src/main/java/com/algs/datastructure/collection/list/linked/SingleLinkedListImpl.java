package com.algs.datastructure.collection.list.linked;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.SingleLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;

import java.util.Arrays;
import java.util.Objects;

public class SingleLinkedListImpl<E> implements ILinkedList<E> {

    private int size;
    private final SingleLinkNode<E> head = new SingleLinkNode<>(null, null);

    /**
     * prev -> newSinglyLinkNode -> next
     */
    @Override
    public void add(int index, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        SingleLinkNode<E> prev = node(index - 1);
        prev.next = new SingleLinkNode<>(item, prev.next);
        size++;
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public E get(int index) {
        SingleLinkNode<E> node = node(index);
        return Objects.isNull(node) ? null : node.item;
    }

    @Override
    public E set(int index, E item) {
        E oldVal = null;
        SingleLinkNode<E> node = node(index);
        if (Objects.nonNull(node)) {
            oldVal = node.item;
            node.item = item;
        }
        return oldVal;
    }

    @Override
    public int indexOf(E item) {
        SingleLinkNode<E> node = head.next;
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
    private SingleLinkNode<E> reverse0(SingleLinkNode<E> node) {
        SingleLinkNode<E> first = node;
        SingleLinkNode<E> newHead = null;
        while (Objects.nonNull(first)) {
            SingleLinkNode<E> second = first.next;
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
     * Side effect： use brand new {@link SingleLinkNode} to replace old {@link SingleLinkNode}
     */
    private SingleLinkNode<E> reverse0x(SingleLinkNode<E> node) {
        SingleLinkNode<E> newHead = null;
        while (Objects.nonNull(node)) {
            newHead = new SingleLinkNode<>(node.item, newHead);
            node = node.next;
        }
        return newHead;
    }

    /**
     * n1 -> n2 -> n3 .... n9 -> n10 -> null
     *      --------------------------------
     * null <- n1 <- n2 <- n3 .... n9 <- n10
     */
    private SingleLinkNode<E> reverse(SingleLinkNode<E> node) {
        if (Objects.isNull(node) || Objects.isNull(node.next)) {
            return node;
        }
        SingleLinkNode<E> newHead = reverse(node.next);
        SingleLinkNode<E> next = node.next;
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
        return indexOf(item) == DefaultValues.ELEMENT_NOT_FOUND;
    }

    @Override
    public SingleLinkNode<E> node(int index) {
        SingleLinkNode<E> node = head;
        for (int i = -1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public ILinkedList<E> copy() {
        SingleLinkedListImpl<E> list = new SingleLinkedListImpl<E>();
        Iterator<E> itr = iterator();
        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }

    /**
     * prev -> node -> next
     */
    @Override
    public E remove(int index) {
        SingleLinkNode<E> prev = node(index - 1);
        SingleLinkNode<E> node = prev.next;
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
        return CollectionUtil.toArray(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private class SinglyLinkedListIterator implements Iterator<E> {

        private SingleLinkNode<E> node = head;

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
