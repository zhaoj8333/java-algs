package com.algs.datastructure.tree;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.Iiterable;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.st.ordered.IOrderedSymbolTable;
import com.algs.datastructure.tree.printer.BinaryTreeInfo;

public interface ITree<K extends Comparable<K>, V> extends IOrderedSymbolTable<K, V>, Iiterable<K>, BinaryTreeInfo {

    int size(TreeNode<K, V> node);

    int height();

    int depth();

    int leaves();

    /**
     * Distance: go from node a to node b, how many nodes
     * Max distance between two nodes
     */
     int maxWidth();

    // int maxDepth();   N ary Tree

    // Flatten to linked list

    // construct from in order + post order, preorder + in order, preorder + post order, level order

    /**
     * predecessor
     */
    K pred(K key);

    /**
     * successor
     */
    K succ(K key);

    /**
     * symmetric tree 对称二叉树
     */
    TreeNode<K, V> reverse();

    TreeNode<K, V> getRoot();

    void setRoot(TreeNode<K, V> root);

    TreeNode<K, V> sibling(TreeNode<K, V> node);

    // int level(int level);

    boolean isComplete();

    boolean isBalanced();

    Iterator<K> iterator(Class<?> itrClass, IVisitor visitor);

}
