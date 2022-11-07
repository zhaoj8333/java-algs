package com.algs.algo.sort;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.ArraysUtil;
import com.algs.util.FileUtil;
import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Comparator;

public class SortImplTest {

    @Test
    void test() {
        IList<Character> chars = FileUtil.readChars("data/tiny.txt");
        Assertions.assertNotNull(chars);

        Class<?>[] klasses = new Class<?>[] {
//                SelectionSortImpl.class,
//                HeapSortImpl.class,
                BubbleSortImpl.class,
        };
        for (Class<?> klass : klasses) {
            System.out.println(klass.getSimpleName());
            functioning(klass, chars);
            System.out.println("---------------------------------");
        }
    }

    private void functioning(Class<?> sortKlass, IList<Character> characters) {
        int index = 0;
        Character[] array = new Character[characters.size()];
        Iterator<Character> itr = characters.iterator();
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }

        ArraysUtil.display(array);

        Assertions.assertTrue(array.length > 1);

        Constructor<?> constructor;
        ISortable<Character> sort = null;
        Comparator<Character> cmp = null;
        try {
            constructor = sortKlass.getConstructor(Comparable[].class, Comparator.class);
//            Comparator<Character> cmp = Comparator.comparingInt(a -> a);
            cmp = Comparator.comparingInt(a -> a);
            sort = (ISortable<Character>) constructor.newInstance(array, cmp);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        assert sort != null;
        sort.sort();
        ArraysUtil.display(array);

        Assertions.assertTrue(SortUtil.isSorted(sort.getArray(), cmp));

    }

}
