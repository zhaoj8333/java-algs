package com.algs.datastructure.collection.heap;

import com.algs.datastructure.collection.heap.pq.ArrayBinaryPqImpl;

class ArrayBinaryPqPerformanceTest {

    public static void main(String[] args) {

    }

    private static void _2_4_36() {
        int[] szs = new int[]{
                80000,
                800000,
                8000000
        };
        for (int sz : szs) {
            ArrayBinaryPqPerformance p = new ArrayBinaryPqPerformance(sz, new ArrayBinaryPqImpl<>(sz));
            p.exec(true);
        }
    }

    private static void _2_4_37() {


    }
}