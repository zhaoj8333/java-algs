package com.algs.datastructure.collection.list.linked;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.node.LinkNode;

public interface ISequentialAccessList<E> extends IList<E> {

    LinkNode<E> node(int i);

//    void set(int i, LinkNode<E> node);

    ISequentialAccessList<E> copy();

}
