package com.algs.algo.filter;

import com.algs.utils.StringUtil;
import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

class BloomFilterImplTest {

    @Test
    void dedup() {
        int size = 1_000000;
        String[] urls = new String[size];
        for (int i = 0; i < size; i++) {
            urls[i] = StringUtil.random(10);
        }
        IFilter<String> filter = new BloomFilterImpl<>(size, 0.01);
        for (int i = 0; i < size; i++) {
            filter.put(urls[i]);
        }
        int error = 0;
        for (int i = 0; i < size; i++) {
            boolean contains = filter.contains(urls[i]);
            if (!contains) {
                error += 1;
            }
        }

        System.out.println("error: " + error + ", rate: " + (error / size));
        error = 0;

        for (int i = 0; i < size / 2; i++) {
            boolean contains = filter.contains(StringUtil.random(3));
            if (contains) {
                error += 1;
            }
        }
        double i = (double) error / size;
        System.out.println("error: " + error + ", rate: " + new DecimalFormat("0.000").format(i));
    }

    @Test
    void test() {
        int size = 1_00000;
        IFilter<Integer> filter = new BloomFilterImpl<>(size, 0.01);
        for (int i = 0; i < size; i++) {
            filter.put(i);
        }
        int error = 0;
        for (int i = 0; i < size; i++) {
            boolean contains = filter.contains(i);
            if (!contains) {
                error += 1;
            }
        }

        System.out.println("error: " + error + ", rate: " + (error / size));
        error = 0;

        for (int i = size; i < size * 2; i++) {
            boolean contains = filter.contains(i);
            if (contains) {
                error += 1;
            }
        }
        double i = (double) error / size;
        System.out.println("error: " + error + ", rate: " + new DecimalFormat("0.000").format(i));
    }


}