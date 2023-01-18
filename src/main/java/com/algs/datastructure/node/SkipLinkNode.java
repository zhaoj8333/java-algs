package com.algs.datastructure.node;

import com.algs.datastructure.collection.list.array.RandomAccessList;

public class SkipNode<K, V> implements LinkNode<K> {

    public K item;
    public RandomAccessList<SkipNode<K, V>> nexts;

    public SkipNode(K item, RandomAccessList<SkipNode<K, V>> nexts) {
        this.item = item;
        this.nexts = nexts;
    }

    @Override
    public K getValue() {
        return item;
    }

    public RandomAccessList<SkipNode<K, V>> getNexts() {
        return nexts;
    }

}
