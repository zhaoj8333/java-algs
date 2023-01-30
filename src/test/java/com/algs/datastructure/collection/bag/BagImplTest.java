package com.algs.datastructure.collection.bag;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagImplTest extends ImplFunctionalityTest {

    @SuppressWarnings("unchecked")
    protected Class<IBag>[] targetClasses = (Class<IBag>[]) new Class<?>[] {
            ArrayBagImpl.class,
            LinkedBagImpl.class,
    };

    @Override
    protected Object construct(Class<?> targetClass) {
        return null;
    }

    protected void testEach(Object obj) {
        IBag<Integer> bag = (IBag<Integer>) obj;
        Assertions.assertTrue(bag.isEmpty());
        bag.add(1);
        Assertions.assertFalse(bag.isEmpty());

        Integer removed = bag.remove(8);
        bag.remove(0);
        Assertions.assertFalse(bag.contains(8));
        Assertions.assertEquals(4, bag.size());

        Assertions.assertTrue(bag.contains(21));
        Assertions.assertTrue(bag.contains(13));
        Assertions.assertTrue(bag.contains(28));
        Assertions.assertTrue(bag.contains(8));
        Assertions.assertTrue(bag.contains(15));

        Assertions.assertEquals(2, bag.numberOf(21));

        Object[] bagEntryArray = bag.toArray();

        int[] bagInts = new int[bagEntryArray.length];
        for (int i = 0; i < bagEntryArray.length; i++) {
            bagInts[i] = (int) bagEntryArray[i];
        }

//        Assertions.assertArrayEquals(ints, bagInts);
//        int removed = bag.remove();

        Assertions.assertEquals(15, removed);
        Assertions.assertFalse(bag.contains(15));
        Assertions.assertEquals(4, bag.size());

        Iterator<Integer> itr = bag.iterator();
        while (itr.hasNext()) {
            Integer item = itr.next();
            System.out.print(item + " ");
        }
        System.out.println();


        bag.clear();

        Assertions.assertTrue(bag.isEmpty());
        Assertions.assertThrows(RuntimeException.class, bag::remove);
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

}