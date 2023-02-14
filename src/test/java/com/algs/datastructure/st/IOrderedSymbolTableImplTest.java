package com.algs.datastructure.st;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.Iiterable;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.node.ComparableSTNode;
import com.algs.datastructure.st.ordered.BinarySearchSTImpl;
import com.algs.datastructure.st.ordered.BinarySearchSTImpl0;
import com.algs.datastructure.st.ordered.OrderedLinkedSequentialSTImpl;
import com.algs.datastructure.st.ordered.IOrderedSymbolTable;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

class IOrderedSymbolTableImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
            BinarySearchSTImpl.class,
            BinarySearchSTImpl0.class,
            OrderedLinkedSequentialSTImpl.class,
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
        IOrderedSymbolTable<Character, Integer> st = (IOrderedSymbolTable<Character, Integer>) obj;

        {
            st.put('a', 1);
            st.put('b', 1);
            st.put('d', 1);
            st.put('c', 1);
            st.put('f', 1);
            st.put('e', 1);

            st.put('e', 90);

            st.put('h', 90);
            st.put('j', 90);
            st.put('m', 90);
            st.put('o', 90);
            st.put('s', 90);
            st.put('x', 90);
            st.put('z', 90);
        }

        Assertions.assertEquals(5, st.size('i', 'y'));

        {
            Assertions.assertEquals(1, st.get('a'));
            Assertions.assertEquals(1, st.get('b'));
            Assertions.assertEquals(90, st.get('e'));
            Assertions.assertEquals(1, st.get('f'));
        }

        {
            Assertions.assertEquals(0, st.rank('a'));
            Assertions.assertEquals(1, st.rank('b'));
            Assertions.assertEquals(2, st.rank('c'));
            Assertions.assertEquals(3, st.rank('d'));
            Assertions.assertEquals(4, st.rank('e'));
            Assertions.assertEquals(5, st.rank('f'));

            st.delete('a');
            st.deleteMin();
            Assertions.assertEquals(0, st.rank('c'));
            Assertions.assertEquals(1, st.rank('d'));
            Assertions.assertEquals(2, st.rank('e'));
            Assertions.assertEquals(3, st.rank('f'));

            st.deleteMax();
            Assertions.assertEquals(0, st.rank('c'));
            Assertions.assertEquals(1, st.rank('d'));
            Assertions.assertEquals(2, st.rank('e'));
        }

        st.put('a', 1);
        Assertions.assertEquals('a', st.floor('b'));
        Assertions.assertEquals('c', st.ceil('b'));
        Assertions.assertEquals('c', st.ceil('c'));
        Assertions.assertEquals(11, st.size());

        Assertions.assertEquals('a', st.min());
        Assertions.assertEquals('x', st.max());

        {
            // a, c, d, e, f, h, j, m, o, s, x
            Assertions.assertEquals('a', st.select(0));
            Assertions.assertEquals('c', st.select(1));
            Assertions.assertEquals('h', st.select(5));
        }

        {
            Iiterable<Character> keys = st.keys('b', 'i');
            Iterator<Character> itr = keys.iterator();
            Assertions.assertEquals('c', itr.next());
            Assertions.assertEquals('d', itr.next());
            Assertions.assertEquals('e', itr.next());
            Assertions.assertEquals('f', itr.next());
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

}