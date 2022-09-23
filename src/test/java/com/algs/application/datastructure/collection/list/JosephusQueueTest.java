package com.algs.application.datastructure.collection.list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JosephusQueueTest {

    @Test
    void byUsingQueue() {
        JosephusQueue jq = new JosephusQueue();
        int[] seq = jq.byUsingQueue(10, 5);
        System.out.println(Arrays.toString(seq));
        System.out.println("live: " + seq[seq.length - 1]);
    }
}