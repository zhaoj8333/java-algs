package com.algs.bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XorOperationTest {

    /**
     * Give an integer array:
     * one number occurred odd number times
     * other number occurred for even number times
     * find the number of occurred odd number
     *
     * reason: associative property of XOR operation, Carry free addition algorithm
     *
     * {@link XorOperation}
     */
    @Test
    void findTheElementOccurredOddNumber() {
        int[] array = {0, 5, 5, 8, 3, 3, 6, 9, 9, 6};

        int eor = 0;
        for (Integer integer : array) {
            eor ^= integer;
        }
        Assertions.assertEquals(eor, 8);
    }

    /**
     * Two numbers occurred odd number times, other numbers occurred even numbers
     * find the two numbers occurred odd number times
     */
    @Test
    void findTwoElementsOccurredOddNumber() {
        int[] array = {1, 5, 8, 3, 3, 8, 5, 8, 0, 0};

        int eor = 0;
        for (Integer integer : array) {
            eor ^= integer;
        }
        // a, b
        // eor == a ^ b;
        // a != b
        // eor != 0, eor至少有一位为1
        int one = 0;
        int theRightestOne = eor & (~eor + 1);  // 提取出最右边的1
        for (int elem : array) {
            if ((elem & theRightestOne) == 1) {
                one ^= elem;
            }
        }
        // xor = a ^ b;
        // a = xor ^ b (a^b^b)
        // b = xor ^ a (a^b^a)
        int other = eor ^ one;
        Assertions.assertTrue((one == 1 || one == 8) && (other == 1 || other == 8));
    }

}