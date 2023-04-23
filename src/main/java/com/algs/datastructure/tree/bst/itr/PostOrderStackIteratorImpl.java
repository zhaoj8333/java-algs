package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.collection.stack.NullableLinkedStackImpl;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.node.BstNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

// left, right, root
public class PostOrderStackIteratorImpl<K extends Comparable<K>, V> extends BstIterator<K, V> {

    private final IStack<BstNode<K, V>> stack;

    // last visited node
    private BstNode<K, V> node;

    public PostOrderStackIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public PostOrderStackIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(tree);
        stack = new LinkedStackImpl<>();
        node = (BstNode<K, V>) tree.getRoot();
        stack.push(node);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public BstNode<K, V> nextNode() {
        while (true) {
            BstNode<K, V> next = stack.top();
            if (Objects.nonNull(next.left) && !Objects.equals(node, next.left) && !Objects.equals(node, next.right)) {
                stack.push(next.left);
            } else if (Objects.nonNull(next.right) && !Objects.equals(node, next.right)) {
                stack.push(next.right);
            } else {
                visit(stack.pop());
                node = next;
                return next;
            }
        }
    }

}

