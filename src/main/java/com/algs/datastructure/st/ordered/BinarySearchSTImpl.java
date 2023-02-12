package com.algs.datastructure.st.ordered;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;

/**
 * Based on ordered indexed array using binary search
 *
 * Complexity:
 *  {@link #put(Comparable, Object)} N
 *  {@link #get(Comparable)}         logN
 *  {@link #delete(Comparable)}      N
 *  {@link #contains(Object)}        logN
 *  {@link #min()}                   1
 *  {@link #max()}                   1
 *  {@link #floor(Comparable)}       logN
 *  {@link #ceil(Comparable)}     logN
 *  {@link #deleteMin()}             N
 *  {@link #deleteMax()}             N
 */
public class BinarySearchSTImpl<K extends Comparable<K>, V> extends AbstractOrderedSymbolTable<K, V> {

    private K[] keys;
    private V[] vals;

    public BinarySearchSTImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public BinarySearchSTImpl(int capacity) {
        this(capacity, null);
    }

    public BinarySearchSTImpl(int capacity, Comparator<K> comparator) {
        super(comparator);
        this.keys = (K[]) new Comparable[capacity];
        this.vals = (V[]) new Object[capacity];
    }

    private void ensureCapacity(int newCap) {
        K[] newKeys = (K[]) new Comparable[newCap];
        ArraysUtil.copyAll(keys, newKeys);
        keys = newKeys;
        V[] newVals = (V[]) new Object[newCap];
        ArraysUtil.copyAll(vals, newVals);
        vals = newVals;
    }

    @Override
    public K min() {
        return keys[0];
    }

    @Override
    public K max() {
        return keys[size - 1];
    }

    @Override
    public K floor(K key) {
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
    public K ceil(K key) {
        int rank = rank(key);
        return keys[rank];
    }

    @Override
    public int rank(K key) {
        ObjectUtil.requireNonNull(key);
        int begin = 0, end = size - 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int cmp = compare(key, keys[mid]);
            if (cmp < 0) {
                end = mid - 1;
            } else if (cmp > 0) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return begin;
    }

    @Override
    public K select(int n) {
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
    public int size(K low, K high) {
        return rank(high) - rank(low);
    }

    @Override
    public Iiterable<K> keys(K low, K high) {
        int lowRank = rank(low);
        int highRank = rank(high);
        IList<K> list = new ResizableArrayImpl<>();
        for (int i = lowRank; i <= highRank; i++) {
            list.add(keys[i]);
        }
        return list;
    }

    @Override
    public Iiterable<K> keys() {
        IList<K> list = new ResizableArrayImpl<>();
        for (int i = 0; i < size; i++) {
            list.add(keys[i]);
        }
        return list;
    }

    @Override
    public V get(K key) {
        int rank = rank(key);
        if (rank < size && compare(keys[rank], key) == 0) {
            return vals[rank];
        }
        return null;
    }

    /**
     * for random inputs, this put is too slow, we can initialize with the whole array,
     * use {@link com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl0} to sort the array to initialize this
     */
    @Override
    public void put(K key, V val) {
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
    public void delete(K key) {
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
