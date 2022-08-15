package com.algs.util;

import java.awt.*;

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


}
