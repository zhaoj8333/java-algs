package com.algs.datastructure.node;

import java.util.Objects;

public class SinglyLinkNode<E> implements LinkNode<E> {

    public E item;
    public SinglyLinkNode<E> next;

    public SinglyLinkNode(E item, SinglyLinkNode<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SinglyLinkNode<?> that = (SinglyLinkNode<?>) obj;
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
