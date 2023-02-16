package com.algs.datastructure.st.unordered;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.LinkedSTNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class SelfOrganizedLinkedSTImpl<K, V> extends AbstractSymbolTable<K, V> {

    private final LinkedSTNode<K, V> head = new LinkedSTNode<>(null, null, null);

    public SelfOrganizedLinkedSTImpl() {
    }

    @Override
    public V get(K key) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> node = head;
        while (Objects.nonNull(node.next)) {
            LinkedSTNode<K, V> next = node.next;
            if (Objects.equals(next.key, key)) {
                node.next = next.next;
                LinkedSTNode<K, V> first = head.next;
                head.next = next;
                next.next = first;
                return next.val;
            }
            node = next;
        }
        return null;
    }

    @Override
    public void put(K key, V val) {
        LinkedSTNode<K, V> node = head;
        while (Objects.nonNull(node.next)) {
            node = node.next;
            if (Objects.equals(node.key, key)) {
                node.val = val;
                return;
            }
        }
        node.next = new LinkedSTNode<>(key, val, null);
        size++;
    }

    @Override
    public void delete(K key) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> node = head;
        while (Objects.nonNull(node.next)) {
            LinkedSTNode<K, V> next = node.next;
            if (Objects.equals(next.key, key)) {
                node.next = next.next;
                size--;
                return;
            }
        }
    }

    @Override
    public Iiterable<K> keys() {
        LinkedSTNode<K, V> node = head.next;
        IList<K> list = new ResizableArrayImpl<>(size);
        while (Objects.nonNull(node)) {
            list.add(node.key);
        }
        return list;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }
}
