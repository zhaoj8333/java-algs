package com.algs.algo.sort.linkedlist;

import com.algs.algo.sort.ISortable;
import com.algs.algo.sort.array.cmp_swp.InsertionSortImpl;
import com.algs.algo.sort.array.cmp_swp.SelectionSortImpl;
import com.algs.algo.sort.array.cmp_swp.merge.MergeSortBuOptmImpl;
import com.algs.algo.sort.array.cmp_swp.shell.ShellSortImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.array.ArrayGenerator;
import com.algs.utils.array.ArraySortUtil;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import com.graph.analysis.algo.sort.ShellSortAlysImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Comparator;

public class LinkedListSortImplTest {

    @Test
    void test() {
        IList<Character> chars = FileUtil.readChars(FilePath.TINY_TXT);
        Assertions.assertNotNull(chars);

        Class<?>[] klasses = new Class<?>[] {
//                QuickSort3wayImpl.class,

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
        Character[] original = ArraysUtil.copy(array);

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
        Assertions.assertTrue(ArraySortUtil.isSorted(array, cmp));
        Assertions.assertTrue(ArraySortUtil.onlySorted(original, array));
    }

}
