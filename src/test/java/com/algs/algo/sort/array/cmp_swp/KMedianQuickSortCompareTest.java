package com.algs.algo.sort.array.cmp_swp;

import com.algs.algo.sort.array.cmp_swp.quick.KMedianQuickSortImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

/**
 * When k == 3, is the best
 */
class KMedianQuickSortCompareTest<E extends Comparable<E>> extends ArraySortCompareTest<E> {

    private final Integer[] Ks = new Integer[] { 3, 5, 7, 9, 11};
    private int kIndex = 0;

    @Test
    @Override
    public void compare() {
        compare(new Class<?>[] {KMedianQuickSortImpl.class});
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Constructor<?> constructor = null;
        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        try {
            constructor = targetClass.getConstructor(Comparable[].class, Comparator.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ArrayCompareAndSwapSort<Integer> sort = null;
        try {
            Integer[] copy = ArraysUtil.copy(testArray);
            sort = (ArrayCompareAndSwapSort<Integer>) constructor.newInstance(copy, cmp, Ks[kIndex]);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return sort;
    }

    @Override
    public void compare(Class<?>[] targetClasses) {
        for (int i = 0; i < Ks.length; i++) {
            kIndex = i;
            Object targetObject = construct(targetClasses[0]);
            System.out.println("Testing: " + targetClasses[0].getName());
            execEach(targetObject);
        }
    }

    @Override
    protected void execEach(Object obj) {
        ArrayCompareAndSwapSort<Integer> sort = (ArrayCompareAndSwapSort) obj;
        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                sort.sort();
                return null;
            }

            @Override
            protected void assertInput() {
                Assertions.assertFalse(ArraySortUtil.isSorted(sort.getArray()));
            }

            @Override
            protected void assertResult() {
                Assertions.assertTrue(ArraySortUtil.isSorted(sort.getArray()));
            }
        };
        sw.exec(true);
    }

}