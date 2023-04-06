package com.algs.datastructure.tree.bst.serialize;

import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;

public class LevelOrderSerializerImpl<K extends Comparable<K>, V> extends TreeSerializer<K, V> {

    public LevelOrderSerializerImpl(ITree<K, V> tree) {
        super(tree);
    }

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public Object deserialize(String data) {
        return null;
    }

}
