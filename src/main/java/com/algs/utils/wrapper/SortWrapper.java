package com.algs.utils.wrapper;

public class SortWrapper implements Comparable<SortWrapper> {

    private final Comparable key;
    private final int index;

    public SortWrapper(Comparable key, int index) {
        this.key = key;
        this.index = index;
    }

    @Override
    public int compareTo(SortWrapper that) {
        int cmp = this.key.compareTo(that.key);
        if (cmp != 0) {
            return cmp;
        }
        if (this.index < that.index) {
            return -1;
        } else if (this.index > that.index) {
            return 1;
        }
        return 0;
    }
}
