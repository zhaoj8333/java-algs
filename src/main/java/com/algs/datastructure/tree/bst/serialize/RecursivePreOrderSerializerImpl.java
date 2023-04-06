package com.algs.datastructure.tree.bst.serialize;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.bst.RecursiveBinarySearchTreeImpl;
import java.util.Objects;
import java.util.stream.IntStream;

public class RecursivePreOrderSerializerImpl<K extends Comparable<K>, V> extends TreeSerializer<K, V> {

    public RecursivePreOrderSerializerImpl(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public RecursivePreOrderSerializerImpl(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        super(tree, keyHandler, valHandler);
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
        sb.append(node.key).append(DefaultValues.DELIMITER);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    @Override
    public ITree<K, V> deserialize(String data) {
        LinkedQueueImpl<String> queue = new LinkedQueueImpl<>();
        String sequence = data.substring(1, data.length() - 1);
        String[] elements = sequence.split(String.valueOf(DefaultValues.DELIMITER));
        for (String element : elements) {
            queue.enque(element);
        }
        BstNode<K, V> root = deserialize(queue, null);
        BinarySearchTree<K, V> tree = new RecursiveBinarySearchTreeImpl<>();
        tree.setRoot(root);
        return tree;
    }

    private BstNode<K, V> deserialize(IQueue<String> queue, BstNode<K, V> parent) {
        if (queue.isEmpty()) {
            return null;
        }
        String ele = queue.deque();
        if (Objects.equals(ele, String.valueOf(DefaultValues.NULLVAL))) {
            return null;
        }
        K key = (K) handleKey(ele);
        V val = (V) handleVal(ele);
        BstNode<K, V> node = new BstNode<>(key, val, parent, null, null, 1);
        node.left  = deserialize(queue, node);
        node.right = deserialize(queue, node);
        node.size();
        return node;
    }

}
