package com.algs.datastructure.collection.bag;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagImplTest extends ImplFunctionalityTest {

    @SuppressWarnings("unchecked")
    protected Class<IBag<?>>[] targetClasses = (Class<IBag<?>>[]) new Class<?>[] {
            ArrayBagImpl.class,
            LinkedBagImpl.class,
    };

    @Override
    protected Class<?>[] getConstructorParameters() {
        return new Class[0];
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    protected void testEach(Object obj) {
        IBag<String> bag = (IBag<String>) obj;
        Assertions.assertTrue(bag.isEmpty());
        bag.add("a");
        Assertions.assertFalse(bag.isEmpty());

        String removed = bag.remove();
        Assertions.assertTrue(bag.isEmpty());
        Assertions.assertFalse(bag.contains("b"));
        Assertions.assertEquals(0, bag.size());

        bag.add("21");
        bag.add("21");
        bag.add("15");
        bag.add("c");
        bag.add("12");
        bag.add("28");
        bag.add("8");
        bag.add("15");

        Assertions.assertEquals(8, bag.size());
        Assertions.assertTrue(bag.contains("c"));
        Assertions.assertTrue(bag.contains("21"));
        Assertions.assertTrue(bag.contains("28"));
        Assertions.assertTrue(bag.contains("8"));
        Assertions.assertTrue(bag.contains("15"));

        Assertions.assertEquals(2, bag.numberOf("21"));

        Object[] bagEntries = bag.toArray();

        String[] entries = new String[bagEntries.length];
        for (int i = 0; i < bagEntries.length; i++) {
            entries[i] = (String) bagEntries[i];
        }

//        Assertions.assertArrayEquals(ints, bagInts);
        removed = bag.remove();

        Assertions.assertEquals("15", removed);
        Assertions.assertTrue(bag.contains("15"));
        Assertions.assertEquals(7, bag.size());

        Iterator<String> itr = bag.iterator();
        while (itr.hasNext()) {
            String item = itr.next();
            System.out.print(item + " ");
        }
        System.out.println();


        bag.clear();

        Assertions.assertTrue(bag.isEmpty());
        Assertions.assertThrows(RuntimeException.class, bag::remove);
    }

}