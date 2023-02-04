package com.algs.application.datastructure.collection.nodes;

import java.math.BigInteger;

public class Cube implements Comparable<Cube> {

    public final int i;
    public final int j;
    public final BigInteger value;

    public Cube(BigInteger val, int i, int j) {
        this.value = val;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Cube that) {
        return this.value.compareTo(that.value);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "i=" + i +
                ", j=" + j +
                ", value=" + value +
                '}';
    }

}
