package com.algs.util;

import com.algs.datastructure.collection.list.IList;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

class FileUtilTest {

    @Test
    void getPathFromResource() {
    }

    @Test
    void readInts() {
        IList<Integer> ints = FileUtil.readInts("data/1Kints.txt");
        System.out.println(ints.size());
    }

    @Test
    void readPair() {
        IList<Pair<Integer>> pairs = FileUtil.readPairs("data/uf/tinyUF.txt");

    }
}