package com.algs.util;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import org.apache.commons.lang.math.RandomUtils;

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

    public static int[] randomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = RandomUtils.nextInt();
        }
        return array;
    }

    public static int[] toPrimitive(ICollection collection) {
        int[] ints = new int[collection.size()];
        int index = 0;
        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            ints[index++] = (int) itr.next();
        }
        return ints;
    }

}
