package com.algs.algo.sort.array;

import com.algs.algo.sort.array.cmp_swp.CompareAndSwapSort;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.array.ArraySortUtil;
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
        Assertions.assertTrue(ArraySortUtil.isSorted(sort.array));
    }

}
