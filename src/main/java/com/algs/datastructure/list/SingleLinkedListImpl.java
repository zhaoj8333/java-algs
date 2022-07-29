package com.algs.datastructure.list;

import com.algs.util.RangeUtil;

public class SingleLinkedListImpl<E> extends AbstractList<E> {

    private final Node<E> head = new Node<>(null, null);

    public Node<E> getHead() {
        return head;
    }

    @Override
    public void clear() {
        head.clear();
        size = 0;
    }

    private Node<E> node(int index) {
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void add(int index, E element) {
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        Node<E> node = node(index);
        Node<E> insertedNode = new Node<>(element);
        insertedNode.next = node.next;
        node.next = insertedNode;
        size++;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public void remove(int index) {

    }

}
