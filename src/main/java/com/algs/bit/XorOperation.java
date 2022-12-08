package com.algs.bit;

public class XorOperation {

    /**
     * XOR operation: Carry Free Addition algorithm(无进位相加)
     *      10110
     *      00111
     * xor -------
     *      10001
     *
     *  0^0 = 0
     *  0^1 = 1
     *  1^1 = 0
     *  the same is 0, different is 1
     *
     * Properties:
     *  N^0 = N
     *  N^N = 0
     *
     * Commutative Property
     * Associative Property
     * a^b = b^a
     * (a^b)^c = a^(b^c)
     * a^b^c^d^...^y^z = A, then, no matter the order of these numbers, their xor result is always A
     *
     *
     * Precondition of this method:
     *     Two swapped number should be in different memory location
     *     &a != &b
     *
     * @see {@link com.algs.utils.array.ArraySortUtil#xorSwap(int[], int, int)}
     *
     * protected void xorSwap(int a, int b) { a = 1, b = 2
     *     int a = a ^ b;   a=1^2, b=2
     *     int b = a ^ b;   a=1^2, b=1^(2^2) -> a^0=a -> b=a
     *     int a = a ^ b;   a=1^2^1, b=a -> 2
     * }
     */



}
