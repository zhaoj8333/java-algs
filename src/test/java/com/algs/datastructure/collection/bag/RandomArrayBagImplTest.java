package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.Iterator;
import org.junit.jupiter.api.Test;

class RandomArrayBagImplTest {

    @Test
    void iterator() {
        IBag<Integer> bag = new RandomArrayBagImpl<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
        }
        Iterator<Integer> itr = bag.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


    }
}