package com.algs.util;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;

public class CollectionUtil<E> {

    public static <E> E[] toArray(ICollection<E> collection) {
        Iterator<E> itr = collection.iterator();
        E[] array =  (E[]) new Object[collection.size()];
        int index = 0;
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }
        return array;
    }

    public static <E> String toString(ICollection<E> collection) {
        Iterator<E> itr = collection.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int index = 0;
        while (itr.hasNext()) {
            index++;
            sb.append(itr.next());
            if (index < collection.size()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int [] toPrimitive(ICollection collection) {
        int[] ints = new int[collection.size()];
        int index = 0;
        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            ints[index++] = (int) itr.next();
        }
        return ints;
    }

}
