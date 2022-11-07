package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.FileUtil;
import com.algs.util.Connection;
import com.graph.GraphicAnalysis;
import org.junit.jupiter.api.Test;

class SizeWeightAlysImplTest {

    public static void main(String[] args) {

        IList<Connection<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
        assert pairs != null;
        GraphicAnalysis qfa = new SizeWeighedAlysImpl(pairs);
        qfa.analyze();

    }

    @Test
    void union() {
    }

    @Test
    void getIds() {
    }

    @Test
    void count() {
    }

    @Test
    void testUnion() {
    }

    @Test
    void find() {
    }

    @Test
    void connected() {
    }

    @Test
    void testGetIds() {
    }

    @Test
    void plot() {
    }

    @Test
    void testFind() {
    }

    @Test
    void testUnion1() {
    }

    @Test
    void analyze() {
    }
}