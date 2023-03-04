package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.Visitable;

import java.util.Objects;

public abstract class TreeIterator<K extends Comparable<K>> implements Iterator<K> {

    protected final Visitable visitor;

    public TreeIterator() {
        this(null);
    }

    public TreeIterator(Visitable visitor) {
        this.visitor = visitor;
    }

    protected void visit(Object node) {
        if (Objects.nonNull(visitor)) {
            visitor.visit(node);
        }
    }

    /**
     * predecessor
     */
    public abstract K pred(K key);

    /**
     * successor
     */
    public abstract K succ(K key);

}
