package com.algs.utils.array;

import com.algs.application.algo.sort.array.ArrayInversionCounter;
import com.algs.datastructure.collection.ICollection;
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
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public static <E> void fill(E[] array, Object value) {
        for (int i = 0; i < array.length; i++) {
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
        for (E e : array) {
            if (Objects.equals(val, e)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Integer[] array, Integer val) {
        for (Integer e : array) {
            if (Objects.equals(val, e)) {
                return true;
            }
        }
        return false;
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
        System.out.println(toString(array));
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
        if (dst.length < src.length) {
            throw new ArrayIndexOutOfBoundsException("Dst array length too small");
        }
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i];
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

    public static String toString(int[] array) {
        ObjectUtil.requireNonNull(array);
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String toString(char[] array) {
        ObjectUtil.requireNonNull(array);
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String toString(Object[] array) {
        ObjectUtil.requireNonNull(array);
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
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
}
