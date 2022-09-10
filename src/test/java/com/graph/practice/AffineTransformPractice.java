package com.graph.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

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

    public AffineTransformPractice() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        BasicStroke stroke = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2.setStroke(stroke);

//        rotate(g2);
        move(g2);
//        flip(g2);
   }

    private void flip(Graphics2D g2) {
        flipDot(g2);


    }

    private void flipDot(Graphics2D g) {
        g.fillOval(20, 20, 10, 10);

    }

    private void move(Graphics2D g) {
        moveDot(g);
//        moveLine(g);
    }

    private void moveLine(Graphics2D g) {
        g.drawLine(20, 20, 100, 10);
        AffineTransform newTrfm = new AffineTransform();
        AffineTransform trfm = g.getTransform();
        g.setTransform(newTrfm);
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            g.drawLine(40, 40, 220, 20);
            g.translate(10, 10);
        }
        g.setTransform(trfm);
    }

    private void moveDot(Graphics2D g) {
        g.fillOval(20, 20, 10, 10);

        AffineTransform newTrfm = new AffineTransform();
        AffineTransform trfm = g.getTransform();
        g.setTransform(newTrfm);
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            g.fillOval(40, 40, 10, 10);
            g.translate(10, 10);
        }
        g.setTransform(trfm);
    }

    private void rotate(Graphics2D g) {
//        rotateDot(g);
        rotateLine(g);
    }

    private void rotateDot(Graphics2D g) {
       AffineTransform trfm = g.getTransform();
        AffineTransform newTrfm = new AffineTransform();
        g.setTransform(newTrfm);
//        for (int i = 0; i < 9; i++) {
//            g.fillOval(250, 10, 10, 10);
//            g.rotate(Math.toRadians(15));
//            newTrfm.rotate(Math.toRadians(10));
//        }
        int x = 250;
        int y = 10;
        int w = 10;
        int h = 10;
        g.fillOval(250, 10, 10, 10);
        for (int i = 0; i < 10; i++) {
            g.fillOval(x, y, w, h);
            g.translate(-10, 8);
        }
        g.setTransform(trfm);

//        Line2D.Double aDouble = new Line2D.Double(100, 100, 200, 200);
//        g.draw(aDouble);

    }

    private void rotateLine(Graphics2D g) {
        g.setColor(Color.RED);
        g.setStroke(new BasicStroke(3));
        int x = 300;
        int y = 300;
        Line2D.Double aDouble1 = new Line2D.Double(x, y, 270, 40);

        AffineTransform transform1 = g.getTransform();
        AffineTransform tfm = new AffineTransform();
        g.setTransform(tfm);
//        g.draw(aDouble1);
        for (int i = 0; i < 24; i++) {
            g.draw(aDouble1);
//            tfm.rotate(Math.toRadians(15.0), x, y);
            tfm.rotate(Math.toRadians(15.0));
//            g.setTransform(tfm);
        }
        g.setTransform(transform1);
    }

    private void arrowHeadRotate(Graphics2D g) {
        int [] polygonXs = { -20, 0, 20, 0 };
        int [] polygonYs = { 20, 10, 20, -20 };
        Shape shape = new Polygon(polygonXs, polygonYs, polygonXs.length);
        double x = 50.0, y = 50.0;
        setBackground(Color.LIGHT_GRAY);
        Graphics2D g2d = g;
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
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            JFrame jf = new JFrame("Affine Transform");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(new Dimension(1202, 900));
            jf.setLayout(new BorderLayout());
//            jf.testAdd(new ShapeImpl(Color.RED));
            jf.add(new AffineTransformPractice());
//            jf.testAdd();
//            jf.testAdd(new CustomPolygon());
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        });
    }

}
