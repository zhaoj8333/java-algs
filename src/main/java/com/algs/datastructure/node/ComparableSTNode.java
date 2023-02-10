package com.algs.datastructure.node;

public class ComparableSTNode<K extends Comparable<K>, V> implements LinkNode<V> {

    public K key;
    public V val;

    public ComparableSTNode(K key, V val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public V getValue() {
        return val;
    }

}
