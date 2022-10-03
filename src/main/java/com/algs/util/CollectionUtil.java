package com.algs.util;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;

import java.util.Objects;
import java.util.Random;

public class CollectionUtil {

    public static void shuffle(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return;
        }
        Random r = new Random();
        for (int i = array.length; i > 1; i--) {
            int n = r.nextInt(i);
            int m = i - 1;
            int tmp = array[n];
            array[n] = array[m];
            array[m] = tmp;
        }
    }

    public static Object[] toArray(ICollection collection) {
        Iterator itr = collection.iterator();
        Object[] array = new Object[collection.size()];
        int index = 0;
        while (itr.hasNext()) {
            array[index++] = itr.next();
        }
        return array;
    }

    public static String toString(ICollection collection) {
        Iterator itr = collection.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
