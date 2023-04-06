package com.algs.datastructure.tree.bst.serialize;

import com.algs.ISerializable;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.bst.itr.PreOrderStackIteratorImpl;
import com.algs.datastructure.tree.bst.itr.TreeIterator;
import com.algs.utils.ObjectUtil;
import com.algs.datastructure.tree.ITree;

import com.sun.source.tree.Tree;
import java.util.Objects;

public abstract class TreeSerializer<K extends Comparable<K>, V> implements ISerializable {

    protected final TreeNode<K, V> root;

    private final ValHandler keyHandler;

    private final ValHandler valHandler;

    public TreeSerializer(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public TreeSerializer(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        ObjectUtil.requireNonNull(tree);
        this.root = tree.getRoot();
        this.keyHandler = keyHandler;
        this.valHandler = valHandler;
    }

    protected Object handleKey(Object key) {
        return Objects.nonNull(key) ? keyHandler.handle(key) : key;
    }

    protected Object handleVal(Object val) {
        return Objects.nonNull(val) ? valHandler.handle(val) : val;
    }

}
