package com.graph.analysis.algo.unionfind.qf;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.DrawUtil;
import com.algs.util.Pair;
import com.graph.GraphicAnalysis;

import java.util.Objects;

public class QuickFindAlysImpl extends QuickFindImpl implements GraphicAnalysis {

    private int totalCost = 0;
    private int cost;
    private final IList<Pair<Integer>> data;

    public QuickFindAlysImpl(IList<Pair<Integer>> pairs) {
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
        totalCost += cost;
    }

    @Override
    public boolean connected(int a, int b) {
        boolean connected = super.connected(a, b);
        totalCost += cost;
        return connected;
    }

    @Override
    public void analyze() {
        DrawUtil.setXscale(0, id.length + 30);
        DrawUtil.setYscale(0, id.length * 2);
        DrawUtil.setPenRadius(0.003);
        DrawUtil.textLeft(1, id.length, String.valueOf(id.length));

        int i = 0;
        Iterator<Pair<Integer>> itr = data.iterator();
        while (itr.hasNext()) {
            cost = 0;
            Pair<Integer> pair = itr.next();
            Integer a = pair.a;
            Integer b = pair.b;
            if (connected(a, b)) {
                i++;
                plot(i, cost, totalCost);
                continue;
            }
            union(a, b);
            i++;
            plot(i, cost, totalCost);
        }
    }
}
