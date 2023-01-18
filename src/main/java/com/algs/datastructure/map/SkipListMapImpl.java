package com.algs.datastructure.map;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.node.SkipNode;
import com.algs.utils.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Compare to Red Black tree, {@link SkipListMapImpl} is easier to maintain and debug
 * Average complexity of search, delete, insert is O(logN)
 *
 * Application: {@link java.util.SortedSet}, LevelDB MemTable
 */
public class SkipListMapImpl<K extends Comparable<K>, V> implements IMap<K, V> {

    private int size;

    private final Comparator<K> comparator;

    private final SkipNode<V> head;

    public SkipListMapImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public SkipListMapImpl(int size) {
        this(size, null);
    }

    public SkipListMapImpl(int size, Comparator<K> comparator) {
        this.size = size;
        this.comparator = comparator;
        this.head = new SkipNode<V>(null, new SkipNode[DefaultValues.DEFAULT_CAPACITY]);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int compare(K a, K b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    @Override
    public boolean contains(K key) {
        ObjectUtil.requireNonNull(key);
        return false;
    }

    @Override
    public V put(K key) {
        ObjectUtil.requireNonNull(key);
        return null;
    }

    @Override
    public V get(K key) {
        ObjectUtil.requireNonNull(key);
        return null;
    }

    @Override
    public V remove(K key) {
        ObjectUtil.requireNonNull(key);
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }
}
