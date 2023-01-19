package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.Connection;
import com.algs.utils.DrawUtil;
import com.algs.utils.RangeUtil;
import com.graph.analysis.algo.unionfind.IUnionFindAlys;

import java.util.Objects;

public class QuickUnionAlysImpl extends QuickUnionImpl implements IUnionFindAlys {

    private int totalCost = 0;
    private int cost;
    private final IList<Connection<Integer>> data;

    public QuickUnionAlysImpl(IList<Connection<Integer>> pairs) {
        super(pairs.size());
        this.data = pairs;
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIntRange(a, 0, id.length);
        while (!Objects.equals(id[a], a)) {
            a = id[a];
            cost += 2;
        }
        return a;
    }

    @Override
    public void union(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return;
        }
        id[idA] = id[idB];
        cost += 2;
        count--;
    }

    @Override
    public boolean connected(int a, int b) {
        return Objects.equals(find(a), find(b));
    }

    @Override
    public void analyze() {
        DrawUtil.setTitle(QuickUnionImpl.class.getSimpleName());
        DrawUtil.setXscale(0, id.length + 30);
        DrawUtil.setYscale(0, id.length * 2);
        DrawUtil.setPenRadius(0.003);
        DrawUtil.textLeft(1, id.length, String.valueOf(id.length));

        int i = 0;
        Iterator<Connection<Integer>> itr = data.iterator();
        while (itr.hasNext()) {
            cost = 0;
            Connection<Integer> connection = itr.next();
            Integer a = connection.a;
            Integer b = connection.b;
            if (connected(a, b)) {
                i++;
                totalCost += cost;
                plot(i, cost, totalCost);
                continue;
            }
            union(a, b);
            i++;
            totalCost += cost;
            plot(i, cost, totalCost);
        }
    }

    @Override
    public int getCost() {
        return cost;
    }
}
