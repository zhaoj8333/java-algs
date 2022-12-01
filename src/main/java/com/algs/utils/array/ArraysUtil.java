package com.algs.utils.array;

import com.algs.datastructure.collection.ICollection;

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

    public static <E> boolean contains(E[] array, Object val) {
        for (E e : array) {
            if (Objects.equals(val, e)) {
                return true;
            }
        }
        return false;
    }

    public static <E> void reverse(E[] array) {
        int len = array.length;
        for (int i = 0; i < len >> 1; i++) {
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

    public static <E> void display(E[] array) {
        System.out.println(toString(array));
    }

    public static void display(char[] array) {
        System.out.println(toString(array));
    }

    public static void display(ICollection<Character> list) {
        System.out.println(list.toString());
    }

    /**
     * copy array
     */
    public static <E> E[] copy(E[] array) {
        E[] target = (E[]) new Object[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static <E, T> T[] copyAndConvert(E[] array) {
        T[] target = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            target[i] = (T) array[i];
        }
        return target;
    }

    public static Integer[] copy(Integer[] array) {
        Integer[] target = new Integer[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static int[] copy(int[] array) {
        int[] target = new int[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static Character[] copy(Character[] array) {
        Character[] target = new Character[array.length];
        System.arraycopy(array, 0, target, 0, array.length);
        return target;
    }

    public static String toString(int[] array) {
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

}