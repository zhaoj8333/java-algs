package com.algs.datastructure.collection.list.linked;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoubleLinkedListImplTest {

    @Test
    void test() {
        IList<Integer> dll = new DoubleLinkedListImpl<>();
        Assertions.assertEquals(0, dll.size());
        Assertions.assertTrue(dll.isEmpty());

        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);

        Assertions.assertEquals(4, dll.size());
        dll.add(0, 5);
        dll.add(2, 6);
        Assertions.assertEquals(6, dll.size());

        Object[] array = dll.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[2]);
        Assertions.assertEquals(5, dll.get(0));
        Assertions.assertEquals(6, dll.get(2));

        Assertions.assertEquals(0, dll.indexOf(5));
        Assertions.assertEquals(2, dll.indexOf(6));

        dll.set(1, 20);
        Assertions.assertEquals(20, dll.get(1));
        array = dll.toArray();
        Assertions.assertEquals(20, array[1]);
        Integer[] ints = new Integer[] {5, 20, 6, 2, 3, 4};
        Assertions.assertArrayEquals(ints, array);

        dll.remove(3);
        array = dll.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[2]);
        Assertions.assertEquals(5, dll.get(0));
        Assertions.assertEquals(6, dll.get(2));
        Assertions.assertEquals(5, dll.size());

        Assertions.assertEquals(0, dll.indexOf(5));
        Assertions.assertEquals(2, dll.indexOf(6));

        dll.set(1, 20);
        Assertions.assertEquals(20, dll.get(1));
        array = dll.toArray();
        Assertions.assertEquals(20, array[1]);

        dll.remove(1);

//        Integer[] ints = new Integer[] {5, 20, 6, 2, 3, 4};
//        ints = new Integer[] {5, 6, 3, 4};
        array = dll.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[1]);
        Assertions.assertEquals(5, dll.get(0));
        Assertions.assertEquals(3, dll.get(2));
        Assertions.assertEquals(4, dll.size());

        Iterator<Integer> itr = dll.iterator();
        while (itr.hasNext()) {
            Integer node = itr.next();
            System.out.println(node);
        }

        dll.clear();
        Assertions.assertTrue(dll.isEmpty());
        Assertions.assertEquals(0, dll.size());

    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void reverse() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void iterator() {
    }
}