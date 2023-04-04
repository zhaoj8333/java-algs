package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;

// left, right, root
// TODO: 4/4/2023  
public class PostOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K, V> {

    protected BstNode<K, V> node;

    public PostOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PostOrderIteratorImpl(BstNode<K, V> root, IVisitor visitor) {
        super(visitor);
        this.node = root;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public TreeNode<K, V> nextNode() {
        return null;
    }

}

