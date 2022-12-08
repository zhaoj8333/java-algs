package com.algs.datastructure.collection.list.linked;

import com.algs.ImplFunctionalityTest;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.array.ArraysUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class SequentialAccessListImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[] {
            DoublyLinkedListImpl.class,
            SinglyLinkedListImpl.class,
            SinglyLinkedListImpl0.class,
    };

    @Override
    protected Class<?>[] constructArgsType() {
        return new Class[0];
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        Object instance = null;
        try {
            Constructor<?> constructor = targetClass.getConstructor();
            instance = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    protected void testEach(Object obj) {
        ISequentialAccessList<Integer> list = (ISequentialAccessList<Integer>) obj;

        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Assertions.assertEquals(4, list.size());
        list.add(0, 5);
        list.add(2, 6);
        Assertions.assertEquals(6, list.size());

        Object[] array = list.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[2]);
        Assertions.assertEquals(5, list.get(0));
        Assertions.assertEquals(6, list.get(2));

        Assertions.assertEquals(0, list.indexOf(5));
        Assertions.assertEquals(2, list.indexOf(6));

        list.set(1, 20);
        Assertions.assertEquals(20, list.get(1));
        array = list.toArray();
        Assertions.assertEquals(20, array[1]);
        Integer[] ints = new Integer[] {5, 20, 6, 2, 3, 4};
        // 5 20 6 2 3 4
        Assertions.assertArrayEquals(ints, array);

        list.remove(3);
        // 5 20 6 3 4
        array = list.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[2]);
        Assertions.assertEquals(5, list.get(0));
        Assertions.assertEquals(6, list.get(2));
        Assertions.assertEquals(5, list.size());

        Assertions.assertEquals(0, list.indexOf(5));
        Assertions.assertEquals(2, list.indexOf(6));

        // 5 20 6 3 4
        list.set(1, 20);
        Assertions.assertEquals(20, list.get(1));
        array = list.toArray();
        Assertions.assertEquals(20, array[1]);

        list.remove(1);

        // 5 6 3 4
//        Integer[] ints = new Integer[] {5, 20, 6, 2, 3, 4};
//        ints = new Integer[] {5, 6, 3, 4};
        array = list.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[1]);
        Assertions.assertEquals(5, list.get(0));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertEquals(4, list.size());

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer node = itr.next();
            System.out.print(node + ", ");
        }
        System.out.println();

        list.remove(Integer.valueOf(6));
        Assertions.assertEquals(3, list.size());
        Assertions.assertFalse(list.contains(6));

        list.set(1, 4);
        list.set(2, 3);
        list.add(0, 6);
        list.add(0, 7);

        Integer[] expected = new Integer[]{7, 6, 5, 4, 3};
        Object[] resultArray = list.toArray();

        Assertions.assertArrayEquals(expected, resultArray);

        list.reverse();
        Object[] reversed = list.toArray();
        ArraysUtil.reverse(expected);
        Assertions.assertArrayEquals(expected, reversed);

        list.clear();
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.size());
    }

}