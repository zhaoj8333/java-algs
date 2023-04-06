package com.algs.datastructure.tree.bst.serialize;

import com.algs.DefaultValues;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

public class RecursiveInOrderSerializerImpl<K extends Comparable<K>, V> extends TreeSerializer<K, V> {

    public RecursiveInOrderSerializerImpl(ITree<K, V> tree) {
        super(tree);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.SQUARE_BRACKET_BEGIN);
        serialize((BstNode<K, V>) root, sb);
        sb.append(DefaultValues.SQUARE_BRACKET_END);
        return sb.toString();
    }

    private void serialize(BstNode<K, V> node, StringBuilder sb) {
        if (Objects.isNull(node)) {
            sb.append(DefaultValues.NULLVAL).append(DefaultValues.DELIMITER);
            return;
        }
        serialize(node.left, sb);
        sb.append(node.key).append(DefaultValues.DELIMITER);
        serialize(node.right, sb);
    }

    @Override
    public Object deserialize(String data) {
        return null;
    }

}
