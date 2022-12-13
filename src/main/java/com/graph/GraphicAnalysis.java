package com.graph;

import com.algs.utils.DrawUtil;

import java.awt.*;

public interface GraphicAnalysis {

    default void plot(int i, int cost, int totalCost) {
        double avg = (totalCost * 1.0) / i;
        DrawUtil.setPenColor(DrawUtil.BLACK);
        DrawUtil.point(i, cost);
        DrawUtil.setPenColor(DrawUtil.RED);
        DrawUtil.point(i, avg);
    }

    default void plot(int i, int cost) {
        DrawUtil.point(i, cost);
    }

    default void plot(int i, int cost, Color color) {
        DrawUtil.setPenColor(color);
        DrawUtil.point(i, cost);
    }

    default void plot(int i, int cost, int totalCost, Color totalColor, Color avgColor) {
        double avg = (totalCost * 1.0) / i;
        DrawUtil.setPenColor(totalColor);
        DrawUtil.point(i, cost);
        DrawUtil.setPenColor(avgColor);
        DrawUtil.point(i, avg);
    }

    void analyze();

}
