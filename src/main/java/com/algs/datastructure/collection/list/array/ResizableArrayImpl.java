package com.algs.datastructure.collection.list.array;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Objects;

public class ResizableArrayImpl<E> implements RandomAccessList<E> {

    private int size;
    private E[] entries;

    public ResizableArrayImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ResizableArrayImpl(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public void add(int index, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(index, 0, size);
        if (size == entries.length) {
            ensureCapacity(entries.length << 1);
        }
        if (index < size) {
            for (int i = size; i > index; i--) {
                entries[i] = entries[i - 1];
            }
        }
        entries[index] = item;
        size++;
    }

    private void ensureCapacity(int newCap) {
        E[] newEntries = (E[]) new Object[newCap];
        ArraysUtil.copyAll(entries, newEntries);
        entries = newEntries;
    }

    @Override
    public E set(int index, E item) {
        RangeUtil.requireIndexRange(index, 0, size);
        E entry = entries[index];
        entries[index] = item;
        return entry;
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, entries[i])) {
                return i;
            }
        }
        return -1;
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
    public E get(int index) {
        RangeUtil.requireIndexRange(index, 0, size);
        return entries[index];
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    @Override
    public E remove(int index) {
        E old = set(index, null);
        if (index < size - 1) {
            for (int i = index; i < size; i++) {
                entries[i] = entries[i + 1];
            }
        }
        size--;
        return old;
    }

    @Override
    public E remove(E item) {
        int index = indexOf(item);
        if (index > -1) {
            return remove(index);
        }
        return null;
    }

    @Override
    public void clear() {
        ArraysUtil.rangeClear(entries, 0, size - 1);
        size = 0;
    }

    @Override
    public E[] toArray() {
        return CollectionUtil.toArray(this);
    }

    @Override
    public void reverse() {
        ArraysUtil.reverse(entries, 0, size);
    }

    private class ResizableArrayImplIterator implements Iterator<E> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return entries[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ResizableArrayImplIterator();
    }
}
