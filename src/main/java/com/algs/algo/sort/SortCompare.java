package com.algs.algo.sort;

import com.algs.analysis.StopWatchTask;
import com.algs.util.ArraysUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class SortCompare<E extends Comparable<E>> extends StopWatchTask<E> {

    private ISortable<Integer> sort;

    public SortCompare(Integer[] array, Class<?> sortKlass) {
        Constructor<?> constructor = null;
        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        try {
            constructor = sortKlass.getConstructor(Comparable[].class, Comparator.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            sort = (ISortable<Integer>) constructor.newInstance(ArraysUtil.copy(array), cmp);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object profileTask() {
        sort.sort();
        return null;
    }
}
