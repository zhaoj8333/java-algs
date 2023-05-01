package com.algs.algo.unionfind.generic.qu;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.generic.IDisjointSet;
import com.algs.algo.unionfind.generic.UFNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * // TODO: 10/18/22
 * Change {@link Map} to {@link com.algs.datastructure.map.IMap}
 */
public class WeighedPathHalvingImpl<E> implements IDisjointSet<E> {

    private final Map<E, UFNode<E>> nodes;
    private int count;

    public WeighedPathHalvingImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public WeighedPathHalvingImpl(int size) {
        nodes = new HashMap<>(size);
    }

    @Override
    public void makeSet(E item) {
        nodes.put(item, new UFNode<>(item));
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(E a, E b) {
        UFNode<E> aRoot = findNode(a);
        UFNode<E> bRoot = findNode(b);
        if ((Objects.isNull(aRoot)) || Objects.isNull(bRoot)) {
            return;
        }
        if (Objects.equals(aRoot.parent, bRoot.parent)) {
            return;
        }
        if (aRoot.rank > bRoot.rank) {
            bRoot.parent = aRoot.parent;
        } else if (aRoot.rank < bRoot.rank) {
            aRoot.parent = bRoot.parent;
        } else {
            aRoot.parent = bRoot.parent;
            aRoot.rank++;
        }
        count--;
    }

    @Override
    public E find(E a) {
        UFNode<E> node = findNode(a);
        return Objects.isNull(node) ? null : node.item;
    }

    private UFNode<E> findNode(E a) {
        UFNode<E> aRoot = nodes.get(a);
        while (Objects.nonNull(aRoot) && !Objects.equals(aRoot, aRoot.parent)) {
            aRoot.parent = aRoot.parent.parent;
            aRoot = aRoot.parent;
        }
        return aRoot;
    }

    @Override
    public boolean connected(E a, E b) {
        return Objects.equals(find(a), find(b));
    }

}
