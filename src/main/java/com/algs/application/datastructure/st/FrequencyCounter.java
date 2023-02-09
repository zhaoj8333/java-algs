package com.algs.application.datastructure.st;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter<K> {

    public static <K> void getMax(ICollection<K> keys, int minLen) {
        Map<K, Integer> map = count(keys, minLen);
        K max = (K) new Object();
        map.put(max, Integer.MIN_VALUE);
        for (K key : map.keySet()) {
            if (map.get(key) > map.get(max)) {
                max = key;
            }
        }
        System.out.println("Max: " + map.get(max));
    }

    public static <K> Map<K, Integer> count(ICollection<K> keys, int minLen) {
        Map<K, Integer> st = new HashMap<>();
        Iterator<K> itr = keys.iterator();
        while (itr.hasNext()) {
            K key = itr.next();
            if (String.valueOf(key).length() < minLen) {
                continue;
            }
            if (!st.containsKey(key)) {
                st.put(key, 1);
            } else {
                st.put(key, st.get(key) + 1);
            }
        }
        return st;
    }

}
