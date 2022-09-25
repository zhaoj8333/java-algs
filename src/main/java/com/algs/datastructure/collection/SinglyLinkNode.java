package com.algs.datastructure.collection;

public class SinglyLinkNode<E> {

    public E item;
    public SinglyLinkNode<E> next;

    public SinglyLinkNode(E item, SinglyLinkNode<E> next) {
        this.item = item;
        this.next = next;
    }
}
