package com.algs.datastructure.tree.bst.itr.morris;

import com.algs.datastructure.IVisitor;
import com.algs.datastructure.node.BstNode;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.itr.BstRecursiveIterator;

/**
 * 无论是递归还是非递归遍历，都会使用栈做遍历：
 *  递归：函数调用栈，空间复杂度O(logN)
 *  非递归：实质是模拟系统栈进行遍历，空间复杂度依旧是O(logN)
 * 
 * 而消除栈的遍历方式就是 {@link #MorrisPreIteratorImpl(ITree)}遍历方式
 * {@link MorrisIterator}遍历方式时间复杂度依然是O(N), 但空间复杂度为O(1)
 *
 * Morris序: ...
 *
 * 1.节点无左树，节点被访问一次
 * 2.节点有左树，节点会被访问两次，第二次访问之前，会将其左树遍历完毕
 *
 * {@link MorrisIterator} 遍历实质是 递归序的变种，不过指挥对有左树的节点遍历两次，无左树的遍历一次
 *
 * 优势: 二叉树遍历中，无论是递归，非递归方式，空间复杂度都是 O(H)或O(log(N)), H为二叉树的高度
 * 但是 {@link MorrisIterator}： 空间复杂度O(1), 时间复杂度O(N)
 *
 * 时间复杂度不会因为寻找左子树最右子节点的环节而导致复杂度不是O(N):
 * 对于含有左子树的某一个节点，会遍历该节点左子树所有右节点两次，第一次是建立最右子树与当前节点的连接，第二次是取消该连接
 * 总代价其实就是整棵树的左边界上的节点数量，且这些节点不重复，且遍历两次，所以总遍历次数为 2*N,依然是O(N)
 */
public abstract class MorrisIterator<K extends Comparable<K>, V> extends BstRecursiveIterator<K, V> {

    protected BstNode<K, V> rightest;

    public MorrisIterator(ITree<K, V> tree) {
        this(tree, null);
    }

    public MorrisIterator(ITree<K, V> tree, IVisitor visitor) {
        super(tree, visitor);
    }

}
