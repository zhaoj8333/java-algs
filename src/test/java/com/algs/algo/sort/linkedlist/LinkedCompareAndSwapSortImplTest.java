package com.algs.algo.sort.linkedlist;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedCompareAndSwapSortImplTest extends ImplFunctionalityTest {

    protected final Class<?>[] targetClasses = new Class<?>[] {
            SinglyLinkedListSortImpl.class,
    };

    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(SinglyLinkedListImpl.class);
            instance = constructor.newInstance(FileUtil.readChars(FilePath.TINY));
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

        Object[] array = sortObj.list.toArray();
        Character[] originalArray = ArraysUtil.toChars(array);

        ArraysUtil.println(originalArray);

//        sortObj.sort();
        sortObj.selectionSort();

        Character[] sortedArray = ArraysUtil.toChars(sortObj.list.toArray());
        ArraysUtil.println(sortedArray);

        Assertions.assertTrue(ArraySortUtil.isSorted(sortedArray, null));
        Assertions.assertTrue(ArraySortUtil.onlySorted(originalArray, sortedArray));

    }
}
