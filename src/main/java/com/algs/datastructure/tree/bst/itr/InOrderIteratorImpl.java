package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;

/**
 * Recursive order:
 *
 * For Recursive iterators, each node will be accessed 3 times,
 *
 * When node is firstly accessed, then visited by {@link Visitable}, it's {@link PreOrderIteratorImpl}
 * When node is secondly accessed, then visited by {@link Visitable}, it's {@link InOrderIteratorImpl}
 * When node is thirdly accessed, then visited by {@link Visitable}, it's {@link PostOrderIteratorImpl}
 *
 * Any recursive functions can be implemented non-recursively
 */
// left, root, right
public class InOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> root;

    private final IStack<BstNode<K, V>> orderStack;

    public InOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public InOrderIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.root = root;
        orderStack = new LinkedStackImpl<>();
        orderStack.push(root);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public TreeNode<K, Object> nextNode() {
        return null;
    }
}
