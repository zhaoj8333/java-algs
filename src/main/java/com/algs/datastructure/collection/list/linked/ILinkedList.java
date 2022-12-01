package com.algs.datastructure.collection.list.linked;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.node.LinkNode;

/**
 * SingleLinkedList: 单向链表
 * DoubleLinkedList: 双向链表
 * MultiplyLinkedList:
 * CircularLinkedList: 循环链表
 * SentinelNodes: 哨兵节点
 * HashLinking:
 * 块状链表：
 *
 * {@docRoot LinkedList /home/allen/Desktop/Linked list - Wikipedia.pdf}
 *
 * algs:
 * dedup: 链表删除重复节点
 * findKthNodeFromTail: 链表倒数第k个节点
 * merge sorted linkedlist: 合并排序链表
 * first common node: 两链表的第一个公共节点
 * entrance of ring in a linkedlist: 链表中环的入口
 * 回文链表
 * 对链表进行插入排序
 * 排序链表
 * LRU 缓存
 * 环形链表插值
 * 链表的分化
 * 无环单链表相交
 * 有环单链表相交判断
 * 单链表相交判断
 * 链表的归并排序
 * 链表的快速排序
 *
 * https://blog.csdn.net/qq_31984717/article/details/84584494?spm=1001.2101.3001.6650.13&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-13-84584494-blog-108581312.t0_edu_mlt&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-13-84584494-blog-108581312.t0_edu_mlt&utm_relevant_index=15
 */
public interface ILinkedList<E> extends IList<E> {

    LinkNode<E> node(int i);

    ILinkedList<E> copy();

}
