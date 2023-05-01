package com.algs.datastructure.collection.list.array;

import com.algs.DefaultValues;
import com.algs.utils.ObjectUtil;

public class ResizableArrayImpl<E> extends NullableResizableArrayImpl<E> {

    public ResizableArrayImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ResizableArrayImpl(int cap) {
        this(cap, DefaultValues.CAPACITY_EXPANSION_RATIO);
    }

    public ResizableArrayImpl(int cap, double ratio) {
        super(cap, ratio);
    }

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        super.add(size, item);
    }

    @Override
    public E set(int i, E item) {
        ObjectUtil.requireNonNull(item);
        return super.set(i, item);
    }

    @Override
    public E remove(E item) {
        ObjectUtil.requireNonNull(item);
        return super.remove(item);
    }

    @Override
    public int indexOf(E item) {
        ObjectUtil.requireNonNull(item);
        return super.indexOf(item);
    }

}
