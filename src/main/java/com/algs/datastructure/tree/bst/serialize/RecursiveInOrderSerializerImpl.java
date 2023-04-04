package com.algs.datastructure.tree.bst.serialize;

import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

public class RecursiveInOrderSerializerImpl<K extends Comparable<K>, V> extends TreeSerializer<K, V> {

    public RecursiveInOrderSerializerImpl(ITree<K, V> tree) {
        super(tree);
    }

    @Override
    public String serialize() {
        BstNode<K, V> root = (BstNode<K, V>) tree.getRoot();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        serialize(root, sb);
        sb.append("]");
        return sb.toString();
    }

    private void serialize(BstNode<K, V> node, StringBuilder sb) {
        if (Objects.isNull(node)) {
            sb.append("#").append(",");
            return;
        }
        serialize(node.left, sb);
        sb.append(node.key).append(",");
        serialize(node.right, sb);
    }

    @Override
    public Object deserialize(String data) {
        return null;
    }

}
