package com.algs.datastructure.node;

import java.util.Objects;

public class BstNode<K extends Comparable<K>, V> extends TreeNode<K, V> {

    public BstNode<K, V> parent;
    public BstNode<K, V> left;
    public BstNode<K, V> right;

    public BstNode(K key, V value, BstNode<K, V> parent, BstNode<K, V> left, BstNode<K, V> right, int size) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.size = size;
    }

    @Override
    public K getValue() {
        return key;
    }

    public boolean isLeaf() {
        return Objects.isNull(this.left) && Objects.isNull(this.right);
    }

    public boolean hasTowChildren() {
        return Objects.nonNull(this.left) && Objects.nonNull(this.right);
    }

    public boolean hasChild() {
        return Objects.nonNull(this.left) || Objects.nonNull(this.right);
    }

}
