package com.algs.issues.algo.sort.array;

import com.algs.utils.CompareUtil;
import com.algs.utils.array.ArraysUtil;
import java.util.Comparator;

/**
 * 1. Brute-force iteration
 * 2. Bubble sort: For {@link com.algs.algo.sort.array.cmp_swp.BubbleSortImpl}, every {{@link com.algs.utils.array.ArraySortUtil#swap(Comparable[], int, int)} will eliminate 1 Inversion
 * 3. Merge Sort: For {@link com.graph.analysis.algo.sort.merge.MergeSortBuOptmAlysImpl}, every array[ai++] = array[ri++] will eliminate (le-li) inversions
 * 4. Tree array
 */
public class ArrayInversionCounter<E extends Comparable<E>> {

    private final E[] array;
    private final E[] aux;
    private final Comparator<E> comparator;
    private long count;

    public ArrayInversionCounter(E[] array, Comparator<E> comparator) {
        this.array = ArraysUtil.copyAll(array);
        aux = (E[]) new Comparable[array.length >> 1];
        this.comparator = comparator;
    }

    public long count() {
        count(0, array.length);
        return count;
    }

    private void count(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        count(begin, mid);
        count(mid, end);
        mergeCount(begin, mid, end);
    }

    /**
     * [begin, mid), [mid, end)
     *
     * i: index of left sub-array, sorted
     * j: index of right sub-array, sorted
     *
     * If a[i] > a[j], a[i+1], a[i+2] ... a[mid] all will be greater than a[j], then there are (mid - i) inversions
     */
    private void mergeCount(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, ai = begin;
        for (int i = 0; i < le; i++) {
            aux[i] = array[begin + i];
        }
        while (li < le) {
            // this will eliminate n inversions which the right is array[ri]
            if (ri < end && CompareUtil.compare(aux[li], array[ri], comparator) > 0) {
                array[ai++] = array[ri++];
                count += (le - li);
            } else {
                array[ai++] = aux[li++];
            }
        }
    }
}
