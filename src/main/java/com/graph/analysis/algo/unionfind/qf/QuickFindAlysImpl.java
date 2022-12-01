package com.graph.analysis.algo.unionfind.qf;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.Connection;
import com.algs.utils.DrawUtil;
import com.graph.analysis.algo.unionfind.IUnionFindAlys;

import java.util.Objects;

public class QuickFindAlysImpl extends QuickFindImpl implements IUnionFindAlys {

    private int totalCost = 0;
    private int cost;
    private final IList<Connection<Integer>> data;

    public QuickFindAlysImpl(IList<Connection<Integer>> pairs) {
        super(pairs.size());
        this.data = pairs;
    }

    @Override
    public int find(int a) {
        cost++;
        return super.find(a);
    }

    @Override
    public void union(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (Objects.equals(id[i], idA)) {
                id[i] = idB;
                cost++;
            }
            cost++;
        }
        count--;
    }

    @Override
    public void analyze() {
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
