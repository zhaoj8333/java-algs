package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListBagImplTest {

    private IBag<Integer> bag;

    @BeforeEach
    public void setUp() throws Exception {
        bag = new LinkedListBagImpl<>();
    }

    @AfterEach
    public void tearDown() throws Exception {
        bag.clear();
        bag = null;
    }

    @Test
    public void testAdd() {
        bag.add(19);
        bag.add(3);
        bag.add(9);

        Assertions.assertEquals(3, bag.size());
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(bag.isEmpty());
        bag.add(19);
        bag.add(3);
        bag.add(9);

        Assertions.assertFalse(bag.isEmpty());
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, bag.size());
        bag.add(19);
        bag.add(3);
        bag.add(9);

        Assertions.assertEquals(3, bag.size());
    }

    @Test
    public void testNumberOf() {
        bag.add(19);
        bag.add(3);
        bag.add(19);
        bag.add(9);
        bag.add(82);

        Assertions.assertEquals(2, bag.numberOf(19));
        Assertions.assertEquals(1, bag.numberOf(9));
    }

    @Test
    public void testContains() {
        bag.add(19);
        bag.add(3);
        bag.add(19);
        bag.add(9);
        bag.add(82);
        Assertions.assertTrue(bag.contains(19));
        Assertions.assertFalse(bag.contains(1));
    }

    @Test
    public void testRemove() {
        bag.add(19);
        bag.add(3);
        bag.add(9);
        bag.add(82);

        System.out.println(bag);
        bag.remove(19);
        System.out.println(bag);
        bag.remove();
        System.out.println(bag);

        Assertions.assertFalse(bag.contains(19));
        Assertions.assertEquals(2, bag.size());

    }

    @Test
    public void testClear() {
        bag.add(19);
        bag.add(3);
        bag.add(9);
        bag.add(82);

        bag.clear();

        Assertions.assertEquals(0, bag.size());

    }

    @Test
    public void testToArray() {
        Integer[] ints = new Integer[] {19, 3, 9};
        for (Integer anInt : ints) {
            bag.add(anInt);
        }

        Object[] integers = bag.toArray();
        Integer[] tmp = new Integer[3];
        for (int i = integers.length - 1; i >= 0; i--) {
            tmp[3 - i - 1] = (Integer) integers[i];
        }

        Assertions.assertArrayEquals(tmp, ints);
    }

    @Test
    public void testIterate() {
        bag.add(19);
        bag.add(3);
        bag.add(9);
        bag.add(82);

        Iterator<Integer> itr = bag.iterator();
        while (itr.hasNext()) {
            Integer node = itr.next();
            System.out.println(node);
        }
    }
}