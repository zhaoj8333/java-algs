package com.algs.datastructure.st.ordered;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.Iterator;
import com.algs.datastructure.st.unordered.AbstractSymbolTable;
import com.algs.utils.CompareUtil;
import java.util.Comparator;

public abstract class AbstractOrderedSymbolTable<K extends Comparable<K>, V> extends AbstractSymbolTable<K, V> implements IOrderedSymbolTable<K, V> {

    private final Comparator<K> comparator;

    public AbstractOrderedSymbolTable(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    protected int compare(K a, K b) {
        return CompareUtil.compare(a, b, comparator);
    }

    @Override
    public String toString() {
        Iiterable<K> keys = keys();
        StringBuilder sb = new StringBuilder();
        Iterator<K> itr = keys.iterator();
        sb.append("{ ");
        while (itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        sb.append(" }");
        return sb.toString();
    }

}
