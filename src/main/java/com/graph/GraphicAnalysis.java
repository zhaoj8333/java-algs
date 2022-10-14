package com.graph;

import com.algs.util.DrawUtil;

public interface GraphicAnalysis {

    default void plot(int i, int cost, int totalCost) {
        double avg = (totalCost * 1.0) / i;
        DrawUtil.setPenColor(DrawUtil.BLACK);
        DrawUtil.point(i, cost);
        DrawUtil.setPenColor(DrawUtil.RED);
        DrawUtil.point(i, avg);
    }

    void analyze();

}
