package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import java.util.Objects;

/**
 * Refer to {@link com.algs.datastructure.collection.heap.array.BinaryArrayPqImpl}
 *
 * For {@link #sizeMultiply}, refer to {@link com.algs.datastructure.tree.bst.serializer.LevelOrderSerializerImpl}
 *
 * 1、一个层数为k 的满二叉树总结点数为：2^k-1, 因此满二叉树的结点数一定是奇数个
 * 2、第i层上的结点数为：2^i-1
 */
public class LevelOrderIteratorImpl<K extends Comparable<K>, V> extends BstRecursiveIterator<K, V> {

    private static final int sizeMultiply = 4;  // ???

    private final BstNode<K, V>[] array;

    public LevelOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public LevelOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
        array = new BstNode[(tree.size() * sizeMultiply)];
    }

    @Override
    protected void iterate(BstNode<K, V> node) {
        iterate(node, 1);
        for (BstNode<K, V> n : array) {
            if (Objects.nonNull(n)) {
                visit(n);
            }
        }
    }

    protected void iterate(BstNode<K, V> node, int i) {
        if (Objects.isNull(node)) {
            return;
        }
        array[i] = node;
        iterate(node.left, 2 * i);
        iterate(node.right, 2 * i + 1);
    }

}
