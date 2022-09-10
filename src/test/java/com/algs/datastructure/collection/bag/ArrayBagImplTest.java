package com.algs.datastructure.collection.bag;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBagImplTest {

    final int expectedSize = 1282;
    IBag<Integer> bag;

    @Before
    public void setUp() throws Exception {
        bag = new ArrayBagImpl<>();
    }

    @After
    public void tearDown() throws Exception {
        bag.clear();
        bag = null;
    }

    @Test
    public void testAdd() {
        int[] ints = new int[expectedSize];
        for (int i = 0; i < expectedSize; i++) {
            ints[i] = i;
        }
        for (int anInt : ints) {
            bag.add(anInt);
        }
        Object[] bagarray = bag.toArray();
        int[] is = new int[bagarray.length];
        for (int i = 0; i < bagarray.length; i++) {
            is[i] = (int) bagarray[i];
        }

        Assert.assertArrayEquals(is, ints);
        Assert.assertFalse(bag.isEmpty());
        Assert.assertEquals(expectedSize, bag.size());

    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(bag.isEmpty());

        bag.add(21);

        Assert.assertFalse(bag.isEmpty());
    }

    @Test
    public void testSize() {
        Assert.assertTrue(bag.isEmpty());

        bag.add(21);
        bag.add(1);

        Assert.assertEquals(2, bag.size());
    }

    @Test
    public void testNumberOf() {
        bag.add(21);
        bag.add(1);
        bag.add(21);

        Assert.assertEquals(2, bag.numberOf(21));
    }

    @Test
    public void testRemove() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        int removed = bag.remove();

        Assert.assertEquals(15, removed);
        Assert.assertFalse(bag.contains(15));
        Assert.assertEquals(4, bag.size());
    }

    @Test
    public void testRemoveSpecified() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        Integer removed = bag.remove(8);
        bag.remove(0);
        Assert.assertFalse(bag.contains(8));
        Assert.assertEquals(4, bag.size());

    }

    @Test
    public void testClear() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        bag.clear();

        Assert.assertTrue(bag.isEmpty());
        Assert.assertThrows(RuntimeException.class, bag::remove);

    }

    @Test
    public void testContains() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        Assert.assertTrue(bag.contains(21));
        Assert.assertTrue(bag.contains(13));
        Assert.assertTrue(bag.contains(28));
        Assert.assertTrue(bag.contains(8));
        Assert.assertTrue(bag.contains(15));

    }

    @Test
    public void testToArray() {
        int[] ints = new int[expectedSize];
        for (int i = 0; i < expectedSize; i++) {
            ints[i] = i;
            bag.add(i);
        }

        Object[] bagEntryArray = bag.toArray();

        int[] bagInts = new int[bagEntryArray.length];
        for (int i = 0; i < bagEntryArray.length; i++) {
            bagInts[i] = (int) bagEntryArray[i];
        }

        Assert.assertArrayEquals(ints, bagInts);

    }
}