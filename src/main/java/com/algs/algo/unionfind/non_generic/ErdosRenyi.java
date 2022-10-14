package com.algs.algo.unionfind.non_generic;

import com.algs.DefaultValues;
import com.algs.util.ArraysUtil;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class ErdosRenyi implements IUnionFind {

    private int count;
    private final int[] id;
    private final int[] rank;

    public ErdosRenyi() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ErdosRenyi(int capacity) {
        RangeUtil.requireGreaterThan(capacity, 0);
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        rank = new int[capacity];
        count = capacity;
        ArraysUtil.fill(rank, 1);
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return;
        }
        if (rank[idA] > rank[idB]) {
            id[idB] = idA;
        } else if (rank[idA] < rank[idB]) {
            id[idA] = idB;
        } else {
            id[idA] = idB;
            rank[idB] += rank[idA];
        }
        count--;
    }

    /**
     * If not connected, then union
     * @return before union, is a, b connected
     */
    @Override
    public boolean notConnectedThenUnion(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return true;
        }
        if (rank[idA] > rank[idB]) {
            id[idB] = idA;
        } else if (rank[idA] < rank[idB]) {
            id[idA] = idB;
        } else {
            id[idA] = idB;
            rank[idB] += rank[idA];
        }
        count--;
        return false;
    }

    @Override
    public int find(int a) {
        while (!Objects.equals(id[a], a)) {
            a = id[a];
        }
        return a;
    }

    @Override
    public boolean connected(int a, int b) {
        return Objects.equals(find(a), find(b));
    }

    @Override
    public int[] getIds() {
        return id;
    }

}
