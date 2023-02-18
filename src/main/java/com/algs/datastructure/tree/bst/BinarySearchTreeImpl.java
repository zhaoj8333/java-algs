package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.node.BstNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

/**
 * Recursive Implementation
 */
public class BinarySearchTreeImpl<K extends Comparable<K>, V> extends AbstractBinarySearchTree<K, V> {

    @Override
    public K min() {
        return min((BstNode<K, V>) root).key;
    }

    private BstNode<K, V> min(BstNode<K, V> root) {
        if (Objects.isNull(root.left)) {
            return root;
        }
        return min(root.left);
    }

    @Override
    public K max() {
        return max((BstNode<K, V>) root).key;
    }

    private BstNode<K, V> max(BstNode<K, V> root) {
        if (Objects.isNull(root.right)) {
            return root;
        }
        return max(root.right);
    }

    @Override
    public K floor(K key) {
        BstNode<K, V> floor = floor((BstNode<K, V>) root, key);
        return Objects.nonNull(floor) ? floor.key : null;
    }

    private BstNode<K, V> floor(BstNode<K, V> root, K key) {
        if (Objects.isNull(root)) {
            return null;
        }
        int cmp = compare(key, root.key);
        if (cmp == 0) {
            return root;
        } else if (cmp < 0) {
            return floor(root.left, key);
        }
        BstNode<K, V> tmp = floor(root.right, key);
        if (Objects.nonNull(tmp)) {
            return tmp;
        } else {
            return root;
        }
    }

    @Override
    public K ceil(K key) {
        BstNode<K, V> ceil = ceil((BstNode<K, V>) root, key);
        return Objects.nonNull(ceil) ? ceil.key : null;
    }

    private BstNode<K, V> ceil(BstNode<K, V> root, K key) {
        if (Objects.isNull(root)) {
            return null;
        }
        int cmp = compare(key, root.key);
        if (cmp == 0) {
            return root;
        } else if (cmp > 0) {
            return ceil(root.right, key);
        }
        BstNode<K, V> tmp = ceil(root.left, key);
        if (Objects.nonNull(tmp)) {
            return tmp;
        } else {
            return root;
        }
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(K low, K high) {
        return 0;
    }

    @Override
    public Iiterable<K> keys(K low, K high) {
        return null;
    }

    @Override
    public V get(K key) {
        BstNode<K, V> node = get((BstNode<K, V>) root, key);
        return Objects.nonNull(node) ? node.value : null;
    }

    private BstNode<K, V> get(BstNode<K, V> root, K key) {
        ObjectUtil.requireNonNull(key);
        if (Objects.isNull(root)) {
            return null;
        }
        int cmp = compare(key, root.key);
        if (cmp == 0) {
            return root;
        } else if (cmp < 0) {
            return get(root.left, key);
        } else {
            return get(root.right, key);
        }
    }

    @Override
    public void put(K key, V val) {
        root = put((BstNode<K, V>) root, key, val);
    }

    private BstNode<K, V> put(BstNode<K, V> root, K key, V val) {
        ObjectUtil.requireNonNull(key, val);
        if (Objects.isNull(root)) {
            return new BstNode<>(key, val, null, null, null, 1);
        }
        int cmp = compare(key, root.key);
        if (cmp == 0) {
            root.value = val;
            return root; // ???
        } else if (cmp < 0) {
            root.left = put(root.left, key, val);
        } else {
            root.right = put(root.right, key, val);
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public Iiterable<K> keys() {
        return null;
    }

}
