package com.algs.utils;

import java.util.Comparator;
import java.util.Objects;

public class CompareUtil {

    public static <E extends Comparable<E>> boolean less(E a, E b) {
        return less(a, b, null);
    }

    public static <E extends Comparable<E>> boolean less(E a, E b, Comparator<E> comparator) {
        return compare(a, b, comparator) < 0;
    }

    public static <E extends Comparable<E>> boolean more(E a, E b) {
        return more(a, b, null);
    }

    public static <E extends Comparable<E>> boolean more(E a, E b, Comparator<E> comparator) {
        return compare(a, b, comparator) > 0;
    }

    public static <E extends Comparable<E>> boolean equals(E a, E b) {
        return equals(a, b, null);
    }

    public static <E extends Comparable<E>> boolean equals(E a, E b, Comparator<E> comparator) {
        return compare(a, b, comparator) == 0;
    }

    public static <E extends Comparable<E>> int compare(E a, E b) {
        return compare(a, b, null);
    }

    public static <E extends Comparable<E>> int compare(E a, E b, Comparator<E> comparator) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

}
