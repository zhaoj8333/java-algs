package com.algs.algo.sort.array.cmp_swp.merge;

import com.algs.algo.sort.ISortable;
import com.algs.application.algo.sort.SortedQueueMerger;
import com.algs.datastructure.collection.queue.array.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.utils.CompareUtil;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.array.ArraySortUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortImplTest {

    @Test
    void _2_2_1() {
//        Character[] chars = getChars();
        Character[] chars = ArrayBuilder.randomPrintableCharArray(39);
        ArraysUtil.println(chars);

        Character[] copy = ArraysUtil.copyAll(chars);
        sort(chars);

        Assertions.assertTrue(ArraySortUtil.onlySorted(copy, chars));
        ArraysUtil.println(chars);
    }

    /**
     *  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
     *
     * {E, A, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}         merge(0, 1)
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}         merge(2, 3)
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}       merge(0, 3)
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}         merge(4, 5)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, T, I, O, N}         merge(6, 7)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, T, I, O, N}       merge(4, 7)
     * {A, E, S, Y, O, R, S, T, Q, U, E, S, T, I, O, N}     merge(0, 7)
     *
     * {A, E, O, R, S, S, T, Y, Q, U, E, S, T, I, O, N}         merge(8, 9)
     * {A, E, O, R, S, S, T, Y, Q, U, E, S, T, I, O, N}         merge(10, 11)
     * {A, E, O, R, S, S, T, Y, Q, U, E, S, T, I, O, N}       merge(8, 11)
     * {A, E, O, R, S, S, T, Y, E, Q, S, U, T, I, O, N}         merge(12, 13)
     * {A, E, O, R, S, S, T, Y, E, Q, S, U, I, T, O, N}         merge(14, 15)
     * {A, E, O, R, S, S, T, Y, E, Q, S, U, I, T, N, O}       merge(12, 15)
     * {A, E, O, R, S, S, T, Y, E, Q, S, U, I, N, O, T}     merge(8, 15)
     *
     * {A, E, O, R, S, S, T, Y, E, I, N, O, Q, S, T, U}   merge(0, 15)
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     */
    private void sort(Character[] array) {
        aux = new Character[array.length];
        topDown(array, 0, array.length - 1);
    }

    private Character[] aux;

    /**
     * Divide
     * sort array[lo, .... hi]
     */
    private void topDown(Character[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        topDown(array, lo, mid);
        topDown(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    /**
     * @param array merge array[lo...mid] and array[mid+1..hi]
     * @param lo  0
     * @param mid 0
     * @param hi  1
     *
     * array[]: {E, A, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     *          i                        j
     *          lo                   mid                     hi
     *
     * aux[]:   {E, A, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}
     */
    private void merge(Character[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
            accessCount += 2;
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {          // left half is done
                array[k] = aux[j++];
            } else if (j > hi) {    // right half is done
                array[k] = aux[i++];
            } else if (CompareUtil.less(aux[j], aux[i])) { // operate with the smaller one
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
            accessCount += 2;
        }
//        System.out.println(ArraysUtil.toString(array));
    }

    private Character[] getChars() {
        String str = "EASYSORTQUESTION";
        System.out.println(str);
        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    @Test
    void _2_2_3() {
        Character[] chars = getChars();
        ArraysUtil.println(chars);

        Character[] copy = ArraysUtil.copyAll(chars);
        sort0(chars);

        Assertions.assertTrue(ArraySortUtil.onlySorted(copy, chars));
        ArraysUtil.println(chars);
    }

    /**
     *  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
     *
     * {E, A, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}           merge(0, 1)
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}           merge(2, 3)
     * {A, E, S, Y, S, O, R, T, Q, U, E, S, T, I, O, N}           merge(4, 5)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, T, I, O, N}           merge(6, 7)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, T, I, O, N}           merge(8, 9)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, T, I, O, N}           merge(10, 11)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, T, I, O, N}           merge(12, 13)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, I, T, O, N}           merge(14, 15)
     *
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, I, T, N, O}         merge(0, 3)
     * {A, E, S, Y, O, S, R, T, Q, U, E, S, I, T, N, O}         merge(4, 7)
     * {A, E, S, Y, O, R, S, T, Q, U, E, S, I, T, N, O}         merge(8, 11)
     * {A, E, S, Y, O, R, S, T, E, Q, S, U, I, T, N, O}         merge(12, 15)
     *
     * {A, E, S, Y, O, R, S, T, E, Q, S, U, I, N, O, T}       merge(0, 7)
     * {A, E, O, R, S, S, T, Y, E, Q, S, U, I, N, O, T}       merge(8, 15)
     *
     * {A, E, O, R, S, S, T, Y, E, I, N, O, Q, S, T, U}       merge(0, 15)
     * {A, E, E, I, N, O, O, Q, R, S, S, S, T, T, U, Y}
     */
    private void sort0(Character[] array) {
        aux = new Character[array.length];
        bottomUp(array);
    }

    /**
     * sequence of lo:
     *  sz: 1, lo: 0 2 4 6 8 10 12 14 16 ...
     *  sz: 2, lo: 0   4   8    12    16 ...
     *  sz: 4, lo: 0       8          16 ...
     *  sz: 8, lo: 0                  16 ...
     *  sz:  , lo: 0
     *
     * merge(lo, mid, hi):
     * 0, 0, 1
     * 2, 2, 3
     * 4, 4, 5
     * 6, 6, 7
     * 8, 8, 9
     * 10, 10, 11
     * 12, 12, 13
     * 14, 14, 15
     *
     * 0, 1, 3
     * 4, 5, 7
     * 8, 9, 11
     * 12, 13, 15
     *
     * 0, 3, 7
     * 8, 11, 15
     *
     * 0, 7, 15
     */
    private void bottomUp(Character[] array) {
        int len = array.length;
        aux = new Character[len];
        for (int sz = 1; sz < len; sz = sz + sz) {
            for (int lo = 0; lo < len - sz; lo += sz + sz) {
                int mid = lo + sz - 1;
                int hi = Math.min(lo + sz + sz - 1, len - 1);
                merge(array, lo, mid, hi);
            }
        }
    }

    /**
     * {@link MergeSortTdImpl}:
     *  1 2 1 4 1 2 1 4 9 1 2 1 4 1 2 1 4 9 19 1 2 1 4 1 2 1 4 9 1 2 1 4 1 1 3 8 18 38
     *
     * {@link MergeSortBuImpl}:
     *  1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 3 3 3 3 3 3 3 3 3 2 7 7 7 7 6 15 15 31 38
     */
    @Test
    void _2_2_5() {
        Character[] chars = ArrayBuilder.randomPrintableCharArray(39);
        sort0(chars);
    }

    private int accessCount;

    /**
     * array size    access count
     *      10           126
     *      20           352        2.7
     *      40           864        2.4
     *      80           2048       2.3
     *      160          4736       2.3
     */
    @Test
    void _2_2_6() {
        Character[] chars = ArrayBuilder.randomPrintableCharArray(160);
        sort(chars);
        System.out.println("Topdown: " + accessCount);
    }

    @Test
    void _2_2_12() {
        Character[] chars = getChars();
        ArraysUtil.println(chars);

        ISortable<Character> sort = new MergeSortLinearSpaceImpl<>(chars, Character::compareTo, 4);
        sort.sort();

        ArraysUtil.println(chars);
        Assertions.assertTrue(ArraySortUtil.isSorted(chars));
    }

    @Test
    void _2_2_14() {
        IQueue<Integer> q1 = new ArrayQueueImpl<>();
        IQueue<Integer> q2 = new LinkedQueueImpl<>();
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                q1.enque(i);
            } else {
                q2.enque(i);
            }
        }
        SortedQueueMerger<Integer> merger = new SortedQueueMerger<>(q1, q2);
        IQueue<Integer> q = merger.merge();
        for (int i = 1; i <= 10; i++) {
            Assertions.assertEquals(i, q.deque());
        }
    }

    @Test
    void _2_2_19() {
        Integer[] array = new Integer[] {3, 0, 2, 1, 4};  // 4
        array = ArrayBuilder.randomUniqueArray(40);
        long expected = ArraysUtil.countInversionByBruteForce(array);
        ArraysUtil.println(array);
        long count = ArraysUtil.countInversion(array);
        System.out.println(count);
        Assertions.assertEquals(expected, count);
    }
}