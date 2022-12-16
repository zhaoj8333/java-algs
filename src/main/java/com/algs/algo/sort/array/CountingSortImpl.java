package com.algs.algo.sort.array;

import java.util.Comparator;

/**
 * // TODO: 12/16/22  
 * Complexity:
 *  Generally, it's O(n), but deeply rely on the input array
 *
 * Application:
 * {@link java.util.DualPivotQuicksort#sort(byte[], int, int)}
 * {@link java.util.DualPivotQuicksort#sort(char[], int, int, char[], int, int)}
 * {@link java.util.DualPivotQuicksort#sort(short[], int, int, short[], int, int)}
 *
 * If the array is sorting {@link Integer}, it can cause {@link OutOfMemoryError}: Java heap space
 * {@link Character}, {@link Short}, {@link Byte} is ok
 */
public class CountingSortImpl extends ArraySort<Integer> {

    public CountingSortImpl(Integer[] array, Comparator<Integer> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort0();
        // sort1();
    }

    private void sort1() {

    }

    public void sort0() {
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (compareEntry(array[i], max) > 0) {
                max = array[i];
            }
            if (compareEntry(array[i], min) < 0) {
                min = array[i];
            }
        }
        int[] times = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            times[array[i] - min]++;
        }
        int index = 0;
        for (int number = 0; number < times.length; number++) {
            int count = times[number];
            for (int j = count; j > 0; j--) {
                array[index++] = number + min;
            }
        }
    }

}
