package com.algs.algo.unionfind.generic.qu;

import com.algs.algo.unionfind.generic.IDisjointSet;

/**
 * Still use array to implement generic UF
 */
public class WeighedPathSplittingImpl<E> implements IDisjointSet<E> {

    private static class Node<E> {
        public E item;
        public int index;
        public int pIndex;
        public int rank;

        public Node(E item, int index) {
            this.item = item;
            this.index = index;
        }
    }

    @Override
    public void makeSet(E item) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void union(E a, E b) {

    }

    @Override
    public E find(E a) {
        return null;
    }

    @Override
    public boolean connected(E a, E b) {
        return false;
    }
}
