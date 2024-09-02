package com.algs.datastructure.collection.heap.array;

import com.algs.ImplFunctionalityTest;
import com.algs.issues.datastructure.collection.heap.CubeSum;
import com.algs.issues.datastructure.collection.heap.HeapCheck;
import com.algs.issues.datastructure.collection.nodes.Cube;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IPriorityQueueImplTest<E> extends ImplFunctionalityTest {

    private static final Integer[] testData;

    static {
        Object[] integers = Objects.requireNonNull(FileUtil.readInts(FilePath.INT_8)).toArray();
        testData = ArraysUtil.toIntegers(integers);
    }

    protected Class<?>[] targetClasses = new Class<?>[] {
//            BinaryArrayPqSentinelImpl.class,
//            BinaryArrayPqImpl.class,
//            TernaryArrayPqImpl.class,
            KWayArrayPqImpl.class,
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            if (!Objects.equals(targetClass.getSimpleName(), KWayArrayPqImpl.class.getSimpleName())) {
                Constructor<?> constructor = targetClass.getConstructor(Comparable[].class, Comparator.class);
                Integer[] data = ArraysUtil.copyAll(testData);
                instance = constructor.newInstance(data, null);
            } else {
                Constructor<?> constructor = targetClass.getConstructor(int.class, Comparable[].class, Comparator.class);
                Integer[] data = ArraysUtil.copyAll(testData);
                instance = constructor.newInstance(4, data, null);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected Class<?>[] getConstructorParameters() {
        return new Class[0];
    }

    @Override
    protected void testEach(Object obj) {
        IPriorityQueue<Integer> pq = (IPriorityQueue) obj;

        withData(pq);

        pq.clear();

        for (int i = 0; i < 5; i++) {
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

    private void withData(IPriorityQueue<Integer> pq) {
        Assertions.assertEquals(40, pq.peek());
        Assertions.assertEquals(pq.peek(), pq.remove());
        Assertions.assertFalse(pq.contains(40));

        pq.replace(31);
        Assertions.assertEquals(31, pq.peek());

        pq.add(33);
        Assertions.assertEquals(33, pq.peek());

        Integer remove0 = pq.remove();
        Assertions.assertEquals(33, remove0);
        Integer remove1 = pq.remove();
        Assertions.assertEquals(31, remove1);
        Integer remove2 = pq.remove();
        Assertions.assertEquals(15, remove2);
        Integer remove3 = pq.remove();
        Assertions.assertEquals(10, remove3);
        Integer remove4 = pq.remove();
        Assertions.assertEquals(8, remove4);
        Integer remove5 = pq.remove();
        Assertions.assertEquals(0, remove5);
        Integer remove6 = pq.remove();
        Assertions.assertEquals(-10, remove6);
        Integer remove7 = pq.remove();
        Assertions.assertEquals(-20, remove7);
        Integer remove8 = pq.remove();
        Assertions.assertEquals(-30, remove8);

        Assertions.assertFalse(pq.contains(-30));

        pq.replace(-21);
        Assertions.assertEquals(-21, pq.peek());

        pq.add(-33);
        Assertions.assertEquals(-21, pq.peek());
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    @Test
    void kwayPq() {
        try {
            System.out.println("Testing Data: " + ArraysUtil.toString(testData));
            System.out.println();

            for (int k = 2; k < 11; k++) {
                Constructor<?> constructor = KWayArrayPqImpl.class.getConstructor(
                        int.class, Comparable[].class, Comparator.class
                );
                Integer[] data = ArraysUtil.copyAll(testData);
                ArrayPq<Integer> pq = (ArrayPq<Integer>) constructor.newInstance(k, new Integer[]{}, null);

                System.out.print("Testing " + k + " Way: ");
                for (Integer em : data) {
                    pq.add(em);
                }
                System.out.print(" size: " + pq.size() + ",\t\t");
//                Integer remove = pq.remove();
//                System.out.print(remove + ", ");
                Assertions.assertEquals(40, pq.remove());
                Assertions.assertEquals(30, pq.remove());
                Assertions.assertEquals(15, pq.remove());
                Assertions.assertEquals(10, pq.remove());
                Assertions.assertEquals(8, pq.remove());
                Assertions.assertEquals(0, pq.remove());
                Assertions.assertEquals(-10, pq.remove());
                Assertions.assertEquals(-20, pq.remove());
                Assertions.assertEquals(-30, pq.remove());
//                while (!pq.isEmpty()) {
//                System.out.print(pq.remove() + ", ");
//                }
                System.out.println();
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @Test
    void _2_4_1() {
        String input = "PRIO*R**I*T*Y***QUE***U*E";
        IPriorityQueue<Character> pq = new BinaryArrayPqSentinelImpl<>();
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
        IPriorityQueue<Integer> pq = new BinaryArrayPqSentinelImpl<>();
        for (int i = 15; i >= 1; i--) {
            pq.add(i);
        }

        IPriorityQueue<Integer> pq1 = new BinaryArrayPqSentinelImpl<>();
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
     */
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
        IPriorityQueue<Integer> pq = new BinaryArrayPqSentinelImpl<>();
        for (int i = 1; i <= 32; i++) {
            pq.add(i);
        }
        IPriorityQueue<Integer> pq1 = pq;
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
    void _2_4_25() {
        CubeSum cnt = new CubeSum();
        int n = 3;
        IPriorityQueue<Cube> pq = new BinaryArrayPqImpl<Cube>(n + 1, Comparator.reverseOrder());
        cnt.init(pq, n);
        cnt.compute(pq, n);
    }
}