package com.graph.analysis.algo.unionfind;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.Connection;
import com.algs.utils.file.FileUtil;
import com.graph.GraphicAnalysis;

class ErdosRenyiAlysImplTest {

    public static void main(String[] args) {

        IList<Connection<Integer>> pairs = FileUtil.readPairs("data/uf/mediumUF.txt");
//        IList<Connection<Integer>> pairs = FileUtil.readPairs("pairs/uf/tinyUF.txt");
        GraphicAnalysis ga = new ErdosRenyiAlysImpl(pairs);
        ga.analyze();
    }

}