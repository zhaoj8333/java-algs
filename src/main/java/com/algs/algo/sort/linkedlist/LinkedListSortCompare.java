package com.algs.algo.sort.linkedlist;

import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.collection.list.linked.ISequentialAccessList;
import com.algs.utils.list.LinkedListSortUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class LinkedListSortCompare<E extends Comparable<E>> extends StopWatchTask<E> {

    private LinkedCompareAndSwapSort<Integer> sort;

    public LinkedListSortCompare(ISequentialAccessList<Integer> list, Class<?> sortKlass) {
        Constructor<?> constructor = null;
        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        try {
            constructor = sortKlass.getConstructor(ISequentialAccessList.class, Comparator.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            sort = (LinkedCompareAndSwapSort<Integer>) constructor.newInstance(list.copy(), cmp);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object profileTask() {
        sort.sort();
        return sort.getList().size();
    }

    @Override
    protected void assertResult() {
        Assertions.assertTrue(LinkedListSortUtil.isSorted(sort.getList()));
    }

}
