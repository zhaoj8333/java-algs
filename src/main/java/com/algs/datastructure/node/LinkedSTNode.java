package com.algs.datastructure.node;

public class LinkedSTNode<K, V> implements LinkNode<V> {

    public K key;
    public V val;
    public LinkedSTNode<K, V> next;

    public LinkedSTNode(K key, V val, LinkedSTNode<K, V> next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    @Override
    public V getValue() {
        return val;
    }
}
