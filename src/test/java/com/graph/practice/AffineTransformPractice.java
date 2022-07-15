package com.graph.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;

/**
 * link:
 * https://zetcode.com/gfx/java2d/basicdrawing/
 * https://www.infoworld.com/article/2076715/getting-started-with-java-2d.html
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J8b_Game_2DGraphics.html
 * https://docs.oracle.com/javase/tutorial/2d/TOC.html
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html
 */
public class AffineTransformPractice extends JPanel {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final String PANEL_TITLE = AffineTransformPractice.class.getName();

    // Define an arrow shape using a polygon centered at (0, 0)
//    int [] polygonXs = { 30, 50, 70, 50 };
//    int [] polygonYs = { 70, 60, 70, 30 };

    int [] polygonXs = { -20, 0, 20, 0 };
    int [] polygonYs = { 20, 10, 20, -20 };
    Shape shape = new Polygon(polygonXs, polygonYs, polygonXs.length);
    double x = 50.0, y = 50.0;

    public AffineTransformPractice() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
        Graphics2D g2d = (Graphics2D) g;
//
        AffineTransform transform = g2d.getTransform();
        /**
         * Allocate a new {@link AffineTransform}
         */
        AffineTransform identity = new AffineTransform();
        g2d.setTransform(identity);
//
//        g2d.setColor(Color.GREEN);
//        g2d.fill(shape);

        g2d.translate(x, y);    // translate from(0, 0) to (x, y) position
        g2d.scale(1.2, 1.2);  // scaling
        g2d.fill(shape);

        for (int i = 0; i < 5; i++) {
            g2d.translate(50.0, 5.0);
            g2d.setColor(Color.BLUE);
            g2d.fill(shape);
            g2d.rotate(Math.toRadians(15.0));
            g2d.setColor(Color.RED);
            g2d.fill(shape);
        }
        g2d.setTransform(transform);    // restore the saved transform before exit
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(PANEL_TITLE);
        frame.setContentPane(new AffineTransformPractice());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
