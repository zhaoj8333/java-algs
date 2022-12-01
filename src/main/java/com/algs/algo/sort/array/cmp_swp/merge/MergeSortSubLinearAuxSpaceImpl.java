package com.algs.algo.sort.array.cmp_swp.merge;

import java.util.Comparator;

public class MergeSortSubLinearAuxSpaceImpl<E extends Comparable<E>> extends MergeSortTdOptmImpl<E> {

    private int blockSize;
    private final E[] auxSpace;

    public MergeSortSubLinearAuxSpaceImpl(E[] array, Comparator<E> comparator, int blockSize) {
        super(array, comparator);
        if (blockSize < 1) {
            throw new RuntimeException("block size should greater than 1");
        }
        if (array.length % blockSize != 0) {
            throw new RuntimeException("array size should be multiple of block size");
        }
        this.blockSize = blockSize;
        auxSpace = (E[]) new Comparable[blockSize];
    }

    /**
     *       {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
     * sort:  ----------  ----------  ------------  --
     */
    @Override
    public void sort() {
        selectionSortByBlocks();
        int blockNum = array.length / blockSize - 1;
        for (int i = blockNum; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int begin = j * blockSize;
                int mid   = (j + 1) * blockSize;
                int end   = mid + blockSize;
                merge(begin, mid, end);
            }
        }
    }

    private void selectionSortByBlocks() {
        for (int i = 0; i < array.length; i+= blockSize) {
            selectionSort(i, i + blockSize);
        }
    }

    private void selectionSort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        for (int i = begin; i < end; i++) {
            int minIndex = i;
            for (int j = i + 1; j < end; j++) {
                if (compareEntry(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override
    protected void merge(int begin, int mid, int end) {
        int li = 0, ri = mid, ai = begin;
        for (int i = li; i < mid - begin; i++) {
            auxSpace[i] = array[begin + i];
        }
        while (li < mid - begin) {
            if (ri < end && compareEntry(auxSpace[li], array[ri]) > 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = auxSpace[li++];
            }
        }
    }
}
