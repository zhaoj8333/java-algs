package com.graph.analysis.datastructure.collection;

import com.graph.GraphicAnalysis;

public abstract class CollectionAlys<E> implements GraphicAnalysis {

    protected E[] rawData;

    protected int cmpCount = 0;
    protected int arrayAcc = 0;

    public CollectionAlys(E[] rawData) {
        this.rawData = rawData;
    }

    public Object getDataScale() {
        return rawData;
    }

    @Override
    public void analyze() {
        plot(rawData.length, arrayAcc);
        plot(rawData.length, cmpCount);
    }
}
