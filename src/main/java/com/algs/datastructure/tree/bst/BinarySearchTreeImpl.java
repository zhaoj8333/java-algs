package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.bst.serialize.ValHandler;
import com.algs.utils.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Non-Recursive Implementation
 */
public class BinarySearchTreeImpl<K extends Comparable<K>, V> extends BinarySearchTree<K, V> {

    public BinarySearchTreeImpl() {
        this(null);
    }

    public BinarySearchTreeImpl(Comparator<K> comparator) {
        super(comparator);
    }

    @Override
    public K min() {
        BstNode<K, V> min = min(root);
        return Objects.nonNull(min) ? min.key : null;
    }

    private BstNode<K, V> min(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        BstNode<K, V> min = node;
        while (Objects.nonNull(min.left)) {
            min = min.left;
        }
        return min;
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
        BstNode<K, V> max = node;
        while (Objects.nonNull(max.right)) {
            max = max.right;
        }
        return max;
    }

    @Override
    public K floor(K key) {
        ObjectUtil.requireNonNull(key);
        BstNode<K, V> parent = null;
        BstNode<K, V> node = root;
        while (Objects.nonNull(node)) {
            int cmp = compare(key, node.key);
            if (cmp == 0) {
                return node.key;
            }
            parent = node;
            if (cmp < 0) {
                node = node.left;
//                if (compare(key, )) {
//                    return ;
//                }
            } else {
                node = node.right;
            }
        }
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
    public K pred(K key) {
        BstNode<K, V> node = pred(getNode(key));
        return Objects.nonNull(node) ? node.key : null;
    }

    protected BstNode<K, V> pred(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        BstNode<K, V> tmp = node.left;
        if (Objects.nonNull(tmp)) {
            while (Objects.nonNull(tmp.right)) {
                tmp = tmp.right;
            }
            return tmp;
        }
        // parent
        while (Objects.nonNull(node.parent) && Objects.equals(node, node.parent.left)) {
            node = node.parent;
        }
        return node.parent;
    }

    @Override
    public K succ(K key) {
        BstNode<K, V> node = succ(getNode(key));
        return Objects.nonNull(node) ? node.key : null;
    }

    protected BstNode<K, V> succ(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        BstNode<K, V> tmp = node.right;
        if (Objects.nonNull(tmp)) {
            while (Objects.nonNull(tmp.left)) {
                tmp = tmp.left;
            }
            return tmp;
        }
        // parent
        while (Objects.nonNull(node.parent) && Objects.equals(node, node.parent.right)) {
            node = node.parent;
        }
        return node.parent;
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
    public boolean isBalanced() {
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
        BstNode<K, V> min = min(root);
        if (Objects.isNull(min)) {
            return;
        }
        if (Objects.isNull(min.parent)) {
            root = null;
            return;
        }
        delete(min);
    }

    @Override
    public void deleteMax() {
        BstNode<K, V> max = max(root);
        if (Objects.isNull(max)) {
            return;
        }
        if (Objects.isNull(max.parent)) {
            root = null;
            return;
        }
        delete(max);
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
        BstNode<K, V> tmp = newNode;
        while (Objects.nonNull(tmp.parent)) {
            tmp.parent.size();
            tmp = tmp.parent;
        }
    }

    @Override
    public void delete(K key) {
        delete(getNode(key));
    }

    public void delete(BstNode<K, V> node) {
        if (Objects.isNull(node)) {
            return;
        }
        if (node.hasTwoChildren()) {
            BstNode<K, V> rept;
            if (node.left.size >= node.right.size) {
                rept = max(node.left);
            } else {
                rept = min(node.right);
            }
            if (Objects.nonNull(rept)) {
                node.key = rept.key;
                node.value = rept.value;
            }
            node = rept;
        }
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.isNull(node.parent)) {
            root = null;
            return;
        }
        BstNode<K, V> replt = Objects.nonNull(node.left) ? node.left : node.right;
        if (Objects.nonNull(replt)) {
            replt.parent = node.parent;
        }
        if (Objects.equals(node.parent.left, node)) {
            node.parent.left = replt;
        } else if (Objects.equals(node.parent.right, node)) {
            node.parent.right = replt;
        }
        BstNode<K, V> tmp = node;
        while (Objects.nonNull(tmp.parent)) {
            tmp.parent.size--;
            tmp = tmp.parent;
        }
    }

    @Override
    public Iiterable<K> keys() {
        return null;
    }

}
