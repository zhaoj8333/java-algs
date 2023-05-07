package com.algs.datastructure.tree.bst.serializer;

import com.algs.DefaultValues;
import com.algs.datastructure.ValHandler;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.RecursiveBinarySearchTreeImpl;
import java.util.Objects;

public class RecursivePreOrderSerializerImpl<K extends Comparable<K>, V> extends BstSerializer<K, V> {

    public RecursivePreOrderSerializerImpl(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public RecursivePreOrderSerializerImpl(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        super(tree, keyHandler, valHandler);
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        serialize((BstNode<K, V>) root, sb);
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    private void serialize(BstNode<K, V> node, StringBuilder sb) {
        if (Objects.isNull(node)) {
            appendNode(node, sb);
            return;
        }
        appendNode(node, sb);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    @Override
    public ITree<K, V> deserialize(String data) {
        IQueue<String> queue = prepare(data);
        BstNode<K, V> root = deserialize(queue, null);
        BinarySearchTree<K, V> tree = new RecursiveBinarySearchTreeImpl<>();
        tree.setRoot(root);
        return tree;
    }

    private BstNode<K, V> deserialize(IQueue<String> queue, BstNode<K, V> parent) {
        if (queue.isEmpty()) {
            return null;
        }
        String elem = queue.deque();
        if (Objects.equals(elem, String.valueOf(DefaultValues.NULLVAL))) {
            return null;
        }
        BstNode<K, V> node = buildNode(elem, parent);
        node.left  = deserialize(queue, node);
        node.right = deserialize(queue, node);
        node.updateSize();
        return node;
    }

}
