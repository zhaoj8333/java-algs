package com.algs.datastructure.list;

public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public abstract void clear();

    @Override
    public boolean contains(E element) {
        return indexOf(element) == ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public abstract void add(int index, E element);

    @Override
    public abstract E get(int index);

    @Override
    public abstract void set(int index, E element);


    @Override
    public abstract void remove(int index);


    @Override
    public abstract int indexOf(E element);

}
