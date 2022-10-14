package com.algs.algo.unionfind.non_generic;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ErdosRenyiTest {

    @Test
    void test() {
        int max = 100;
        int times = 0;
        ErdosRenyi er = new ErdosRenyi(100);
        while (er.count() > 1) {
            int i = RandomUtils.nextInt(max);
            int j = RandomUtils.nextInt(max);
            while (j == i) {
                j = RandomUtils.nextInt(max);
            }
            boolean b = er.notConnectedThenUnion(i, j);
            if (b) {
                System.out.println("connecting: [" + i + ", " + j + "]");
            }

            times ++;
        }
        System.out.println(times);
        System.out.println(Arrays.toString(er.getIds()));
    }

    @Test
    void count() {
    }

    @Test
    void union() {
    }

    @Test
    void find() {
    }

    @Test
    void connected() {
    }

    @Test
    void getIds() {
    }
}