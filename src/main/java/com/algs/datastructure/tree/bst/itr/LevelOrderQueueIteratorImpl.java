package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;

import java.util.Objects;

// by topdown level
public class LevelOrderQueueIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> node;

    private final IQueue<BstNode<K, V>> queue;

    public LevelOrderQueueIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public LevelOrderQueueIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
        queue = new LinkedQueueImpl<>();
        queue.enque(root);
    }

    private void pushNode(BstNode<K, V> node) {
        if (Objects.nonNull(node)) {
            queue.enque(node);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public K next() {
        BstNode<K, V> node = queue.deque();
        visit(node);
        pushNode(node.left);
        pushNode(node.right);
        return node.key;
    }

}

