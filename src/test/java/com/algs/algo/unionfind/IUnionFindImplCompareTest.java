package com.algs.algo.unionfind;

import com.algs.ImplPerformanceTest;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.algo.unionfind.non_generic.qu.path_compression.FullCompressImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.FullCompressImpl0;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.SplittingImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.SizeWeighedImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.utils.array.ArrayBuilder;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Objects;

class IUnionFindImplCompareTest<E> extends ImplPerformanceTest<E> {

    protected static final Integer[] array;

    static {
        int size = 2000000;
        array = ArrayBuilder.randomIntArrayBetween(size, 0, size);
    }

    protected Class<?>[] targetClasses = new Class<?>[]{
            SizeWeighedImpl.class, RankWeighedImpl.class,
            FullCompressImpl.class, FullCompressImpl0.class,
            SplittingImpl.class, HalvingImpl.class,
//            QuickUnionImpl.class, QuickFindImpl.class,
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(int.class);
            instance = constructor.newInstance(array.length);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void execEach(Object obj) {
        StopWatchTask<Object> sw = new StopWatchTask<>() {

            @Override
            protected Object profileTask() {
                IUnionFind uf = (IUnionFind) obj;
                for (int i = 0; i < array.length - 1; i++) {
                    int j = i + 1;
                    if (!Objects.equals(uf.find(array[i]), uf.find(array[j]))) {
                        uf.union(array[i], array[j]);
                    }
                }
                return uf.getClass().getName();
            }

            @Override
            protected void assertInput() { }

            @Override
            protected void assertResult() { }

        };
        sw.exec(true);
    }

    @Test
    @Override
    public void compare() {
        compare(targetClasses);
    }

}