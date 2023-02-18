package com.algs.datastructure.tree;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.Visitable;
import com.algs.datastructure.node.TreeNode;
import com.algs.datastructure.st.ordered.IOrderedSymbolTable;
import com.algs.datastructure.tree.printer.BinaryTreeInfo;

public interface ITree<K extends Comparable<K>, V> extends IOrderedSymbolTable<K, V>, Iiterable<K>, BinaryTreeInfo {

    int size(TreeNode<K, V> node);

    Iterator<K> inOrderIterator();

    Iterator<K> levelOrderIterator();

    Iterator<K> preOrderIterator();

    Iterator<K> postOrderIterator();

    Iterator<K> inOrderIterator(Visitable visitor);

    Iterator<K> levelOrderIterator(Visitable visitor);

    Iterator<K> preOrderIterator(Visitable visitor);

    Iterator<K> postOrderIterator(Visitable visitor);

}
