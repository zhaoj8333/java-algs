package com.algs.datastructure.st.unordered;

import com.algs.datastructure.st.ISymbolTable;
import java.util.Objects;

public abstract class AbstractSymbolTable<K, V> implements ISymbolTable<K, V> {

    protected int size;

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final boolean isEmpty() {
        return size == 0;
    }

    @Override
    public final boolean contains(K key) {
        return Objects.nonNull(get(key));
    }

}
