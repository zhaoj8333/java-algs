package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.algo.unionfind.non_generic.qu.weight.RankWeightLinkedListImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.DrawUtil;
import com.algs.util.Pair;
import com.algs.util.RangeUtil;
import com.graph.GraphicAnalysis;

import java.util.Objects;

/**
 * // TODO: 10/15/22
 *
 * Need to add an Analyse Framework
 */
public class RankWeightLinkedListAlysImpl extends RankWeightLinkedListImpl implements GraphicAnalysis {

    private int totalCost = 0;
    private int cost;
    private final IList<Pair<Integer>> data;

    public RankWeightLinkedListAlysImpl(IList<Pair<Integer>> data) {
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
        DrawUtil.setTitle(RankWeightLinkedListImpl.class.getSimpleName());
        DrawUtil.setXscale(0, id.size() + 30);
        DrawUtil.setYscale(0, id.size() * 10);
        DrawUtil.setPenRadius(0.003);
        DrawUtil.textLeft(1, id.size(), String.valueOf(id.size()));

        int i = 0;
        Iterator<Pair<Integer>> itr = data.iterator();
        while (itr.hasNext()) {
            cost = 0;
            Pair<Integer> pair = itr.next();
            Integer a = pair.a;
            Integer b = pair.b;
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
