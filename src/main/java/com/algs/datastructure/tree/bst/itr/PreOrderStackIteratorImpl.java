package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.utils.ObjectUtil;
import java.util.Objects;

// root, left, right
public class PreOrderStackIteratorImpl<K extends Comparable<K>, V> extends BstIterator<K, V> {

    private final IStack<BstNode<K, V>> stack;

    public PreOrderStackIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public PreOrderStackIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(tree);
        stack = new LinkedStackImpl<>();
        stack.push((BstNode<K, V>) tree.getRoot());
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public BstNode<K, V> nextNode() {
        BstNode<K, V> node = stack.pop();
        visit(node);
        if (Objects.nonNull(node.right)) {
            stack.push(node.right);
        }
        if (Objects.nonNull(node.left)) {
            stack.push(node.left);
        }
        return node;
    }
}
