package com.algs.datastructure.collection.stack;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.queue.link.NullableLinkedQueueImpl;
import com.algs.datastructure.node.SinglyLinkNode;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

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
