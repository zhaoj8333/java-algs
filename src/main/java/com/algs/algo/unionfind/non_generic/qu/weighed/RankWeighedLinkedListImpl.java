package com.algs.algo.unionfind.non_generic.qu.weighed;

import com.algs.algo.unionfind.non_generic.IDynamicUnionFind;
import com.algs.datastructure.collection.list.ILinkedList;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl0;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class RankWeighedLinkedListImpl implements IDynamicUnionFind {

    protected ILinkedList<Integer> id;
    protected ILinkedList<Integer> rank;
    protected int count;

    public RankWeighedLinkedListImpl() {
        id = new SinglyLinkedListImpl<>();
        rank = new SinglyLinkedListImpl0<>();
    }

    @Override
    public int count() {
        return count;
    }

    /**
     * 2 * log N * 2 + 2N + 2N
     */
    @Override
    public void union(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return;
        }
        Integer rankA = rank.get(idA);
        Integer rankB = rank.get(idB);
        if (rankA > rankB) {
            id.set(idB, idA);
        } else if (rankA < rankB) {
            id.set(idA, idB);
        } else {
            id.set(idA, idB);
            rank.set(idB, 1 + rank.get(idB));
        }
        count--;
    }

    /**
     * Complexity: N * log N * 2
     */
    @Override
    public int find(int a) {
        RangeUtil.requireIndexRange(a, 0, id.size());
        while (!Objects.equals(a, id.get(a))) {
            a = id.get(a);
        }
        return a;
    }

    @Override
    public boolean connected(int a, int b) {
        return Objects.equals(find(a), find(b));
    }

    @Override
    public int newSite() {
        int ele = id.size();
        id.add(ele);
        rank.add(1);
        count++;
        return ele;
    }

    @Override
    public int[] getIds() {
        Integer[] ids = id.toArray();
        int[] ints = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            ints[i] = ids[i];
        }
        return ints;
    }

}
