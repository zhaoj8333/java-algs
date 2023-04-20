package com.algs.datastructure.tree.bst.itr;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.NullableResizableArrayImpl;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.utils.CollectionUtil;
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

    public LevelOrderIteratorImpl(ITree<K, V> tree) {
        this(tree, null);
    }

    public LevelOrderIteratorImpl(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
    }

    @Override
    protected void iterate(BstNode<K, V> node) {
        BstNode<K, V>[] array = new BstNode[(tree.size() * sizeMultiply)];
        iterate(node, 1, array);
        for (BstNode<K, V> n : array) {
            if (Objects.nonNull(n)) {
                visit(n);
            }
        }
    }

    protected void iterate(BstNode<K, V> node, int i, BstNode<K, V>[] array) {
        if (Objects.isNull(node)) {
            return;
        }
        array[i] = node;
        iterate(node.left, 2 * i, array);
        iterate(node.right, 2 * i + 1, array);
    }

}
