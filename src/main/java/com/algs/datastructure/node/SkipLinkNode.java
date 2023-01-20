package com.algs.datastructure.node;

import com.algs.datastructure.collection.list.array.RandomAccessList;

public class SkipLinkNode<K, V> implements LinkNode<V> {

    private final K key;
    private V value;
    public RandomAccessList<SkipLinkNode<K, V>> nexts;

    public SkipLinkNode(K key, V value, RandomAccessList<SkipLinkNode<K, V>> nexts) {
        this.key = key;
        this.value = value;
        this.nexts = nexts;
    }

    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public RandomAccessList<SkipLinkNode<K, V>> getNexts() {
        return nexts;
    }

}
