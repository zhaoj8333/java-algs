package com.algs.datastructure.tree.bst.itr.morris;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

public class MorrisInOrderIteratorImpl<K extends Comparable<K>, V> extends MorrisIterator<K, V> {

    public MorrisInOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public MorrisInOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
    }

    @Override
    protected void iterate(BstNode<K, V> node) {
        while (Objects.nonNull(node)) {
            rightest = node.left;
            if (Objects.nonNull(rightest)) {
                while (Objects.nonNull(rightest.right) && !Objects.equals(rightest.right, node)) {
                    rightest = rightest.right;
                }
                if (Objects.isNull(rightest.right)) {
                    rightest.right = node;
                    node = node.left;
                    continue;
                } else {
                    rightest.right = null;
                }
            }
            visit(node);
            node = node.right;
        }
    }
}
