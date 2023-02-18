package com.algs.datastructure.node;

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

}
