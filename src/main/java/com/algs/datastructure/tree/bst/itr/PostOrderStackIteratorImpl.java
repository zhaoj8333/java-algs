package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedStackImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.node.TreeNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

// left, right, root
public class PostOrderStackIteratorImpl<K extends Comparable<K>, V> extends TreeIterator<K, V> {

    private final IStack<BstNode<K, V>> stack;

    // last visited node
    private BstNode<K, V> root;

    public PostOrderStackIteratorImpl(BstNode<K, V> root) {
        this(root, null);
    }

    public PostOrderStackIteratorImpl(BstNode<K, V> root, IVisitor visitor) {
        super(visitor);
        ObjectUtil.requireNonNull(root);
        stack = new LinkedStackImpl<>();
        this.root = root;
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(root) && !stack.isEmpty();
    }

    @Override
    public TreeNode<K, V> nextNode() {
        while (true) {
            BstNode<K, V> next = stack.top();
            if (Objects.nonNull(next.left) && !Objects.equals(root, next.left) && !Objects.equals(root, next.right)) {
                stack.push(next.left);
            } else if (Objects.nonNull(next.right) && !Objects.equals(root, next.right)) {
                stack.push(next.right);
            } else {
                visit(stack.pop());
                root = next;
                return (TreeNode<K, V>) next;
            }
        }
    }
}

