package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

/**
 * 树/图的遍历分为深度优先搜索(DFS)和广度优先搜索(BFS)。
 * 一般来说深度优先搜索的特点决定了深度优先搜索依赖于栈的实现，而广度优先搜索的实现依赖于队列的实现。
 */
public abstract class BstRecursiveIterator<K extends Comparable<K>, V> implements IRecursiveIterator<K> {

    protected final BstNode<K, V> root;

    protected final IVisitor visitor;

    public BstRecursiveIterator() {
        this(null);
    }

    public BstRecursiveIterator(ITree<K, V> tree) {
        this(tree, null);
    }

    public BstRecursiveIterator(ITree<K, V> tree, IVisitor visitor) {
        root = (BstNode<K, V>) tree.getRoot();
        this.visitor = visitor;
    }

    protected void visit(Object node) {
        if (Objects.isNull(visitor)) {
            return;
        }
        visitor.visit(node);
    }

    @Override
    public void iterate() {
        iterate(root);
    }

    protected abstract void iterate(BstNode<K, V> node);

}
