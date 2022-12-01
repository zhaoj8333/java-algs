package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.node.DoubleLinkNode;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class CircularLinkedListDequeImpl<E> implements IDeque<E> {

    private int size;
    private final DoubleLinkNode<E> head = new DoubleLinkNode<>(null, null, null);
    private final DoubleLinkNode<E> tail = new DoubleLinkNode<>(null, null, null);

    public CircularLinkedListDequeImpl() {
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
    }

    public boolean hasCircle() {
        DoubleLinkNode<E> slow = head.next;
        DoubleLinkNode<E> fast = head.next.next;
        while (Objects.nonNull(slow) && Objects.nonNull(fast)) {
            if (Objects.equals(slow, fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
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
        DoubleLinkNode<E> node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, node.item)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void enqueHead(E item) {
        ObjectUtil.requireNonNull(item);
        DoubleLinkNode<E> first = head.next;
        head.next = new DoubleLinkNode<>(item, head, first);
        first.prev = head.next;
        size++;
    }

    @Override
    public E dequeHead() {
        ObjectUtil.requireNonEmpty(this);
        DoubleLinkNode<E> first = head.next;
        DoubleLinkNode<E> second = head.next.next;
        E item = first.item;
        head.next = first.next;
        second.prev = head;
        size--;
        return item;
    }

    /**
     * head <-> n1 <-> n2 <-> ... node <-> newTail
     *  /|\                                 /|\
     *   |-----------------------------------|
     */
    @Override
    public void enqueTail(E item) {
        ObjectUtil.requireNonNull(item);
        DoubleLinkNode<E> node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
        }
        node.next = new DoubleLinkNode<>(item, node, tail);
        tail.prev = node.next;
        size++;
    }

    /**
     * head <-> n1 <-> n2 <-> ... node <->  tail
     *  /|\                                 /|\
     *   |-----------------------------------|
     */
    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        DoubleLinkNode<E> node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        size--;
        return node.item;
    }

    @Override
    public E peekHead() {
        return Objects.nonNull(head.next) ? head.next.item : null;
    }

    @Override
    public E peekTail() {
        return Objects.nonNull(tail.prev) ? tail.prev.item : null;
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
    public void clear() {
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        DoubleLinkNode<E> node = head.next;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    private class CircularLinkedListDequeIterator<E> implements Iterator<E> {

        private DoubleLinkNode<E> node = (DoubleLinkNode<E>) head.next;

        @Override
        public boolean hasNext() {
            return Objects.isNull(node.item);
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
        return new CircularLinkedListDequeIterator<>();
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void add(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final E remove(E item) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

}
