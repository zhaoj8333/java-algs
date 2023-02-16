package com.algs.datastructure.collection.list.array;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Objects;

public class ResizableArrayImpl<E> implements RandomAccessList<E> {

    private int size;
    private E[] entries;
    private final double ratio;

    public ResizableArrayImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ResizableArrayImpl(int cap) {
        this(cap, DefaultValues.CAPACITY_EXPANSION_RATIO);
    }

    public ResizableArrayImpl(int cap, double ratio) {
        RangeUtil.requireRangeWhenAdd(cap, 1, Integer.MAX_VALUE);
        RangeUtil.requireNumberRange(ratio, 1, 1000);
        this.ratio = ratio;
        if (cap < DefaultValues.DEFAULT_CAPACITY) {
            cap = DefaultValues.DEFAULT_CAPACITY;
        }
        this.entries = (E[]) new Object[cap];
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
            ensureCapacity((int) (entries.length * ratio));
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
    public E set(int i, E item) {
        RangeUtil.requireIntRange(i, 0, size);
        E entry = entries[i];
        entries[i] = item;
        return entry;
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, entries[i])) {
                return i;
            }
        }
        return DefaultValues.ELEMENT_NOT_FOUND;
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
    public E get(int i) {
        RangeUtil.requireIntRange(i, 0, size);
        return entries[i];
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != DefaultValues.ELEMENT_NOT_FOUND;
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
        if (index > DefaultValues.ELEMENT_NOT_FOUND) {
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

    private class ResizableArrayImplReverseIterator implements Iterator<E> {

        private int index = size;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public E next() {
            return entries[--index];
        }
    }

    @Override
    public Iterator<E> reverseIterator() {
        return new ResizableArrayImplReverseIterator();
    }

}
