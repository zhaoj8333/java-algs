package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.utils.array.ArraysUtil;
import com.algs.utils.array.ArraySortUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortImplTest {

    private final Character[] array = new Character[] {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};

    /**
     * E:  {E, A, S, Y, Q, U, E, S, T, I, O, N}
     * E:  {E, A, E, Y, Q, U, S, S, T, I, O, N}
     * E:  {A, E, E, Y, Q, U, S, S, T, I, O, N}
     * Y:  {A, E, E, N, Q, U, S, S, T, I, O, Y}
     * N:  {A, E, E, I, N, U, S, S, T, Q, O, Y}
     * U:  {A, E, E, I, N, O, S, S, T, Q, U, Y}
     * O:  {A, E, E, I, N, O, S, S, T, Q, U, Y}
     * S:  {A, E, E, I, N, O, Q, S, T, S, U, Y}
     * T:  {A, E, E, I, N, O, Q, S, S, T, U, Y}
     *
     * {A, E, E, I, N, O, Q, S, S, T, U, Y}
     */
    @Test
    void _2_3_1() {
//        ArraysUtil.shuffle(array);
        ArraysUtil.display(array);
        sort(array, 0, array.length - 1);
        ArraysUtil.display(array);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * [begin, mid - 1], mid, [mid + 1, end]
     *
     *  i                                 j
     */
    private void sort(Character[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = partition(array, begin, end);
        sort(array, begin, mid - 1);
        sort(array, mid + 1, end);
    }

    private int partition(Character[] array, int begin, int end) {
        int i = begin, j = end + 1;
        char pivot = array[begin];
        while (true) {
            // find array[i] greater than entry
            do {
                i++;
            } while (i <= end && ArraySortUtil.less(array[i], pivot));

            // find array[j] smaller than entry
            do {
                j--;
            } while (j > begin && ArraySortUtil.more(array[j], pivot));

            if (i >= j) {
                break;
            }
            ArraySortUtil.swap(array, i, j);
        }
        ArraySortUtil.swap(array, begin, j);

        System.out.print(pivot + ":  ");
        ArraysUtil.display(array);

        return j;
    }
}