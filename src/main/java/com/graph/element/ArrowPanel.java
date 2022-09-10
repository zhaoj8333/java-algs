package com.graph.element;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

@Data
class ArrowHead {

    private double height;
    private double angle;
    private Color color;
    Point2D.Double x;
    Point2D.Double y;
    Point2D.Double z;

    public ArrowHead(double height, double angle, Color color) {
        this.height = height;
        this.angle = angle;
        this.color = color;
    }
}

public class ArrowPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Line2D.Double aDouble = new Line2D.Double(120, 100, 300, 300);
        drawArrowHead(g2d, aDouble);
    }

    private void drawArrowHead(Graphics2D g2d, Line2D.Double aDouble) {
        ArrowHead arrowHead = getArrow(aDouble);
    }

    private ArrowHead getArrow(Line2D.Double line2d) {
        int height = 60;
        int angle  = 30;
        ArrowHead arrowHead = new ArrowHead(height, angle, Color.RED);
        double v = Math.toRadians(angle >> 1);
        double cos = Math.cos(v);


        return null;

    }
}