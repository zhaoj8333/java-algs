package com.algs.datastructure.tree.bst.serialize;

import com.algs.ISerializable;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.bst.itr.TreeIterator;
import com.algs.utils.ObjectUtil;

public abstract class TreeSerializer<K extends Comparable<K>, V> implements ISerializable {

    protected final TreeNode<K, V> root;

    protected final TreeIterator<K> itr;

    public TreeSerializer(TreeNode<K, V> root, TreeIterator<K> itr) {
        ObjectUtil.requireNonNull(root);
        this.root = root;
        this.itr  = itr;
    }

}
