package com.algs.datastructure.tree.bst.serializer;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.NullableLinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.BinarySearchTree;
import com.algs.datastructure.tree.bst.RecursiveBinarySearchTreeImpl;
import com.algs.utils.TreeUtil;
import java.util.Objects;

public class PreOrderSerializerImpl<K extends Comparable<K>, V> extends BstSerializer<K, V> {

    public PreOrderSerializerImpl(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public PreOrderSerializerImpl(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        super(tree, keyHandler, valHandler);
    }

    @Override
    public String serialize() {
        if (Objects.isNull(root)) {
            return TreeUtil.emptySerializedTree();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        IStack<BstNode<K, V>> stack = new NullableLinkedStackImpl<>();
        stack.push((BstNode<K, V>) root);
        while (!stack.isEmpty()) {
            BstNode<K, V> node = stack.pop();
            appendNode(node, sb);
            if (Objects.nonNull(node)) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    /**
     * 15,11,9,1,#,4,3,#,#,7,5,#,#,8,#,#,10,#,#,13,#,14,#,#,22,17,#,20,#,#,30,25,#,26,#,#,#
     */
    @Override
    public ITree<K, V> deserialize(String data) {
        IQueue<String> queue = prepare(data);
        BinarySearchTree<K, V> tree = new RecursiveBinarySearchTreeImpl<>();
        BstNode<K, V> root = deserialize(queue);
        tree.setRoot(root);
        return tree;
    }

    /**
     *      ┌─────15────┐
     *      │           │
     *   ┌─11─┐     ┌───22──┐
     *   │    │     │       │
     * ┌─9─┐  13─┐ 17─┐   ┌─30
     * │   │     │    │   │
     * 1─┐ 10    14   20 25─┐
     *   │                  │
     * ┌─4─┐                26
     * │   │
     * 3 ┌─7─┐
     *   │   │
     *   5   8
     * 15,11,9,1,#,4,3,#,#,7,5,#,#,8,#,#,10,#,#,13,#,14,#,#,22,17,#,20,#,#,30,25,#,26,#,#,#
     */
    private BstNode<K, V> deserialize(IQueue<String> strQueue) {
        if (strQueue.isEmpty()) {
            return null;
        }

        return null;
    }

}
