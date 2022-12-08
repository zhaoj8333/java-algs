package com.algs.algo.sort.linkedlist;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.list.linked.ISequentialAccessList;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class LinkedCompareAndSwapSortImplTest extends ImplFunctionalityTest {

    protected final Class<?>[] targetClasses = new Class<?>[] {
            SinglyLinkedListSortImpl.class,
    };

    @Override
    protected Class<?>[] constructArgsType() {
        return null;
    }

    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(ISequentialAccessList.class);
            instance = constructor.newInstance(FileUtil.readChars(FilePath.TINY_TXT));
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    @Override
    protected void testEach(Object obj) {
        LinkedCompareAndSwapSort<Character> sortObj = (LinkedCompareAndSwapSort<Character>) obj;

        Object[] array = sortObj.linkedList.toArray();
        Character[] originalArray = ArraysUtil.toChars(array);

        ArraysUtil.display(originalArray);

        sortObj.sort();

        Character[] sortedArray = ArraysUtil.toChars(sortObj.linkedList.toArray());
        ArraysUtil.display(sortedArray);

        Assertions.assertTrue(ArraySortUtil.isSorted(sortedArray, null));
        Assertions.assertTrue(ArraySortUtil.onlySorted(originalArray, sortedArray));

    }
}
