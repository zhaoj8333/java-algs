package com.algs.datastructure.tree.bst;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.itr.BstIterator;
import com.algs.datastructure.tree.bst.itr.InOrderStackIteratorImpl;
import com.algs.utils.CompareUtil;
import com.algs.utils.TreeUtil;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public abstract class BinarySearchTree<K extends Comparable<K>, V> implements ITree<K, V> {

    protected BstNode<K, V> root;

    private final Comparator<K> comparator;

    protected BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<K> comparator) {
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
    public int maxWidth() {
//        return maxWidthMap();
        return maxWidth0();
    }

    private int maxWidth0() {
        if (Objects.isNull(root)) {
            return 0;
        }
        IQueue<BstNode<K, V>> q = new LinkedQueueImpl<>();
        q.enque(root);
        BstNode<K, V> curEnd = root;
        BstNode<K, V> nxtEnd = null;
        int max = 0;
        int curLvlNodes = 0;
        while (!q.isEmpty()) {
            BstNode<K, V> curr = q.deque();
            if (Objects.nonNull(curr.left)) {
                q.enque(curr.left);
                nxtEnd = curr.left;
            }
            if (Objects.nonNull(curr.right)) {
                q.enque(curr.right);
                nxtEnd = curr.right;
            }
            curLvlNodes++;
            if (Objects.equals(curr, curEnd)) {
                max = Math.max(max, curLvlNodes);
                curLvlNodes = 0;
                curEnd = nxtEnd;
            }
        }
        return max;
    }

    private int maxWidthMap() {
        int curLvl = 1;
        int curLvlNodes = 0;
        int max = 0;
        HashMap<BstNode<K, V>, Integer> lvlMap = new HashMap<>();
        lvlMap.put(root, 1);
        IQueue<BstNode<K, V>> q = new LinkedQueueImpl<>();
        q.enque(root);
        while (!q.isEmpty()) {
            BstNode<K, V> node = q.deque();
            Integer curNodeLvl = lvlMap.get(node);
            if (Objects.nonNull(node.left)) {
                lvlMap.put(node.left, curNodeLvl + 1);
                q.enque(node.left);
            }
            if (Objects.nonNull(node.right)) {
                lvlMap.put(node.right, curNodeLvl + 1);
                q.enque(node.right);
            }
            if (Objects.equals(curNodeLvl, curLvl)) {
                curLvlNodes++;
            } else {
                max = Math.max(max, curLvlNodes);
                curLvl++;
                curLvlNodes = 1;
            }
        }
        max = Math.max(max, curLvlNodes);
        return max;
    }

    @Override
    public BstNode<K, V> sibling(TreeNode<K, V> node) {
        BstNode<K, V> n = (BstNode<K, V>) node;
        BstNode<K, V> parent = n.parent;
        if (compare(parent.left.key, node.key) < 0) {
            return parent.right;
        } else {
            return parent.left;
        }
    }

    @Override
    public BstNode<K, V> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<K, V> root) {
        if (root instanceof BstNode) {
            this.root = (BstNode<K, V>) root;
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
    public BstIterator<K, V> iterator() {
        return iterator(InOrderStackIteratorImpl.class, null);
    }

    @Override
    public BstIterator<K, V> iterator(Class<?> itrClass, IVisitor visitor) {
        Object instance = null;
        try {
            Constructor<?> constructor = itrClass.getConstructor(ITree.class, IVisitor.class);
            instance = constructor.newInstance(this, visitor);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return (BstIterator<K, V>) instance;
    }

}
