package com.algs.datastructure.st.ordered;

import com.algs.datastructure.st.unordered.AbstractSymbolTable;
import com.algs.utils.CompareUtil;

import java.util.Comparator;

public abstract class AbstractOrderedSymbolTable<K extends Comparable<K>, V>
        extends AbstractSymbolTable<K, V>
        implements IOrderedSymbolTable<K, V>
{

    private final Comparator<K> comparator;

    public AbstractOrderedSymbolTable(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    protected int compare(K a, K b) {
        return CompareUtil.compare(a, b, comparator);
    }

}
