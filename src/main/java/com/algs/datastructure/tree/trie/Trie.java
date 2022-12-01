package com.algs.datastructure.trie;

import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class Trie {

    private int size;
    private final Node root = new Node();  // root Node doesn't store value

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.root.clear();
        this.size = 0;
    }

    public Character get(String key) {
        Node node = node(key);
        return Objects.nonNull(node) && node.isEnd() ? node.getValue() : null;
    }

    public boolean contains(String key) {
        Node node = node(key);
        return Objects.nonNull(node) && node.isEnd();
    }

    public Node node(String key) {
        ObjectUtil.requireNonEmpty(key);
        Node node = this.root;
        for (int i = 0; i < key.length(); i++) {
            node = node.getChildren().get(key.charAt(i));
            if (Objects.isNull(node)) {
                return null;
            }
        }
        return node;
    }

    public void add(String key) {
        ObjectUtil.requireNonEmpty(key);
        Node node = this.root;
        for (int i = 0; i < key.length(); i++) {
            Character ch = key.charAt(i);
            Node child = node.getChild(ch);
            if (Objects.isNull(child)) {
                child = node.addChild(ch);
                child.setCh(node.getCh());
            }
            node = child;
        }
        if (!node.isEnd()) {
            node.setEnd(true);
            this.size++;
        }
    }

    public boolean startsWith(String prefix) {
        return Objects.nonNull(node(prefix));
    }

    public Character remove(String key) {
        Node node = node(key);
        if (Objects.isNull(node) || !node.isEnd()) {
            return null;
        }
        this.size--;
        if (!node.hasChildren()) {
            node.setEnd(false);
            return node.getValue();
        }
        // reversely delete
        Node parent;
        while (Objects.nonNull(parent = node.getParent())) {
            parent.getChildren().remove(node.getCh());
            if (parent.isEnd() || parent.hasChildren()) {
                break;
            }
            node = parent;
        }
        node.setEnd(false);
        return node.getValue();
    }

}
