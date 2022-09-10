package com.algs.datastructure.collection.bag;

import java.util.Arrays;
import java.util.Objects;

public class ArrayBagImpl<E> implements IBag<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private E[] entries;

    public ArrayBagImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBagImpl(int size) {
        entries = (E[]) new Object[size];
    }

    private boolean isFull() {
        return size == entries.length;
    }

    private void resize(int newSize) {
        E[] newEntries = (E[]) new Object[newSize];
        System.arraycopy(entries, 0, newEntries, 0, entries.length);
        entries = newEntries;
    }

    @Override
    public void add(E item) {
        if (isFull()) {
            resize(size << 1);
        }
        entries[size++] = item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numberOf(E item) {
        int number = 0;
        for (E datum : entries) {
            if (Objects.equals(item, datum)) {
                number ++;
            }
        }
        return number;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) > -1;
    }

    @Override
    public E remove() {
        return removeIndexOf(size - 1);
    }

    /**
     * replace the item of index with the last item
     * then the last item assigned with null
     */
    private E removeIndexOf(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Already empty");
        }
        E item = entries[index];
        entries[index] = entries[size - 1];
        entries[--size] = null;
        return item;
    }

    @Override
    public E remove(E item) {
        int index = indexOf(item);
        if (index > -1) {
            removeIndexOf(index);
        }
        return item;
    }

    private int indexOf(E item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, entries[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void clear() {
        Arrays.fill(entries, null);
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        System.arraycopy(entries, 0, array, 0, size);
        return array;
    }
}
