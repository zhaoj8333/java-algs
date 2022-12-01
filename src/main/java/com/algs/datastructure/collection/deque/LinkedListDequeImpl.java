package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.node.DoubleLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class LinkedListDequeImpl<E> implements IDeque<E> {

    private int size;
    private DoubleLinkNode<E> head;
    private DoubleLinkNode<E> tail;

    /**
     * enquedHead(newHead) <-> head <-> n1 <-> ... tail
     * [enqueuedDoubleLinkNode (newTail)] <-> null
     */
    @Override
    public void enqueHead(E item) {
        DoubleLinkNode<E> DoubleLinkNode = new DoubleLinkNode<>(item, null, head);
        if (Objects.nonNull(head)) {
            head.prev = DoubleLinkNode;
        } else {
            tail = DoubleLinkNode;
        }
        head = DoubleLinkNode;
        size++;
    }

    /**
     * head <-> n1 <-> n2 <-> tail
     */
    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        DoubleLinkNode<E> node = head;
        DoubleLinkNode<E> next = node.next;
        if (Objects.nonNull(next)) {
            next.prev = null;
        }
        head = next;
        size--;
        return node.item;
    }

    /**
     * head <-> n1 <-> n2 <-> ... <-> tail <-> enqueuedDoubleLinkNode (newTail)
     * null [enqueuedDoubleLinkNode (newTail)]
     */
    @Override
    public void enqueTail(E item) {
        DoubleLinkNode<E> node = new DoubleLinkNode<>(item, tail, null);
        if (Objects.nonNull(tail)) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * head <-> n1 <-> ... <-> prev <-> tail(dequeuedDoubleLinkNode (newTail))
     * null [enqueuedDoubleLinkNode (newTail)]
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        DoubleLinkNode<E> node = tail;
        DoubleLinkNode<E> prev = tail.prev;
        if (Objects.nonNull(prev)) {
            prev.next = null;
        }
        tail = prev;
        size--;
        return node.item;
    }

    @Override
    public E peekHead() {
        return head.item;
    }

    @Override
    public E peekTail() {
        return tail.item;
    }

    @Override
    public void enque(E item) {
        enqueTail(item);
    }

    @Override
    public E deque() {
        return dequeHead();
    }

    @Override
    public E peek() {
        return peekHead();
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

    private DoubleLinkNode<E> node(E item) {
        DoubleLinkNode<E> node = head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(node.item, item)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        DoubleLinkNode<E> node = head;
        int index = 0;
        while (Objects.nonNull(node)) {
            array[index++] = node.item;
            node = node.next;
        }
        return array;
    }

    private class LinkedListDequeIterator<E> implements Iterator<E> {

        private DoubleLinkNode<E> node = (DoubleLinkNode<E>) head;

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
        return new LinkedListDequeIterator<>();
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
