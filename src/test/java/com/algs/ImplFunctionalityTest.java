package com.algs;

public abstract class ImplFunctionalityTest implements IJunitTestable {

    protected abstract Object construct(Class<?> targetClass);

    protected abstract void testEach(Object obj);

    public void test(Class<?>[] targetClasses) {
        for (Class<?> klass : targetClasses) {
            Object targetObject = construct(klass);
            System.out.println("Testing: " + klass.getName());
            testEach(targetObject);
        }
    }
}
