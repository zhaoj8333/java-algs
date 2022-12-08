package com.graph.analysis.algo.unionfind.qf;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.Connection;
import com.algs.utils.file.FileUtil;
import com.graph.GraphicAnalysis;

class QuickFindAlysImplTest {

    public static void main(String[] args) {

        IList<Connection<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
        assert pairs != null;
        GraphicAnalysis qfa = new QuickFindAlysImpl(pairs);
        qfa.analyze();

    }

}