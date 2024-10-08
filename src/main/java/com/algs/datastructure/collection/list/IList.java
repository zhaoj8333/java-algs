package com.algs.datastructure.collection.list;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;

public interface IList<E> extends ICollection<E> {

    void add(int index, E item);
    E set(int index, E item);
    int indexOf(E item);
    Iterator<E> reverseIterator();
    void reverse();

}
