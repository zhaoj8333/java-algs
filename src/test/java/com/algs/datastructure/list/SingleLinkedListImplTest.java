package com.algs.datastructure.list;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

public class SingleLinkedListImplTest {

    @Test
    public void test() {
        SingleLinkedListImpl<String> ssll = new SingleLinkedListImpl<>();
        ssll.add(RandomStringUtils.random(5));
    }

}
