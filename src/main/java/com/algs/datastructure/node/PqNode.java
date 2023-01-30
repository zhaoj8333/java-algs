package com.algs.datastructure.node;

public class PqNode<E> {

    public E item;
    public PqNode<E> parent;
    public PqNode<E> left;
    public PqNode<E> right;

    public PqNode() {
    }

    public PqNode(E item, PqNode<E> parent, PqNode<E> left, PqNode<E> right) {
        this.item = item;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
