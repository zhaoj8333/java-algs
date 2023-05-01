package com.algs.algo.unionfind;

import com.algs.ImplFunctionalityTest;
import com.algs.algo.unionfind.generic.IDisjointSet;
import com.algs.algo.unionfind.generic.qu.WeighedPathHalvingImpl;
import com.algs.utils.wrapper.Wrapper;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IDisjointSetImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[]{
            WeighedPathHalvingImpl.class,
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(int.class);
            instance = constructor.newInstance(10);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    protected void testEach(Object obj) {
        IDisjointSet<Wrapper> uf = (IDisjointSet<Wrapper>) obj;
        Wrapper wrapper1 = new Wrapper("name" + 1, "location: " + 1);
        Wrapper wrapper2 = new Wrapper("name" + 2, "location: " + 2);
        uf.makeSet(wrapper1);
        uf.makeSet(wrapper2);
        for (int i = 3; i < 10; i++) {
            uf.makeSet(new Wrapper("name:" + i, "location: " + i));
        }
        uf.union(wrapper1, wrapper2);

        Assertions.assertTrue(uf.connected(wrapper1, wrapper2));
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }
}