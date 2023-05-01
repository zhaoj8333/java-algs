package com.algs.datastructure.map;

import com.algs.ImplFunctionalityTest;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IMapImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
            SkipListMapImpl.class,
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
        IMap<String, Integer> map = (IMap<String, Integer>) obj;

        Assertions.assertEquals(0, map.size());
        Assertions.assertTrue(map.isEmpty());
        Assertions.assertEquals(null, map.get("a"));

    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }
}