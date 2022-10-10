package com.algs.datastructure.array;

public class ArrayUtil {

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


}
