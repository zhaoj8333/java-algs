package com.algs.datastructure.collection.heap.array;

import com.algs.ImplPerformanceTest;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Comparator;

/**
 * Looks like the best K value for {@link KWayArrayPqImpl} is 4
 */
class KWayArrayPqImplCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    private final Integer[] Ks = new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int kIndex = 0;

    protected static final Integer[] testArray;

    static {
        testArray = ArrayBuilder.randomIntArray(900000);
    }

    private final Class<?>[] targetClasses = new Class<?>[] {
            KWayArrayPqImpl.class,
    };

    @Test
    @Override
    public void compare() {
        compare(targetClasses);
    }

    @Override
    public void compare(Class<?>[] targetClasses) {
        for (int i = 0; i < Ks.length; i++) {
            kIndex = i;
            Object targetObject = construct(targetClasses[0]);
            System.out.print("Testing: K = " + Ks[kIndex] + ", " + targetClasses[0].getName());
            System.out.println();
            execEach(targetObject);
        }
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(int.class, Comparable[].class, Comparator.class);
            Integer[] data = ArraysUtil.copyAll(testArray);
            instance = constructor.newInstance(Ks[kIndex], data, null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
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
            protected void assertInput() { }

            @Override
            protected void assertResult() { }
        };
        long time = sw.exec(false);
        System.out.print(", time: " + time);
        System.out.println();
        pq = null;
        obj = null;
        System.gc();
    }
//
//    @Test
//    void findBestGeometricSequenceBase() {
//        int minCost = 0;
//        int base = 0;
//        long minimum = Integer.MAX_VALUE;
//        for (int i = 2; i < 32; i++) {
//            int step = i;
//
//            long timing = st.exec(false);
//            int cost = st.getCost();
//            if (minimum > timing) {
//                minimum = timing;
//                minCost = cost;
//                base = i;
//                iseq = st;
//            }
//        }
//        System.out.println("min time: " + minimum + ", min cost: " + minCost + ", base: " + base);
//    }
}