package com.algs.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathUtilTest {

    @Test
    void lg() {
        int lg = MathUtil.lg(33);
        Assertions.assertEquals(5, lg);
        System.out.println(lg);
        lg = MathUtil.lg(32);
        System.out.println(lg);
        int lg2 = MathUtil.lg(10);
        System.out.println(lg2);
        int lg1 = MathUtil.lg(1);
        System.out.println(lg1);

    }

    @Test
    void pow() {
        int pow = MathUtil.pow(2, 5);
        Assertions.assertEquals(32, pow);
        pow = MathUtil.pow(2, -5);
        Assertions.assertEquals(1 / 32, pow);
    }
}