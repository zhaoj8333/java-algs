package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedLinkedListImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.DrawUtil;
import com.algs.utils.Connection;
import com.algs.utils.RangeUtil;
import com.graph.GraphicAnalysis;

import java.util.Objects;

/**
 * // TODO: 10/15/22
 *
 * Need to add an Analyse Framework
 */
public class RankWeighedLinkedListAlysImpl extends RankWeighedLinkedListImpl implements GraphicAnalysis {

    private int totalCost = 0;
    private int cost;
    private final IList<Connection<Integer>> data;

    public RankWeighedLinkedListAlysImpl(IList<Connection<Integer>> data) {
        this.data = data;
        for (int i = 0; i < data.size(); i++) {
            id.add(i);
            rank.add(1);
        }
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIndexRange(a, 0, data.size());
        while (!Objects.equals(a, id.get(a))) {
            cost += a;
            a = id.get(a);
            cost += a;
            cost += 1;
        }
        cost += a;
        return a;
    }

    @Override
    public void union(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return;
        }
        Integer rankA = rank.get(idA);
        cost += idA;
        Integer rankB = rank.get(idB);
        cost += idB;
        if (rankA > rankB) {
            id.set(idB, idA);
            cost += idB;
        } else if (rankA < rankB) {
            id.set(idA, idB);
            cost += idA;
        } else {
            id.set(idA, idB);
            rank.set(idB, 1 + rank.get(idB));
            cost += 2 * idB;
            cost += idA;
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return Objects.equals(find(a), find(b));
    }

    @Override
    public void analyze() {
        DrawUtil.setTitle(RankWeighedLinkedListImpl.class.getSimpleName());
        DrawUtil.setXscale(0, id.size() + 30);
        DrawUtil.setYscale(0, id.size() * 10);
        DrawUtil.setPenRadius(0.003);
        DrawUtil.textLeft(1, id.size(), String.valueOf(id.size()));

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
}
