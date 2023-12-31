package com.algs.analysis;

public class ThreeSum extends StopWatchTask {

    private final Integer[] array;
    private final long sum;

    public ThreeSum(Integer[] array, long sum) {
        this.array = array;
        this.sum = sum;
    }

    @Override
    public Object profileTask() {
        return count();
    }

    @Override
    protected void assertInput() {

    }

    @Override
    protected void assertResult() {

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
