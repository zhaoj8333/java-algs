package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.node.BstNode;

// left, right, root
public class PostOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> node;

    public PostOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PostOrderIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }

    @Override
    public K pred(K key) {
        return null;
    }

    @Override
    public K succ(K key) {
        return null;
    }
}

