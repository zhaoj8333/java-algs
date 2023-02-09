package com.algs.utils;

import java.awt.*;

public class VisualCostAccumulator {

    private static final String HELVETICA_FONT = "Helvetica";
    private double total;
    private int size;
    private double lastComputedValue;

    public VisualCostAccumulator(int originValue, double maxX, double maxY, String title, String xAxisLabel, String yAxisLabel) {
        DrawUtil.setXscale(-(maxX * 0.05), maxX + (maxX * 0.05));
        DrawUtil.setYscale(-(maxY * 0.05), maxY + (maxY * 0.05));
        DrawUtil.setPenRadius(.005);

        drawLabels(originValue, maxX, maxY, title, xAxisLabel, yAxisLabel);
    }

    private void drawLabels(int originValue, double maxX, double maxY, String title, String xAxisLabel, String yAxisLabel) {
        Font font = new Font(HELVETICA_FONT, Font.BOLD, 12);
        DrawUtil.setFont(font);
        DrawUtil.setPenColor(DrawUtil.RED);

        //X axis label
        double xAxisLabelHeight = -(maxY * 0.025);

        DrawUtil.text(maxX / 2, xAxisLabelHeight, xAxisLabel);
        //Y axis label
        DrawUtil.text(-(maxY * 15), maxY / 2, yAxisLabel, 90);

        DrawUtil.setPenColor(DrawUtil.BLACK);
        //Title
        DrawUtil.text(maxX / 2, maxY - (maxY * 0.02), title);

        Font font2 = new Font(HELVETICA_FONT, Font.PLAIN, 12);
        DrawUtil.setFont(font2);

        DrawUtil.text(-(maxX * 0.01), xAxisLabelHeight, String.valueOf(originValue));
        //X axis label
        DrawUtil.text(-(maxX * 0.005), maxY - (maxY * 0.07), String.valueOf((int) maxY));
        //Y axis label
        DrawUtil.text(maxX - (maxX * 0.06), xAxisLabelHeight, String.valueOf((int) maxX));
    }

    public void addDataValue(double value, boolean drawMean) {
        size++;
        total += value;

        DrawUtil.setPenColor(DrawUtil.DARK_GRAY);
        DrawUtil.point(size, value);

        if (drawMean) {
            DrawUtil.setPenColor(DrawUtil.RED);
            DrawUtil.point(size, mean());
        }

        lastComputedValue = value;
    }

    public void drawDataValue(double xCoordinate, double yCoordinate, Color color) {
        DrawUtil.setPenColor(color);
        DrawUtil.point(xCoordinate, yCoordinate);
    }

    private double mean() {
        return total / size;
    }

    public void writeFinalMean() {
        DrawUtil.setPenColor(DrawUtil.RED);
        long roundMean = Math.round(mean());
        DrawUtil.text(size + (size * 0.04), mean(), String.valueOf(roundMean));
    }

    public void writeExactFinalMean() {
        DrawUtil.setPenColor(DrawUtil.RED);
        DrawUtil.text(size + (size * 0.04), mean(), String.format("%.1f", mean()));
    }

    public void writeText(String text, double xCoordinate, double yCoordinate, Color color) {
        DrawUtil.setPenColor(color);
        DrawUtil.text(xCoordinate, yCoordinate, text);
    }

    public void writeLastComputedValue() {
        DrawUtil.setPenColor(DrawUtil.RED);
        DrawUtil.text(size + (size * 0.04), lastComputedValue, String.valueOf((int) lastComputedValue));
    }

    public String toString() {
        return "Mean (" + size + " values): " + String.format("%7.5f", mean());
    }

}
