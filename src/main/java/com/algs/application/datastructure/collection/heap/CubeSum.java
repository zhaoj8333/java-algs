package com.algs.application.datastructure.collection.heap;

import com.algs.application.datastructure.collection.nodes.Cube;
import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.datastructure.collection.list.IList;
import com.algs.datastructure.collection.list.array.ResizableArrayImpl;

import java.math.BigInteger;
import java.util.Objects;

/**
 * 2.4.25 // TODO: 2/4/23  
 */
public class CubeSum {

    public void init(IPriorityQueue<Cube> pq, int n) {
        for (int i = 0; i < n + 1; i++) {
            BigInteger val = BigInteger.valueOf(i);
            BigInteger cubeVal = val.multiply(val).multiply(val);
            pq.add(new Cube(cubeVal, i, 0));
        }
    }

    public void compute(IPriorityQueue<Cube> pq, int n) {
        IList<Cube> list = new ResizableArrayImpl<>();
        while (!pq.isEmpty()) {
            Cube min = pq.remove();
            insertNext(pq, min, n);
            getEqualValues(pq, min, list, n);
            print(list);
        }

    }

    private void print(IList<Cube> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Cube c1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Cube c2 = list.get(j);
                if (uniqueEqual(c1, c2)) {
                    System.out.println("a^3 + b^3 = c^3 + d^3: A: " + c1.i + " B: " + c1.j + " C: " + c2.i + " D: " + c2.j);
                    System.out.println("a^3 + b^3 = c^3 + d^3: A: " + c2.i + " B: " + c2.j + " C: " + c1.i + " D: " + c1.j);
                }

            }
        }
    }

    private boolean uniqueEqual(Cube c1, Cube c2) {
        return c1.i != c1.j && c1.i != c2.i && c1.i != c2.j && c1.j != c2.i && c1.j != c2.j && c2.i != c2.j;
    }

    private void insertNext(IPriorityQueue<Cube> pq, Cube cube, int max) {
        if (cube.j > max) {
            return;
        }
        BigInteger iVal = BigInteger.valueOf(cube.i);
        BigInteger jVal = BigInteger.valueOf(cube.j + 1);
        BigInteger newVal = iVal.multiply(iVal).multiply(iVal).add(jVal.multiply(jVal).multiply(jVal));
        pq.add(new Cube(newVal, cube.i, cube.j + 1));
    }

    private void getEqualValues(IPriorityQueue<Cube> pq, Cube curVal, IList<Cube> equalResults, int n) {
        equalResults.add(curVal);
        while (!pq.isEmpty() && Objects.equals(pq.get().value, curVal.value)) {
            Cube top = pq.remove();
            equalResults.add(top);
            insertNext(pq, top, n);
        }
    }
}
