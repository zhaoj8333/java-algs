package com.algs.datastructure.collection.list.linked;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.node.LinkNode;

public interface ILinkedList<E> extends IList<E> {

    LinkNode<E> node(int i);

    ILinkedList<E> copy();

}
