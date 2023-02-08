package com.algs.utils.wrapper;

import java.util.Objects;

public class Wrapper {

    private final String name;
    private final String location;

    public Wrapper(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Wrapper wrapper = (Wrapper) that;
        return Objects.equals(name, wrapper.name) &&
                Objects.equals(location, wrapper.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
