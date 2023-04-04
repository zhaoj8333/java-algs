package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;

/**
 * Recursive order:
 *
 * For Recursive iterators, each node will be accessed 3 times,
 *
 * When node is firstly  visited by {@link IVisitor}, it's {@link PreOrderIteratorImpl}
 * When node is secondly visited by {@link IVisitor}, it's {@link InOrderIteratorImpl}
 * When node is thirdly  visited by {@link IVisitor}, it's {@link PostOrderIteratorImpl}
 *
 * Any recursive functions can be implemented non-recursively
 */
// left, root, right
public class InOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K, V> {

    protected BstNode<K, V> node;

    public InOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public InOrderIteratorImpl(BstNode<K, V> root, IVisitor visitor) {
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
