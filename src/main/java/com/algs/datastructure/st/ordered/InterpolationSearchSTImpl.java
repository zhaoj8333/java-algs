package com.algs.datastructure.st.ordered;

import com.algs.DefaultValues;
import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;
import java.util.Comparator;
import java.util.Objects;

public class InterpolationSearchSTImpl<V> extends AbstractOrderedSymbolTable<Integer, V> {

    private Integer[] keys;
    private V[] vals;

    public InterpolationSearchSTImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public InterpolationSearchSTImpl(int capacity) {
        this(capacity, null);
    }

    public InterpolationSearchSTImpl(int capacity, Comparator<Integer> comparator) {
        super(comparator);
        keys = new Integer[capacity];
        vals = (V[]) new Object[capacity];
    }

    @Override
    public int rank(Integer key) {
        Objects.requireNonNull(key);
        int begin = 0, end = size - 1;
        while (begin <= end) {
            if (compare(keys[begin], key) > 0) {
                return begin;
            }
            int mid = 0;
            int tmp = (keys[end] - keys[begin]);
            if (tmp == 0) {
                mid = begin;
            } else {
                mid = begin + ((key - keys[begin]) * (end - begin) / tmp);
                // System.out.println("mid: " + mid + ", key: " + key + ", begin: " + begin + ", end: " + end);
                // ArraysUtil.println(keys);
            }
            mid = Math.min(mid, end);
            if (mid < 0) {
                return begin;
            }
            int cmp = compare(key, keys[mid]);
            if (cmp > 0) {
                begin = mid + 1;
            } else if (cmp < 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return begin;
    }

    private void ensureCapacity(int newCap) {
        Integer[] newKeys = new Integer[newCap];
        ArraysUtil.copyAll(keys, newKeys);
        keys = newKeys;
        V[] newVals = (V[]) new Object[newCap];
        ArraysUtil.copyAll(vals, newVals);
        vals = newVals;
    }

    @Override
    public Integer min() {
        return keys[0];
    }

    @Override
    public Integer max() {
        return keys[size - 1];
    }

    @Override
    public Integer floor(Integer key) {
        int rank = rank(key);
        if (compare(key, keys[rank]) == 0) {
            return key;
        }
        if (rank > 0) {
            return keys[rank - 1];
        }
        return null;
    }

    @Override
    public Integer ceil(Integer key) {
        return keys[rank(key)];
    }

    @Override
    public Integer select(int n) {
        return keys[n];
    }

    @Override
    public void deleteMin() {
        for (int i = 1; i < size; i++) {
            keys[i - 1] = keys[i];
            vals[i - 1] = vals[i];
        }
        keys[size - 1] = null;
        vals[size--] = null;
    }

    @Override
    public void deleteMax() {
        keys[size - 1] = null;
        vals[size--] = null;
    }

    @Override
    public int size(Integer low, Integer high) {
        if (compare(low, high) > 0) {
            return 0;
        }
        int lowRank = rank(low);
        int hiRank = rank(high);
        if (compare(low, keys[lowRank]) == 0) {
            if (hiRank < size) {
                if (compare(high, keys[hiRank]) == 0) {
                    return hiRank - lowRank + 1;
                }
            } else {
                return size;
            }
        }
        return hiRank - lowRank;
    }

    //   b              i
    // a, c, d, e, f, h, j, m, o, s, x
    @Override
    public Iiterable<Integer> keys(Integer low, Integer high) {
        int lowRank = rank(low);
        int begin = lowRank;
        if (compare(low, keys[lowRank]) > 0) {
            begin++;
        }
        int highRank = rank(high);
        int end = highRank;
        if (compare(high, keys[highRank]) < 0) {
            end--;
        }
        IList<Integer> list = new ResizableArrayImpl<>();
        for (int i = begin; i <= end; i++) {
            list.add(keys[i]);
        }
        return list;
    }

    @Override
    public Iiterable<Integer> keys() {
        IList<Integer> list = new ResizableArrayImpl<>();
        for (int i = 0; i < size; i++) {
            list.add(keys[i]);
        }
        return list;
    }

    @Override
    public V get(Integer key) {
        int rank = rank(key);
        if (rank < size && compare(keys[rank], key) == 0) {
            return vals[rank];
        }
        return null;
    }

    @Override
    public void put(Integer key, V val) {
        ObjectUtil.requireNonNull(val);
        int rank = rank(key);
        if (rank < size && compare(key, keys[rank]) == 0) {
            vals[rank] = val;
            return;
        }
        if (size >= keys.length) {
            ensureCapacity(keys.length << 1);
        }
        for (int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            vals[i] = vals[i - 1];
        }
        keys[rank] = key;
        vals[rank] = val;
        size++;
    }

    @Override
    public void delete(Integer key) {
        int rank = rank(key);
        if (compare(key, keys[rank]) != 0) {
            return;
        }
        for (int i = rank; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            vals[i] = vals[i + 1];
        }
        keys[size - 1] = null;
        vals[size--] = null;
    }

    @Override
    public void clear() {
        ArraysUtil.fill(keys, null);
        ArraysUtil.fill(vals, null);
        size = 0;
    }
}
