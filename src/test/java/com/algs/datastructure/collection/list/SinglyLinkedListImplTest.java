package com.algs.datastructure.collection.list;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedListImplTest {

    @Test
    void test() {
        List<Integer> sll = new SinglyLinkedListImpl<>();
        Assertions.assertEquals(0, sll.size());
        Assertions.assertTrue(sll.isEmpty());

        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);

        Assertions.assertEquals(4, sll.size());
        sll.add(0, 5);
        sll.add(2, 6);
        Assertions.assertEquals(6, sll.size());

        Object[] array = sll.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[2]);
        Assertions.assertEquals(5, sll.get(0));
        Assertions.assertEquals(6, sll.get(2));

        Assertions.assertEquals(0, sll.indexOf(5));
        Assertions.assertEquals(2, sll.indexOf(6));

        sll.set(1, 20);
        Assertions.assertEquals(20, sll.get(1));
        array = sll.toArray();
        Assertions.assertEquals(20, array[1]);
        Integer[] ints = new Integer[] {5, 20, 6, 2, 3, 4};
        Assertions.assertArrayEquals(ints, array);

        sll.remove(3);
        array = sll.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[2]);
        Assertions.assertEquals(5, sll.get(0));
        Assertions.assertEquals(6, sll.get(2));
        Assertions.assertEquals(5, sll.size());

        Assertions.assertEquals(0, sll.indexOf(5));
        Assertions.assertEquals(2, sll.indexOf(6));

        sll.set(1, 20);
        Assertions.assertEquals(20, sll.get(1));
        array = sll.toArray();
        Assertions.assertEquals(20, array[1]);

        sll.remove(1);

//        Integer[] ints = new Integer[] {5, 20, 6, 2, 3, 4};
//        ints = new Integer[] {5, 6, 3, 4};
        array = sll.toArray();
        Assertions.assertEquals(5, array[0]);
        Assertions.assertEquals(6, array[1]);
        Assertions.assertEquals(5, sll.get(0));
        Assertions.assertEquals(3, sll.get(2));
        Assertions.assertEquals(4, sll.size());

        Iterator<Integer> itr = sll.iterator();
        while (itr.hasNext()) {
            Integer node = itr.next();
            System.out.println(node);
        }

        sll.clear();
        Assertions.assertTrue(sll.isEmpty());
        Assertions.assertEquals(0, sll.size());

    }


    @Test
    void add() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
        List<Integer> sll = new SinglyLinkedListImpl<>();

        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);

        sll.set(0, 10);

        Assertions.assertEquals(10, sll.get(0));
    }

    @Test
    void indexOf() {
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
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void reverse() {
        List<Integer> sll = new SinglyLinkedListImpl<>();
        Integer[] integers = new Integer[10];
        for (int i = 0; i < 10; i++) {
            sll.add(i * 100);
            integers[i] = i * 100;
        }
        Object[] integers1 = sll.toArray();
        Assertions.assertArrayEquals(integers, integers1);

        for (int i = 0; i < integers.length / 2; i++) {
            int index = 10 - i - 1;
            Integer tmp = integers[index];
            integers[index] = integers[i];
            integers[i] = tmp;
        }
        sll.reverse();
        Object[] integers2 = sll.toArray();
        Assertions.assertArrayEquals(integers, integers2);

    }

    @Test
    void iterator() {
    }
}