package com.algs.datastructure.collection.heap.pq;

import com.algs.application.datastructure.collection.heap.HeapCheck;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayBinaryPqImpl0Test {

    @Test
    void _2_4_1() {
        String input = "PRIO*R**I*T*Y***QUE***U*E";
        IPriorityQueue<Character> pq = new ArrayBinaryPqImpl0<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*') {
                Character remove = pq.remove();
//                System.out.print(remove + " ");
            } else {
                pq.add(input.charAt(i));
            }
            System.out.println(pq);
        }
        System.out.println();
    }

    @Test
    void _2_4_5() {
        String input = "EASYQUESTION";
        IPriorityQueue<Character> pq = new ArrayBinaryPqImpl<>();
        for (int i = 0; i < input.length(); i++) {
            pq.add(input.charAt(i));
        }
        IPriorityQueue<Character> pq1 = pq;

    }

    /**
     * 大堆中第K大的元素所在位置：
     *
     * Heap-of-size-31 positions
     *
     *                             1
     *               2                         3
     *         4            5             6            7
     *     8      9     10     11     12     13     14     15
     *   16 17  18 19  20 21  22 23  24 25  26 27  28 29  30 31
     *
     * Kth largest item  Can appear                         Cannot appear
     * 2                 2,3                                1,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
     * 3                 2,3,4,5,6,7                        1,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
     * 4                 2,3,4,5,6,7,8,9,10,11,12,13,14,15  1,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
     *
     *
     * Kth smallest item   Can appear                                                               Cannot appear
     * 2                   16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31                          1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
     * 3                   8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31    1,2,3,4,5,6,7
     * 4                   8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31    1,2,3,4,5,6,7
     *
     * ① One extreme case of max-heap is a descendent sorted array
     *                       15
     *              14                 13
     *          12     11          10      9
     *        8   7   6   5      4   3    2  1
     *    the Kth largest  element is in: kth   position
     *    the Kth smallest element is in: n-K   position
     *
     * ② The other extreme cases of max-heap is a highly asymmetric array
     *                       15
     *              14                  7
     *          13       10          6      3
     *       12   11    9   8      5   4   2  1
     *    the Kth largest  element is in: 2kth  position
     *    the Kth smallest element is in: n-K   position
     *
     *                        15
     *              7                   14
     *          3      6            10      13
     *       1   2    5   4      9    8   11  12
     *   the kth largest element can be much farther out: 2^k+1 position
     *   the Kth smallest element is in:  n/2 position, so kth smallest position of element is: (n/2 + k) ~ n-1
     *
     *  Each child is at node 2n+1 and 2n+2, where n is the parent's node.
     *  The sequence of indices for the right-most sequence is 1, 3, 7, 15, 31, 63(a.k.a: 2^n-1)
     *  Smaller values fill in the left side of each branch
     *  The extreme case is where the first six elements are the root and a series of right-children.
     *
     * ③ Also, in a case, 4 th largest can also appear in 2nd position
     *                      15
     *               11            14
     *            10    9       12   13
     *
     * +----------------------------------------------------------+
     * | In a Map-heap, the nth largest value is from 2 to 2^n-1  |
     * +----------------------------------------------------------+
     *
     *  In a 0-based Max-heap, element at i is larger than elements at 2i+1 and 2i+2
     */
    @Test
    void _2_4_7_8() {
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl<>();
        for (int i = 15; i >= 1; i--) {
            pq.add(i);
        }

        IPriorityQueue<Integer> pq1 = new ArrayBinaryPqImpl<>();
        for (int i = 1; i <= 15; i++) {
            pq1.add(i);
        }
        IPriorityQueue<Integer> pq11 = pq1;
    }

    /**
     * Kth smallest item position in a Max-heap
     *              30
     *         20       10
     *      7    9    5
     *
     *  1st min element -> 6
     *  2nd min element -> 4
     *  3rd min element -> 5
     *
     *  Kth min element -> (n-k+1) th element
     *
     * {@link ArrayBinaryPqImpl0Test#_2_4_7_8()}
     */
    @Test
    void _2_4_8() {
    }

    /**
     * ① One extreme case of max-heap is a descendent sorted array
     *                       15
     *              14                 13
     *          12     11          10      9
     *        8   7   6   5      4   3    2  1
     *
     *  In this case, each removal takes 4 swaps
     *
     * ② The other extreme cases of max-heap is a highly asymmetric array
     *                       15
     *              14                  7
     *          13       10          6      3
     *       12   11    9   8      5   4   2  1
     *
     *  In this case, each removal takes 4 swaps
     *
     *                        15
     *              7                   14
     *          3      6            10      13
     *       1   2    5   4      9    8   11  12
     *
     *  In this case, each removal takes 3 swaps
     *
     *                   100
     *           99               98
     *       9       10      97        96
     *      5 6     7  8   95  94    93  92
     *
     *  In this case, each removal takes 2 swaps
     *
     */
    @Test
    void _2_4_14() { }

    @Test
    void _2_4_15() {
        Integer[] array = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        boolean b = checkIsMinHeap(array);
        Assertions.assertTrue(b);

        array = new Integer[]{0, 0, 1, 2, -1, -5, 99, 6, 7, 8};
        b = checkIsMinHeap(array);
        Assertions.assertFalse(b);
    }

    private boolean checkIsMinHeap(Integer[] array) {
        HeapCheck<Integer> hc = new HeapCheck<>();
        return hc.isMinHeap(array);
    }

    @Test
    void _2_4_16() {
        /**
         * As many compares in heapsort, like following
         *                       15
         *              14                 13
         *          12     11          10      9
         *        8   7   6   5      4   3    2  1
         */
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl<>();
        for (int i = 1; i <= 32; i++) {
            pq.add(i);
        }
        IPriorityQueue<Integer> pq1 = pq;
    }

    @Test
    void _2_4_17() {
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl0<>();
        for (int i = 0; i < 10; i++) {
            pq.add(i);
        }
        IPriorityQueue<Integer> pq1 = pq;

        pq.add(20);
        pq.remove();
        pq.add(100);
        pq.remove();
        IPriorityQueue<Integer> pq2 = pq;

        pq.add(200);
        pq.add(300);
        pq.remove();
        pq.remove();
    }

    /**
     * For full tree, number of node is n, height is h, n = 2^h - 1
     *
     * total heights(node number * level height) :
     *  H(n) = 2^0*(h-0) + 2^1*(h-1) + 2^2*(h-2) + ... + 2^(h-1)*[h-(h-1)]
     *  H(n) = h*(2^0 + 2^1 + 2^2 + ... + 2^(h-1)) - [1*2^1 + 2*2^2 + 3*2^3 + ... + (h-1)*2^(h-1)]
     *  H(n) = h * (2^h - 1) - [(h-2)*2^h + 2]
     *  H(n) = h * 2^h - h - h*2^h + 2^(h+1) - 2
     *  H(n) = 2^(h+1) - h - 2
     *  H(n) = 2*(2^h-1) - h
     *  H(n) = 2n - h
     *  H(n) = 2n - log(n+1)
     *  H(n) = O(n)
     */
    void _2_4_20() { }

    @Test
    void testInit() {
        IList<Integer> ints8 = FileUtil.readInts("data/ints/8ints.txt");
        assert ints8 != null;
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl0<>(ints8);
        Integer integer = pq.get();
        Assertions.assertEquals(9, pq.size());
        Assertions.assertEquals(40, integer);

    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void add() {
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl0<>();

        for (int i = 1; i < 12; i++) {
            pq.add(i);
        }
        pq.add(12);

        Assertions.assertEquals(12, pq.get());
        pq.add(13);
        Assertions.assertEquals(13, pq.get());

//        Assertions.assertEquals(12, pq.remove());


        System.out.println(pq);

    }

    @Test
    void get() {
    }

    @Test
    void remove() {
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl0<>();

        pq.add(1);
        pq.add(2);
        pq.add(2);
        Integer remove2 = pq.remove();
        Assertions.assertEquals(2, remove2);
        pq.clear();

        for (int i = 1; i < 15; i++) {
            pq.add(i);
        }

        Integer integer = pq.get();
        Integer remove = pq.remove();
        Assertions.assertEquals(integer, remove);
        Assertions.assertEquals(14, remove);

        Integer integer1 = pq.get();
        Integer remove1 = pq.remove();
        Assertions.assertEquals(integer1, remove1);
        Assertions.assertEquals(13, remove1);

        System.out.println(pq);
    }

    @Test
    void replace() {
        IPriorityQueue<Integer> pq = new ArrayBinaryPqImpl0<>();

        Integer replace = pq.replace(1);
        Integer integer = pq.get();
        Assertions.assertEquals(1, integer);
        Assertions.assertEquals(1, replace);
        Assertions.assertEquals(1, pq.size());

        Integer replace1 = pq.replace(2);
        Assertions.assertEquals(1, replace1);

        for (int i = 3; i < 15; i++) {
            pq.add(i);
        }
        Integer replace2 = pq.replace(20);
        Assertions.assertEquals(14, replace2);

        Integer replace3 = pq.replace(19);
        Assertions.assertEquals(20, replace3);
        Assertions.assertEquals(19, pq.get());

        Integer replace4 = pq.replace(0);
        Assertions.assertEquals(19, replace4);

        Iterator<Integer> itr = pq.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    void compare() {
    }

    @Test
    void contains() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void iterator() {
    }

    @Test
    void testGet() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void testRemove1() {
    }

    @Test
    void reverse() {
    }
}