package com.graph.analysis.algo.sort;

import com.algs.datastructure.collection.list.IList;
import com.algs.util.Connection;
import com.algs.util.FileUtil;
import com.graph.GraphicAnalysis;
import com.graph.analysis.algo.unionfind.qf.QuickFindAlysImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTopdownAlysImplTest {

    public static void main(String[] args) {

        IList<Connection<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
        assert pairs != null;
        GraphicAnalysis qfa = new QuickFindAlysImpl(pairs);
        qfa.analyze();

    }

    @Test
    void analyze() {
    }
}