package com.algs.util;

import com.algs.datastructure.collection.ICollection;
import org.apache.commons.lang.math.JVMRandom;

import java.util.Objects;
import java.util.Random;

@SuppressWarnings("all")
public class ArraysUtil {

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

    public static <E> void swap(E[] array, int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E> void shuffle(E[] array) {
        int len = array.length;
        Random r = new JVMRandom();
        for (int i = len; i > 0; i--) {
            int random = r.nextInt(i);
            swap(array, random, i);
        }
    }

    public static <E> void display(E[] array) {
        System.out.println(toString(array));
    }

    public static void display(Character[] array) {
        System.out.println(toString(array));
    }

    public static void display(ICollection<Character> list) {
        System.out.println(list.toString());
    }

    public static Comparable[] randomArray(int length) {
        Comparable[] array = new Comparable[length];
        Random r = new JVMRandom();
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(length);
        }
        return array;
    }

    public static Integer[] randomIntArray(int length) {
        Integer[] array = new Integer[length];
        Random r = new JVMRandom();
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(length) + 1;
        }
        return array;
    }

    public static Character[] randomPrintableCharArray(int length) {
        Character[] array = new Character[length];
        Random r = new JVMRandom();
        for (int i = 0; i < length; i++) {
            array[i] = (char)(0X20 + r.nextInt(95));
        }
        return array;
    }

    public static Integer[] randomArrayWith2Values(int length, int val1, int val2) {
        Integer[] array = new Integer[length];
        Random r = new JVMRandom();
        for (int i = 0; i < length; i++) {
            int m = r.nextInt(length);
            if (m % 2 == 0) {
                array[i] = val1;
            } else {
                array[i] = val2;
            }
        }
        return array;
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

    public static String toString(Character[] array) {
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
