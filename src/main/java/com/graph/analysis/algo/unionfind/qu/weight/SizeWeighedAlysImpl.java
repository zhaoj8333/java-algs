package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.algo.unionfind.non_generic.qu.weighed.SizeWeighedImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.Connection;
import com.algs.utils.DrawUtil;
import com.graph.analysis.algo.unionfind.IUnionFindAlys;

import java.util.Objects;

public class SizeWeighedAlysImpl extends SizeWeighedImpl implements IUnionFindAlys {

    private int totalCost = 0;
    private int cost;
    private final IList<Connection<Integer>> data;

    public SizeWeighedAlysImpl(IList<Connection<Integer>> data) {
        super(data.size());
        this.data = data;
    }

    @Override
    public int find(int a) {
        while (!Objects.equals(a, id[a])) {
            a = id[a];
            cost++;
        }
        return a;
    }

    @Override
    public void union(int a, int b) {
        super.union(a, b);
        cost++;
    }

    @Override
    public void analyze() {
        DrawUtil.setTitle(SizeWeighedImpl.class.getSimpleName());
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
