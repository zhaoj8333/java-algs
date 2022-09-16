package com.algs.datastructure.collection.bag;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayBagImplTest {

    final int expectedSize = 1282;
    IBag<Integer> bag;

    @BeforeEach
    public void setUp() throws Exception {
        bag = new ArrayBagImpl<>();
    }

    @AfterEach
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

        Assertions.assertArrayEquals(is, ints);
        Assertions.assertFalse(bag.isEmpty());
        Assertions.assertEquals(expectedSize, bag.size());

    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(bag.isEmpty());

        bag.add(21);

        Assertions.assertFalse(bag.isEmpty());
    }

    @Test
    public void testSize() {
        Assertions.assertTrue(bag.isEmpty());

        bag.add(21);
        bag.add(1);

        Assertions.assertEquals(2, bag.size());
    }

    @Test
    public void testNumberOf() {
        bag.add(21);
        bag.add(1);
        bag.add(21);

        Assertions.assertEquals(2, bag.numberOf(21));
    }

    @Test
    public void testRemove() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        int removed = bag.remove();

        Assertions.assertEquals(15, removed);
        Assertions.assertFalse(bag.contains(15));
        Assertions.assertEquals(4, bag.size());
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
        Assertions.assertFalse(bag.contains(8));
        Assertions.assertEquals(4, bag.size());

    }

    @Test
    public void testClear() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        bag.clear();

        Assertions.assertTrue(bag.isEmpty());
        Assertions.assertThrows(RuntimeException.class, bag::remove);

    }

    @Test
    public void testContains() {
        bag.add(21);
        bag.add(13);
        bag.add(28);
        bag.add(8);
        bag.add(15);

        Assertions.assertTrue(bag.contains(21));
        Assertions.assertTrue(bag.contains(13));
        Assertions.assertTrue(bag.contains(28));
        Assertions.assertTrue(bag.contains(8));
        Assertions.assertTrue(bag.contains(15));

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

        Assertions.assertArrayEquals(ints, bagInts);

    }
}