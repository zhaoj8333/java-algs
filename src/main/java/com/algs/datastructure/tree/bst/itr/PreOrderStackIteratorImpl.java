package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;

import java.util.Objects;

// root, left, right
public class PreOrderStackIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    private final BstNode<K, V> node;

    private final IStack<BstNode<K, V>> orderStack;

    public PreOrderStackIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PreOrderStackIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
        orderStack = new LinkedStackImpl<>();
        if (Objects.nonNull(node)) {
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
        if (Objects.nonNull(node)) {
            if (Objects.nonNull(node.right)) {
                orderStack.push(node.right);
            }
            if (Objects.nonNull(node.left)) {
                orderStack.push(node.left);
            }
        }
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

