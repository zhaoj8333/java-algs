package com.algs.util;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import org.jetbrains.annotations.NotNull;

public class CollectionUtil {

    public static Object [] toArray(@NotNull ICollection collection) {
        Iterator itr = collection.iterator();
        Object[] array = new Object[collection.size()];
        int index = 0;
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }
        return array;
    }

    public static String toString(@NotNull ICollection collection) {
        Iterator itr = collection.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static int [] toPrimitive(@NotNull ICollection collection) {
        int[] ints = new int[collection.size()];
        int index = 0;
        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            ints[index++] = (int) itr.next();
        }
        return ints;
    }

}
