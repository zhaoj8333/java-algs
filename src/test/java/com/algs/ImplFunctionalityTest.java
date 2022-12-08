package com.algs;

import java.lang.reflect.Constructor;

public abstract class ImplFunctionalityTest implements IJunitTestable {

    protected Class<?>[] constructArgs() {
        return new Class<?>[0];
    }

    protected Object construct(Class<?> targetClass) {
        Class<?>[] args = constructArgs();
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor(args);
            instance = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    protected abstract void testEach(Object obj);

    public void test(Class<?>[] targetClasses) {
        for (Class<?> klass : targetClasses) {
            Object targetObject = construct(klass);
//            StackTraceElement ste = new StackTraceElement(klass.getName(), "", klass.getSimpleName(), 0);
            System.out.println("Testing: " + klass.getName());
            testEach(targetObject);
        }
    }

}
