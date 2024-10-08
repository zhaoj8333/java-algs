package com.algs.issues.datastructure.collection.median_find;

import com.algs.utils.array.ArraysUtil;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianFinderTest {

    @Test
    void test() {
        MedianFinder<Integer> dmf = new PqMedianFinder<>();
        // 2, 9, 18, 23, 30, 59, 68, 100
        Integer[] array = new Integer[] {100, 2, 59, 9, 23, 68, 18, 30};
        for (Integer em : array) {
            dmf.insert(em);
        }
        Integer[] expected0 = {23, 30};
        Comparable<Integer>[] b = dmf.find();
        Comparable<Integer>[] c = dmf.delete();
        Assertions.assertTrue(ArraysUtil.matchesInOrder(expected0, b));
        Assertions.assertTrue(ArraysUtil.matchesInOrder(expected0, c));

        for (Integer integer : expected0) {
            if (Objects.nonNull(integer)) {
                dmf.insert(integer);
            }
        }
        dmf.insert(0);
        // 0, 2, 9, 18, 23, 30, 59, 68, 100
        Integer[] expected1 = new Integer[]{23, null};
        Integer[] b1 = ArraysUtil.toIntegers(dmf.find());
        Assertions.assertTrue(ArraysUtil.matchesInOrder(expected1, b1));
        Assertions.assertTrue(ArraysUtil.matchesInOrder(expected1, ArraysUtil.toIntegers(dmf.delete())));

        for (Integer integer : expected1) {
            if (Objects.nonNull(integer)) {
                dmf.insert(integer);
            }
        }
        dmf.insert(200);
        // 0, 2, 9, 18, 23, 30, 59, 68, 100, 200
        Integer[] b2 = ArraysUtil.toIntegers(dmf.find());
        Assertions.assertTrue(ArraysUtil.matchesInOrder(expected0, b2));
        Integer[] b3 = ArraysUtil.toIntegers(dmf.delete());
        Assertions.assertTrue(ArraysUtil.matchesInOrder(expected0, b3));

    }
}