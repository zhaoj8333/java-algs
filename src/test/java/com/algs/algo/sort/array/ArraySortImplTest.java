package com.algs.algo.sort.array;

import com.algs.ImplFunctionalityTest;
import com.algs.utils.array.ArrayBuilder;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraySortImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//        CountingSortImpl.class,
        RadixSortImpl.class,
    };

    private Integer[] testIntArray;

    @Override
    public void testEach(Object obj) {
        ArraySort<Integer> sortObj = (ArraySort) obj;

        ArraysUtil.println(testIntArray);

        sortObj.sort();

        Integer[] sortedArray = sortObj.getArray();
        ArraysUtil.println(sortedArray);
        Assertions.assertTrue(ArraySortUtil.isSorted(sortedArray, null));
        Assertions.assertTrue(ArraySortUtil.onlySorted(testIntArray, sortedArray));
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(Integer[].class, Comparator.class);
            Integer[] data = ArraysUtil.copyAll(testIntArray);
            instance = constructor.newInstance(data, null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Test
    @Override
    public void test() {
//        IList<Integer> list = FileUtil.readInts(FilePath.TINY_T_TXT);
//        Assertions.assertNotNull(list);
//        testArray = ArraysUtil.toIntegers(list.toArray());
//        testArray = ArrayBuilder.randomIntArrayBetween(10, -20, 20);
        testIntArray = ArrayBuilder.randomIntArrayBetween(10, 0, 1100);

        test(targetClasses);
    }

}
