package com.algs.datastructure.st;

import com.algs.ImplPerformanceTest;
import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.st.ordered.BinarySearchSTImpl;
import com.algs.datastructure.st.ordered.BinarySearchSTImpl0;
import com.algs.datastructure.st.ordered.InterpolationSearchSTImpl;
import com.algs.datastructure.st.ordered.OrderedLinkedSequentialSTImpl;
import com.algs.utils.RandomUtil;
import com.algs.utils.array.ArrayBuilder;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

class ISymbolTableImplCompareTest<E extends Comparable<E>> extends ImplPerformanceTest<E> {

    protected static final Integer[] testArray;

    static {
//        System.out.println("Reading file ...");
//        testArray = FileUtil.readEnglishWordsAsArray(FilePath.TALE);
        testArray = ArrayBuilder.randomIntArrayBetween(28000, 0, 22000);

    }

    private final Class<?>[] targetClasses = new Class<?>[] {
            BinarySearchSTImpl.class,
//            BinarySearchSTImpl0.class,
//            OrderedLinkedSequentialSTImpl.class,
            InterpolationSearchSTImpl.class,
    };

    /**
     * {@link com.algs.utils.file.FilePath#TALE}
     *
     * {@link BinarySearchSTImpl}:  411 ms
     * {@link BinarySearchSTImpl0}: 216 ms
     * {@link OrderedLinkedSequentialSTImpl}: 8705 ms
     *
     * testArray = ArrayBuilder.randomIntArrayBetween(50000, 0, 30000);
     * {@link BinarySearchSTImpl}: 1986 ms
     * {@link InterpolationSearchSTImpl}: 1363 ms
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
    protected void execEach(Object obj) {
        ISymbolTable<Integer, Integer> st = (ISymbolTable<Integer, Integer>) obj;

        StopWatchTask<Object> sw = new StopWatchTask<>() {
            @Override
            protected Object profileTask() {
                for (Integer em : testArray) {
                    st.put(em, RandomUtil.uniform(Integer.MAX_VALUE));
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