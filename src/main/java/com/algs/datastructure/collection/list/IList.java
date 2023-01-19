package com.algs.datastructure.collection.list;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;

public interface IList<E> extends ICollection<E> {

    void add(int index, E item);
    E set(int index, E item);
    int indexOf(E item);
    Iterator<E> reverseIterator();

}
