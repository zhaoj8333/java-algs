package com.algs.datastructure.collection;

public class DoublyLinkNode<E> {

    public E item;
    public DoublyLinkNode<E> prev;
    public DoublyLinkNode<E> next;

    public DoublyLinkNode(E item, DoublyLinkNode<E> prev, DoublyLinkNode<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

}
