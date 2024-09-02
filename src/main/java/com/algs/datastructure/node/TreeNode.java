package com.algs.datastructure.node;

import java.util.Objects;

public abstract class TreeNode<K extends Comparable<K>, V> implements LinkNode<K> {

    public int size;
    public K key;
    public V value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode<?, ?> that = (TreeNode<?, ?>) o;
        return size == that.size && Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    public abstract boolean isSubNode(Object o);

    @Override
    public int hashCode() {
        return Objects.hash(size, key, value);
    }

}
