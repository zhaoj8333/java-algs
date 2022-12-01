package com.algs.datastructure.collection.list.array;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 *
 */
public class CircularArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    private int firstIndex;

    public CircularArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public CircularArrayList(Collection<? extends E> c) {
    }

    @Override
    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public boolean add(E e) {

        return false;
    }

    public void add(int index, E e) {

    }

    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public int indexOf(Object o) {
        return 0;
    }
}
