package com.algs.datastructure.st;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.st.ordered.BinarySearchSymbolTableImpl0;
import com.algs.datastructure.st.unordered.IOrderedSymbolTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

class IOrderedSymbolTableTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
//            BinarySearchSymbolTableImpl.class,
            BinarySearchSymbolTableImpl0.class,
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

        st.put('a', 1);
        st.put('b', 1);
        st.put('c', 1);
        st.put('d', 1);
        st.put('e', 1);
        st.put('f', 1);

        st.put('e', 90);

        st.put('h', 90);
        st.put('j', 90);
        st.put('m', 90);
        st.put('o', 90);
        st.put('s', 90);
        st.put('x', 90);
        st.put('z', 90);

        Assertions.assertEquals(5, st.size('i', 'y'));

        Assertions.assertEquals(1, st.get('a'));
        Assertions.assertEquals(1, st.get('b'));
        Assertions.assertEquals(90, st.get('e'));
        Assertions.assertEquals(1, st.get('f'));

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

        st.put('a', 1);
        Assertions.assertEquals('a', st.floor('b'));
        Assertions.assertEquals('c', st.ceiling('b'));
        Assertions.assertEquals(11, st.size());

        Assertions.assertEquals('a', st.min());
        Assertions.assertEquals('x', st.max());

    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

}