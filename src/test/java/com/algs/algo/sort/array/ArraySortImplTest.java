package com.algs.algo.sort.array;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Comparator;

class ArraySortImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
        CountingSortImpl.class
    };

    private Integer[] testArray;

    @Override
    public void testEach(Object obj) {
        ArraySort<Integer> sortObj = (ArraySort) obj;

        ArraysUtil.display(testArray);

        sortObj.sort();

        Integer[] sortedArray = sortObj.getArray();
        ArraysUtil.display(sortedArray);
        Assertions.assertTrue(ArraySortUtil.isSorted(sortedArray, null));
        Assertions.assertTrue(ArraySortUtil.onlySorted(testArray, sortedArray));
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(Integer[].class, Comparator.class);
            Integer[] data = ArraysUtil.copy(testArray);
            instance = constructor.newInstance(data, null);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Test
    @Override
    public void test() {
        IList<Integer> list = FileUtil.readInts(FilePath.TINY_T_TXT);
        Assertions.assertNotNull(list);
        testArray = ArraysUtil.toIntegers(list.toArray());

        test(targetClasses);
    }

}
