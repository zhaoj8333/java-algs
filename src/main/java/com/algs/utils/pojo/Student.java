package com.algs.utils.pojo;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private final String name;
    private final Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return '[' + name + ',' + score + ']';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }

}
