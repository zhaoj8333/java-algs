package com.algs;

import java.lang.reflect.Constructor;

public abstract class ImplPerformanceTest<E> implements IJunitComparable {

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

    protected abstract Class<?> getConstructorParameters();

    protected abstract void execEach(Object obj);

    public void compare(Class<?>[] targetClasses) {
        for (Class<?> klass : targetClasses) {
            Object targetObject = construct(klass);
            System.out.println("Testing: " + klass.getName());
            execEach(targetObject);
        }
    }
}
