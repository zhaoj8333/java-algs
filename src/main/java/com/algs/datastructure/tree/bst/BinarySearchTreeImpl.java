package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

/**
 * Non-Recursive Implementation
 */
public class BinarySearchTreeImpl<K extends Comparable<K>, V> extends AbstractBinarySearchTree<K, V> {

    @Override
    public K min() {
        BstNode<K, V> min = min(root);
        return Objects.nonNull(min) ? min.key : null;
    }

    private BstNode<K, V> min(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        while (Objects.nonNull(node.left)) {
            node = node.left;
        }
        return node;
    }

    @Override
    public K max() {
        BstNode<K, V> max = max(root);
        return Objects.nonNull(max) ? max.key : null;
    }

    private BstNode<K, V> max(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        while (Objects.nonNull(node.right)) {
            node = node.right;
        }
        return node;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceil(K key) {
        return null;
    }

    @Override
    public int height() {
        int height = 0;
        IQueue<BstNode<K, V>> q = new LinkedQueueImpl<>();
        q.enque(root);
        int lvSz = 1;
        while (!q.isEmpty()) {
            BstNode<K, V> node = q.deque();
            lvSz--;
            if (Objects.nonNull(node.left)) {
                q.enque(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.enque(node.right);
            }
            if (lvSz == 0) {
                lvSz = q.size();
                height++;
            }
        }
        return height;
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public int leaves() {
        return 0;
    }

    @Override
    public BstNode<K, V> reverse() {
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
        BstNode<K, V> node = getNode(key);
        return Objects.nonNull(node) ? node.value : null;
    }

    private BstNode<K, V> getNode(K key) {
        ObjectUtil.requireNonNull(key);
        BstNode<K, V> node = root;
        while (Objects.nonNull(node)) {
            int cmp = compare(key, node.key);
            if (cmp == 0) {
                return node;
            }
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V val) {
        ObjectUtil.requireNonNull(key, val);
        if (Objects.isNull(root)) {
            root = new BstNode<>(key, val, null, null, null, 1);
            return;
        }
        BstNode<K, V> node = root;
        BstNode<K, V> parent = root;
        int cmp = 0;
        while (Objects.nonNull(node)) {
            parent = node;
            cmp = compare(key, node.key);
            if (cmp == 0) {
                node.value = val;
                return;
            }
            if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        BstNode<K, V> newNode = new BstNode<>(key, val, parent, null, null, 1);
        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public Iiterable<K> keys() {
        return null;
    }

}
