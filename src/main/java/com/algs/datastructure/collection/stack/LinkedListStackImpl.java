package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.SinglyLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class LinkedListStackImpl<E> implements IStack<E> {

    private int size;
    private SinglyLinkNode<E> top;

    /**
     * newTop -> oldTop -> n1 -> ... -> n
     */
    @Override
    public void push(E item) {
        ObjectUtil.requireNonNull(item);
        top = new SinglyLinkNode<>(item, top);
        size++;
    }

    /**
     * oldTop -> newTop -> n1 -> ... -> n
     */
    @Override
    public E pop() {
        ObjectUtil.requireNonEmpty(this);
        SinglyLinkNode<E> node = top;
        top = node.next;
        size--;
        return node.item;
    }

    @Override
    public E top() {
        return top.item;
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
        return Objects.nonNull(node(item));
    }

    private SinglyLinkNode<E> node(E item) {
        SinglyLinkNode<E> node = top;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        SinglyLinkNode<E> node = top;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        return CollectionUtil.toString(this);
    }

    private class LinkedListStackIterator<E> implements Iterator<E> {

        private SinglyLinkNode<E> newTop;

        public LinkedListStackIterator() {
            if (Objects.nonNull(top)) {
                newTop = new SinglyLinkNode(top.item, top.next);
            }
        }

        @Override
        public boolean hasNext() {
            return Objects.nonNull(newTop);
        }

        @Override
        public E next() {
            E item = newTop.item;
            newTop = newTop.next;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator<>();
    }

    private class LinkedListStackReverseIterator0<E> implements Iterator<E> {

        private SinglyLinkNode<E> newTop;

        public LinkedListStackReverseIterator0() {
            SinglyLinkNode<E> oldTop = (SinglyLinkNode<E>) top;
            newTop = reverse(oldTop);
        }

        /**
         * node -> n1 -> n2 ... -> n*
         */
        private SinglyLinkNode<E> reverse(SinglyLinkNode<E> first) {
            if (Objects.isNull(first)) {
                return null;
            }
            SinglyLinkNode<E> node = new SinglyLinkNode<>(first.item, first.next);
            SinglyLinkNode<E> newTop = null;
            while (Objects.nonNull(node)) {
                SinglyLinkNode<E> tmp = null;
                if (Objects.nonNull(node.next)) {
                    tmp = new SinglyLinkNode<>(node.next.item, node.next.next);
                }
                node.next = newTop;
                newTop = node;
                node = tmp;
            }
            return newTop;
        }

        @Override
        public boolean hasNext() {
            return Objects.nonNull(newTop);
        }

        @Override
        public E next() {
            E item = newTop.item;
            newTop = newTop.next;
            return item;
        }
    }

    private class LinkedListStackReverseIterator<E> implements Iterator<E> {

        private int i;
        private final E[] array;

        public LinkedListStackReverseIterator() {
            Iterator<E> itr = (Iterator<E>) iterator();
            array = (E[]) new Object[size];
            int index = 0;
            while (itr.hasNext()) {
                array[size - (index++) - 1] = itr.next();
            }
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            return (E) array[i++];
        }
    }

    @Override
    public final Iterator<E> reverseIterator() {
        return new LinkedListStackReverseIterator0<>();
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

}
