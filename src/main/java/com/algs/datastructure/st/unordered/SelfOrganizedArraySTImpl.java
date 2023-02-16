package com.algs.datastructure.st.unordered;

import com.algs.DefaultValues;
import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.KeyValNode;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Objects;

/**
 * move-to-front heuristic
 */
public class SelfOrganizedArraySTImpl<K, V> extends AbstractSymbolTable<K, V> {

    private KeyValNode<K, V>[] entries;

    public SelfOrganizedArraySTImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public SelfOrganizedArraySTImpl(int capacity) {
        this.entries = (KeyValNode<K, V>[]) new KeyValNode<?, ?>[capacity];
    }

    /**
     * {0, 1, 2, 3, 4, 5, 6, 7, 8}
     *          idx
     */
    @Override
    public V get(K key) {
        int idx = node(key);
        if (idx == DefaultValues.ELEMENT_NOT_FOUND) {
            return null;
        }
        KeyValNode<K, V> entry = entries[idx];
        for (int i = idx; i >= 1; i--) {
            entries[i] = entries[i - 1];
        }
        entries[0] = entry;
        return entry.val;
    }

    private int node(K key) {
        ObjectUtil.requireNonNull(key);
        for (int i = 0; i < size; i++) {
            if (Objects.equals(entries[i].key, key)) {
                return i;
            }
        }
        return DefaultValues.ELEMENT_NOT_FOUND;
    }

    private void ensureCapacity(int newCap) {
        KeyValNode<K, V>[] newEntries = (KeyValNode<K, V>[]) new KeyValNode<?, ?>[newCap];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    @Override
    public void put(K key, V val) {
        ObjectUtil.requireNonNull(val);
        int idx = node(key);
        if (idx > DefaultValues.ELEMENT_NOT_FOUND) {
            entries[idx] = new KeyValNode<>(key, val);
            return;
        }
        if (size == entries.length) {
            ensureCapacity(size << 1);
        }
        entries[size++] = new KeyValNode<>(key, val);
    }

    @Override
    public void delete(K key) {
        int idx = node(key);
        if (idx == DefaultValues.ELEMENT_NOT_FOUND) {
            return;
        }
        for (int i = idx; i < size - 1; i++) {
            entries[i] = entries[i + 1];
        }
        entries[--size] = null;
    }

    @Override
    public Iiterable<K> keys() {
        IList<K> list = new ResizableArrayImpl<>(size);
        for (int i = 0; i < size; i++) {
            list.add(entries[i].key);
        }
        return list;
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, null);
        size = 0;
    }
}
