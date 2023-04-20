package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.node.BstNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

// left, right, root
public class PostOrderStackIteratorImpl<K extends Comparable<K>, V> extends BstIterator<K, V> {

    private final IStack<BstNode<K, V>> stack;

    // last visited node
    private BstNode<K, V> root;

    public PostOrderStackIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public PostOrderStackIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(tree);
        stack = new LinkedStackImpl<>();
        root = (BstNode<K, V>) tree.getRoot();
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(root) && !stack.isEmpty();
    }

    @Override
    public BstNode<K, V> nextNode() {
        while (true) {
            BstNode<K, V> next = stack.top();
            if (Objects.nonNull(next.left) && !Objects.equals(root, next.left) && !Objects.equals(root, next.right)) {
                stack.push(next.left);
            } else if (Objects.nonNull(next.right) && !Objects.equals(root, next.right)) {
                stack.push(next.right);
            } else {
                visit(stack.pop());
                root = next;
                return (BstNode<K, V>) next;
            }
        }
    }
}

