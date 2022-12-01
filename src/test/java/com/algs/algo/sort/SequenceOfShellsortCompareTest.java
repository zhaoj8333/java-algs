package com.algs.algo.sort;

import com.algs.algo.sort.array.cmp_swp.shell.sequence.Geometric;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.N3Plus1;
import com.algs.algo.sort.array.cmp_swp.shell.sequence.SedgeWick;
import com.algs.util.ArrayGenerator;
import com.graph.analysis.algo.sort.IncrementSequenceOfShellsortCompare;
import org.junit.jupiter.api.Test;

class SequenceOfShellsortCompareTest {

    @Test
    void test() {
        Class<?>[] klasses = new Class<?>[] {
//                N3Plus1Sequence.class,
//                SedgeWickSequence.class,
                Geometric.class
        };

        exec(klasses);
    }

    /**
     * 900000:
     * {@link N3Plus1}: 2109 ms
     * {@link SedgeWick}: 1362
     *
     */
    private void exec(Class<?>[] klasses) {
        Integer[] array = ArrayGenerator.randomIntArray(900000);
        System.out.println("Init done");
        for (Class<?> klass : klasses) {
            IncrementSequenceOfShellsortCompare<Integer> compare = new IncrementSequenceOfShellsortCompare<>(array, klass);
            compare.exec(false);
        }
    }

    @Test
    void findBestGeometricSequenceBase() {
        Integer[] array = ArrayGenerator.randomIntArray(100000);
        System.out.println("Init done");

        int minCost = 0;
        int base = 0;
        long minimum = Integer.MAX_VALUE;
        IncrementSequenceOfShellsortCompare<Integer> iseq = null;
        for (int i = 2; i < 32; i++) {
            IncrementSequenceOfShellsortCompare<Integer> st = new IncrementSequenceOfShellsortCompare<>(array, Geometric.class);
            st.setStep(i);
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
}