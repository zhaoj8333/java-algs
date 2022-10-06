package com.algs.analysis;

import com.algs.util.Task;

public class ThreeSum extends Task {

    private final int[] array;
    private final int sum;

    public ThreeSum(int[] array, int sum) {
        this.array = array;
        this.sum = sum;
    }

    @Override
    public Object profileTask() {
        return count();
    }

    public int count() {
        int len = array.length;
        int cnt = 0;
        for (int i = len; i > 0; i--) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (array[i] + array[j] + array[k] == sum) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
