package com.algs.algo.sort;

import com.algs.analysis.StopWatchTask;
import com.algs.util.ArraysUtil;
import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class SortCompare<E extends Comparable<E>> extends StopWatchTask<E> {

    private CompareAndSwapSort<Integer> sort;

    public SortCompare(Integer[] array, Class<?> sortKlass) {
        Constructor<?> constructor = null;
        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        try {
            constructor = sortKlass.getConstructor(Comparable[].class, Comparator.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            sort = (CompareAndSwapSort<Integer>) constructor.newInstance(ArraysUtil.copy(array), cmp);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object profileTask() {
        sort.sort();
        return sort.array.length;
    }

    @Override
    protected void assertResult() {
        Assertions.assertTrue(SortUtil.isSorted(sort.array));
    }
}
