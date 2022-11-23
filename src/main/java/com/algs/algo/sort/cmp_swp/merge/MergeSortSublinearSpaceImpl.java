package com.algs.algo.sort.cmp_swp.merge;

import java.util.Comparator;

/**
 * // TODO: 11/23/22  
 */
public class MergeSortSublinearSpaceImpl<E extends Comparable<E>> extends MergeSortTopdownOptImpl<E> {

    private int blockSize = 0;
    private final E[] aux;

    public MergeSortSublinearSpaceImpl(E[] array, Comparator<E> comparator, int blockSize) {
        super(array, comparator);
        if (blockSize < 1) {
            throw new RuntimeException("block size should greater than 1");
        }
        if (array.length % blockSize != 0) {
            throw new RuntimeException("array size should be multiple of block size");
        }
        this.blockSize = blockSize;
        aux = (E[]) new Comparable[blockSize];
    }

    @Override
    public void sort() {
        selectionSortByBlocks();
        int blockNum = array.length / blockSize - 1;
        System.out.println("blockNum: " + blockNum);
//        for (int i = blockNum; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                int begin = j * blockSize;
//                int mid   = (j + 1) * blockSize - 1;
//                int end   = mid + blockSize;
//                merge(begin, mid, end);
//            }
//        }
//        blockNum = array.length / blockSize;
        for (int i = 0; i < array.length; i += blockSize) {
            int begin = i;
            int mid = i + blockSize;
            int end = i + blockSize << 1;
            end = Math.min(array.length, end);
            merge(begin, mid, end);
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
                if (compareIndex(minIndex, j) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override
    protected void merge(int begin, int mid, int end) {
        for (int i = 0; i < mid - begin; i++) {
            aux[i] = array[i + begin];
        }
        int li = 0, ri = mid, ai = begin;
        while (li < mid - begin) {
            if (ri < end && compareEntry(array[li], aux[ri]) > 0) {
                array[ai++] = aux[ri++];
            } else {
                array[ai++] = aux[li++];
            }
        }
    }
}
