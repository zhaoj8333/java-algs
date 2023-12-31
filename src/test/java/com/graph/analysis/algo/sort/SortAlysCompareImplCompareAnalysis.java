package com.graph.analysis.algo.sort;

import com.algs.ImplComplexityGrowthCompareAnalysis;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.DrawUtil;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.analysis.algo.sort.merge.MergeSortBuAlysImpl;
import com.graph.analysis.algo.sort.merge.MergeSortBuOptmAlysImpl;
import com.graph.analysis.algo.sort.merge.MergeSortTdAlysImpl;
import com.graph.analysis.algo.sort.merge.MergeSortTdOptmAlysImpl;
import com.graph.analysis.algo.sort.merge.NaturalMergeSortBuAlysImpl;
import com.graph.analysis.algo.sort.quick.NoSentinelQuickSortAlysImpl;
import com.graph.analysis.algo.sort.quick.QuickSort3wayAlysImpl;
import com.graph.analysis.algo.sort.quick.QuickSortAlysImpl;
import com.graph.analysis.algo.sort.quick.QuickSortIgnoreSmallArrayAlysImpl;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortAlysCompareImplCompareAnalysis<E> extends ImplComplexityGrowthCompareAnalysis<E> {

    private static final Integer[][] testArray = new Integer[n][];

    static {
        int index = 0;
        for (int i = 0; i < n; i++) {
            testArray[index++] = ArrayBuilder.randomIntArray(i);
        }
    }

    private final Class<?>[] compareGroupClasses = new Class<?>[] {
//            SelectionSortAlysImpl.class,
//            InsertionSortAlysImpl.class,
//            ShellSortAlysImpl.class,
//            MergeSortTdAlysImpl.class,
//            MergeSortBuAlysImpl.class,
//            MergeSortBuOptmAlysImpl.class,
//            NaturalMergeSortBuAlysImpl.class,
            QuickSortAlysImpl.class,
//            QuickSort3wayAlysImpl.class,
//            NoSentinelQuickSortAlysImpl.class,
            QuickSortIgnoreSmallArrayAlysImpl.class,
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
            Integer[] testedData = ArraysUtil.copyAll(testArray[offset]);
            instance = constructor.newInstance(testedData, null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void execEach(Object obj) {
        CompareAndSwapSortAlys<Integer> sortAlys = (CompareAndSwapSortAlys<Integer>) obj;
        sortAlys.analyze();
    }

    public static void main(String[] args) {
        SortAlysCompareImplCompareAnalysis<Integer> test = new SortAlysCompareImplCompareAnalysis<>();
        Assertions.assertTrue(test.assureFunctionality());

        test.drawCoordinate();
        DrawUtil.setPenRadius(0.003);
        test.drawReferenceLine();
        test.analyze();
    }

    @Override
    public void drawReferenceLine() {
        for (int N = 0; N < n; N += 1) {
            int cost = (int) (7 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (6 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (5 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (4 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (3 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (2 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (N * Math.log(N));
            DrawUtil.point(N, cost);
        }
    }

    private boolean assureFunctionality() {
        Character[] array = getChars();
        CompareAndSwapSortAlys<Character> alys;

        try {
            alys = new MergeSortTdAlysImpl<>(ArraysUtil.copyAll(array), Comparator.comparingInt(o -> o));
            alys.sort();

            alys = new MergeSortTdOptmAlysImpl<>(ArraysUtil.copyAll(array), Comparator.comparingInt(o -> o));
            alys.sort();

            alys = new MergeSortBuAlysImpl<>(ArraysUtil.copyAll(array), Comparator.comparingInt(o -> o));
            alys.sort();

            alys = new MergeSortBuOptmAlysImpl<>(ArraysUtil.copyAll(array), Comparator.comparingInt(o -> o));
            alys.sort();

            alys = new NaturalMergeSortBuAlysImpl<>(ArraysUtil.copyAll(array), null);
            alys.sort();
//
            alys = new QuickSortAlysImpl<>(ArraysUtil.copyAll(array));
            alys.sort();

            alys = new QuickSort3wayAlysImpl<>(ArraysUtil.copyAll(array));
            alys.sort();

            alys = new NoSentinelQuickSortAlysImpl<>(ArraysUtil.copyAll(array));
            alys.sort();

            alys = new QuickSortIgnoreSmallArrayAlysImpl<>(ArraysUtil.copyAll(array));
            alys.sort();

            return true;
        } catch (Exception e) {
            try {
                throw new Exception(e.getMessage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return false;
        }
    }

    private Character[] getChars() {
        IList<Character> chars = FileUtil.readChars(FilePath.TINY);
        assert chars != null;
        Character[] array = ArraysUtil.toChars(chars.toArray());

        Assertions.assertTrue(array.length > 1);
        return array;
    }

    @Test
    void _2_3_28() {
        for (int i = 4; i <= 8; i++) {
            double pow = Math.pow(8, i);
            Integer[] array = ArrayBuilder.randomUniqueArray((int) pow);

            QuickSortAlysImpl<Integer> sortAlys = new QuickSortAlysImpl<Integer>(array);
            sortAlys.sort();
            int recursiveCalls = sortAlys.getRecursiveCalls();
            int recursiveDepth = sortAlys.getRecursiveDepth();
            System.out.println("size: " + pow + ", average recursive depth: " + (recursiveDepth / recursiveCalls));
        }
    }

}