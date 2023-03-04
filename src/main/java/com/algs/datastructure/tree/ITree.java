package com.algs.datastructure.tree;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.Visitable;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.st.ordered.IOrderedSymbolTable;
import com.algs.datastructure.tree.printer.BinaryTreeInfo;

public interface ITree<K extends Comparable<K>, V> extends IOrderedSymbolTable<K, V>, Iiterable<K>, BinaryTreeInfo {

    int size(TreeNode<K, V> node);

    int height();

    int depth();

    int leaves();

    // int maxWidth();

    // int maxDepth();   N ary Tree

    // Flatten to linked list

    // construct from in order + post order, preorder + in order, preorder + post order, level order

    /**
     * symmetric tree 对称二叉树
     */
    TreeNode<K, V> reverse();

    TreeNode<K, V> sibling(TreeNode<K, V> node);

    // int level(int level);

    boolean isComplete();

    Iterator<K> iterator(Class<?> itrClass, Visitable visitor);

}
