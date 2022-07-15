package com.algs.datastructure.list;

public interface List<E> {

    int ELEMENT_NOT_FOUND = -1;

    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    void add(E element);
    void add(int index, E element);
    E get(int index);
    void set(int index, E element);
    void remove(int index);
    int indexOf(E element);

}
