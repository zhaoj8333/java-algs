package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.Visitable;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;

import java.util.Objects;

// left, root, right
public class InOrderIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K> {

    protected BstNode<K, V> node;

    private final IStack<BstNode<K, V>> orderStack;

    public InOrderIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public InOrderIteratorImpl(BstNode<K, V> root, Visitable visitor) {
        super(visitor);
        this.node = root;
        orderStack = new LinkedStackImpl<>();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }

    @Override
    public K pred(K key) {
        BstNode<K, V> node = predNode(key);
        return Objects.nonNull(node) ? node.key : null;
    }

    protected BstNode<K, V> predNode(K key) {
//        ObjectUtil.requireNonNull(key);
//        BstNode<K, V> node = getNode(key);
//        if (Objects.isNull(node)) {
//            return null;
//        }
//        BstNode<K, V> tmp = node.left;
//        if (Objects.nonNull(tmp)) {
//            while (Objects.nonNull(tmp.right)) {
//                tmp = tmp.right;
//            }
//            return tmp;
//        }
//         parent
//        while (Objects.nonNull(node.parent) && Objects.equals(node, node.parent.left)) {
//            node = node.parent;
//        }
//        return Objects.nonNull(node.parent) ? node.parent : null;
        return null;
    }

    @Override
    public K succ(K key) {
        BstNode<K, V> node = succNode(key);
        return Objects.nonNull(node) ? node.key : null;
    }

    protected BstNode<K, V> succNode(K key) {
//        ObjectUtil.requireNonNull(key);
//        BstNode<K, V> node = getNode(key);
//        if (Objects.isNull(node)) {
//            return null;
//        }
//        BstNode<K, V> tmp = node.right;
//        if (Objects.nonNull(tmp)) {
//            while (Objects.nonNull(tmp.left)) {
//                tmp = tmp.left;
//            }
//            return tmp;
//        }
//         parent
//        while (Objects.nonNull(node.parent) && Objects.equals(node, node.parent.right)) {
//            node = node.parent;
//        }
//        return Objects.nonNull(node.parent) ? node.parent : null;
        return null;
    }

}
