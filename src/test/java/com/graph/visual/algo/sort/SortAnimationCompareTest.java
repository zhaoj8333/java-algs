package com.graph.visual.algo.sort;

import com.algs.utils.array.ArrayGenerator;
import com.algs.utils.array.ArraysUtil;

class SortAnimationCompareTest {

    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.randomIntArray(10);
        System.out.println(ArraysUtil.toString(array));
//        array = new Integer[] {8, 5, 7, 4, 6, 9, 2, 1, 0};

        CompareAndSwapSortAnimation<Integer> sortCmp = new SelectionSortAnimationImpl<>(array, 1000);

        sortCmp.sort();

        System.out.println(ArraysUtil.toString(array));
    }

}