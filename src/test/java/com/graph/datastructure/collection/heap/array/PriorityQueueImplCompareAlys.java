package com.graph.datastructure.collection.heap.array;

import com.algs.ImplComplexityGrowthCompareAnalysis;
import com.algs.utils.DrawUtil;
import com.algs.utils.array.ArrayBuilder;
import com.graph.analysis.datastructure.collection.heap.array.ArrayPqAlys;
import com.graph.analysis.datastructure.collection.heap.array.BinaryArrayPqImplAlys;
import com.graph.analysis.datastructure.collection.heap.array.TernaryArrayPqImplAlys;
import java.lang.reflect.Constructor;
import java.util.Comparator;

class PriorityQueueImplCompareAlys<E extends Comparable<E>> extends ImplComplexityGrowthCompareAnalysis<E> {

    protected static final Integer[][] testArray = new Integer[n][];

    static {
        int index = 0;
        for (int i = 0; i < n; i++) {
            testArray[index++] = ArrayBuilder.randomIntArray(i);
        }
    }

    private final Class<?>[] comparedClasses = new Class<?>[] {
            BinaryArrayPqImplAlys.class,
            TernaryArrayPqImplAlys.class,
    };

    @Override
    public void analyze() {
        analyze(comparedClasses);
    }

    @Override
    protected Object construct(Class<?> klass, int offset) {
        Object instance = null;
        try {
            Constructor<?> constructor = klass.getConstructor(Comparable[].class, Comparator.class);
            instance = constructor.newInstance(testArray[offset], Comparator.naturalOrder());
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void execEach(Object obj) {
        ArrayPqAlys<Integer> alys = (ArrayPqAlys<Integer>) obj;
        alys.analyze();
    }

    public static void main(String[] args) {
        ImplComplexityGrowthCompareAnalysis<Integer> test = new PriorityQueueImplCompareAlys<>();

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
            cost = (int) (3 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (2 * N * Math.log(N));
            DrawUtil.point(N, cost);
            cost = (int) (N * Math.log(N));
            DrawUtil.point(N, cost);
        }
    }

}