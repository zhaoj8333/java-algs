package com.algs.datastructure.st.ordered;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;
import com.algs.datastructure.node.LinkedSTNode;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * !!! This implementation is very inefficient
 */
public class OrderedLinkedSequentialSTImpl<K extends Comparable<K>, V> extends AbstractOrderedSymbolTable<K, V> {

    private LinkedSTNode<K, V> head = new LinkedSTNode<>(null, null, null);

    public OrderedLinkedSequentialSTImpl() {
        this(null);
    }

    public OrderedLinkedSequentialSTImpl(Comparator<K> comparator) {
        super(comparator);
    }

    @Override
    public K min() {
        return head.next.key;
    }

    @Override
    public K max() {
        LinkedSTNode<K, V> node = node(size - 1);
        return Objects.nonNull(node) ? node.key : null;
    }

    @Override
    public K floor(K key) {
        LinkedSTNode<K, V> left = floorNode(key);
        if (Objects.nonNull(left)) {
            LinkedSTNode<K, V> node = left.next;
            return Objects.nonNull(node) && compare(key, node.key) == 0 ? node.key : left.key;
        }
        return null;
    }

    @Override
    public K ceil(K key) {
        LinkedSTNode<K, V> node = ceilNode(key);
        return Objects.nonNull(node) ? node.key : null;
    }

    private LinkedSTNode<K, V> ceilNode(K key) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> node = head.next;
        while (Objects.nonNull(node) && compare(key, node.key) > 0) {
            node = node.next;
        }
        return node;
    }

    private LinkedSTNode<K, V> leftNode(K key) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> left = head;
        LinkedSTNode<K, V> node = head.next;
        while (Objects.nonNull(node) && compare(key, node.key) > 0) {
            left = node;
            node = node.next;
        }
        return left;
    }

    private LinkedSTNode<K, V> floorNode(K key) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> floor = head;
        LinkedSTNode<K, V> node = head.next;
        while (Objects.nonNull(node) && compare(key, node.key) >= 0) {
            floor = node;
            node = node.next;
        }
        return floor;
    }

    private LinkedSTNode<K, V> node(int index) {
        RangeUtil.requireIntRange(index, 0, size);
        LinkedSTNode<K, V> node = head.next;
        for (int j = 0; j < index; j++) {
            node = node.next;
        }
        return node;
    }

    private LinkedSTNode<K, V> node(K key) {
        LinkedSTNode<K, V> floorNode = floorNode(key);
        if (compare(floorNode.key, key) == 0) {
            return floorNode;
        }
        return null;
    }

    @Override
    public int rank(K key) {
        ObjectUtil.requireNonNull(key);
        LinkedSTNode<K, V> node = head.next;
        int rank = 0;
        while (Objects.nonNull(node)) {
            if (compare(node.key, key) >= 0) {
                break;
            }
            rank++;
            node = node.next;
        }
        return rank;
    }

    @Override
    public K select(int k) {
        RangeUtil.requireIntRange(k, 0, size);
        LinkedSTNode<K, V> node = node(k);
        return Objects.nonNull(node) ? node.key : null;
    }

    @Override
    public void deleteMin() {
        if (Objects.isNull(head)) {
            return;
        }
        head.next = head.next.next;
        size--;
    }

    @Override
    public void deleteMax() {
        LinkedSTNode<K, V> node = node(size - 2);
        if (Objects.nonNull(node)) {
            node.next = null;
            size--;
        }
    }

    private boolean isNodeBetween(LinkedSTNode<K, V> node, K low, K high) {
        return Objects.nonNull(node) && compare(node.key, low) >= 0 && compare(node.key, high) <= 0;
    }

    @Override
    public int size(K low, K high) {
        ObjectUtil.requireNonNull(low);
        ObjectUtil.requireNonNull(high);
        int sz = 0;
        if (compare(low, high) <= 0) {
            LinkedSTNode<K, V> node = floorNode(low);
            while (Objects.nonNull(node)) {
                if (Objects.nonNull(node.key)) {
                    int cmp = compare(node.key, high);
                    if (compare(node.key, low) >= 0 && cmp <= 0) {
                        sz++;
                    }
                    if (cmp > 0) {
                        break;
                    }
                }
                node = node.next;
            }
        }
        return sz;
    }

    @Override
    public Iiterable<K> keys(K low, K high) {
        ObjectUtil.requireNonNull(low);
        ObjectUtil.requireNonNull(high);
        IList<K> list = new ResizableArrayImpl<>();
        if (compare(low, high) <= 0) {
            LinkedSTNode<K, V> node = floorNode(low);
            while (Objects.nonNull(node)) {
                int cmp = compare(node.key, high);
                if (compare(node.key, low) >= 0 && cmp <= 0) {
                    list.add(node.key);
                }
                if (cmp > 0) {
                    break;
                }
                node = node.next;
            }
        }
        return list;
    }

    @Override
    public V get(K key) {
        LinkedSTNode<K, V> node = node(key);
        return Objects.nonNull(node) ? node.val : null;
    }

    @Override
    public void put(K key, V val) {
        LinkedSTNode<K, V> floorNode = floorNode(key);
        if (Objects.nonNull(floorNode.key) && compare(floorNode.key, key) == 0) {
            floorNode.val = val;
            return;
        }
        floorNode.next = new LinkedSTNode<>(key, val, floorNode.next);
        size++;
    }

    @Override
    public void delete(K key) {
        LinkedSTNode<K, V> leftNode = leftNode(key);
        if (Objects.isNull(leftNode) || Objects.isNull(leftNode.next)) {
            return;
        }
        leftNode.next = leftNode.next.next;
        size--;
    }

    @Override
    public Iiterable<K> keys() {
        IList<K> list = new ResizableArrayImpl<>(size);
        LinkedSTNode<K, V> node = head.next;
        while (Objects.nonNull(node)) {
            list.add(node.key);
            node = node.next;
        }
        return list;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

}
