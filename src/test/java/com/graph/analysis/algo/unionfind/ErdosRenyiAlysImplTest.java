package com.graph.analysis.algo.unionfind;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.Connection;
import com.algs.util.FileUtil;
import com.graph.GraphicAnalysis;
import org.junit.jupiter.api.Test;

class ErdosRenyiAlysImplTest {

    public static void main(String[] args) {

        IList<Connection<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
//        IList<Connection<Integer>> pairs = FileUtil.readPairs("pairs/uf/tinyUF.txt");
        GraphicAnalysis ga = new ErdosRenyiAlysImpl(pairs);
        ga.analyze();
    }

    @Test
    void generate() {
    }

    @Test
    void count() {
    }

    @Test
    void testCount() {
    }

    @Test
    void plot() {
    }

    @Test
    void testCount1() {
    }

    @Test
    void testAllUnderSameSize() {
    }

    @Test
    void analyze() {
    }
}