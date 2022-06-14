package com.collection;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

/**
 * {@link java.util.ConcurrentModificationException} is a very common exception in java collection
 * {@link ConcurrentModificationException} are fail-fast, which means:
 *  if the Collection will be changed while some threads is traversing over it using {@link java.util.Iterator},
 *  {@link Iterator#next()} will throw {@link ConcurrentModificationException}
 *
 *  {@link ConcurrentModificationException} can come in multithreaded or single-threaded
 *
 * {@link AbstractList#modCount}: number of times of list has been structurally modified(结构性修改)
 * Structural modification: change the size of the list, or perturb it leads to iterations yield incorrect results
 *
 * 结构性修改： 添加，删除，或明显的调整背后数组的大小叫结构性修改，仅仅修改元素内容并非结构性修改
 *
 *
 */
public class ConcurrentModificationExceptionTest {

    private static final List<String> listA = new ArrayList<>();
    private static final List<String> listB = new ArrayList<>();

    private static final Map<String, String> mapA = new HashMap<>();
    private static final Map<String, String> mapB = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            long e;
            if (i >= 4) {
                e = (i - 4) + 65;
            } else {
                e = System.nanoTime();
            }
            listA.add(String.valueOf((char) e));
            listB.add(String.valueOf((char) e));
            mapA.put(String.valueOf((char) e), String.valueOf(i));
            mapB.put(String.valueOf((char) e), String.valueOf(i));
        }
        System.out.println("Before Traversal: " + listB);
        System.out.println("Before Traversal: " + mapB);
        System.out.println();
    }

    @Test
    public void testOnList() {
        testOnListUsingSimpleTraversal();
        testOnListUsingIterator();
    }

    @Test
    public void avoidOnList() {
        avoidUsingSimpleTraversal();
        avoidByUsingIteratorRemove();
    }

    /**
     * Decrease the counter to remove one object
     */
    private void avoidUsingSimpleTraversal() {
        System.out.print("During Traversal: [");
        for (int i = 0; i < listB.size(); i++) {
            String s = listB.get(i);
            if ("A".equals(s)) {
                listB.remove(s);
                i--;
            }
            System.out.print(s + ", ");
        }
        System.out.println("]");
        System.out.println("After  Traversal: " + listB);
    }

    /**
     * 不建议使用增强for循环时使用 {@link List#remove(Object)} 元素，大概率会发生 {@link ConcurrentModificationException}
     *
     * 一般编辑器会建议使用 {@link Collection#removeIf(Predicate)}
     */
    private void avoidByUsingIteratorRemove() {
        Iterator<String> itr = listA.iterator();
        while (itr.hasNext()) {
            String next = itr.next();
//            System.out.println(next);
            if (next.equals("A")) {
                itr.remove();
            }
        }
        System.out.println("Iterator: " + listA);
    }

    private void testOnListUsingSimpleTraversal() {
        System.out.print("During Traversal: [");
        for (int i = 0; i < listB.size(); i++) {
            String s = listB.get(i);
            if (s.equals("A")) {
                listB.remove(s);
            }
            System.out.print(s + ", ");
        }
        System.out.println("]");
        System.out.println("After  Traversal: " + listB);
    }

    private void testOnListUsingIterator() {
        Iterator<String> itr = listA.iterator();
        while (itr.hasNext()) {
            String next = itr.next();
//            System.out.println(next);
            if (next.equals("A")) {
                listA.remove("A");
            }
        }
        System.out.println("Iterator: " + listA);
    }

    @Test
    public void testOnMap() {

        testOnMapUsingSimpleTraversal();
        testOnMapUsingIterator();

    }

    private void testOnMapUsingSimpleTraversal() {
        Set<String> keys = mapA.keySet();

    }

    private void testOnMapUsingIterator() {
        Set<String> keys = mapB.keySet();
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            String nextKey = itr.next();
//            System.out.println(nextKey);
            if ("A".equals(nextKey)) {
                mapB.remove("A");
            }
        }
        System.out.println("After Traversal: " + mapB);
    }

    @Test
    public void test() {

    }
}
