package com.algs.datastructure.st;

import com.algs.ImplPerformanceTest;
import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.st.unordered.SelfOrganizedArraySTImpl;
import com.algs.datastructure.st.unordered.SelfOrganizedLinkedSTImpl;
import com.algs.utils.RandomUtil;
import com.algs.utils.file.FilePath;
import com.algs.utils.file.FileUtil;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

class SelfOrganizedSTCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    protected static final String[] testArray;

    static {
        System.out.println("Reading file ...");
        testArray = FileUtil.readEnglishWordsAsArray(FilePath.TALE);
    }

    private final Class<?>[] targetClasses = new Class<?>[] {
            SelfOrganizedArraySTImpl.class,
            SelfOrganizedLinkedSTImpl.class,
    };

    /**
     * {@link SelfOrganizedArraySTImpl}: 4195 ms
     * {@link SelfOrganizedLinkedSTImpl}: 4083 ms
     */
    @Test
    @Override
    public void compare() {
        compare(targetClasses);
    }

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
    protected Class<?> getConstructorParameters() {
        return null;
    }

    @Override
    protected void execEach(Object obj) {
        ISymbolTable<String, Integer> st = (ISymbolTable<String, Integer>) obj;

        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                for (String em : testArray) {
                    st.put(em, RandomUtil.uniform(Integer.MAX_VALUE));
                }
                for (String em : testArray) {
                    st.get(em);
                }
                return null;
            }

            @Override
            protected void assertInput() {
            }

            @Override
            protected void assertResult() {
            }
        };
        sw.exec(true);
    }

}