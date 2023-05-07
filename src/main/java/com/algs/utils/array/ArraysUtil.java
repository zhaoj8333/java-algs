package com.algs.utils.array;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;
import com.algs.issues.algo.sort.array.ArrayInversionCounter;
import com.algs.utils.CompareUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

@SuppressWarnings("all")
public final class ArraysUtil {

    private static Random r = new Random();

    public static void fill(int[] array, int value) {
        fill(array, 0, array.length, value);
    }

    public static void fill(int[] array, int from, int to, int value) {
        for (int i = from; i < to; i++) {
            array[i] = value;
        }
    }

    public static <E> void fill(E[] array, Object value) {
        fill(array, 0, array.length, value);
    }

    public static <E> void fill(E[] array, int from, int to, Object value) {
        RangeUtil.requireIntRange(from, 0, array.length);
        RangeUtil.requireIntRange(to, 0, array.length + 1);
        for (int i = from; i < to; i++) {
            array[i] = (E) value;
        }
    }

    public static int[][] transpos(int[][] matrix) {
        int[][] array = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                array[i][j] = matrix[j][i];
            }
        }
        return array;
    }

    public static int[] histogram(int[] array, int m) {
        int[] histo = new int[m];
        for (int i = 0; i < m; i++) {
            for (int value : array) {
                if (value == i) {
                    histo[i]++;
                }
            }
        }
        return histo;
    }

    public static <E> boolean contains(E[] array, E val) {
        return contains(array, val, 0, array.length);
    }

    public static <E> boolean contains(E[] array, E val, int from, int to) {
        RangeUtil.requireIntRange(from, 0, array.length);
        RangeUtil.requireIntRange(to, 0, array.length);
        for (int i = from; i < to; i++) {
            if (Objects.equals(array[i], val)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean sameElements(E[] a, E[] b) {
        if (!Objects.equals(a.length, b.length)) {
            return false;
        }
        for (E e : a) {
            if (indexOf(b, e) == DefaultValues.ELEMENT_NOT_FOUND) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean equals(E[] a, E[] b) {
        ObjectUtil.requireNonNull(a, b);
        if (!Objects.equals(a.length, b.length)) {
            return false;
        }
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (!Objects.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean equals(E[] a, ICollection<E> b) {
        ObjectUtil.requireNonNull(a, b);
        if (!Objects.equals(a.length, b.size())) {
            return false;
        }
        return sameElements(a, b);
    }

    public static <E> boolean sameElements(E[] a, ICollection<E> b) {
        Iterator<E> itr = b.iterator();
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (!itr.hasNext()) {
                return false;
            }
            if (!Objects.equals(a[i], itr.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> int indexOf(E[] array, E val) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(val, array[i])) {
                return i;
            }
        }
        return DefaultValues.ELEMENT_NOT_FOUND;
    }

    public static <E> void reverse(E[] array) {
        reverse(array, 0, array.length);
    }

    /**
     * array: [from, to)
     */
    public static <E> void reverse(E[] array, int from, int to) {
        int len = to - from;
        for (int i = from; i < (from + to) >> 1; i++) {
            E tmp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = tmp;
        }
    }

    public static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E> void shuffle(E[] array) {
        int len = array.length;
        for (int i = len; i > 0; i--) {
            swap(array, r.nextInt(i), i - 1);
        }
    }

    public static void shuffle(char[] array) {
        for (int i = array.length; i > 0; i--) {
            swap(array, r.nextInt(i), i - 1);
        }
    }

    public static <E> void println(E[] array) {
        System.out.println(toString(array, 20));
    }

    public static void println(char[] array) {
        System.out.println(toString(array));
    }

    public static void println(ICollection<Character> list) {
        System.out.println(list.toString());
    }

    public static <E> void rangeClear(E[] array) {
        rangeClear(array, 0, array.length - 1);
    }

    public static <E> void rangeClear(E[] array, int begin, int end) {
        RangeUtil.requireIntRange(begin, 0, array.length - 1);
        RangeUtil.requireIntRange(end, 0, array.length - 1);
        for (int i = begin; i <= end; i++) {
            array[i] = null;
        }
    }

    /**
     * copy array
     */
    public static <E> E[] copyAll(E[] array) {
        E[] target = (E[]) new Object[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    /**
     * copy array
     */
    public static <E extends Comparable<E>> E[] copyAll(E[] array) {
        E[] target = (E[]) new Comparable[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static <E> void copyAll(E[] src, E[] dst) {
        copyAll(src, dst, 0, 0, src.length);
    }

    public static <E> void copyAll(E[] src, E[] dst, int srcPos, int dstPos, int len) {
        if (dst.length < src.length) {
            throw new ArrayIndexOutOfBoundsException("Dst array length too small");
        }
        for (int i = srcPos; i < len; i++) {
            dst[dstPos + i] = src[srcPos + i];
        }
    }

    public static <E, T> T[] copyAndConvert(E[] array) {
        T[] target = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            target[i] = (T) array[i];
        }
        return target;
    }

    public static Character[] toChars(Object[] array) {
        ObjectUtil.requireNonNull(array);
        ObjectUtil.requireNonEmpty(array);
        boolean b = array[0] instanceof Character;
        if (!b) {
            throw new ClassCastException("Unable to convert to Character");
        }
        Character[] chars = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            chars[i] = (Character) array[i];
        }
        return chars;
    }

    public static Integer[] toIntegers(Object[] array) {
        ObjectUtil.requireNonNull(array);
        ObjectUtil.requireNonEmpty(array);
        boolean b = array[0] instanceof Integer;
        if (!b) {
            throw new ClassCastException("Unable to convert to Integer");
        }
        Integer[] ints = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            ints[i] = (Integer) array[i];
        }
        return ints;
    }

    public static Long[] toLongs(Object[] array) {
        ObjectUtil.requireNonNull(array);
        ObjectUtil.requireNonEmpty(array);
        boolean b = array[0] instanceof Long;
        if (!b) {
            throw new ClassCastException("Unable to convert to Long");
        }
        Long[] longs = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            longs[i] = (Long) array[i];
        }
        return longs;
    }

    public static Float[] toFloats(Object[] array) {
        ObjectUtil.requireNonNull(array);
        ObjectUtil.requireNonEmpty(array);
        boolean b = array[0] instanceof Integer;
        if (!b) {
            throw new ClassCastException("Unable to convert to Float");
        }
        Float[] floats = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            floats[i] = (Float) array[i];
        }
        return floats;
    }

    public static Double[] toDoubles(Object[] array) {
        ObjectUtil.requireNonNull(array);
        ObjectUtil.requireNonEmpty(array);
        boolean b = array[0] instanceof Integer;
        if (!b) {
            throw new ClassCastException("Unable to convert to Double");
        }
        Double[] doubles = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            doubles[i] = (Double) array[i];
        }
        return doubles;
    }

    public static String[] toStrings(Object[] array) {
        ObjectUtil.requireNonNull(array);
        ObjectUtil.requireNonEmpty(array);
        boolean b = array[0] instanceof String;
        if (!b) {
            throw new ClassCastException("Unable to convert to Double");
        }
        String[] strings = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strings[i] = (String) array[i];
        }
        return strings;
    }

    public static Integer[] copyAll(Integer[] array) {
        ObjectUtil.requireNonNull(array);
        Integer[] target = new Integer[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static int[] copyAll(int[] array) {
        ObjectUtil.requireNonNull(array);
        int[] target = new int[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static Character[] copyAll(Character[] array) {
        ObjectUtil.requireNonNull(array);
        Character[] target = new Character[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static Short[] copyAll(Short[] array) {
        ObjectUtil.requireNonNull(array);
        Short[] target = new Short[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static String toString(double[] array) {
        return toString(array, array.length);
    }

    public static String toString(double[] array, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < Math.min(len, array.length); i++) {
            sb.append(array[i]).append(DefaultValues.DELIMITER);
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    public static String toString(float[] array) {
        return toString(array, array.length);
    }

    public static String toString(float[] array, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < Math.min(len, array.length); i++) {
            sb.append(array[i]).append(DefaultValues.DELIMITER);
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    public static String toString(long[] array) {
        return toString(array, array.length);
    }

    public static String toString(long[] array, int len) {
        ObjectUtil.requireNonNull(array);
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < Math.min(len, array.length); i++) {
            sb.append(array[i]).append(DefaultValues.DELIMITER);
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    public static String toString(char[] array) {
        return toString(array, array.length);
    }

    public static String toString(char[] array, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < Math.min(len, array.length); i++) {
            sb.append(array[i]).append(DefaultValues.DELIMITER);
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    public static String toString(int[] array) {
        return toString(array, array.length);
    }

    public static String toString(int[] array, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < Math.min(len, array.length); i++) {
            sb.append(array[i]).append(DefaultValues.DELIMITER);
        }
        return sb.toString();
    }

    public static String toString(Object[] array, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultValues.LEFT_SQUARE_BRACKET);
        for (int i = 0; i < Math.min(array.length, len); i++) {
            Object obj = array[i];
            if (Objects.isNull(obj)) {
                sb.append(DefaultValues.NULLVAL);
            } else {
                sb.append(obj);
            }
            sb.append(DefaultValues.DELIMITER);
        }
        sb.append(DefaultValues.RIGHT_SQUARE_BRACKET);
        return sb.toString();
    }

    public static String toString(Object[] array) {
        return toString(array, array.length);
    }

    public static <E extends Comparable<E>> long countInversion(E[] array) {
        return countInversion(array, null);
    }

    public static long countInversion(Integer[] array) {
        Integer[] copy = ArraysUtil.copyAll(array);
        return countInversion(copy, null);
    }

    public static <E extends Comparable<E>> long countInversion(E[] array, Comparator<E> comparator) {
        ArrayInversionCounter<E> counter = new ArrayInversionCounter<>(array, comparator);
        return counter.count();
    }

    public static <E extends Comparable<E>> long countInversionByBruteForce(E[] array) {
        return countInversionByBruteForce(array, null);
    }

    public static <E extends Comparable<E>> long countInversionByBruteForce(E[] array, Comparator<E> comparator) {
        long count = 0;
        for (int left = 0; left < array.length; left++) {
            for (int right = left + 1; right < array.length; right++) {
                if (CompareUtil.more(array[left], array[right], comparator)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int random(int[] array) {
        return array[r.nextInt(array.length)];
    }

    public static Integer random(Integer[] array) {
        return array[r.nextInt(array.length)];
    }

}
