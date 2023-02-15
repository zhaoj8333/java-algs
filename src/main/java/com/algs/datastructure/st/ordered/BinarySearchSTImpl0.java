package com.algs.datastructure.st.ordered;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.ComparableSTNode;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;

public class BinarySearchSTImpl0<K extends Comparable<K>, V> extends AbstractOrderedSymbolTable<K, V> {

    private ComparableSTNode<K, V>[] entries;

    public BinarySearchSTImpl0() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public BinarySearchSTImpl0(int capacity) {
        this(capacity, null);
    }

    public BinarySearchSTImpl0(int capacity, Comparator<K> comparator) {
        super(comparator);
        this.entries = (ComparableSTNode<K, V>[]) new ComparableSTNode<?, ?>[capacity];
    }

    private void ensureCapacity(int newCap) {
        ComparableSTNode<K, V>[] newEntries = (ComparableSTNode<K, V>[]) new ComparableSTNode<?, ?>[newCap];
        ArraysUtil.copyAll(entries, newEntries);
        entries = newEntries;
    }

    @Override
    public K min() {
        return entries[0].key;
    }

    @Override
    public K max() {
        return entries[size - 1].key;
    }

    @Override
    public K floor(K key) {
        int rank = rank(key);
        if (compare(key, entries[rank].key) == 0) {
            return key;
        }
        if (rank > 0) {
            return entries[rank - 1].key;
        }
        return null;
    }

    @Override
    public K ceil(K key) {
        return entries[rank(key)].key;
    }

    @Override
    public int rank(K key) {
        ObjectUtil.requireNonNull(key);
        int begin = 0, end = size - 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int cmp = compare(key, entries[mid].key);
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
        RangeUtil.requireIntRange(n, 0, size);
        return entries[n].key;
    }

    @Override
    public void deleteMin() {
        for (int i = 1; i < size; i++) {
            entries[i - 1] = entries[i];
        }
        entries[size--] = null;
    }

    @Override
    public void deleteMax() {
        entries[size--] = null;
    }

    @Override
    public int size(K low, K high) {
        if (compare(low, high) > 0) {
            return 0;
        }
        int lowRank = rank(low);
        int hiRank = rank(high);
        if (compare(low, entries[lowRank].key) == 0) {
            if (hiRank < size) {
                if (compare(high, entries[hiRank].key) == 0) {
                    return hiRank - lowRank + 1;
                }
            } else {
                return size;
            }
        }
        return hiRank - lowRank;
    }

    @Override
    public Iiterable<K> keys(K low, K high) {
        int lowRank = rank(low);
        int begin = lowRank;
        if (compare(low, entries[lowRank].key) > 0) {
            begin++;
        }
        int highRank = rank(high);
        int end = highRank;
        if (compare(high, entries[highRank].key) < 0) {
            end--;
        }
        IList<K> list = new ResizableArrayImpl<>();
        for (int i = begin; i <= end; i++) {
            list.add(entries[i].key);
        }
        return list;
    }

    @Override
    public Iiterable<K> keys() {
        IList<K> list = new ResizableArrayImpl<>();
        for (int i = 0; i < size; i++) {
            list.add(entries[i].key);
        }
        return list;
    }

    @Override
    public V get(K key) {
        int rank = rank(key);
        if (rank < size && compare(entries[rank].key, key) == 0) {
            return entries[rank].val;
        }
        return null;
    }

    /**
     * This approach can reduce the {@link BinarySearchSTImpl#put(Comparable, Object)}
     * Complexity from 2N to N
     */
    @Override
    public void put(K key, V val) {
        ObjectUtil.requireNonNull(val);
        int rank = rank(key);
        ComparableSTNode<K, V> node = new ComparableSTNode<>(key, val);
        if (rank < size && compare(key, entries[rank].key) == 0) {
            entries[rank] = node;
            return;
        }
        if (size >= entries.length) {
            ensureCapacity(entries.length << 1);
        }
        for (int i = size; i > rank; i--) {
            entries[i] = entries[i - 1];
        }
        entries[rank] = node;
        size++;
    }

    @Override
    public void delete(K key) {
        int rank = rank(key);
        if (compare(key, entries[rank].key) != 0) {
            return;
        }
        for (int i = rank; i < size - 1; i++) {
            entries[i] = entries[i + 1];
        }
        entries[size--] = null;
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, null);
        size = 0;
    }
}
