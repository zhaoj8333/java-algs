package com.algs.datastructure.collection;

import java.util.Objects;

public class SinglyLinkNode<E> {

    public E item;
    public SinglyLinkNode<E> next;

    public SinglyLinkNode(E item, SinglyLinkNode<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkNode<?> that = (SinglyLinkNode<?>) o;
        return Objects.equals(item, that.item) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, next);
    }
}
