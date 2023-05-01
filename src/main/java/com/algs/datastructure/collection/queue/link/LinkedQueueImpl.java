package com.algs.datastructure.collection.queue.link;

import com.algs.utils.ObjectUtil;

/**
 * Implemented by DoublyLinkedList
 */
@SuppressWarnings("unchecked")
public class LinkedQueueImpl<E> extends NullableLinkedQueueImpl<E> {

    /**
     * head <-> n1 <-> n2 <-> ... <-> oldTail <-> enqueuedDoublyLinkNode
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        super.enque(item);
    }

    /**
     * head(dequedDoublyLinkNode) <-> null
     * head(dequedDoublyLinkNode) <-> n1 <-> n2 <-> ... <-> tail
     */
    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        return super.deque();
    }

}
