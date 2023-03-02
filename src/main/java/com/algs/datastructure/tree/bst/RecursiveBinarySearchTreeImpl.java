package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class RecursiveBinarySearchTreeImpl<K extends Comparable<K>, V> extends AbstractBinarySearchTree<K, V> {

    @Override
    public K min() {
        return min(root).key;
    }

    private BstNode<K, V> min(BstNode<K, V> root) {
        if (Objects.isNull(root.left)) {
            return root;
        }
        return min(root.left);
    }

    @Override
    public K max() {
        return max(root).key;
    }

    private BstNode<K, V> max(BstNode<K, V> root) {
        if (Objects.isNull(root.right)) {
            return root;
        }
        return max(root.right);
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

    @Override
    public TreeNode<K, V> reverse() {
        if (Objects.isNull(root)) {
            return null;
        }
        IQueue<BstNode<K, V>> q = new LinkedQueueImpl<>();
        q.enque(root);
        while (!q.isEmpty()) {
            BstNode<K, V> node = q.deque();
            BstNode<K, V> tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (Objects.nonNull(node.left)) {
                q.enque(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.enque(node.right);
            }
        }
        return root;
    }

    @Override
    public int level(int level) {
        return 0;
    }

    @Override
    public TreeNode<K, V> pred(TreeNode<K, V> node) {
        return null;
    }

    @Override
    public TreeNode<K, V> succ(TreeNode<K, V> node) {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
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
