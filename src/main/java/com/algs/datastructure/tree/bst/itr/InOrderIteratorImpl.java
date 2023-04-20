package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import java.util.Objects;

// left, root, right
public class InOrderIteratorImpl<K extends Comparable<K>, V> extends BstRecursiveIterator<K, V> {

    public InOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public InOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
    }

    @Override
    protected void iterate(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return;
        }
        iterate(node.left);
        visit(node);
        iterate(node.right);
    }

}
