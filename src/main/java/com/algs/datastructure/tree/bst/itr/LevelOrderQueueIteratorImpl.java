package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl0;
import com.algs.datastructure.node.BstNode;

import java.util.Objects;

// by topdown level
public class LevelOrderQueueIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> node;

    private final IQueue<BstNode<K, V>> orderQueue;

    public LevelOrderQueueIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public LevelOrderQueueIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
        orderQueue = new LinkedQueueImpl0<>();
        pushNode(node);
    }

    private void pushNode(BstNode<K, V> node) {
        if (Objects.nonNull(node)) {
            orderQueue.enque(node);
        }
    }

    @Override
    public boolean hasNext() {
        return !orderQueue.isEmpty();
    }

    @Override
    public K next() {
        BstNode<K, V> node = orderQueue.deque();
        visitor.visit(node);
        pushNode(node.left);
        pushNode(node.right);
        return node.key;
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

