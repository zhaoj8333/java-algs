package com.algs.datastructure.node;

public class DoublyLinkNode<E> implements LinkNode<E> {

    public E item;
    public DoublyLinkNode<E> prev;
    public DoublyLinkNode<E> next;

    public DoublyLinkNode(E item, DoublyLinkNode<E> prev, DoublyLinkNode<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public E getValue() {
        return item;
    }
}
