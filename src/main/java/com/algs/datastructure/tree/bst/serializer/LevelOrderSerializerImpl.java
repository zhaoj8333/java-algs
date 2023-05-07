package com.algs.datastructure.tree.bst.serializer;

import com.algs.DefaultValues;
import com.algs.datastructure.ValHandler;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.collection.queue.link.NullableLinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.RecursiveBinarySearchTreeImpl;
import com.algs.utils.TreeUtil;
import java.util.Objects;

public class LevelOrderSerializerImpl<K extends Comparable<K>, V> extends BstSerializer<K, V> {

    public LevelOrderSerializerImpl(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public LevelOrderSerializerImpl(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        super(tree, keyHandler, valHandler);
    }

    @Override
    public String serialize() {
        if (Objects.isNull(root)) {
            return TreeUtil.emptySerializedTree();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        IQueue<BstNode<K, V>> queue = new NullableLinkedQueueImpl<>();
        queue.enque((BstNode<K, V>) root);
        while (!queue.isEmpty()) {
            BstNode<K, V> node = queue.deque();
            appendNode(node, sb);
            if (Objects.nonNull(node)) {
                queue.enque(node.left);
                queue.enque(node.right);
            }
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    @Override
    public ITree<K, V> deserialize(String data) {
        IQueue<String> queue = prepare(data);
        BinarySearchTree<K, V> tree = new RecursiveBinarySearchTreeImpl<>();
        BstNode<K, V> root = deserialize(queue);
        tree.setRoot(root);
        return tree;
    }

    private BstNode<K, V> deserialize(IQueue<String> strQue) {
        if (strQue.isEmpty()) {
            return null;
        }
        IQueue<BstNode<K, V>> nodeQueue = new LinkedQueueImpl<>();
        BstNode<K, V> root = buildNode(strQue.deque(), null);
        if (Objects.nonNull(root)) {
            nodeQueue.enque(root);
            BstNode<K, V> node = null;
            while (!nodeQueue.isEmpty()) {
                node = nodeQueue.deque();
                node.left = buildNode(strQue.deque(), node);
                node.right = buildNode(strQue.deque(), node);
                if (Objects.nonNull(node.left)) {
                    nodeQueue.enque(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    nodeQueue.enque(node.right);
                }
                updateSize(node);
            }
        }
        return root;
    }

}
