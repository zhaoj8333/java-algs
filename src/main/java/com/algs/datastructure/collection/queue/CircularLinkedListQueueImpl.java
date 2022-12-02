package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.node.SinglyLinkNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class CircularLinkedListQueueImpl<E> implements IQueue<E> {

    private int size;
    private SinglyLinkNode<E> head = new SinglyLinkNode<>(null, null);
    private SinglyLinkNode<E> tail = new SinglyLinkNode<>(null, null);

    public CircularLinkedListQueueImpl() {
        head.next = tail;
        tail.next = head;
    }

    @Override
    public void enque(E item) {
        linkLast(item);
    }

    public boolean hasCircle() {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return false;
        }
        SinglyLinkNode<E> slow = head.next;
        SinglyLinkNode<E> fast = head.next.next;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
            if (Objects.equals(slow, fast)) {
                return true;
            }
        }
        return false;
    }

    /**
     * head -> n1 -> n2 -> n3 -> node -> tail
     *   /|\                              |
     *    --------------------------------
     */
    private void linkLast(E item) {
        ObjectUtil.requireNonNull(item);
        SinglyLinkNode<E> node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
        }
        tail.next = node.next = new SinglyLinkNode<>(item, head);
        size++;
    }

    /**
     * dequed Node(head)
     *
     * head -> n1 -> n2 -> n3 -> n4 -> tail
     *   /|\                            |
     *   <------------------------------
     *
     * head ->
     *  /|\  |
     *  <----
     */
    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        E item = head.next.item;
        head.next = head.next.next;
        tail.next = head.next;
        if (size == 1) {
            head.next = tail.next = null;
        }
        size--;
        return item;
    }

    @Override
    public E peek() {
        return Objects.nonNull(head) ? head.item : null;
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
        SinglyLinkNode<E> node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, node.item)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        SinglyLinkNode<E> node = head.next;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }

    private class CircularLinkedListQueueIterator<E> implements Iterator<E> {

        private SinglyLinkNode<E> node = (SinglyLinkNode<E>) head.next;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            E item = node.item;
            node = node.next;
            index ++;
            return item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularLinkedListQueueIterator<>();
    }

    @Override
    public final E get(int index) {
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
