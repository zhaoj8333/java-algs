package com.algs.datastructure.tree.bst.itr.morris;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

public class MorrisPreOrderIteratorImpl<K extends Comparable<K>, V> extends MorrisIterator<K, V> {

    public MorrisPreOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public MorrisPreOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
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
                    visit(node);
                    node = node.left;
                    continue;
                } else {
                    rightest.right = null;
                }
            } else {
                visit(node);
            }
            node = node.right;
        }
    }

}
