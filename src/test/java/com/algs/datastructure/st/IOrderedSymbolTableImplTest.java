package com.algs.datastructure.st;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iiterable;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.node.ComparableSTNode;
import com.algs.datastructure.st.ordered.BinarySearchSTImpl;
import com.algs.datastructure.st.ordered.IOrderedSymbolTable;
import com.algs.datastructure.st.ordered.InterpolationSearchSTImpl;
import com.algs.datastructure.tree.ITree;
import com.algs.datastructure.tree.bst.BinarySearchTreeImpl;
import com.algs.datastructure.tree.printer.BinaryTreeInfo;
import com.algs.datastructure.tree.printer.BinaryTrees;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IOrderedSymbolTableImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//            BinarySearchSTImpl.class,
//            BinarySearchSTImpl0.class,
//            OrderedLinkedSequentialSTImpl.class,
//            InterpolationSearchSTImpl.class,
            BinarySearchTreeImpl.class,
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor();
            instance = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void testEach(Object obj) {
        IOrderedSymbolTable<Integer, Integer> st = (IOrderedSymbolTable<Integer, Integer>) obj;

        // put
        {
            st.put(0, 1);
            st.put(1, 1);
            st.put(3, 1);
            st.put(2, 1);
            st.put(5, 1);
            st.put(4, 1);

            st.put(4, 90);

            st.put(7, 90);
            st.put(9, 90);
            st.put(12, 90);
            st.put(14, 90);
            st.put(18, 90);
            st.put(23, 90);
            st.put(25, 90);
        }

        if (st instanceof ITree) {
            BinaryTrees.print((BinaryTreeInfo) st);
        }

        // get
        {
            assertEquals(1, st.get(0));
            assertEquals(1, st.get(1));
            assertEquals(90, st.get(4));
            assertEquals(1, st.get(5));
        }

        // rank delete
        {
            assertEquals(0, st.rank(0));
            assertEquals(1, st.rank(1));
            assertEquals(2, st.rank(2));
            assertEquals(3, st.rank(3));
            assertEquals(4, st.rank(4));
            assertEquals(5, st.rank(5));

            st.delete(0);
            st.deleteMin();
            assertEquals(0, st.rank(2));
            assertEquals(1, st.rank(3));
            assertEquals(2, st.rank(4));
            assertEquals(3, st.rank(5));

            st.deleteMax();
            assertEquals(0, st.rank(2));
            assertEquals(1, st.rank(3));
            assertEquals(2, st.rank(4));
        }

        // floor ceil
        {
            st.put(0, 1);
            assertEquals(0, st.floor(1));
            assertEquals(0, st.floor(0));
            assertEquals(12, st.floor(13));
            assertEquals(18, st.floor(19));
            assertEquals(2, st.ceil(1));
            assertEquals(2, st.ceil(2));
            assertEquals(11, st.size());

            assertEquals(0, st.min());
            assertEquals(23, st.max());
        }
        // 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23
        // select
        {
            assertEquals(0, st.select(0));
            assertEquals(2, st.select(1));
            assertEquals(7, st.select(5));
        }

        // size
        {
            assertEquals(5, st.size(0, 5));
            assertEquals(5, st.size(8, 24));
            assertEquals(4, st.size(3, 8));
            assertEquals(7, st.size(2, 13));
            assertEquals(11, st.size(-4, 25));
            assertEquals(11, st.size(0, 19090));
            assertEquals(0, st.size(19, 20));
            assertEquals(0, st.size(5, 4));
        }

        // keys
        {
            Iiterable<Integer> keys = st.keys(1, 8);
            Iterator<Integer> itr = keys.iterator();
            assertEquals(2, itr.next());
            assertEquals(3, itr.next());
            assertEquals(4, itr.next());
            assertEquals(5, itr.next());

            keys = st.keys(2, 13);
            itr = keys.iterator();
            assertEquals(2, itr.next());
            assertEquals(3, itr.next());
            assertEquals(4, itr.next());
            assertEquals(5, itr.next());
            assertEquals(7, itr.next());
            assertEquals(9, itr.next());
            assertEquals(12, itr.next());

        }
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    @Test
    void _3_1_12() {
        String[] strings = FileUtil.readEnglishWordsAsArray(FilePath.MED_TALE);
        String[] array = ArraysUtil.toStrings(ArraysUtil.copyAll(strings));
        ArraysUtil.println(array);

        ComparableSTNode<String, Integer>[] copiedArray = (ComparableSTNode<String, Integer>[]) new ComparableSTNode<?, ?>[array.length];
        for (int i = 0; i < array.length; i++) {
//            if (!"".equals(array[i])) {
                copiedArray[i] = new ComparableSTNode<>(array[i], 0);
//            }
        }
        BinarySearchSTImpl<String, Integer> st = new BinarySearchSTImpl<>(copiedArray, null);
    }

    /**
     * mid: 8, key: 20, begin: 0, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 9, key: 20, begin: 9, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 0, key: 1, begin: 0, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 3, key: 8, begin: 0, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 5, key: 8, begin: 4, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 0, key: 2, begin: 0, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 1, key: 2, begin: 1, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 5, key: 13, begin: 0, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     * mid: 7, key: 13, begin: 6, end: 10
     * { 0, 2, 3, 4, 5, 7, 9, 12, 14, 18, 23, null, null, null, null, null, null, null, null }
     *
     * {@link InterpolationSearchSTImpl}
     */
    void _3_1_24() {

    }

}