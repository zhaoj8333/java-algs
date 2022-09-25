package com.algs.datastructure.collection.list;

/**
 * SinglyLinkedList: 单向链表
 * DoublyLinkedList: 双向链表
 * MultiplyLinkedList:
 * CircularLinkedList: 循环链表
 * SentinelNodes: 哨兵节点
 * HashLinking:
 * 块状链表：
 *
 * {@docRoot LinkedList /home/allen/Desktop/Linked list - Wikipedia.pdf}
 */
public interface ILinkedList<E> extends IList<E> {

    boolean hasCircle();

}
