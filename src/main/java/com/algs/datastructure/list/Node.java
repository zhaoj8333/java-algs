package com.algs.datastructure.list;

import lombok.Getter;

@Getter
public class Node<E> {

    public E element;
    public Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public Node(E element) {
        this.element = element;
        this.next = null;
    }

    public void clear() {
        this.element = null;
        this.next = null;
    }
}
