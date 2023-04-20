package com.algs.datastructure.node;

import com.algs.datastructure.collection.list.array.RandomAccessable;

public class SkipLinkNode<K, V> implements LinkNode<V> {

    private final K key;
    private V value;
    public RandomAccessable<SkipLinkNode<K, V>> nexts;

    public SkipLinkNode(K key, V value, RandomAccessable<SkipLinkNode<K, V>> nexts) {
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

    public RandomAccessable<SkipLinkNode<K, V>> getNexts() {
        return nexts;
    }

}
