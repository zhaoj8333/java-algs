package com.algs.utils;

public class Connection<E> {

    public E a;
    public E b;

    public Connection(E a, E b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[" + a.toString() + ", " + b.toString() + "]";
    }

}
