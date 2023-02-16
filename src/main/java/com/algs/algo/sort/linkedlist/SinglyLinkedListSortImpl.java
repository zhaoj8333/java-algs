package com.algs.algo.sort.linkedlist;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.datastructure.node.LinkNode;
import com.algs.datastructure.node.SinglyLinkNode;

import java.util.Comparator;
import java.util.Objects;

public class SinglyLinkedListSortImpl<E extends Comparable<E>> extends LinkedCompareAndSwapSort<E> {

    public SinglyLinkedListSortImpl(SinglyLinkedListImpl<E> list) {
        super(list);
    }

    public SinglyLinkedListSortImpl(SinglyLinkedListImpl<E> list, Comparator<E> comparator) {
        super(list, comparator);
    }

    @Override
    public void sort() {
//        System.out.println("sorting");
    }

    @Override
    protected void swap(LinkNode<E> a, LinkNode<E> b) {
        SinglyLinkNode<E> aNode = (SinglyLinkNode<E>) a;
        SinglyLinkNode<E> bNode = (SinglyLinkNode<E>) b;

    }

    @Override
    public void bubbleSort() {

    }

    /**
     * head -> n1 -> n2 -> n3 -> ... -> n*
     */
    @Override
    public void selectionSort() {
        SinglyLinkNode<E> dummy = new SinglyLinkNode<>(null, null);
        Iterator<E> itr = list.iterator();
        while (itr.hasNext()) {
            SinglyLinkNode<E> node = (SinglyLinkNode<E>) itr.next();
            SinglyLinkNode<E> prev = getMinPrevNode(node);
            if (Objects.nonNull(prev)) {
                SinglyLinkNode<E> curr = prev.next;
                prev.next = curr.next;
                node.next = curr;
                curr.next = node;
            }
        }
        SinglyLinkedListImpl<E> list = (SinglyLinkedListImpl<E>) this.list;
        list.setHead(dummy);
    }

    private SinglyLinkNode<E> getMinPrevNode(SinglyLinkNode<E> node) {
        SinglyLinkNode<E> min = node;
        SinglyLinkNode<E> prev = null;
        while (Objects.nonNull(node.next)) {
            SinglyLinkNode<E> next = node.next;
            if (compareNode(min, next) > 0) {
                min = next;
                prev = node;
            }
            node = next;
        }
        return prev;
    }

    @Override
    public void insertionSort() {

    }

    @Override
    public void mergeSort() {

    }

    @Override
    public void quickSort() {

    }
}
