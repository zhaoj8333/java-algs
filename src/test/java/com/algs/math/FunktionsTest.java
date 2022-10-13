package com.algs.math;

import org.junit.jupiter.api.Test;

class FunktionsTest {

    @Test
    void ackermann() {
        int m = 4;
        int n = 1;
        int ackermann = Funktions.ackermann(m, n);
        System.out.println(ackermann);
    }
}