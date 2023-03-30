package com.algs.datastructure.tree.bst.serialize;

import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.bst.itr.InOrderIteratorImpl;
import com.algs.datastructure.tree.bst.itr.TreeIterator;

import java.util.Objects;

public class DFSSerializerImpl<K extends Comparable<K>, V> extends TreeSerializer<K, V> {

    public DFSSerializerImpl(TreeNode<K, V> root) {
        this(root, new InOrderIteratorImpl<K, V>((BstNode) root));
    }

    public DFSSerializerImpl(TreeNode<K, V> root, TreeIterator<K> itr) {
        super(root, itr);
    }

    @Override
    public String serialize() {
        if (Objects.isNull(root)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (itr.hasNext()) {
            BstNode<K, Object> node = (BstNode<K, Object>) itr.nextNode();
            sb.append(node).append("#");
            if (Objects.isNull(node.left)) {
                sb.append("#null#");
            }
            if (Objects.isNull(node.right)) {
                sb.append("#null#");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public Object deserialize(String data) {
        return null;
    }

}
