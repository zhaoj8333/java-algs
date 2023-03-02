package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;

import java.util.Objects;

// left, right, root
public class PostOrderStackIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> node;

    private final IStack<BstNode<K, V>> orderStack;

    public PostOrderStackIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PostOrderStackIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
        orderStack = new LinkedStackImpl<>();
        pushNode(node);
    }

    private void pushNode(BstNode<K, V> node) {
        if (Objects.nonNull(node)) {
            if (Objects.nonNull(node.left)) {
                orderStack.push(node.left);
            }
            if (Objects.nonNull(node.right)) {
                orderStack.push(node.right);
            }
            orderStack.push(node);
        }
    }

    @Override
    public boolean hasNext() {
        return !orderStack.isEmpty();
    }

    @Override
    public K next() {
        BstNode<K, V> node = orderStack.pop();
        visit(node);
        pushNode(node);
        return node.key;
    }
}

