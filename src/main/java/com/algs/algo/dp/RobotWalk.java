package com.algs.algo.dp;

import com.algs.utils.array.ArraysUtil;

public class RobotWalk {

    public static void main(String[] args) {
        System.out.println(ways(4, 2, 4, 4));
    }

    /**
     * @return number of ways
     */
    public static int ways(int n, int start, int aim, int k) {
//        return way1(start, k, aim, n);
        return way2(start, k, aim, n);
    }

    private static int way2(int n, int start, int aim, int k) {
        int[][] dp = new int[n + 1][n + 1];
        ArraysUtil.fill(dp, -1);
        return ways2(start, k, aim, n, dp);
    }

    private static int ways2(int cur, int rest, int aim, int n, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ways = 0;
        if (rest <= 0) {
            ways = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ways = ways2(2, rest - 1, aim, n, dp);
        } else {
            ways = ways2(cur - 1, rest - 1, aim, n, dp) + ways2(cur + 1, rest - 1, aim, n, dp);
        }
        dp[cur][rest] = ways;
        return ways;
    }

    /**
     *
     * @param cur 机器人当前来到 的位置 1 ~ n
     * @param rest 机器人还需要走多少步 0 ~ k
     * @param aim 最终目标位置
     * @param n   有多少位置可以移动
     * @return 返回机器人从cur触发，走过rest步之后，最终停在aim的 方法数
     */
    private static int way1(int cur, int rest, int aim, int n) {
        if (rest <= 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return way1(2, rest - 1, aim, n);
        }
        if (cur == n) {
            return way1(n - 1, rest - 1, aim, n);
        }
        return way1(cur - 1, rest - 1, aim, n) + way1(cur + 1, rest - 1, aim, n);
    }

}
