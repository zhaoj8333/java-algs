package com.algs.math;

public class Funktions {

    /**
     * 历史上一个著名的递归函数
     *
     * 阿克曼函数(Ackermann)是非原始递归函数的例子。
     * 两个自然数作为输入值，输出一个自然数。
     * 输出值增长速度非常高，仅是对于(4,3)的输出已大得不能准确计算。
     */
    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }

}
