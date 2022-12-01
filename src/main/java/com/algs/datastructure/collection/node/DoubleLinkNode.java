package com.algs.datastructure.collection.node;

public class DoubleLinkNode<E> implements LinkNode<E> {

    public E item;
    public DoubleLinkNode<E> prev;
    public DoubleLinkNode<E> next;

    public DoubleLinkNode(E item, DoubleLinkNode<E> prev, DoubleLinkNode<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public E getValue() {
        return item;
    }
}
