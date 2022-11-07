package com.algs.util;

import java.util.Objects;
import java.util.Random;

@SuppressWarnings("all")
public class ArraysUtil<E> {

    public static int [] randomIntArray(int size) {
        Random r = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

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

    private static <E> void swap(E[] array, int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E> void shuffle(E[] array) {
        int len = array.length;
        Random r = new Random();
        for (int i = len; i > 0; i--) {
            int random = r.nextInt(i);
            swap(array, random, i);
        }
    }

    public static <E> void display(E[] array) {
        System.out.print("[");
        for (E ele : array) {
            System.out.print(ele + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static Comparable[] randomArray(int length) {
        Comparable[] array = new Comparable[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = r.nextInt(length);
        }
        return array;
    }

}
