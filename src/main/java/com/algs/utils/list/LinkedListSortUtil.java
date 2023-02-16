package com.algs.utils.list;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.list.linked.ISequentialAccessList;
import com.algs.utils.CompareUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LinkedListSortUtil<E extends Comparable<E>> {

    public static <E extends Comparable<E>> boolean isAsc(ISequentialAccessList<E> list) {
        return isAsc(list, null);
    }

    public static <E extends Comparable<E>> boolean isDesc(ISequentialAccessList<E> list) {
        return isDesc(list, null);
    }

    public static <E extends Comparable<E>> boolean isAsc(ISequentialAccessList<E> list, Comparator<E> comparator) {
        if (list.size() == 0 || list.size() == 1) {
            return true;
        }
        Iterator<E> itr = list.iterator();
        E first = itr.next();
        while (itr.hasNext()) {
            E second = itr.next();
            int cmp = CompareUtil.compare(first, second, comparator);
            if (cmp >= 0) {
                return false;
            }
            first = second;
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean isDesc(ISequentialAccessList<E> list, Comparator<E> comparator) {
        if (list.size() == 0 || list.size() == 1) {
            return true;
        }
        Iterator<E> itr = list.iterator();
        E first = itr.next();
        while (itr.hasNext()) {
            E second = itr.next();
            int cmp = CompareUtil.compare(first, second, comparator);
            if (cmp <= 0) {
                return false;
            }
            first = second;
        }
        return true;
    }

    public static <E extends Comparable<E>> boolean isSorted(ISequentialAccessList<E> list) {
        return isSorted(list, null);
    }

    public static <E extends Comparable<E>> boolean isSorted(ISequentialAccessList<E> list, Comparator<E> comparator) {
        return isAsc(list, comparator) || isDesc(list, comparator);
    }

    /**
     * Check if elements in the sorted array has been changed
     */
    public static <E extends Comparable<E>> boolean onlySorted(ISequentialAccessList<E> originalList, ISequentialAccessList<E> sortedList) {
        if (originalList.size() != sortedList.size()) {
            return false;
        }
        Map<Comparable<E>, Integer> valueMap = new HashMap<>();
        Iterator<E> originalItr = originalList.iterator();
        while (originalItr.hasNext()) {
            E value = originalItr.next();
            int count = 0;
            if (valueMap.containsKey(value)) {
                count = valueMap.get(value);
            }
            count++;
            valueMap.put(value, count);
        }
        boolean sorted = isSorted(sortedList, null);
        if (!sorted) {
            return false;
        }
        Iterator<E> sortedItr = sortedList.iterator();
        while (sortedItr.hasNext()) {
            E e = sortedItr.next();
            if (valueMap.containsKey(e)) {
                Integer count = valueMap.get(e);
                count--;
                if (count == 0) {
                    valueMap.remove(e);
                } else {
                    valueMap.put(e, count);
                }
            } else {
                return false;
            }
        }
        return 0 == valueMap.size();
    }

}
