package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.FileUtil;
import com.algs.util.Connection;
import com.graph.GraphicAnalysis;
import org.junit.jupiter.api.Test;

class RankWeightLinkedListAlysImplTest {

    public static void main(String[] args) {
        IList<Connection<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
        assert pairs != null;

        GraphicAnalysis ra = new RankWeighedLinkedListAlysImpl(pairs);
        ra.analyze();

    }

    @Test
    void count() {
    }

    @Test
    void union() {
    }

    @Test
    void find() {
    }

    @Test
    void connected() {
    }

    @Test
    void newSite() {
    }

    @Test
    void getIds() {
    }

    @Test
    void notConnectedThenUnion() {
    }

    @Test
    void plot() {
    }

    @Test
    void testFind() {
    }

    @Test
    void testUnion() {
    }

    @Test
    void testConnected() {
    }

    @Test
    void analyze() {
    }
}