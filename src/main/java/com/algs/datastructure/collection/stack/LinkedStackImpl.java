package com.algs.datastructure.collection.stack;

import com.algs.utils.ObjectUtil;

public class LinkedStackImpl<E> extends NullableLinkedStackImpl<E> {

    /**
     * newTop -> oldTop -> n1 -> ... -> n
     */
    @Override
    public void push(E item) {
        ObjectUtil.requireNonNull(item);
        super.push(item);
    }

    /**
     * oldTop -> newTop -> n1 -> ... -> n
     */
    @Override
    public E pop() {
        ObjectUtil.requireNonEmpty(this);
        return super.pop();
    }

}
