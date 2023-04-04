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

    protected final ITree<K, V> tree;

    public TreeSerializer(ITree<K, V> tree) {
        ObjectUtil.requireNonNull(tree);
        this.tree = tree;
    }

}
