package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.FileUtil;
import com.algs.util.Pair;
import com.graph.GraphicAnalysis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankWeightLinkedListAlysImplTest {

    public static void main(String[] args) {
        IList<Pair<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
        assert pairs != null;

        GraphicAnalysis ra = new RankWeightLinkedListAlysImpl(pairs);
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