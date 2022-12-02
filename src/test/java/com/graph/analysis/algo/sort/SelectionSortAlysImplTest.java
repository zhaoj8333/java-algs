package com.graph.analysis.algo.sort;

import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.utils.array.ArrayGenerator;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class SelectionSortAlysImplTest {

    public static void main(String[] args) {
//        testFile();

        IList<Comparable[]> list = new SinglyLinkedListImpl<>();
        for (int i = 10; i < 90000; i *= 10) {
            list.add(ArrayGenerator.randomArray(i));
        }
        for (int i = 0; i < list.size(); i++) {
            Comparable[] comparables = list.get(i);
//            GraphicAnalysis sort = new SelectionSortAlysImpl<>(comparables);
//            sort.analyze();
        }
    }

    private static void testFile() {
        String[] files = new String[] {
                "data/ints/8ints.txt",
                "data/ints/1Kints.txt",
                "data/ints/2Kints.txt",
                "data/ints/4Kints.txt",
                "data/ints/8Kints.txt",
                "data/ints/16Kints.txt",
                "data/ints/32Kints.txt",
                "data/ints/1Mints.txt",
        };
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            IList<Integer> list = FileUtil.readInts(file);
            if (Objects.isNull(list)) {
                continue;
            }
            Object[] objs = list.toArray();
            Integer[] ints = new Integer[objs.length];
            for (int j = 0; j < objs.length; j++) {
                ints[j] = (int) objs[j];
            }
//            GraphicAnalysis sort = new SelectionSortAlysImpl<>(ints, i);
//            sort.analyze();

        }
    }

    @Test
    void analyze() {
    }
}