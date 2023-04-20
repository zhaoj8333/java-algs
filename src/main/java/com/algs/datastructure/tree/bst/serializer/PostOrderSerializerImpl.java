package com.algs.datastructure.tree.bst.serializer;

import com.algs.datastructure.tree.ITree;

public class PostOrderSerializerImpl<K extends Comparable<K>, V> extends BstSerializer<K, V> {

    public PostOrderSerializerImpl(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public PostOrderSerializerImpl(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        super(tree, keyHandler, valHandler);
    }

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public ITree<K, V> deserialize(String data) {
        return null;
    }

}
