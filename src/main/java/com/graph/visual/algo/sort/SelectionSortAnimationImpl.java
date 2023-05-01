package com.graph.visual.algo.sort;

import com.algs.utils.DrawUtil;
import java.awt.Color;

public class SelectionSortAnimationImpl<E extends Comparable<E>> extends CompareAndSwapSortAnimation<E> {

   public SelectionSortAnimationImpl(E[] array, int miliSeconds) {
        super(array, miliSeconds);
    }

    protected void beforeCompare() {
        pause(pauseMilliSecond / 5);
        DrawUtil.setPenColor(Color.BLUE);
        drawEntry(baseIndex);
        DrawUtil.setPenColor();
    }

    @Override
    protected void afterCompare() {

    }

    @Override
    protected void afterSwap() {
        DrawUtil.setPenColor(Color.LIGHT_GRAY);
        drawEntry(baseIndex);
        DrawUtil.setPenColor();
    }

    /**
     * {5, 1, 8, 6, 9, 3, 4}
     */
    @Override
    protected void beforeSwap() {
    }

    @Override
    public void sort() {
        if (array.length < 2) {
            return;
        }
        int len = array.length;
        for (baseIndex = 0; baseIndex < len; baseIndex++) {
            beforeCompare();
            for (comparedIndex = baseIndex + 1; comparedIndex < len; comparedIndex++) {
                if (compare() > 0) {
                    baseIndex = comparedIndex;
                }
            }
            afterCompare();
//            swap(minIndex, i);
//            afterSwap();
        }
    }
}
