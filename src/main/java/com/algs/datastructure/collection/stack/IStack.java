package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.Collection;

/**
 * {@link java.util.Stack}
 *
 * LIFO
 */
public interface IStack<E> extends Collection<E> {

    void push(E item);

    E pop();

    E top();

}
