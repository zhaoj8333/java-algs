package com.algs.datastructure.tree.bst.itr.morris;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

public class MorrisPostOrderIteratorImpl<K extends Comparable<K>, V> extends MorrisIterator<K, V> {

    public MorrisPostOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public MorrisPostOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
    }

    @Override
    protected void iterate(BstNode<K, V> node) {
        BstNode<K, V> head = node;
        while (Objects.nonNull(head)) {
            rightest = head.left;
            if (Objects.nonNull(rightest)) {
                while (Objects.nonNull(rightest.right) && !Objects.equals(rightest.right, head)) {
                    rightest = rightest.right;
                }
                if (Objects.isNull(rightest.right)) {
                    rightest.right = head;
                    head = head.left;
                    continue;
                } else {
                    rightest.right = null;
                    visitEdge(head.left);
                }
            }
            head = head.right;
        }
        visitEdge(node);
    }

    /**
     * To assure the space complexity of {@link MorrisIterator} is O(1)
     */
    private void visitEdge(BstNode<K, V> node) {
        BstNode<K, V> tail = reverseEdge(node);
        BstNode<K, V> tmp = tail;
        while (Objects.nonNull(tmp)) {
            visit(tmp);
            tmp = tmp.right;
        }
        reverseEdge(tail);
    }

    private BstNode<K, V> reverseEdge(BstNode<K, V> node) {
        BstNode<K, V> prev = null;
        BstNode<K, V> next = null;
        while (Objects.nonNull(node)) {
            next = node.right;
            node.right = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

}
