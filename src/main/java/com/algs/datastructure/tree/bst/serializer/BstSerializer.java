package com.algs.datastructure.tree.bst.serializer;

import com.algs.DefaultValues;
import com.algs.ISerializable;
import com.algs.datastructure.ValHandler;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.utils.ObjectUtil;
import java.util.Objects;

/**
 * MorrisSerializer ?
 */
public abstract class BstSerializer<K extends Comparable<K>, V> implements ISerializable {

    protected final BstNode<K, V> root;

    private final ValHandler keyHandler;

    private final ValHandler valHandler;

    public BstSerializer(ITree<K, V> tree) {
        this(tree, null, null);
    }

    public BstSerializer(ITree<K, V> tree, ValHandler keyHandler, ValHandler valHandler) {
        ObjectUtil.requireNonNull(tree);
        this.root = (BstNode<K, V>) tree.getRoot();
        this.keyHandler = keyHandler;
        this.valHandler = valHandler;
    }

    protected Object handleKey(Object key) {
        return Objects.nonNull(key) ? keyHandler.handle(key) : key;
    }

    protected Object handleVal(Object val) {
        return Objects.nonNull(val) ? valHandler.handle(val) : val;
    }

    protected IQueue<String> prepare(String data) {
        ObjectUtil.requireNonNull(data);
        IQueue<String> queue = new LinkedQueueImpl<>();
        String sequence = data.substring(1, data.length() - 1);
        String[] elements = sequence.split(String.valueOf(DefaultValues.DELIMITER));
        for (String element : elements) {
            queue.enque(element);
        }
        return queue;
    }

    protected BstNode<K, V> buildNode(String str, BstNode<K, V> parent) {
        if (Objects.equals(str, String.valueOf(DefaultValues.NULLVAL))) {
            return null;
        }
        K key = (K) handleKey(str);
        V val = (V) handleVal(str);
        return new BstNode<>(key, val, parent, null, null, 1);
    }

    protected void appendNode(BstNode<K, V> node, StringBuilder sb) {
        if (Objects.isNull(node)) {
            sb.append(DefaultValues.NULLVAL);
        } else {
            sb.append(node);
        }
        sb.append(DefaultValues.DELIMITER);
    }

    protected void updateSize(BstNode<K, V> node) {
        BstNode<K, V> n = (BstNode<K, V>) node;
        while (Objects.nonNull(n)) {
            n.updateSize();
            n = n.parent;
        }
    }

}
