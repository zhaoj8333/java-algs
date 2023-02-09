package com.algs.datastructure.st;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Objects;

class ISymbolTableImplTest extends ImplFunctionalityTest {

    private final IList<String> testData;

    {
        testData = FileUtil.readEnglishWords(FilePath.TINY_TALE);
    }

    protected Class<?>[] targetClasses = new Class<?>[] {
        LinkedSequentialSearch.class
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
        ISymbolTable<String, Integer> st = new LinkedSequentialSearch<>();
        Assertions.assertTrue(st.isEmpty());
        Assertions.assertEquals(0, st.size());

        st.put("", 1);
        st.put("a", 2);

        Assertions.assertEquals(2, st.size());

        st.put("", 5);
        Assertions.assertEquals(2, st.size());
        Assertions.assertEquals(5, st.get(""));

        st.delete("");
        Assertions.assertFalse(st.contains(""));
        Assertions.assertEquals(1, st.size());

        st.clear();
        Assertions.assertTrue(st.isEmpty());

        Iterator<String> itr = testData.iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            Integer val = st.get(key);
            if (Objects.isNull(val)) {
                st.put(key, 1);
            } else {
                st.put(key, val + 1);
            }
        }

        Assertions.assertEquals(20, st.size());

    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }
}