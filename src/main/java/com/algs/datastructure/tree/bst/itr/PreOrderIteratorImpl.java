package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

// root, left, right
public class PreOrderIteratorImpl<K extends Comparable<K>, V> extends BstRecursiveIterator<K, V> {

    public PreOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public PreOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
    }

    @Override
    protected void iterate(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return;
        }
        visit(node);
        iterate(node.left);
        iterate(node.right);
    }

}

