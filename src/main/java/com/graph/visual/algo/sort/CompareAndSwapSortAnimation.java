package com.graph.visual.algo.sort;

import com.algs.DefaultValues;
import com.algs.algo.sort.ISortable;
import com.algs.utils.DrawUtil;
import com.algs.utils.ObjectUtil;

import java.awt.*;
import java.util.Comparator;
import java.util.Objects;

// TODO: 11/13/22  
public abstract class CompareAndSwapSortAnimation<E extends Comparable<E>> implements ISortable<E> {

    protected int pauseMilliSecond;
    protected int baseIndex;
    protected int comparedIndex;

    protected E[] array;
    protected Comparator<E> comparator;

    public CompareAndSwapSortAnimation(E[] array) {
        this(array, null);
    }

    public CompareAndSwapSortAnimation(E[] array, Comparator<E> comparator) {
        this(array, comparator, DefaultValues.ANIMATION_PAUSE_MILLISECONDS);
    }

    public CompareAndSwapSortAnimation(E[] array, int milliSecond) {
        this(array, null, milliSecond);
    }

    public CompareAndSwapSortAnimation(E[] array, Comparator<E> comparator, int pauseSecond) {
        ObjectUtil.requireNonNull(array);
        this.array = array;
        this.pauseMilliSecond = pauseSecond;

        DrawUtil.setCanvasSize();
        DrawUtil.setScale(0, array.length + 6);
        DrawUtil.setPenColor();

        for (int n = 0; n < array.length; n++) {
            pause(pauseMilliSecond / array.length);
            drawEntry(n);
        }
    }

    protected abstract void beforeCompare();

    protected int compare() {
//        pause();
        int cmp = Objects.nonNull(comparator) ? comparator.compare(array[baseIndex], array[comparedIndex]) : array[baseIndex].compareTo(array[comparedIndex]);
//        for (int i = baseIndex + 1; i < comparedIndex; i++) {
//        if (comparedIndex - baseIndex > 2) {
//            drawEntry(comparedIndex - 1, SortUtil.UNSORTED_COLOR);
//        }
//        }
//        int smallerIndex = baseIndex;
//        if (cmp != 0) {
//            if (cmp > 0) {
//                smallerIndex = cmpedIndex;
//            }
//            DrawUtil.setPenColor(SortUtil.SELECTED_COLOR);
//            drawEntry(smallerIndex);
//        }
//        DrawUtil.setPenColor();
//        drawElement(otherIndex);
//        return cmp;
        return cmp;
    }

    protected void swap() {
        E tmp = array[baseIndex];
        array[baseIndex] = array[comparedIndex];
        array[comparedIndex] = tmp;
    }

    protected void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void pause() {
        pause(pauseMilliSecond);
    }

    protected void drawEntry(int i) {
        drawEntry(i, DrawUtil.getPenColor());
    }

    protected void drawEntry(int i, Color penColor) {
        DrawUtil.setPenColor(penColor);
        double x = 15.0 * (i + 1) / array.length;
        String val = String.valueOf(array[i]);
        double y = Double.parseDouble(val);
        double bw = 0.4;
        double bh = y / 2;
        DrawUtil.filledRectangle(x, y / 2, bw, bh);
        DrawUtil.text(x, y + 0.5, val);
        DrawUtil.setPenColor();
    }

    protected abstract void afterCompare();

    protected abstract void afterSwap();

    protected abstract void beforeSwap();

}
