package com.algs;

import java.lang.reflect.Constructor;
import java.util.Objects;

public abstract class ImplFunctionalityTest implements IJunitTestable {

    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Class<?>[] params = getConstructorParameters();
            Constructor<?> constructor;
            if (Objects.isNull(params)) {
                constructor = targetClass.getConstructor();
            } else {
                constructor = targetClass.getConstructor(params);
            }
            instance = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    protected abstract Class<?>[] getConstructorParameters();

    protected abstract void testEach(Object obj);

    public final void test(Class<?>[] targetClasses) {
        for (Class<?> klass : targetClasses) {
            Object targetObject = construct(klass);
            System.out.println("Testing: " + klass.getName());
            testEach(targetObject);
        }
    }
}
