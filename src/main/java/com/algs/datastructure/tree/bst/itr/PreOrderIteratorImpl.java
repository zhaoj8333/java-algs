package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.utils.ObjectUtil;
import java.util.Objects;

// root, left, right
// TODO: 4/4/2023  
public class PreOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K, V> {

    private BstNode<K, V> node;

    private BstNode<K, V> next;

    public PreOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PreOrderIteratorImpl(BstNode<K, V> root, IVisitor visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(root);
        this.node = root;
        this.next = root;
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    @Override
    public BstNode<K, V> nextNode() {
        return null;
    }

}

