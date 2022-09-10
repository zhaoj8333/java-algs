package com.algs.datastructure.collection.bag;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListBagImplTest {

    private IBag<Integer> bag;

    @Before
    public void setUp() throws Exception {
        bag = new LinkedListBagImpl<>();
    }

    @After
    public void tearDown() throws Exception {
        bag.clear();
        bag = null;
    }

    @Test
    public void testAdd() {
        bag.add(19);
        bag.add(3);
        bag.add(9);

        Assert.assertEquals(3, bag.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(bag.isEmpty());
        bag.add(19);
        bag.add(3);
        bag.add(9);

        Assert.assertFalse(bag.isEmpty());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, bag.size());
        bag.add(19);
        bag.add(3);
        bag.add(9);

        Assert.assertEquals(3, bag.size());
    }

    @Test
    public void testNumberOf() {
        bag.add(19);
        bag.add(3);
        bag.add(19);
        bag.add(9);
        bag.add(82);

        Assert.assertEquals(2, bag.numberOf(19));
        Assert.assertEquals(1, bag.numberOf(9));
    }

    @Test
    public void testContains() {
        bag.add(19);
        bag.add(3);
        bag.add(19);
        bag.add(9);
        bag.add(82);
        Assert.assertTrue(bag.contains(19));
        Assert.assertFalse(bag.contains(1));
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

        Assert.assertFalse(bag.contains(19));
        Assert.assertEquals(2, bag.size());

    }

    @Test
    public void testClear() {
        bag.add(19);
        bag.add(3);
        bag.add(9);
        bag.add(82);

        bag.clear();

        Assert.assertEquals(0, bag.size());

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

        Assert.assertArrayEquals("", tmp, ints);
    }

}