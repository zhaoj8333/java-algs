package com.algs.algo.unionfind;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.IDisjointSet;
import com.algs.util.RangeUtil;

public class QuickFindImpl<E> implements IDisjointSet<E> {

    private E[] id;

    public QuickFindImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuickFindImpl(int capacity) {
        RangeUtil.requireGreaterThan(capacity, 0);
        id = (E[]) new Object[capacity];
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void union(E p, E q) {

    }

    @Override
    public E find(E p) {
        return null;
    }

    @Override
    public boolean connected(E p, E q) {
        return false;
    }
}