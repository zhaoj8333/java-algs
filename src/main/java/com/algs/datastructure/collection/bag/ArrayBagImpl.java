package com.algs.datastructure.collection.bag;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.utils.CollectionUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class ArrayBagImpl<E> implements IBag<E> {

    protected int size;
    protected E[] entries;

    public ArrayBagImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayBagImpl(int size) {
        entries = (E[]) new Object[size];
    }

    private void ensureCapacity(int newCap) {
        if (entries.length >= newCap) return;
        E[] newEntries = (E[]) new Object[newCap];
        System.arraycopy(entries, 0, newEntries, 0, entries.length);
        entries = newEntries;
    }

    @Override
    public void add(E item) {
        if (size == entries.length) {
            ensureCapacity(size << 1);
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
                number++;
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
        if (isEmpty()) throw new RuntimeException("Already empty");
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
        ArraysUtil.fill(entries, 0, size, null);
        size = 0;
    }

    @Override
    public E[] toArray() {
        return CollectionUtil.toArray(this);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>();
    }

    @Override
    public E get(int i) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    private class ArrayIterator<E> implements Iterator<E> {

        private int n = -1;

        @Override
        public boolean hasNext() {
            return n <= size - 2;
        }

        @Override
        public E next() {
            return (E) entries[++n];
        }
    }

}
