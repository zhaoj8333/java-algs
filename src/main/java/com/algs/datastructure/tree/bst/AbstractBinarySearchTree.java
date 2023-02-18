package com.algs.datastructure.tree.bst;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl0;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import com.algs.utils.CompareUtil;
import com.algs.utils.TreeUtil;

import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractBinarySearchTree<K extends Comparable<K>, V> implements ITree<K, V> {

    protected TreeNode<K, V> root;

    private final Comparator<K> comparator;

    protected AbstractBinarySearchTree() {
        this(null);
    }

    public AbstractBinarySearchTree(Comparator<K> comparator) {
        this.comparator = comparator;
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

    protected int compare(K a, K b) {
        return CompareUtil.compare(a, b, comparator);
    }

    @Override
    public String toString() {
        return TreeUtil.toString(this);
    }

    @Override
    public Iterator<K> iterator() {
        return preOrderIterator();
    }

    @Override
    public Iterator<K> inOrderIterator() {
        return inOrderIterator(null);
    }

    @Override
    public Iterator<K> levelOrderIterator() {
        return levelOrderIterator(null);
    }

    @Override
    public Iterator<K> preOrderIterator() {
        return preOrderIterator(null);
    }

    @Override
    public Iterator<K> postOrderIterator() {
        return postOrderIterator(null);
    }

    @Override
    public Iterator<K> inOrderIterator(Visitable visitor) {
        return new InOrderIteratorImpl<>(visitor);
    }

    @Override
    public Iterator<K> levelOrderIterator(Visitable visitor) {
        return new LevelOrderIteratorImpl<>(visitor);
    }

    @Override
    public Iterator<K> preOrderIterator(Visitable visitor) {
        return new PreOrderIteratorImpl<>(visitor);
    }

    @Override
    public Iterator<K> postOrderIterator(Visitable visitor) {
        return new PostOrderIteratorImpl<>(visitor);
    }

    protected abstract static class AbstractTreeIterator<K extends Comparable<K>> implements Iterator<K> {

        protected final Visitable visitor;

        public AbstractTreeIterator() {
            this(null);
        }

        public AbstractTreeIterator(Visitable visitor) {
            this.visitor = visitor;
        }

        protected void visit(Object node) {
            if (Objects.nonNull(visitor)) {
                visitor.visit(node);
            }
        }

    }

    // root, left, right
    protected class PreOrderIteratorImpl<K extends Comparable<K>> extends AbstractTreeIterator<K> {

        private final BstNode<K, V> node = (BstNode<K, V>) root;

        private final IStack<BstNode<K, V>> orderStack;

        public PreOrderIteratorImpl() {
            this(null);
        }

        public PreOrderIteratorImpl(Visitable visitor) {
            super(visitor);
            orderStack = new LinkedStackImpl<>();
            if (Objects.nonNull(node)) {
                orderStack.push(node);
            }
        }

        @Override
        public boolean hasNext() {
            return !orderStack.isEmpty();
        }

        @Override
        public K next() {
            BstNode<K, V> node = orderStack.pop();
            visit(node);
            if (Objects.nonNull(node)) {
                if (Objects.nonNull(node.right)) {
                    orderStack.push(node.right);
                }
                if (Objects.nonNull(node.left)) {
                    orderStack.push(node.left);
                }
            }
            return node.key;
        }
    }

    // left, root, right
    protected class InOrderIteratorImpl<K extends Comparable<K>> extends AbstractTreeIterator<K> {

        protected BstNode<K, V> node = (BstNode<K, V>) root;

        private final IStack<BstNode<K, V>> orderStack;

        public InOrderIteratorImpl() {
            this(null);
        }

        public InOrderIteratorImpl(Visitable visitor) {
            super(visitor);
            orderStack = new LinkedStackImpl<>();
            pushNode(node);
        }

        private void pushNode(BstNode<K, V> node) {
            if (Objects.nonNull(node)) {
                if (Objects.nonNull(node.left)) {
                    orderStack.push(node.left);
                }
                orderStack.push(node);
                if (Objects.nonNull(node.right)) {
                    orderStack.push(node.right);
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !orderStack.isEmpty();
        }

        @Override
        public K next() {
            BstNode<K, V> node = orderStack.pop();
            visit(node);
            pushNode(node);
            return node.key;
        }
    }

    // left, right, root
    protected class PostOrderIteratorImpl<K extends Comparable<K>> extends AbstractTreeIterator<K> {

        protected BstNode<K, V> node = (BstNode<K, V>) root;

        private final IStack<BstNode<K, V>> orderStack;

        public PostOrderIteratorImpl() {
            this(null);
        }

        public PostOrderIteratorImpl(Visitable visitor) {
            super(visitor);
            orderStack = new LinkedStackImpl<>();
            pushNode(node);
        }

        private void pushNode(BstNode<K, V> node) {
            if (Objects.nonNull(node)) {
                if (Objects.nonNull(node.left)) {
                    orderStack.push(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    orderStack.push(node.right);
                }
                orderStack.push(node);
            }
        }

        @Override
        public boolean hasNext() {
            return !orderStack.isEmpty();
        }

        @Override
        public K next() {
            BstNode<K, V> node = orderStack.pop();
            visit(node);
            pushNode(node);
            return node.key;
        }
    }

    // by topdown level
    protected class LevelOrderIteratorImpl<K extends Comparable<K>> extends AbstractTreeIterator<K> {

        protected BstNode<K, V> node = (BstNode<K, V>) root;

        private final IQueue<BstNode<K, V>> orderQueue;

        public LevelOrderIteratorImpl() {
            this(null);
        }

        public LevelOrderIteratorImpl(Visitable visitor) {
            super(visitor);
            orderQueue = new LinkedQueueImpl0<>();
            pushNode(node);
        }

        private void pushNode(BstNode<K, V> node) {
            if (Objects.nonNull(node)) {
                orderQueue.enque(node);
            }
        }

        @Override
        public boolean hasNext() {
            return !orderQueue.isEmpty();
        }

        @Override
        public K next() {
            BstNode<K, V> node = orderQueue.deque();
            visitor.visit(node);
            pushNode(node.left);
            pushNode(node.right);
            return node.key;
        }
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
        return n.key + "/" + n.value;
    }

}
