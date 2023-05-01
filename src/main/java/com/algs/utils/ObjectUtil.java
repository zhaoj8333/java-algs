package com.algs.utils;

import com.algs.datastructure.collection.ICollection;
import java.util.Objects;

public final class ObjectUtil<E> {

    private ObjectUtil() {
        throw new AssertionError("No " + ObjectUtil.class.getName() + " Instance for you");
    }

    public static void requireNonEmpty(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            throw new IllegalArgumentException("require String non empty");
        }
    }

    public static void requireNonNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException("require Object non null");
        }
    }

    public static void requireNonNull(Object... objects) {
        for (Object object : objects) {
            if (Objects.isNull(object)) {
                throw new IllegalArgumentException("require Object non empty");
            }
        }
    }

    public static <E> void requireNonEmpty(ICollection<E> collection) {
        if (collection.isEmpty()) {
            throw new RuntimeException("Already Empty");
        }
    }

    public static <E> void requireNonEmpty(E[] array) {
        requireNonNull((Object) array);
        if (array.length == 0) {
            throw new RuntimeException("Array should be non empty");
        }
    }

    public static <E> void requireNonNullElement(E[] array) {
        requireNonNull((Object) array);
        requireNonEmpty(array);
        for (E e : array) {
            if (Objects.isNull(e)) {
                throw new RuntimeException("All elements should't be null");
        }
    }
}

}
