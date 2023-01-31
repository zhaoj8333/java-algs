package com.algs.datastructure.collection.list.array;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;

import java.util.Collection;

/**
 *
 */
public class CircularArrayListImpl<E> implements IList<E>, RandomAccessList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    private int firstIndex;

    public CircularArrayListImpl() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public CircularArrayListImpl(Collection<? extends E> c) {
    }

    @Override
    public E get(int i) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(E e) {
    }

    public void add(int index, E e) {

    }

    public E remove(int i) {
        return null;
    }

    @Override
    public E remove(E item) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public void reverse() {

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

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> reverseIterator() {
        return null;
    }

}
