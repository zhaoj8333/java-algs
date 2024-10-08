package com.algs.datastructure.collection;

import com.algs.datastructure.Iiterable;

public interface ICollection<E> extends Iiterable<E> {

    int size();
//    int count();
    boolean isEmpty();

    /**
     * search
     */
    E get(int i);
    boolean contains(E item);
//    boolean contains(E item, int fromIndex, int toIndex);
//    E min();
//    E min(int fromIndex, int toIndex);
//    E max();
//    E max(int fromIndex, int toIndex);

    void add(E item);
    E remove(int i);
    E remove(E item);
    void clear();

    E[] toArray();

//    void dedup();
//    void fill(int i, int j, E replacement);

    /**
     * sort
     */
//    void shuffle();
//    void sort(IComparable<E> b);
//    void sort(IComparable<E> b, int fromIndex, int toIndex);
//    void reverse(int fromIndex, int toIndex);
//    Collection<E> merge(Collection<E> b);
//    Collection<E> merge(Collection<E> b, int fromAIndex, int toAIndex, int fromBIndex, int endBIndex);


//    Collection<E> intersect(Collection<E> b);
//    Collection<E> unionsect(Collection<E> b);
//    Collection<E> diff(Collection<E> b);

//    ICollection<E> copy();
//    Collection<E> replace(int startIndex, int endIndex, E oldVal, E newVal);



}
