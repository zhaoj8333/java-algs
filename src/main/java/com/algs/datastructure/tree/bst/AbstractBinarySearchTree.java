package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.itr.InOrderIteratorImpl;
import com.algs.utils.CompareUtil;
import com.algs.utils.TreeUtil;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractBinarySearchTree<K extends Comparable<K>, V> implements ITree<K, V> {

    protected BstNode<K, V> root;

    private final Comparator<K> comparator;

    protected AbstractBinarySearchTree() {
        this(null);
    }

    public AbstractBinarySearchTree(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    protected int compare(K a, K b) {
        return CompareUtil.compare(a, b, comparator);
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public int size(TreeNode<K, V> node) {
        return Objects.nonNull(node) ? node.size : 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean contains(K key) {
        return Objects.nonNull(get(key));
    }

    @Override
    public boolean isComplete() {
        if (Objects.isNull(root)) {
            return false;
        }
        IQueue<BstNode<K, V>> q = new LinkedQueueImpl<>();
        q.enque(root);
        boolean requireLeaf = false;
        while (!q.isEmpty()) {
            BstNode<K, V> node = q.deque();
            if (requireLeaf && !node.isLeaf()) {
                return false;
            }
            if (Objects.nonNull(node.left)) {
                q.enque(node.left);
            } else if (Objects.nonNull(node.right)) {
                return false;
            }
            if (Objects.nonNull(node.right)) {
                q.enque(node.right);
            } else {
                requireLeaf = true;
            }
        }
        return true;
    }

    @Override
    public TreeNode<K, V> sibling(TreeNode<K, V> node) {
        BstNode<K, V> n = (BstNode<K, V>) node;
        BstNode<K, V> parent = n.parent;
        if (compare(parent.left.key, node.key) < 0) {
            return parent.right;
        } else {
            return parent.left;
        }
    }

    @Override
    public String toString() {
        return TreeUtil.toString(this);
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((BstNode<K, V>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((BstNode<K, V>) node).right;
    }

    @Override
    public Object string(Object node) {
        BstNode<K, V> n = (BstNode<K, V>) node;
        return n.key;
    }

    @Override
    public Iterator<K> iterator() {
        return iterator(InOrderIteratorImpl.class, null);
    }

    @Override
    public Iterator<K> iterator(Class<?> itrClass, Visitable visitor) {
        Object instance = null;
        try {
            Constructor<?> constructor = itrClass.getConstructor(BstNode.class, Visitable.class);
            instance = constructor.newInstance(root, visitor);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return (Iterator<K>) instance;
    }

}
