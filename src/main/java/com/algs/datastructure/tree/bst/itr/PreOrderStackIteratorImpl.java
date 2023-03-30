package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

// root, left, right
public class PreOrderStackIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    private final IStack<BstNode<K, V>> stack;

    public PreOrderStackIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PreOrderStackIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(root);
        stack = new LinkedStackImpl<>();
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeNode<K, Object> nextNode() {
        BstNode<K, V> node = stack.pop();
        visit(node);
        if (Objects.nonNull(node.right)) {
            stack.push(node.right);
        }
        if (Objects.nonNull(node.left)) {
            stack.push(node.left);
        }
        return (TreeNode<K, Object>) node;
    }
}
