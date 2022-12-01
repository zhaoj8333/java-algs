package com.algs.datastructure.collection.node;

import java.util.Objects;

public class SingleLinkNode<E> implements LinkNode<E> {

    public E item;
    public SingleLinkNode<E> next;

    public SingleLinkNode(E item, SingleLinkNode<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLinkNode<?> that = (SingleLinkNode<?>) o;
        if (item == null) return false;
        if (that.item == null) return false;
        return Objects.equals(item, that.item) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, next);
    }

    @Override
    public E getValue() {
        return item;
    }
}
