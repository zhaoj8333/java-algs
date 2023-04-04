package com.algs.algo.sort.array;

import java.util.Comparator;

/**
 * 基数排序： 适合整数（尤其是非负整数）排序
 *
 * 依次对个位数，十位数，百位数，千位数，万位数进行计数排序（从低位到高位）
 */
public class RadixSortImpl extends ArraySort<Integer> {

    public RadixSortImpl(Integer[] array, Comparator<Integer> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (compareEntry(max, array[i]) < 0) {
                max = array[i];
            }
        }
        Integer[] tmp = new Integer[array.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }
        for (int divider = 1; divider <= max; divider *= 10) {
            int[] times = new int[10];
            for (int i = 0; i < array.length; i++) {
                times[array[i] / divider % 10]++;
            }
            int index = 0;
            for (int number = 0; number < times.length; number++) {
                int count = times[number];
                for (int m = count; m > 0; m--) {
                    tmp[index++] += number * divider;
                }
            }
        }
        array = tmp;
    }
}
