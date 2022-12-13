package com.algs;

public abstract class ImplPerformanceTest<E> implements IJunitComparable {

    protected abstract Object construct(Class<?> targetClass);

    protected abstract void execEach(Object obj);

    public void compare(Class<?>[] targetClasses) {
        for (Class<?> klass : targetClasses) {
            Object targetObject = construct(klass);
            System.out.println("Testing: " + klass.getName());
            execEach(targetObject);
        }
    }
}
