package com.graph.analysis.algo.sort.quick;

import com.algs.utils.array.ArraySortUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

public class MaximumSwapOfLargestElement<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    private int prevPos;
    private int nextPos;
    private int swapOfMax;
    private final boolean print;

    public MaximumSwapOfLargestElement(E[] array, boolean print) {
        super(array);
        this.print = print;
    }

    public int get() {
        sortAndCalculate(0, array.length - 1);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
        return swapOfMax;
    }

    @Override
    public void sort() {
        sortAndCalculate(0, array.length - 1);
    }

    private void sortAndCalculate(int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = pivot(begin, end);
        sortAndCalculate(begin, mid - 1);
        sortAndCalculate(mid + 1, end);
    }

    private int pivot(int begin, int end) {
        int i = begin, j = end + 1;
        // ArraySortUtil.swap(array, begin, begin + new Random().nextInt(end - begin));
        E pivot = array[begin];
        prevPos = getIndexOfMaxItem();

        while (i <= j) {
            while (++i <= end && compareEntry(array[i], pivot) < 0);   // array[i] < pivot
            while (--j >= begin && compareEntry(array[j], pivot) > 0); // array[j] > pivot
            if (i >= j) {
                break;
            }
            ArraySortUtil.swap(array, i, j);

            nextPos = getIndexOfMaxItem();
            if (prevPos != nextPos) {
                swapOfMax++;
                if (print) {
                    printBiggestElementSwap(i, j);
                }
                prevPos = nextPos;
            }
        }
        ArraySortUtil.swap(array, begin, j);

        nextPos = getIndexOfMaxItem();
        if (prevPos != nextPos) {
            swapOfMax++;
            if (print) {
                printBiggestElementSwap(i, j);
            }
        }
        return j;
    }

    private int getIndexOfMaxItem() {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (compareEntry(array[i], array[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void printBiggestElementSwap(int i, int j) {
        if (i < array.length && j < array.length) {
            E a = array[i];
            E b = array[j];
            System.out.println("After swap: [" + a + ", " + b + "], index: [" + i + ", " + j + "]");
        }
    }

}
