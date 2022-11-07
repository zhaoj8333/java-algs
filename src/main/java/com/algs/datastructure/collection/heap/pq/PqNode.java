package com.algs.datastructure.collection.heap.pq;

public class PqNode<E> {

    E item;
    PqNode<E> parent;
    PqNode<E> left;
    PqNode<E> right;

    public PqNode() {
    }

    public PqNode(E item, PqNode<E> parent, PqNode<E> left, PqNode<E> right) {
        this.item = item;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
