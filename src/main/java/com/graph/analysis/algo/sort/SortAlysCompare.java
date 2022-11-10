package com.graph.analysis.algo.sort;

import com.algs.analysis.StopWatchTask;
import com.algs.util.ArraysUtil;
import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class SortAlysCompare<E extends Comparable<E>> extends StopWatchTask<E> {

    private CompareAndSwapSortAlys<Integer> sort;

    public SortAlysCompare(Integer[] array, Class<?> sortKlass) {
        Constructor<?> constructor = null;
        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        try {
            constructor = sortKlass.getConstructor(Comparable[].class, Comparator.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            sort = (CompareAndSwapSortAlys<Integer>) constructor.newInstance(ArraysUtil.copy(array), cmp);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object profileTask() {
        sort.sort();
        return "Cost (" + sort.getCost() + "), Cmp (" + sort.getCmpCount() + "), Swap (" + sort.getSwapCount() + ")";
    }

    @Override
    protected void assertResult() {
        Assertions.assertTrue(SortUtil.isSorted(sort.array));
    }
}
