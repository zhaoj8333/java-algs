package com.algs.util;

public class Pair<E> {
    public E a;
    public E b;

    public Pair(E a, E b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[" + a.toString() + ", " + b.toString() + "]";
    }

}
