package com.algs.datastructure.collection.list.linked;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.bag.LinkedBagImpl;
import com.algs.datastructure.node.LinkNode;
import com.algs.datastructure.node.SinglyLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;
import java.util.Objects;

public class SinglyLinkedListImpl<E> implements ISequentialAccessList<E> {

    private int size;
    private SinglyLinkNode<E> head = new SinglyLinkNode<>(null, null);

    public SinglyLinkedListImpl() {}

    public SinglyLinkedListImpl(E[] array) {
        for (E item : array) {
            add(item);
        }
    }

    public SinglyLinkedListImpl(ICollection<E> collection) {
        Iterator<E> itr = collection.iterator();
        if (itr.hasNext()) {
            add(itr.next());
        }
    }

    public void setHead(LinkNode<E> node) {
        head = (SinglyLinkNode<E>) node;
    }

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
    public E get(int i) {
        SinglyLinkNode<E> node = node(i);
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
        return DefaultValues.ELEMENT_NOT_FOUND;
    }

    @Override
    public void reverse() {
//        head.next = reverse(head.next);
        head.next = reverse0(head.next);
    }

    /**
     *  node
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
     * Essentially, reversing a linkedlist is similar with {@link LinkedBagImpl#linkHead(Object)}
     *
     * @param node oldHead
     * @return newHead
     */
    private SinglyLinkNode<E> reverse0(SinglyLinkNode<E> node) {
        SinglyLinkNode<E> newHead = null;
        while (Objects.nonNull(node)) {
            SinglyLinkNode<E> next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
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
        return indexOf(item) > DefaultValues.ELEMENT_NOT_FOUND;
    }

    @Override
    public SinglyLinkNode<E> node(int index) {
        SinglyLinkNode<E> node = head;
        for (int i = -1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public ISequentialAccessList<E> copy() {
        SinglyLinkedListImpl<E> list = new SinglyLinkedListImpl<E>();
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
    public E remove(int i) {
        SinglyLinkNode<E> prev = node(i - 1);
        SinglyLinkNode<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.item;
    }

    @Override
    public final E remove(E item) {
        ObjectUtil.requireNonNull(item);
        SinglyLinkNode<E> prev = head;
        SinglyLinkNode<E> node = prev.next;
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
        return ArraysUtil.toString(toArray());
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
    public Iterator<E> reverseIterator() {
        return null;
    }

}
