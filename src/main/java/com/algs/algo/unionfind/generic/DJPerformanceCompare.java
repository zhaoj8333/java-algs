package com.algs.algo.unionfind.generic;

import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.SinglyLinkedListImpl;
import com.algs.util.Connection;

import java.util.Random;

public class DJPerformanceCompare<E> extends StopWatchTask<E> {

    private final IDisjointSet<E> uf;
    private final IList<Connection<E>> pairs;

    public DJPerformanceCompare(IDisjointSet<E> uf, IDeque<E> q) {
        this.uf = uf;
        pairs = new SinglyLinkedListImpl<>();
        Random r = new Random();
        while (!q.isEmpty()) {
            E v1 = q.deque();
            E v2;
            if (r.nextInt(10) % 2 == 0) {
                v2 = q.deque();
            } else {
                v2 = q.dequeTail();
            }
            pairs.add(new Connection<E>(v1, v2));
        }
    }

    @Override
    public Object profileTask() {
        Iterator<Connection<E>> itr = pairs.iterator();
        while (itr.hasNext()) {
            Connection<E> pair = itr.next();
            if (uf.connected(pair.a, pair.b)) {
                continue;
            }
            uf.union(pair.a, pair.b);
        }

        return "Void";
    }

    @Override
    protected void assertResult() {
    }
}
