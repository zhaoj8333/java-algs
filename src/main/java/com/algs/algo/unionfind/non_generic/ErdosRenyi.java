package com.algs.algo.unionfind.non_generic;

import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.linked.SinglyLinkedListImpl;
import com.algs.utils.Connection;
import java.util.Random;

public class ErdosRenyi {

    public Object[] generate(int n) {
        Random r = new Random();
        IList<Connection<Integer>> conns = new SinglyLinkedListImpl<>();
        IUnionFind uf = new HalvingImpl();
        while (uf.count() > 1) {
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            uf.union(p, q);
            conns.add(new Connection<>(p, q));
        }
        return conns.toArray();
    }

    public int count(IUnionFind uf) {
        Random r = new Random();
        int size = uf.count();
        int cnt = 0;
        while (uf.count() > 1) {
            int p = r.nextInt(size);
            int q = r.nextInt(size);
            uf.union(p, q);
            cnt++;
        }
        return cnt;
    }

//    public void count(IUnionFind uf, Connection[] conns) {
//        for (Connection conn : conns) {
//            uf.union(conn.a, conn.b);
//        }
//    }
}
