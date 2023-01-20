package com.algs.datastructure.map;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.SkipLinkNode;
import com.algs.utils.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Compare to Red Black tree, {@link SkipListMapImpl} is easier to maintain and debug
 * Average complexity of search, delete, insert is O(logN)
 *
 * Application: {@link java.util.SortedSet}, LevelDB MemTable
 * 
 * // TODO: 1/19/23  
 */
public class SkipListMapImpl<K extends Comparable<K>, V> implements IMap<K, V> {

    private int size;
    private int height;
    private final Comparator<K> comparator;
    private final SkipLinkNode<K, V> head;

    public SkipListMapImpl() {
        this(null);
    }

    public SkipListMapImpl(Comparator<K> comparator) {
        this.comparator = comparator;
        this.head = new SkipLinkNode<>(null, null, new ResizableArrayImpl<>(4, 1.5));
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
        return Objects.nonNull(get(key));
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < DefaultValues.ONE_FOURTH_RATIO && level < DefaultValues.MAX_HEIGHT) {
            level ++;
        }
        return level;
    }

    @Override
    public V put(K key, V val) {
        ObjectUtil.requireNonNull(key);
        SkipLinkNode<K, V> node = this.head;
        SkipLinkNode<K, V>[] prevs = (SkipLinkNode<K, V>[]) new SkipLinkNode<?, ?>[height];
        for (int i = height - 1; i > -1; i--) {
            SkipLinkNode<K, V> next = node.getNexts().get(i);
            int cmp = -1;
            while (Objects.nonNull(next) && (cmp = compare(key, next.getKey())) > 0) {
                node = next;
            }
            if (cmp == 0) {
                V oldVal = node.getValue();
                node.setValue(val);;
                return oldVal;
            }
            prevs[i] = node;
        }
        // node is the predecessor of the new added node
        int newHeight = randomLevel();
        SkipLinkNode<K, V> newNode = new SkipLinkNode<>(key, val, new ResizableArrayImpl<>(newHeight, 1.5));
        for (int i = 0; i < newHeight; i++) {
            if (i >= height) {
                head.nexts.set(i, newNode);
            } else {
                newNode.nexts.set(i, prevs[i].nexts.get(i));
                prevs[i].nexts.set(i, newNode);
            }
        }
        size++;
        height = Math.max(height, newHeight);
        return null;
    }

    /**
     *                                   7.5
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
     */
    @Override
    public V get(K key) {
        ObjectUtil.requireNonNull(key);
        SkipLinkNode<K, V> node = this.head;
        for (int le = height - 1; le > -1; le--) {
            SkipLinkNode<K, V> next = node.nexts.get(le);
            int cmp = -1;
            while (Objects.nonNull(next) && (cmp = compare(key, next.getKey())) > 0) {
                node = next;
            }
            if (cmp == 0) {
                return next.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        ObjectUtil.requireNonNull(key);
        SkipLinkNode<K, V> node = this.head;
        SkipLinkNode<K, V>[] prevs = (SkipLinkNode<K, V>[]) new SkipLinkNode<?, ?>[height];
        boolean exists = false;
        for (int i = height - 1; i > -1; i--) {
            SkipLinkNode<K, V> next = node.getNexts().get(i);
            int cmp = -1;
            while (Objects.nonNull(next) && (cmp = compare(key, next.getKey())) > 0) {
                node = next;
            }
            prevs[i] = node;
            exists = cmp == 0;
        }
        if (!exists) {
            return null;
        }
        // update successor
        SkipLinkNode<K, V> removedNode = node.getNexts().get(0);
        for (int i = 0; i < removedNode.getNexts().size(); i++) {
            prevs[i].nexts.set(i, removedNode.getNexts().get(i));
        }
        // height
        int newHeight = height;
        while (--newHeight >= 0 && head.getNexts().get(newHeight) == null) {
            height = newHeight;
        }
        size--;
        return removedNode.getValue();
    }

    @Override
    public void clear() {
        head.getNexts().clear();
        size = 0;
    }

    private static class SkipListMapImplIterator<K, V> implements Iterator<K> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return null;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }
}
