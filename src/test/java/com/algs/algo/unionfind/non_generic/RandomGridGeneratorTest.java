package com.algs.algo.unionfind.non_generic;

import org.junit.jupiter.api.Test;

class RandomGridGeneratorTest {

    @Test
    void generate() {
    }

    @Test
    void test() {
        Object[] conns = RandomGridGenerator.get(10);
        for (Object conn : conns) {
            System.out.println(conn);
        }

    }
}