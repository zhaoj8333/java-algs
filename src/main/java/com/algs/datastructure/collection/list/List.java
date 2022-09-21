package com.algs.datastructure.collection.list;

import com.algs.datastructure.collection.Collection;

public interface List<E> extends Collection<E> {

    void add(int index, E item);
    E get(int index);
    void set(int index, E item);
    int indexOf(E item);
    void reverse();

}
