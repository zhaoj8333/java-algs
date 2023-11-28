package com.algs.datastructure.tree.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {

    private char value;
    private char ch;
    private boolean isEnd;
    private Map<Character, Node> children;
    private Node parent;

    public Node(Character value, Node parent) {
        this.value = value;
        this.parent = parent;
        this.isEnd = false;
    }

    public Node() {}

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public Character getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Map<Character, Node> getChildren() {
        return Objects.isNull(this.children) ? this.children = new HashMap<>() : children;
    }

    public boolean hasChildren() {
        return Objects.nonNull(children) && !children.isEmpty();
    }

    public Node getChild(Character ch) {
        return this.getChildren().get(ch);
    }

    public Node addChild(Character ch) {
        Node node = new Node(ch, this);
        this.getChildren().put(ch, node);
        return node;
    }

    public void clear() {
        this.children.clear();
        this.children = null;
    }
}
