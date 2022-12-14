package com.algs.algo.sort.array;

import java.util.Comparator;

/**
 * Only for ranged Integers
 */
public class CountingSortImpl extends ArraySort<Integer> {

    public CountingSortImpl(Integer[] array, Comparator<Integer> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (compareEntry(array[i], max) > 0) {
                max = array[i];
            }
        }
        int[] times = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            times[array[i]]++;
        }
        int index = 0;
        for (int number = 0; number < times.length; number++) {
            int count = times[number];
            for (int j = count; j > 0; j--) {
                array[index++] = number;
            }
        }
    }

}
