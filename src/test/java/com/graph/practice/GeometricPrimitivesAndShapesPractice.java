package com.graph.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Java 2D primitives includes:
 *  point({@link java.awt.geom.Point2D}
 *  line {@link java.awt.geom.Line2D}
 *  rectagular shapes:
 *      {@link java.awt.geom.RectangularShape},
 *      {@link java.awt.geom.RoundRectangle2D}
 *      {@link java.awt.geom.Ellipse2D}
 *      {@link java.awt.geom.Arc2D}
 *      {@link java.awt.geom.Dimension2D}
 *
 *  quadratic and cubic curves with control points:
 *      {@link java.awt.geom.QuadCurve2D}
 *      {@link java.awt.geom.CubicCurve2D}
 *
 *  arbitrary shapes
 *      {@link java.awt.geom.Path2D}
 *
 *  Xxx2D classes have two nested public static subclass XXX2D, Double and Float to support different precision rendering
 *  (thus leads to different accuracy and smoothness)
 */
public class GeometricPrimitivesAndShapesPractice extends JPanel {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final String PANEL_TITLE = AffineTransformPractice.class.getName();

    public GeometricPrimitivesAndShapesPractice() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);

        int[] x = { -20, 0, 20, 0 };
        int[] y = { 20, 10, 20, -20 };

        GeneralPath p = new GeneralPath();
        p.moveTo(x[0], y[0]);

        for (int i = 1; i < x.length; i++) {
            p.lineTo(x[i], y[i]);
        }
        p.closePath();

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(350, 250);
        g2d.draw(p);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(PANEL_TITLE);
        frame.setContentPane(new GeometricPrimitivesAndShapesPractice());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
