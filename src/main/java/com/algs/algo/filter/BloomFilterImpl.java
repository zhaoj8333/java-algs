package com.algs.algo.filter;

import com.algs.utils.ObjectUtil;

/**
 * Test an element exists:
 *  HashSet, HashMap: not space efficient
 *
 * {@link BloomFilterImpl}: space efficiency and time efficiency far better than other algorithms,
 *  also it's a probabilistic data structure, it test an element exists or not exist
 *  if the result of index which hash function generated returns not 1, means not exist(100% correct)
 *                                                  ...  returns 1, means exist(but not absolutely correct)
 *
 *  Disadvantage:
 *      deletion is inefficient
 *      error rate: number of binary(m), hash functions(k), data data scale(n)
 *      p = (1-e^-(k(n+0.5) / (m-1)))^k
 *      p = (1-e^-kn/m)^k
 *
 *      m = -(nlogP/((log2)^2))
 *      k = m/n * log2
 *
 *  Reduce the error rate(reduce the hash collision)
 *  increase array size(bit size)
 *  more hash function
 *
 * Time Complexity:
 *  add, query: O(k), k is the number of hash funciton
 * Space Complexity:
 *  O(m), m is the number of binary
 */
public class BloomFilterImpl<E> implements IFilter<E> {

    private final int bitSize;

    private final long[] bits;

    private final int hashSize;

    /**
     * @param n data scale
     * @param p error rate
     */
    public BloomFilterImpl(int n, double p) {
        if (n <= 0 || p <= 0 || p >= 1) {
            throw new IllegalArgumentException("n must > 0 and p between 0 and 1");
        }
        double ln2 = Math.log(2);
        bitSize = (int) (-(n * Math.log(p)) / (ln2 * ln2));
        hashSize = (int) (bitSize * ln2 / n);
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
    }

    /**
     * Google Implementation
     */
    @Override
    public void put(E item) {
        ObjectUtil.requireNonNull(item);
        int hashCode = item.hashCode();
        int hash = hashCode >>> 16;
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hashCode + (i * hash);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            set(combinedHash % bitSize);
        }
    }

    /**
     * | 按位或
     */
    private void set(int index) {
        bits[index / Long.SIZE] |= 1 << (index % Long.SIZE);
    }

    private boolean get(int index) {
        long l = bits[index / Long.SIZE];
        return (l & (1 << (index % Long.SIZE))) != 0;
    }

    @Override
    public boolean contains(E item) {
        ObjectUtil.requireNonNull(item);
        int hashCode = item.hashCode();
        int hash = hashCode >>> 16;
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hashCode + (i * hash);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            if (!get(combinedHash % bitSize)) {
                return false;
            }
        }
        return true;
    }

}
