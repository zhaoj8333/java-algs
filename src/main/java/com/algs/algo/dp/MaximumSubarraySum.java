package com.algs.algo.dp;

import com.algs.utils.array.ArraysUtil;

/**
 * 最大子序列和
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {

        double a = (double) 3 /20;
        System.out.println(a);

//        Integer[] array = ArrayBuilder.randomIntArrayBetween(10, -10, 10);
        Integer[] array = new Integer[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ArraysUtil.println(array);

        int maxSum = getMaxSum(array);
        System.out.println(maxSum);
    }

    /**
     * 状态转移方程：
     *  dp[i] 表示以 第i个数 结尾的区间的区间和 最大值
     *  dp数组最大值为最终结果
     *
     *  dp[i] = max(array[i], array[i] + dp[i - 1])
     */
    private static int getMaxSum(Integer[] array) {
        int tmp = 0;
        int sum = 0;
        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];
            if (tmp < array[i]) {
                tmp = array[i];
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

}
