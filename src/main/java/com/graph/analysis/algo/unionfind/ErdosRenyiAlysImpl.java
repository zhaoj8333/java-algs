package com.graph.analysis.algo.unionfind;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl;
import com.algs.datastructure.collection.queue.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.util.Connection;
import com.algs.util.DrawUtil;
import com.graph.GraphicAnalysis;
import com.graph.analysis.algo.unionfind.qf.QuickFindAlysImpl;
import com.graph.analysis.algo.unionfind.qu.weight.QuickUnionAlysImpl;
import com.graph.analysis.algo.unionfind.qu.weight.RankWeightAlysImpl;
import com.graph.analysis.algo.unionfind.qu.weight.SizeWeightAlysImpl;

import java.util.Arrays;

public class ErdosRenyiAlysImpl implements GraphicAnalysis {

    private final int size;
    private final IList<Connection<Integer>> conns;
    private final IQueue<IUnionFindAlys> q;
    private final IList<Result> results = new SinglyLinkedListImpl<>();

    private static class Result {
        public String name;
        public int[] result;

        public Result(String name, int[] result) {
            this.name = name;
            this.result = result;
        }
    }

    public ErdosRenyiAlysImpl(IList<Connection<Integer>> conns) {
        this.conns = conns;
        this.size  = conns.size();
        q = new ArrayQueueImpl<>();
        q.enque(new QuickFindAlysImpl(conns));
        q.enque(new QuickUnionAlysImpl(conns));
        q.enque(new SizeWeightAlysImpl(conns));
        q.enque(new RankWeightAlysImpl(conns));
    }

    public void compute(IUnionFindAlys uf) {
        Iterator<Connection<Integer>> itr = conns.iterator();
        int[] result = new int[size];
        int i = 0;
        while (itr.hasNext()) {
            Connection<Integer> conn = itr.next();
            if (uf.connected(conn.a, conn.b)) {
                result[i++] = uf.getCost();
                continue;
            }
            uf.union(conn.a, conn.b);
            result[i++] = uf.getCost();
        }
        results.add(new Result(uf.getClass().getSimpleName().replace("AlysImpl", ""), result));
    }

    @Override
    public void analyze() {
        DrawUtil.setTitle(ErdosRenyiAlysImpl.class.getSimpleName());
        int xscale = 620;
        int yscale = 620000;
        DrawUtil.setXscale(0, xscale);
        DrawUtil.setYscale(0, yscale);
        DrawUtil.setPenRadius(0.003);
        DrawUtil.textLeft(1, size, String.valueOf(size));

        while (!q.isEmpty()) {
            IUnionFindAlys d = q.deque();
            compute(d);
        }
        System.out.println("Compute done");

        Iterator<Result> itr = results.iterator();
        int j = 0;
        while (itr.hasNext()) {
            DrawUtil.setPenColor(DrawUtil.BLACK);
            Result res = itr.next();
            int[] nums = res.result;
            System.out.println(res.name + ": " + Arrays.toString(nums));
            int totalCost = 0;
            DrawUtil.textRight(xscale + 330, (yscale / 2 + (j += 21050)), String.valueOf(res.name));
            for (int value : nums) {
                totalCost += value;
            }
            for (int i = 1; i <= nums.length - 1; i++) {
                plot(i, nums[i], totalCost);
            }
        }

    }

}
