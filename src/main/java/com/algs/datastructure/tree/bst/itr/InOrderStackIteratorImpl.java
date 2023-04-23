package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

// left, root, right
public class InOrderStackIteratorImpl<K extends Comparable<K>, V> extends BstIterator<K, V> {

    private BstNode<K, V> node;

    private final IStack<BstNode<K, V>> stack;

    public InOrderStackIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public InOrderStackIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(tree);
        stack = new LinkedStackImpl<>();
        node = (BstNode<K, V>) tree.getRoot();
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(node) || !stack.isEmpty();
    }

    /**
     * 1. all the left nodes push to stack, from the perspective of left size of the tree, the pop order of nodes are always: left node first, then root node;
     * 2. pop the node from stack, visit it, then visit the right subtree
     */
    @Override
    public BstNode<K, V> nextNode() {
        while (Objects.nonNull(node)) {
            stack.push(node);
            node = node.left;
        }
        BstNode<K, V> pop = stack.pop();
        visit(pop);
        node = pop.right;
        return pop;
    }
}
