package com.algs.datastructure.node;

public abstract class TreeNode<K extends Comparable<K>, V> implements LinkNode<K> {

    public int size;
    public K key;
    public V value;

}
