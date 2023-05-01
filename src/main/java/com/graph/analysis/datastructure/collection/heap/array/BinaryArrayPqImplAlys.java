package com.graph.analysis.datastructure.collection.heap.array;

import com.algs.datastructure.Iterator;
import java.util.Comparator;

public class BinaryArrayPqImplAlys<E extends Comparable<E>> extends ArrayPqAlys<E> {

    public BinaryArrayPqImplAlys(E[] rawData, Comparator<E> comparator) {
        super(rawData, comparator);
    }

    @Override
    protected void siftUp(int i) {
        E entry = entries[i];
        arrayAcc++;
        while (i > 0) {
            int pi = (i - 1) >> 1;
            E parent = entries[pi];
            arrayAcc++;
            cmpCount++;
            if (compare(entry, parent) <= 0) {
                break;
            }
            entries[i] = parent;
            arrayAcc ++;
            i = pi;
        }
        entries[0] = entry;
        arrayAcc++;
    }

    @Override
    protected void siftDown(int i) {
        E root = entries[i];
        arrayAcc++;
        int half = size >> 1;
        while (i < half) {
            int ci = (i << 1) + 1;
            E child = entries[ci];
            arrayAcc++;
            int ri = ci + 1;
            if (ri < size) {
                cmpCount++;
                arrayAcc++;
                if (compare(entries[ri], child) > 0) {
                    arrayAcc++;
                    child = entries[ci = ri];
                }
            }
            cmpCount++;
            if (compare(root, child) >= 0) {
                break;
            }
            entries[i] = child;
            arrayAcc++;
            i = ci;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void analyze() {
        for (E em : rawData) {
            this.add(em);
        }
        while (!isEmpty()) {
            remove();
        }
        super.analyze();
    }
}
