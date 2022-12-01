package com.algs.algo.unionfind.non_generic;

import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.datastructure.collection.bag.IBag;
import com.algs.datastructure.collection.bag.RandomArrayBagImpl;
import com.algs.utils.Connection;

import java.util.Random;

public class RandomGridGenerator extends QuickUnionImpl {

    public static IBag<Connection> generate(int n) {
        IBag<Connection> bag = new RandomArrayBagImpl<>();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (r.nextInt(10) > 4) {
                    bag.add(new Connection(i * n + j, (i * n) + j + 1));
                } else {
                    bag.add(new Connection(i * n + 1, i * n + j));
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (r.nextInt(10) > 4) {
                    bag.add(new Connection(i * n + j, (i + 1) * n + j));
                } else {
                    bag.add(new Connection((i + 1) * n, i * n + j));
                }
            }
        }
        return bag;
    }

    public static Object[] get(int n) {
        IBag<Connection> bag = generate(n);
        return bag.toArray();
    }

}
