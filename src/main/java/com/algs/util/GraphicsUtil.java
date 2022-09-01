package com.algs.util;

import com.graph.object.Locatable;

import java.awt.*;
import java.util.List;

public class GraphicsUtil {

    private final static Toolkit toolkit = Toolkit.getDefaultToolkit();
    public final static Dimension screen = toolkit.getScreenSize();

    public static void drawCoordinateSystem(Graphics2D g) {
        float[] dashes = {1, 5};
        g.drawLine(0, 0, screen.width, 0);
        g.drawLine(0, 0, 0, screen.height);
        g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, dashes, 1.0f));
        int dis = 20;
        for (int i = 0; i < screen.width; i += dis) {
            g.drawLine(i, 0, i, screen.height);
        }
        for (int i = 0; i < screen.height; i += dis) {
            g.drawLine(0, i, screen.width, i);
        }
    }

    public static void locate(Graphics2D g, Locatable shape) {
        java.util.List<Point> points = List.of(
//            shape.getTopLeft(),
//            shape.getInnerTopLeft(),
            shape.getOuterTopLeft(),
            shape.getOuterBottomLeft(),
//            shape.getInnerBottomLeft(),
//            shape.getInnerTopRight(),
            shape.getOuterTopRight(),
//            shape.getInnerBottomRight(),
            shape.getOuterBottomRight(),
            shape.getCenter()
        );

        g.setColor(Color.RED);
        int diameter = 10;
        for (Point point : points) {
            g.drawOval(point.x - diameter / 2, point.y - diameter / 2, diameter, diameter);
            g.fillOval(point.x - diameter / 2, point.y - diameter / 2, diameter, diameter);
        }
    }

}
