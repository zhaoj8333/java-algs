package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

// by topdown level
public class LevelOrderQueueIteratorImpl<K extends Comparable<K>, V> extends BstIterator<K, V> {

    protected BstNode<K, V> node;

    private final IQueue<BstNode<K, V>> queue;

    public LevelOrderQueueIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public LevelOrderQueueIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(visitor);
        node = (BstNode<K, V>) tree.getRoot();
        queue = new LinkedQueueImpl<>();
        queue.enque((BstNode<K, V>) tree.getRoot());
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
    public BstNode<K, V> nextNode() {
        BstNode<K, V> node = queue.deque();
        visit(node);
        pushNode(node.left);
        pushNode(node.right);
        return (BstNode<K, V>) node;
    }
}

