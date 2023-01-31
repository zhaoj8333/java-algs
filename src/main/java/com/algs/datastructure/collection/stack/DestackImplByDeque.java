package com.algs.datastructure.collection.stack;

import com.algs.datastructure.node.DoublyLinkNode;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

import java.util.Arrays;
import java.util.Objects;

/**
 * 双端栈
 *
 *       <-------------          --------------->
 * head <-> ln1 <-> ln2 <-> ... <-> rn2 <-> rn1 <-> tail
 */
public class DestackImplByDeque<E> implements ICollection<E> {

    private int leftSize;
    private int rightSize;

    private DoublyLinkNode<E> head = new DoublyLinkNode<>(null, null, null);
    private DoublyLinkNode<E> tail = new DoublyLinkNode<>(null, null, null);

    @Override
    public int size() {
        return leftSize + rightSize;
    }

    @Override
    public boolean isEmpty() {
        return leftSize + rightSize == 0;
    }

    public int leftSize() {
        return leftSize;
    }

    public boolean isLeftEmpty() {
        return leftSize == 0;
    }

    public int rightSize() {
        return rightSize;
    }

    public boolean isRightEmpty() {
        return rightSize == 0;
    }

    /**
     * head <-> pushedHead <-> oldFirst
     */
    public void pushLeft(E item) {
        ObjectUtil.requireNonNull(item);
        DoublyLinkNode<E> oldFirst = head.next;
        DoublyLinkNode<E> newNode = new DoublyLinkNode<>(item, head, oldFirst);
        head.next = newNode;
        if (Objects.nonNull(oldFirst)) {
            oldFirst.prev = newNode;
        }
        leftSize++;
    }

    /**
     * head <-> poppedHead <-> n1
     */
    public E popLeft() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = head.next;
        head.next = node.next;
        node.next.prev = head;
        leftSize--;
        return node.item;
    }

    public E topLeft() {
        return Objects.isNull(head.next) ? null : head.next.item;
    }

    /**
     * n2 <-> prev <-> pushedNode <-> tail
     */
    public void pushRight(E item) {
        Objects.requireNonNull(item);
        DoublyLinkNode<E> oldLast = tail.prev;
        DoublyLinkNode<E> newNode = new DoublyLinkNode<>(item, oldLast, tail);
        tail.prev = newNode;
        if (Objects.nonNull(oldLast)) {
            oldLast.next = newNode;
        }
        rightSize++;
    }

    /**
     * n2 <-> poppedNode <-> tail
     */
    public E popRight() {
        ObjectUtil.requireNonEmpty(this);
        DoublyLinkNode<E> node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node.item;
    }

    public E topRight() {
        return Objects.isNull(tail) ? null : tail.prev.item;
    }

    public final boolean contains(E item) {
        return false;
    }

    public void clear() {
        head = tail = null;
        leftSize = rightSize = 0;
    }

    /**
     *        left               right
     * ------------------ ----------------
     * [ l, l, l, l, l, ... , r, r, r, r]
     */
    public E[] toArray() {
        E[] array = (E[]) new Object[size() + 1];
        DoublyLinkNode<E> left = head.next;
        for (int i = 0; i < leftSize; i++) {
            array[i] = left.item;
            left = left.next;
        }
        DoublyLinkNode<E> right = tail.prev;
        for (int i = size(); i > leftSize; i--) {
            array[i] = right.item;
            right = right.prev;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private class DestackIterator<E> implements Iterator<E> {

        private DoublyLinkNode<E> left = (DoublyLinkNode<E>) head.next;
        private DoublyLinkNode<E> right = (DoublyLinkNode<E>) tail.prev;

        @Override
        public boolean hasNext() {
            return Objects.nonNull(left) || Objects.nonNull(right);
        }

        @Override
        public E next() {
            E item;
            if (Objects.nonNull(left)) {
                item = left.item;
                left = left.next;
                return item;
            }
            if (Objects.nonNull(right)) {
                item = right.item;
                right = right.prev;
                return item;
            }
            return null;
        }
    }

    public Iterator<E> iterator() {
        return new DestackIterator<>();
    }

    @Override
    public final E get(int i) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void add(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public E remove(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

}
