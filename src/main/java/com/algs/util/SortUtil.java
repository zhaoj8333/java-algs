package com.algs.util;

import java.util.Comparator;

public class SortUtil<E extends Comparable<E>> {

    public static <E> boolean less(Comparable<E> a, Comparable<E> b) {
        return a.compareTo((E) b) < 0;
    }

    public static <E> boolean more(Comparable<E> a, Comparable<E> b) {
        return a.compareTo((E) b) > 0;
    }

    public static <E> void swap(Comparable<E>[] array, int i, int j) {
        Comparable<E> tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E> boolean isAsc(Comparable<E>[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean isDesc(Comparable<E>[] array) {
        for (int i = 1; i < array.length; i++) {
            if (more(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean isSorted(Comparable<E>[] array) {
        return isAsc(array) || isDesc(array);
    }

    public static <E> boolean isSorted(E[] array, Comparator<E> comparator) {
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(array[i], array[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

}
