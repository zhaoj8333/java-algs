package com.graph.analysis.algo.sort;

import com.algs.datastructure.collection.list.IList;
import com.algs.utils.DrawUtil;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.GraphicAnalysis;
import com.graph.analysis.algo.sort.merge.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Comparator;

class MergeSortAlysImplTest {

    private static final int x = 512;
    private static final int y = (int) ((98 * x) / 2.6);

    public static void main(String[] args) {
        DrawUtil.setCanvasSize();
        DrawUtil.setTitle(MergeSortAlysImplTest.class.getSimpleName());
        DrawUtil.setXscale(0, x * 0.75);
        DrawUtil.setYscale(0, y);
        DrawUtil.textRight(500, 18000, "6*N*lgN");
        DrawUtil.textRight(520, 15500, "5*N*lgN");
        DrawUtil.setPenRadius(0.006);
        DrawUtil.setPenColor();

        coordinate();

        DrawUtil.setPenColor(DrawUtil.DARK_GRAY);
        DrawUtil.setPenRadius(0.003);

        for (int N = 0; N < x; N += 1) {
            int cost = (int) (6 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (5 * N * Math.log(N));
            DrawUtil.point(N, cost);
//            cost = (int) (4.5 * N * Math.log(N));
//            DrawUtil.point(N, cost);
            cost = (int) (4 * N * Math.log(N));
            DrawUtil.point(N, cost);
        }

        for (int sz = 2; sz < x; sz++) {
            Integer[] array = ArrayBuilder.randomIntArray(sz);
            compareTd(array, sz);
            compareBu(array, sz);
       }
    }

    private static void compareTd(Integer[] array, int sz) {
        DrawUtil.setPenColor(DrawUtil.BOOK_BLUE);
        GraphicAnalysis alys;
        alys = new MergeSortTdAlysImpl<>(ArraysUtil.copy(array), Integer::compare);
        alys.analyze();

//        DrawUtil.setPenColor(DrawUtil.ORANGE);
//        alys = new MergeSortTdOptmAlysImpl<>(ArraysUtil.copy(array), Integer::compareTo);
//        alys.analyze();

//        if (sz == x - 1) {
//            DrawUtil.setPenColor(DrawUtil.BOOK_BLUE);
//            DrawUtil.textRight(570, 17500, "TopDown(acc)");
//            DrawUtil.setPenColor(DrawUtil.ORANGE);
//            DrawUtil.textRight(570, 13500, "TopDownOpt(acc)");
//        }
    }

    private static void compareBu(Integer[] array, int sz) {
        DrawUtil.setPenColor(DrawUtil.BOOK_LIGHT_BLUE);
        GraphicAnalysis alys;
        alys = new MergeSortBuAlysImpl<>(ArraysUtil.copy(array), null);
        alys.analyze();

        alys = new MergeSortBuOptmAlysImpl<>(ArraysUtil.copy(array), null);
        DrawUtil.setPenColor(DrawUtil.ORANGE);
        alys.analyze();

//        if (sz == x - 1) {
//            DrawUtil.setPenColor(DrawUtil.BOOK_BLUE);
//            DrawUtil.textRight(570, 17500, "BottomUp(acc)");
//            DrawUtil.setPenColor(DrawUtil.ORANGE);
//            DrawUtil.textRight(570, 13500, "BottomUp(acc)");
//        }
    }

    private static void coordinate() {
        float[] dash = {1, 5};
        BasicStroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0F, dash, 0.0f);
        int c = x / 20;
        for (int i = 0; i < x; i += c) {
            if (i == 0) {
                DrawUtil.setPenRadius(0.006);
//                DrawUtil.line(-1, 0, -1, y);
            } else {
                DrawUtil.setPenRadius(0.001);
                DrawUtil.line(i, 0, i, y, stroke);
            }
        }
        double v = y / 20;
        for (int i = 0; i < y; i += v) {
            if (i == 0) {
                DrawUtil.setPenRadius(0.006);
//                DrawUtil.line(0, -12, x, -12);
            } else {
                DrawUtil.setPenRadius(0.001);
                DrawUtil.line(0, i, x, i, stroke);
            }
        }
    }

    @Test
    void testTd() {
        Character[] array = getChars();

        MergeSortAlysImpl<Character> alys;
        alys = new MergeSortTdAlysImpl<>(ArraysUtil.copy(array), Comparator.comparingInt(o -> o));
        alys.sort();
        alys = new MergeSortTdOptmAlysImpl<>(ArraysUtil.copy(array), Comparator.comparingInt(o -> o));
        alys.sort();
    }

    @Test
    void testBu() {
        Character[] array = getChars();
        Character[] copy = ArraysUtil.copy(array);
        CompareAndSwapSortAlys<Character> alys;
        alys = new MergeSortBuAlysImpl<>(copy, Comparator.comparingInt(o -> o));
        alys.sort();
        Assertions.assertTrue(ArraySortUtil.isSorted(copy));

        copy = ArraysUtil.copy(array);
        alys = new MergeSortBuOptmAlysImpl<>(copy, Comparator.comparingInt(o -> o));
        alys.sort();
        Assertions.assertTrue(ArraySortUtil.isSorted(copy));
    }

    private Character[] getChars() {
        IList<Character> chars = FileUtil.readChars(FilePath.TINY_TXT);
        assert chars != null;
        Character[] array = ArraysUtil.toChars(chars.toArray());
        ArraysUtil.display(array);
        Assertions.assertTrue(array.length > 1);
        return array;
    }

}