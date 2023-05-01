package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.node.BstNode;
import java.util.Objects;

/**
 * 树/图的遍历分为深度优先搜索(DFS)和广度优先搜索(BFS)。
 * 一般来说深度优先搜索的特点决定了深度优先搜索依赖于栈的实现，而广度优先搜索的实现依赖于队列的实现。
 */
public abstract class BstIterator<K extends Comparable<K>, V> implements Iterator<K> {

    protected final IVisitor visitor;

    public BstIterator() {
        this(null);
    }

    public BstIterator(IVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public final K next() {
        BstNode<K, V> node = nextNode();
        return Objects.nonNull(node) ? node.key : null;
    }

    public abstract BstNode<K, V> nextNode();

    protected void visit(Object node) {
        if (Objects.isNull(visitor)) {
            return;
        }
        visitor.visit(node);
    }

}
