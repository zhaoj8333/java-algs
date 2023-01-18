package com.algs.algo.sort.array.cmp_swp;

import com.algs.ImplPerformanceTest;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.Geometric;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.N3Plus1;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.SedgeWick;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.SequenceGenerator;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.graph.analysis.algo.sort.ShellSortAlysImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class SequenceOfShellSortCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    private static final Integer[] testArray;

    static {
        testArray = ArrayBuilder.randomIntArray(90000);
    }

    private final Class<?>[] generatorClasses = new Class<?>[] {
            N3Plus1.class,
            SedgeWick.class,
            Geometric.class
    };

    public SequenceGenerator sg = null;

    public void setStep(int step) {
        if (sg instanceof Geometric) {
            ((Geometric) sg).step = step;
        }
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        try {
            sg = (SequenceGenerator) targetClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Integer[] copy = ArraysUtil.copyAll(testArray);
        return new ShellSortAlysImpl<>(copy, null, sg);
    }

    @Override
    protected void execEach(Object obj) {
        ShellSortAlysImpl<Integer> sort = (ShellSortAlysImpl<Integer>) obj;
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

    @Test
    @Override
    public void compare() {
        compare(generatorClasses);
    }

    /**
     * 900000:
     * {@link N3Plus1}: 2109 ms
     * {@link SedgeWick}: 1362
     */
    /*
    @Test
    void findBestGeometricSequenceBase() {
        int minCost = 0;
        int base = 0;
        long minimum = Integer.MAX_VALUE;
        for (int i = 2; i < 32; i++) {
            int step = i;

            long timing = st.exec(false);
            int cost = st.getCost();
            if (minimum > timing) {
                minimum = timing;
                minCost = cost;
                base = i;
                iseq = st;
            }
        }
        System.out.println("min time: " + minimum + ", min cost: " + minCost + ", base: " + base);
    }
     */

}