package com.graph;

import edu.princeton.cs.algs4.StdDraw;

public interface GraphicAnalysis {

    default void plot(int i, int cost, int totalCost) {
        double avg = (totalCost * 1.0) / i;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(i, cost);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(i, avg);
    }

    void analyze();

}
