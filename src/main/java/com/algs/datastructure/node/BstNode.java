package com.algs.datastructure.node;

import java.util.Objects;

public class BstNode<K extends Comparable<K>, V> extends TreeNode<K, V> {

    public BstNode<K, V> parent;
    public BstNode<K, V> left;
    public BstNode<K, V> right;

    public BstNode(K key, V value, BstNode<K, V> parent, BstNode<K, V> left, BstNode<K, V> right, int size) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.size = size;
    }

    public void updateSize() {
        int sz = 1;
        if (Objects.nonNull(left)) {
            sz += left.size;
        }
        if (Objects.nonNull(right)) {
            sz += right.size;
        }
        size = sz;
    }

    @Override
    public K getValue() {
        return key;
    }

    public boolean isLeaf() {
        return Objects.isNull(this.left) && Objects.isNull(this.right);
    }

    public boolean hasTwoChildren() {
        return Objects.nonNull(this.left) && Objects.nonNull(this.right);
    }

    public boolean hasChild() {
        return Objects.nonNull(this.left) || Objects.nonNull(this.right);
    }

    public boolean isLeft() {
        if (Objects.isNull(this.parent)) {
            return false;
        }
        return Objects.equals(this.parent.left, this);
    }

    public boolean isRight() {
        if (Objects.isNull(this.parent)) {
            return false;
        }
        return Objects.equals(this.parent.right, this);
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BstNode<?, ?> that = (BstNode<?, ?>) o;
        return Objects.equals(this.size, that.size) && Objects.equals(this.key, that.key)
                && Objects.equals(this.value, that.value) && Objects.equals(parent, that.parent)
                && Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    public boolean equalsWithoutParent(BstNode<K, V> that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        if (size != that.size) {
            return false;
        }
        return equalsTo(left, that.left) && equalsTo(right, that.right);
    }

    public boolean equalsTo(BstNode<K, V> a, BstNode<K, V> b) {
        return (a == b) || (a != null && a.equalsWithoutParent(b));
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, left, right);
    }
}
