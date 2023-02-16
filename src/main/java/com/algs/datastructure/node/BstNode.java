package com.algs.datastructure.node;

public class BinaryPqNode<E> {

    public E value;
    public BinaryPqNode<E> parent;
    public BinaryPqNode<E> left;
    public BinaryPqNode<E> right;

    public BinaryPqNode(E value) {
        this(value, null, null, null);
    }

    public BinaryPqNode(E value, BinaryPqNode<E> parent, BinaryPqNode<E> left, BinaryPqNode<E> right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
