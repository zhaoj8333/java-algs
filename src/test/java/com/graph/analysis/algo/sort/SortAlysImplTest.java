package com.graph.analysis.algo.sort;

import com.algs.ImplComplexityGrowthAnalysis;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.DrawUtil;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.analysis.algo.sort.merge.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Comparator;

class SortAlysImplTest<E> extends ImplComplexityGrowthAnalysis<E> {

    private static final Integer[][] testArray = new Integer[n][];

    static {
        int index = 0;
        for (int i = 0; i < n; i++) {
            testArray[index++] = ArrayBuilder.randomIntArray(i);
        }
    }

    private final Class<?>[] compareGroupClasses = new Class<?>[] {
//            MergeSortTdAlysImpl.class,
            MergeSortBuAlysImpl.class,
            NaturalMergeSortBuAlysImpl.class,
    };

    @Override
    public void analyze() {
        analyze(compareGroupClasses);
    }

    @Override
    protected Object construct(Class<?> targetClass, int offset) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(Comparable[].class, Comparator.class);
            Integer[] testedData = ArraysUtil.copy(testArray[offset]);
            instance = constructor.newInstance(testedData, null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void execEachByOffset(Object obj) {
        CompareAndSwapSortAlys<Integer> sortAlys = (CompareAndSwapSortAlys<Integer>) obj;
        sortAlys.analyze();
//        if (sz == x - 1) {
//            DrawUtil.setPenColor(colors.deque());
//            DrawUtil.textRight(570, 17500, "TopDown(acc)");
//            DrawUtil.setPenColor(colors.deque());
//            DrawUtil.textRight(570, 13500, "TopDownOpt(acc)");
//        }
    }

    public static void main(String[] args) {
        SortAlysImplTest<Integer> test = new SortAlysImplTest<>();
        // test.assureFunctionality();
        test.drawCoordinate();
        DrawUtil.setPenRadius(0.003);
        test.drawReferenceLine();
        test.analyze();
    }

    @Override
    public void drawReferenceLine() {
        for (int N = 0; N < n; N += 1) {
            int cost = (int) (6 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (5 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (4 * N * Math.log(N));
            DrawUtil.point(N, cost);
        }
    }

    @Test
    void assureFunctionality() {
        Character[] array = getChars();
        CompareAndSwapSortAlys<Character> alys;

        alys = new MergeSortTdAlysImpl<>(ArraysUtil.copy(array), Comparator.comparingInt(o -> o));
        alys.sort();

        alys = new MergeSortTdOptmAlysImpl<>(ArraysUtil.copy(array), Comparator.comparingInt(o -> o));
        alys.sort();

        alys = new MergeSortBuAlysImpl<>(ArraysUtil.copy(array), Comparator.comparingInt(o -> o));
        alys.sort();

        alys = new MergeSortBuOptmAlysImpl<>(ArraysUtil.copy(array), Comparator.comparingInt(o -> o));
        alys.sort();

        alys = new NaturalMergeSortBuAlysImpl<>(ArraysUtil.copy(array), null);
        alys.sort();
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