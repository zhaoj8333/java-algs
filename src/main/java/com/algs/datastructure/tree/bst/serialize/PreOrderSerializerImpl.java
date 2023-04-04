package com.algs.datastructure.tree.bst.serialize;

import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

public class PreOrderSerializerImpl<K extends Comparable<K>, V> extends TreeSerializer<K, V> {

    public PreOrderSerializerImpl(ITree<K, V> tree) {
        super(tree);
    }

    @Override
    public String serialize() {
        if (tree.isEmpty()) {
            return "[#,]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        BstNode<K, V> root = (BstNode<K, V>) tree.getRoot();
        IStack<BstNode<K, V>> stack = new LinkedStackImpl<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BstNode<K, V> node = stack.pop();
            sb.append(node).append(",");
            if (Objects.isNull(node.left)) {
                sb.append("#").append(",");
            }
            if (Objects.isNull(node.right)) {
                sb.append("#").append(",");
            }
            if (Objects.nonNull(node.right)) {
                stack.push(node.right);
            }
            if (Objects.nonNull(node.left)) {
                stack.push(node.left);
            }
        }
        System.out.println();
        sb.append(']');
        return sb.toString();
    }

    @Override
    public Object deserialize(String data) {
        return null;
    }
}
