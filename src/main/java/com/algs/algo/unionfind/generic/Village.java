package com.algs.algo.unionfind.generic;

import java.util.Objects;

public class Village {

    private String name;
    private String location;

    public Village(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Village village = (Village) o;
        return Objects.equals(name, village.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
