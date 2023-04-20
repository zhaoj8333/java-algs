package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.BstNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class RecursiveBinarySearchTreeImpl<K extends Comparable<K>, V> extends BinarySearchTree<K, V> {

    @Override
    public K min() {
        BstNode<K, V> min = min(root);
        return Objects.nonNull(min) ? min.key : null;
    }

    private BstNode<K, V> min(BstNode<K, V> node) {
        if (Objects.isNull(node) || Objects.isNull(node.left)) {
            return node;
        }
        return min(node.left);
    }

    @Override
    public K max() {
        BstNode<K, V> max = max(root);
        return Objects.nonNull(max) ? max.key : null;
    }

    private BstNode<K, V> max(BstNode<K, V> node) {
        if (Objects.isNull(node) || Objects.isNull(node.right)) {
            return node;
        }
        return max(node.right);
    }

    @Override
    public K floor(K key) {
        BstNode<K, V> floor = floor(root, key);
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
        BstNode<K, V> ceil = ceil(root, key);
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
    public int height() {
        return height(root);
    }

    private int height(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    @Override
    public int depth() {
        return depth(root);
    }

    private int depth(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    @Override
    public int leaves() {
        return 0;
    }

    private int maxDistance(BstNode<K, V> a, BstNode<K, V> b) {
        return 0;
    }

    @Override
    public BstNode<K, V> reverse() {
        return reverse(root);
    }

    public K pred(K key) {
        BstNode<K, V> node = get(root, key);
        if (Objects.isNull(node)) {
            return null;
        }
        BstNode<K, V> pred = pred(node);
        return Objects.nonNull(pred) ? pred.key : null;
    }

    protected BstNode<K, V> pred(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        BstNode<K, V> left = node.left;
        if (Objects.nonNull(left)) {
            return max(left);
        }
        if (Objects.isNull(node.right)) {
            return node;
        }
        return pred(root);
    }

    public K succ(K key) {
        return null;
    }

    public K succNode(K key, BstNode<K, V> root) {
        return null;
    }

    /**
     * Using way of {@link com.algs.datastructure.tree.bst.itr.PreOrderIteratorImpl},
     * be careful if you use the way of {@link com.algs.datastructure.tree.bst.itr.InOrderIteratorImpl}
     */
    private BstNode<K, V> reverse(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        BstNode<K, V> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        reverse(node.left);
        reverse(node.right);
        return node;
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return true;
        }
        return isBalanced(node.left) && isBalanced(node.right)
                && Math.abs(height(node.left) - height(node.right)) <= 1;
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
        BstNode<K, V> node = get(root, key);
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
        root = put(root, key, val);
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
