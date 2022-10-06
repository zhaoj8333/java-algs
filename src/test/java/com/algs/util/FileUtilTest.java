package com.algs.util;

import com.algs.datastructure.collection.list.IList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void getPathFromResource() {
    }

    @Test
    void readInts() {
        IList<Integer> ints = FileUtil.readInts("data/1Kints.txt");
        System.out.println(ints.size());
    }
}