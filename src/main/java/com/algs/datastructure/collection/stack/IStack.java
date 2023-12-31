package com.algs.datastructure.collection.stack;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;

/**
 * {@link java.util.Stack}
 *
 * LIFO
 */
public interface IStack<E> extends ICollection<E> {

    void push(E item);

    E pop();

    E top();

    Iterator<E> reverseIterator();

}
