package com.algs.algo.unionfind.generic;

import com.algs.util.ObjectUtil;

import java.util.Objects;

public class UFNode<E> {

    public E item;
    public UFNode<E> parent;
    public int rank;

    public UFNode(E item) {
        ObjectUtil.requireNonNull(item);
        this.item = item;
        this.parent = this;
        this.rank = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UFNode<?> ufNode = (UFNode<?>) o;
        return Objects.equals(item, ufNode.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
