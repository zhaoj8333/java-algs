package com.graph.analysis.algo.sort.quick;

import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;

/**
 * 最好的情况：每次选的pivot几乎能把数据均分成两半，这样递归树的深度就是logN，这样快排的时间复杂度为O(NlogN)
 *
 * 最坏的情况：每次找的pivot将数组分成两部分，其中有一部分是空，这样递归树就变成了一棵倾斜的树。树的深度为n-1,这样时间复杂度就变成了O(N^2).
 * 一般当数据有序或者局部有序的时候会出现这种坏的情况，比如数组正序或者逆序，（数字完全相同的时候也是有序的特殊情况）。
 */
public class BestCaseOfQuickSortGenerator<E extends Comparable<E>> {

    public static Character[] getChars(int size) {
        Character[] array = new Character[size];
        Integer[] indices = ArrayBuilder.ascIntArray(size);
        genIndices(indices, 0, indices.length - 1);

        for (int i = 0; i < size; i++) {
            array[i] = (char) (indices[i] + 0x41);
        }
        return array;
    }

    public static Integer[] getInts(int size, int min) {
        Integer[] array = new Integer[size];
        Integer[] indices = ArrayBuilder.ascIntArray(size);
        genIndices(indices, 0, indices.length - 1);

        for (int i = 0; i < size; i++) {
            array[i] = min + indices[i];
        }
        return array;
    }

    public static Long[] getLongs(int size, long min) {
        Long[] array = new Long[size];
        Integer[] indices = ArrayBuilder.ascIntArray(size);
        genIndices(indices, 0, indices.length - 1);

        for (int i = 0; i < size; i++) {
            array[i] = min + indices[i];
        }
        return array;
    }

    /**
     * {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}
     *
     * {9, 0, 2, 3, 1, 6, 5, 7, 8, 4, 11, 14, 12, 13, 10, 17, 16, 15, 18, 19}
     *
     * index: [0, 3],   swap:{0,  1}
     * index: [5, 8],   swap:{5,  6}
     * index: [0, 8],   swap:{0,  4}
     * index: [10, 13], swap:{10, 11}
     * index: [15, 19], swap:{15, 17}
     * index: [10, 19], swap:{10, 14}
     * index: [0, 19],  swap:{0,  9}
     *
     * Every time, swap the smallest(first) and the half biggest(middle) element
     * Essentially it's the reverse order of {@link com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl}
     */
    private static void genIndices(Integer[] array, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        genIndices(array, begin, mid - 1);
        genIndices(array, mid + 1, end);
        ArraySortUtil.swap(array, begin, mid);
        System.out.println("index: [" + begin + ", " + end + "]" + ", swap:{" + begin + ", " + mid + "}");
    }

}
