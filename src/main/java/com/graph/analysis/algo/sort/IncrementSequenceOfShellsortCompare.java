package com.graph.analysis.algo.sort;

import com.algs.algo.sort.cmp_swp.shell.sequence.Geometric;
import com.algs.algo.sort.cmp_swp.shell.sequence.SequenceGenerator;
import com.algs.analysis.StopWatchTask;
import com.algs.util.ArraysUtil;
import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class IncrementSequenceOfShellsortCompare<E extends Comparable<E>> extends StopWatchTask<E> {

    public final IncrementSequenceOfShellsort<Integer> is;

    public SequenceGenerator sg = null;

    public IncrementSequenceOfShellsortCompare(Integer[] array, Class<?> sgKlass) {
        try {
            sg = (SequenceGenerator) sgKlass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Comparator<Integer> cmp = Comparator.comparingInt(a -> a);
        is = new IncrementSequenceOfShellsort<>(ArraysUtil.copy(array), cmp, sg);
    }

    public void setStep(int step) {
        if (sg instanceof Geometric) {
            ((Geometric) sg).step = step;
        }
    }

    @Override
    protected Object profileTask() {
        is.sort();
        return "Cost (" + is.getCost() + "), Cmp (" + is.getCmpCount() + "), Swap (" + is.getSwapCount() + ")";
    }

    @Override
    protected void assertResult() {
        Assertions.assertTrue(SortUtil.isSorted(is.array));
    }

    public int getCost() {
        return is.getCost();
    }

}
