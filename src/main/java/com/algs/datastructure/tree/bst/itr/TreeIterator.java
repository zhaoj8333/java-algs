package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.TreeNode;

import java.util.Objects;

/**
 * 树/图的遍历分为深度优先搜索(DFS)和广度优先搜索(BFS)。
 * 一般来说深度优先搜索的特点决定了深度优先搜索依赖于栈的实现，而广度优先搜索的实现依赖于队列的实现。
 */
public abstract class TreeIterator<K extends Comparable<K>, V> implements Iterator<K> {

    protected final IVisitor visitor;

    public TreeIterator() {
        this(null);
    }

    public TreeIterator(IVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public final K next() {
        TreeNode<K, V> node = nextNode();
        return Objects.nonNull(node) ? node.key : null;
    }

    public abstract TreeNode<K, V> nextNode();

    protected void visit(Object node) {
        if (Objects.isNull(visitor)) {
            return;
        }
        visitor.visit(node);
    }

}
