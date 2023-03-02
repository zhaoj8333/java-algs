package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl0;
import com.algs.datastructure.node.BstNode;

// by topdown level
public class LevelOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> node;

    private final IQueue<BstNode<K, V>> orderQueue;

    public LevelOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public LevelOrderIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
        orderQueue = new LinkedQueueImpl0<>();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }

}

