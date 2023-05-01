package com.graph.analysis.datastructure.collection.heap.array;

import com.algs.datastructure.Iterator;
import java.util.Comparator;

public class TernaryArrayPqImplAlys<E extends Comparable<E>> extends ArrayPqAlys<E> {

    public TernaryArrayPqImplAlys(E[] rawData, Comparator<E> comparator) {
        super(rawData, comparator);
    }

    @Override
    protected void siftUp(int i) {
        E entry = entries[i];
        arrayAcc++;
        while (i > 0) {
            int pi = (i - 1) / 3;
            E parent = entries[pi];
            arrayAcc++;
            cmpCount++;
            if (compare(parent, entry) >= 0) {
                break;
            }
            entries[i] = parent;
            arrayAcc++;
            i = pi;
        }
        entries[i] = entry;
        arrayAcc++;
    }

    @Override
    protected void siftDown(int i) {
        E root = entries[i];
        arrayAcc++;
        while (i < size / 3) {
            int ci = i * 3 + 1;
            arrayAcc++;
            E child = entries[ci];
            if (ci + 1 < size) {
                arrayAcc += 2;
                cmpCount++;
                if (compare(entries[ci], entries[ci + 1]) > 0) {
                    child = entries[++ci];
                    arrayAcc++;
                }
            }
            if (ci + 1 < size) {
                cmpCount++;
                arrayAcc += 2;
                if (compare(entries[ci], entries[ci + 1]) > 0) {
                    child = entries[++ci];
                    arrayAcc++;
                }
            }
            cmpCount++;
            if (compare(root, child) >= 0) {
                break;
            }
            entries[ci] = child;
            arrayAcc++;
            i = ci;
        }
        entries[i] = root;
        arrayAcc++;
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
