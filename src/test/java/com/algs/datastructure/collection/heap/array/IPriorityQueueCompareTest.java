package com.algs.datastructure.collection.heap.array;

import com.algs.ImplPerformanceTest;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class IPriorityQueueCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    protected static final Integer[] testArray;

    static {
//        testArray = ArrayBuilder.randomIntArray(900000);
//        testArray = ArrayBuilder.randomArrayWithSeveralValues(900000, 50);
//        testArray = ArrayBuilder.ascIntArray(900000);
        testArray = ArrayBuilder.randomIntArrayBetween(900000, 1, 1);
    }

    /**
     * {@link TernaryArrayPqImpl} is better than {@link BinaryArrayPqImpl}
     *
     * {@link com.graph.analysis.datastructure.collection.heap.array.ArrayPqAlys}
     * {@link com.graph.analysis.datastructure.collection.heap.array.BinaryArrayPqImplAlys}
     * {@link com.graph.analysis.datastructure.collection.heap.array.TernaryArrayPqImplAlys}
     *
     * Run: {@link com.graph.datastructure.collection.heap.array.PriorityQueueImplCompareAlys}
     */
    private final Class<?>[] targetClasses = new Class<?>[] {
            TernaryArrayPqImpl.class,
            BinaryArrayPqImpl.class,
            KWayArrayPqImpl.class,
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
        IPriorityQueue<Integer> finalPq = pq;
        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                // add
                for (int i = 0; i < testArray.length; i++) {
                    finalPq.add(testArray[i]);
                }
                // remove
                while (!finalPq.isEmpty()) {
                    finalPq.remove();
                }
                return null;
            }

            @Override
            protected void assertInput() {
            }

            @Override
            protected void assertResult() {
            }
        };
        sw.exec(true);
        pq = null;
        obj = null;
        System.gc();
    }

}