package com.algs.datastructure.trie;

import com.algs.util.AlgsUtil;
import joptsimple.internal.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.zip.CheckedInputStream;

public class Trie<V> {

    private int size;
    private final Node<V> root = new Node<>();

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        root.getChildren().clear();
    }

    public V get(String key) {
        Node<V> node = node(key);
        return Objects.nonNull(node) ? node.value : null;
    }

    public boolean contains(String key) {
        return Objects.nonNull(node(key));
    }

    private Node<V> node(String key) {
        AlgsUtil.requireStringNonEmpty(key);
        Node<V> node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            Node<V> child = node.getChildren().get(ch);
            if (Objects.isNull(child)) {
                return null;
            }
            node = child;
        }
        return node.isEnd() ? node : null;
    }

    public V add(String key, V value) {
        return null;
    }

    public V remove(String v) {
        return null;
    }

    public boolean startsWith(String prefix) {
        return false;
    }

    private static class Node<V> {
        Map<Character, Node<V>> children;
        private V value;
        private boolean end;

        public V getValue() {
            return value;
        }

        public boolean isEnd() {
            return end;
        }

        public Map<Character, Node<V>> getChildren() {
            return Objects.isNull(children) ? (children = new HashMap<>()) : children;
        }

    }
}
