package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.node.BstNode;

// root, left, right
public class PreOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    private final BstNode<K, V> node;

    public PreOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PreOrderIteratorImpl(BstNode<K, V> root, Visitable visitor) {
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
}

