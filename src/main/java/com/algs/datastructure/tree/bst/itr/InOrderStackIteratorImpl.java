package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

// left, root, right
public class InOrderStackIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    private BstNode<K, V> node;

    private final IStack<BstNode<K, V>> stack;

    public InOrderStackIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public InOrderStackIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(root);
        stack = new LinkedStackImpl<>();
        node = root;
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(node) || !stack.isEmpty();
    }

    /**
     * 1. all the left nodes push to stack, from the perspective of left size of the tree,
     * the pop order of nodes are always: left node first, then root node;
     * 2. pop the node from stack, visit it, access the right subtree
     */
    @Override
    public TreeNode<K, Object> nextNode() {
        while (Objects.nonNull(node)) {
            stack.push(node);
            node = node.left;
        }
        BstNode<K, V> pop = stack.pop();
        visit(pop);
        node = pop.right;
        return (TreeNode<K, Object>) pop;
    }
}
