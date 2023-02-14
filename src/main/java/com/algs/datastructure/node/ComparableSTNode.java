package com.algs.datastructure.node;

public class ComparableSTNode<K extends Comparable<K>, V> implements LinkNode<V>, Comparable<ComparableSTNode<K, V>> {

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

    @Override
    public int compareTo(ComparableSTNode<K, V> that) {
        return this.key.compareTo(that.key);
    }
}
