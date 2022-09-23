package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.queue.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidBracesTest {

    private IQueue<String> strings;

    @BeforeEach
    void setUp() {
        strings = new ArrayQueueImpl<>(9);
        strings.enque("{}");
        strings.enque("({})");
        strings.enque("(){}");
        strings.enque("{}[]");
        strings.enque("{{}}");
        strings.enque("");
        strings.enque("{}[])");
        strings.enque("[{})");
        strings.enque("{}[{()}]()");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        ValidBraces vb = new ValidBraces();
        while (!strings.isEmpty()) {
            String str = strings.deque();
            boolean res1 = vb.usingStringManipulation(str);
            boolean res2 = vb.usingStack(str);
            System.out.println(str + ": " + "res1: " + res1 + ", res2: " + res2);
            Assertions.assertEquals(res1, res2);
        }
    }
}