package com.algs.analysis;

public class ThreeSum extends StopWatchTask {

    private final int[] array;
    private final long sum;

    public ThreeSum(int[] array, long sum) {
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
                    if ((long)array[i] + (long)array[j] + (long)array[k] == sum) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
