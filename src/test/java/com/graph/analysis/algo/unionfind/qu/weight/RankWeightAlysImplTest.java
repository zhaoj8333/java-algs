package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.Connection;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.GraphicAnalysis;

class RankWeightAlysImplTest {

    public static void main(String[] args) {

        IList<Connection<Integer>> pairs = FileUtil.readPairs(FilePath.MEDIUM_UF);
        assert pairs != null;
        GraphicAnalysis qfa = new RankWeighedAlysImpl(pairs);
        qfa.analyze();

        GraphicAnalysis qua = new QuickUnionAlysImpl(pairs);
        qua.analyze();

        GraphicAnalysis ra = new RankWeighedLinkedListAlysImpl(pairs);
        ra.analyze();

        qfa = new SizeWeighedAlysImpl(pairs);
        qfa.analyze();


    }

}