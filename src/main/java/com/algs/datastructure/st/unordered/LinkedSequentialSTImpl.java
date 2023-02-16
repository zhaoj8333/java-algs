package com.algs.datastructure.st.unordered;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.LinkedSTNode;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

public class LinkedSequentialSTImpl<K, V> extends AbstractSymbolTable<K, V> {

    private LinkedSTNode<K, V> head;

    public LinkedSequentialSTImpl() {
    }

    @Override
    public void put(K key, V val) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> node = node(key);
        if (Objects.nonNull(node)) {
            node.val = val;
            return;
        }
        head = new LinkedSTNode<>(key, val, head);
        size++;
    }

    private LinkedSTNode<K, V> node(K key) {
        for (LinkedSTNode<K, V> node = head; Objects.nonNull(node); node = node.next) {
            if (Objects.equals(key, node.key)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        LinkedSTNode<K, V> node = node(key);
        return Objects.nonNull(node) ? node.val : null;
    }

    @Override
    public void delete(K key) {
        ObjectUtil.requireNonNull(key);
        if (isEmpty()) {
            return;
        }
        LinkedSTNode<K, V> prev = null;
        LinkedSTNode<K, V> node = this.head;
        while (Objects.nonNull(node)) {
            if (Objects.equals(key, node.key)) {
                break;
            }
            prev = node;
            node = node.next;
        }
        if (Objects.isNull(prev)) {     // size == 1 || Objects.equals(this.head.key, key)
            this.head = this.head.next;
        } else {
            prev.next = null;
        }
        size--;
    }

    @Override
    public Iiterable<K> keys() {
        IList<K> list = new ResizableArrayImpl<>(size);
        LinkedSTNode<K, V> node = this.head;
        while (Objects.nonNull(node)) {
            list.add(node.key);
            node = node.next;
        }
        return list;
    }

    @Override
    public void clear() {
        this.head = null;
        size = 0;
    }

}
