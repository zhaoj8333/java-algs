package com.algs.datastructure.collection.heap.array;

import com.algs.ImplPerformanceTest;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class IPriorityQueueCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    protected static final Integer[] testArray;

    static {
        testArray = ArrayBuilder.randomIntArray(900000);
    }

    /**
     * {@link TernaryArrayPqImpl} is better than {@link BinaryArrayPqImpl}
     */
    private final Class<?>[] targetClasses = new Class<?>[] {
            BinaryArrayPqImpl.class,
            TernaryArrayPqImpl.class,
    };

    @Test
    @Override
    public void compare() {
        compare(targetClasses);
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Constructor<?> constructor = null;
        try {
            constructor = targetClass.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        IPriorityQueue<Integer> pq = null;
        try {
            pq = (IPriorityQueue<Integer>) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return pq;
    }

    @Override
    protected void execEach(Object obj) {
        IPriorityQueue<Integer> pq = (IPriorityQueue<Integer>) obj;
        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                // add
                for (int i = 0; i < testArray.length; i++) {
                    pq.add(testArray[i]);
                }
                // remove
                while (!pq.isEmpty()) {
                    pq.remove();
                }
                return null;
            }

            @Override
            protected void assertInput() { }

            @Override
            protected void assertResult() { }
        };
        sw.exec(true);
    }

}