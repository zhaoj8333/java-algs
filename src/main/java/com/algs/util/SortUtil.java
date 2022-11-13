package com.algs.util;

import java.awt.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortUtil<E extends Comparable<E>> {

    public static final Color SORTED_COLOR = Color.LIGHT_GRAY;
    public static final Color UNSORTED_COLOR = Color.BLACK;
    public static final Color COMPARED_COLOR = Color.CYAN;
    public static final Color CHECKING_COLOR = Color.YELLOW;
    public static final Color COMPARE_BASE_COLOR = Color.BLUE;
    public static final Color SELECTED_COLOR = Color.BLUE;

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

    /**
     * Check if elements in the sorted array has been changed
     */
    public static <E extends Comparable> boolean onlySorted(E[] originalArray, E[] sortedArray) {
        if (originalArray.length != sortedArray.length) {
            return false;
        }
        Map<Comparable, Integer> valueMap = new HashMap<>();
        for (Comparable value : originalArray) {
            int count = 0;
            if (valueMap.containsKey(value)) {
                count = valueMap.get(value);
            }
            count++;
            valueMap.put(value, count);
        }
        boolean sorted = isSorted(sortedArray);
        if (!sorted) {
            return false;
        }
        for (Comparable e : sortedArray) {
            if (valueMap.containsKey(e)) {
                Integer count = valueMap.get(e);
                count--;
                if (count == 0) {
                    valueMap.remove(e);
                } else {
                    valueMap.put(e, count);
                }
            } else {
                return false;
            }
        }
        return 0 == valueMap.size();
    }

}
