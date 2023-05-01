package com.algs.issues.datastructure.collection.list;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class JosephusQueueTest {

    @Test
    void byUsingQueue() {
        JosephusQueue jq = new JosephusQueue();
        int[] seq = jq.byUsingQueue(10, 5);
        System.out.println(Arrays.toString(seq));
        System.out.println("live: " + seq[seq.length - 1]);
    }
}