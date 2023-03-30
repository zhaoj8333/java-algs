package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.Visitable;
import com.algs.datastructure.node.TreeNode;

import java.util.Objects;

/**
 * 树/图的遍历分为深度优先搜索(DFS)和广度优先搜索(BFS)。
 * 一般来说深度优先搜索的特点决定了深度优先搜索依赖于栈的实现，而广度优先搜索的实现依赖于队列的实现。
 */
public abstract class TreeIterator<K extends Comparable<K>> implements Iterator<K> {

    protected final Visitable visitor;

    public TreeIterator() {
        this(null);
    }

    public TreeIterator(Visitable visitor) {
        this.visitor = visitor;
    }

    @Override
    public K next() {
        TreeNode<K, Object> node = nextNode();
        return Objects.nonNull(node) ? node.key : null;
    }

    public abstract TreeNode<K, Object> nextNode();

    protected void visit(Object node) {
        if (Objects.isNull(visitor)) {
            return;
        }
        visitor.visit(node);
    }

}
