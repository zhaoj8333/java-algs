package com.graph.practice;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class ShapePractice {

    private static class ShapeImpl extends JPanel {

        private Color color;

        public ShapeImpl(Color color) {
            this.color = color;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
//            line(g);
//            drawOvals(g);
//            rectangle(g);
//            lineWithStyle(g);
//            triangle(g);

        }

        private void triangle(Graphics g) {
            int width = this.getWidth() / 3;
            int height = this.getHeight() / 3;

            g.setColor(Color.RED);

//            int[] xs = new int[] {0, width, width / 2};
//            int[] ys = new int[] {0, 0, height};
//            Polygon polygon = new Polygon(xs, ys, 3);

            Polygon polygon = new Polygon();
            polygon.addPoint(0, height);
            polygon.addPoint(width / 2, 0);
            polygon.addPoint(width, height);

            g.drawPolygon(polygon);
            g.fillPolygon(polygon);
        }

        private void line(Graphics g) {
            setForeground(color);
            g.drawString("top", 10, 50);
            g.drawLine(10, 60, 200, 60);
            g.drawRect(200, 300, 100, 50);
            g.drawOval(200, 300, 100, 50);
        }

        private void lineWithStyle(Graphics g) {
            int centerX;
            int centerY;

            centerX = 550;
            centerY = 200;

            g.drawLine(centerX, centerY, 660, 50);
            Line2D.Double aDouble = new Line2D.Double(
                    (double) centerX + 10.0D,
                    (double) centerY + 10.0D,
                    (double) centerX + 100.0D,
                    (double) centerY + 100.0D
            );
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.MAGENTA);
//            g2d.setStroke(new BasicStroke(5));
            float[] dashpattern = {2f, 2f};
            Stroke basicStroke = new BasicStroke(
                    2f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    1.0f,
                    dashpattern,
                    2.0f
            );
            g2d.setStroke(basicStroke);
            g2d.draw(aDouble);

            Line2D.Double bDouble = new Line2D.Double(
                    (double) centerX + 120.0D,
                    (double) centerY + 120.0D,
                    (double) centerX + 180.0D,
                    (double) centerY + 180.0D
            );
            Stroke bs = new BasicStroke(12f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
            g2d.setStroke(bs);
            g2d.draw(bDouble);
//            g2d.drawLine();
        }

        private void rectangle(Graphics g) {
            int centerX = 380;
            int centerY = 100;
            int radius = 80;
            int diameter = radius * 2;
            int x = centerX - radius;
            int y = centerY - radius;

            g.setColor(Color.BLACK);

            g.drawRect(x, y, diameter, diameter);
            g.drawLine(x, y, x + diameter, y + diameter);
            g.drawLine(x, y + diameter, x + diameter, y);
            g.setColor(Color.RED);
            g.drawOval(x, y, diameter, diameter);
            g.fillOval(x, y, diameter, diameter);
        }

        private void drawOvals(Graphics g) {
            for (int i = 1; i <= 9; i++) {
                g.drawOval(50, 200, 10 + 20 * i, 210 - 20 * i);
            }
        }
    }

    public static class Triangle extends JPanel {

        int baseX = 0;
        int baseY = 0;

        @SneakyThrows
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point a = new Point(getWidth() / 2, 15);
            Point b = new Point(15, getHeight() - 15);
            Point c = new Point(getWidth() - 15, getHeight() - 15);
//            paintSierpinskiTriangle(a, b, c, g);
//            Point a = new Point(100, 100);
//            Point b = new Point(200, 100);
//            Point c = new Point((a.x + b.x) >> 1, 200);
//            System.out.println(Math.sin(Math.toRadians(120)));
//            paintTriangle(a, b, c, g, 1);
//            paintEquilateralTriangle(g);
//            paintObtuseTriangle120(g, this.baseX + (70 * 0) , this.baseY + (70 * 0));
//            paintObtuseTriangle150(g);
//            paintIsocelesTriangle(g, 0, 0, 90.0D, 200.0);
//
//            paintIsocelesTriangle(g, baseX, baseY, 130.0D, 200.0);
//            paintIsocelesTriangle(g, baseX + 100, 0, 70.0D, 200.0);

//            for (int i = 1; i < 36; i++) {
//                paintIsocelesTriangle(g, baseX + 100, baseY + 100, 10 * i, 200.0);
//            }
            paintIsocelesTriangleAndRotate((Graphics2D) g, baseX + 200, baseY + 200, 90.0D, 200.0);
        }

        private void  paintIsocelesTriangleAndRotate(Graphics2D g, int baseX, int baseY, double vertexAngle, double legLength) {
            paintIsocelesTriangle(g, baseX, baseY, vertexAngle, legLength);

            AffineTransform origlTrfm = g.getTransform();
            AffineTransform trfm = new AffineTransform();
            g.setTransform(trfm);
            g.scale(1, -1);

            for (int i = 0; i < 5; i++) {
                g.rotate(Math.toRadians(15));
            }

            g.setTransform(origlTrfm);

        }

        private void paintIsocelesTriangle(Graphics g, int baseX, int baseY, double vertexAngle, double legLength) {
            Point V = new Point(baseX + 0, baseY + 0);
            Point A = new Point();
            A.setLocation(baseX + 0, baseY + legLength);
            Point B = new Point();
            if (vertexAngle == 90.0D) {
                B.setLocation(baseX + 0 + legLength, baseY + 0);
            } else {
                B.setLocation(baseX + Math.sin(Math.toRadians(vertexAngle)) * legLength, baseY + Math.cos(Math.toRadians(vertexAngle)) * legLength);
            }
            paintSierpinskiTriangle(V, A, B, g, 1);
        }

        private void paintObtuseTriangle150(Graphics g, int baseX, int baseY) {
            Point A = new Point(baseX + 0, baseX + 0);
            Point B = new Point(baseX + 0, baseX + 100);
            Point C = new Point(((B.y - baseY) / 2) + baseX, (int) (-((B.y - baseY) * Math.sqrt(3) / 2) + baseX));
            paintSierpinskiTriangle(A, B, C, g, 1);
        }

        private void paintObtuseTriangle120(Graphics g, int baseX, int baseY) {
            Point A = new Point(baseX + 0, baseX + 0);
            Point B = new Point(baseX + 0, baseX + 100);
            Point C = new Point((int) ((B.y - baseY) * Math.sqrt(3) / 2) + baseX, -((B.y - baseY) / 2) + baseX);
            paintSierpinskiTriangle(A, B, C, g, 1);
        }

        public void paintEquilateralTriangle(Graphics g) {
            Point A = new Point(100, 100);
            Point B = new Point(200, 100);
            Point C = new Point((A.x + B.x) >> 1, (int) (A.y + A.x / 2 * (Math.sqrt(3))));
            System.out.println(C);
            paintSierpinskiTriangle(A, B, C, g, 4);
        }

        private void paintSierpinskiTriangle(Point a, Point b, Point c, Graphics g) {
            paintSierpinskiTriangle(a, b, c, g, 8);
            System.out.println(count);
        }

        private int count = 0;

        /**
         * @todo Need to be Optimized
         */
        private void paintSierpinskiTriangle(Point a, Point b, Point c, Graphics g, int iterate) {
            count++;
            if (iterate <= 0) {
                return;
            }
            g.drawLine(a.x, a.y, b.x, b.y);
            g.drawLine(a.x, a.y, c.x, c.y);
            g.drawLine(b.x, b.y, c.x, c.y);

            Point ab = getMidPoint(a, b);
            Point ac = getMidPoint(a, c);
            Point bc = getMidPoint(b, c);

            paintSierpinskiTriangle(a, ab, ac, g, iterate - 1);
            paintSierpinskiTriangle(ab, b, bc, g, iterate - 1);
            paintSierpinskiTriangle(ac, bc, c, g, iterate - 1);

        }

        private Point getMidPoint(Point a, Point b) {
            return new Point((a.x + b.x) >> 1, (a.y + b.y) >> 1);
        }
    }

    private class CustomPolygon extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
//            paintShape((Graphics2D) g);
//            paintFullStar((Graphics2D) g, baseX, baseY);
//            paintFullStar1((Graphics2D) g, baseX, baseY);
//            paintArrow((Graphics2D) g, baseX, baseY, 20, 80, 30);

            Random r = new Random();
            int targetX = r.nextInt(180) + 90;
            int targetY = r.nextInt(180) + 90;
//            System.out.println(String.format("from:  %d, %d", fromX, fromY));
//            System.out.println(String.format("to:    %d, %d", targetX, targetY));

//            paintArror((Graphics2D) g, 324, 182, 268, 190);
            paintArrowLine((Graphics2D) g, 0, 200, targetX, targetY);

        }

        private void drawCorordinateSystem(Graphics2D g) {
            float[] dashes = {2, 5};
            g.drawLine(0, 0, 800, 0);
            g.drawLine(0, 0, 0, 800);
            g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10.0f, dashes, 0));
            for (int i = 0; i < 700; i += 100) {
                g.drawLine(0, 100 + i, 800, 100 + i);
                g.drawLine(i + 100, 0, 100 + i, 800);
            }
        }

        private void paintArrowLine(Graphics2D g, int fromX, int fromY, int targetX, int targetY) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            List<Point> points = new ArrayList<>();
            points.add(new Point(fromX, fromY));
            points.add(new Point(targetX, targetY));

            List<Point> points1 = new ArrayList<>();
            points1.add(new Point(fromX, fromY));
            points1.add(new Point(targetX, targetY));

            drawLineArrow(g, points, 30, 20);
            drawCurveArrow(g, points1, 30, 20);
        }

        private void drawCurveArrow(Graphics2D g, List<Point> points, int vertexAngle, int height) {
            GeneralPath path = new GeneralPath();
            Point first = points.get(0);
            path.moveTo(first.getX(), first.getY());
            for (int i = 0; i <= points.size() - 2; i++) {
                Point curr = points.get(i);
                Point next = points.get(i + 1);
                path.curveTo((curr.x + next.x) >> 1, curr.y, (curr.x + next.x) >> 1, next.y, next.x, next.y);
            }
            drawTriangle(g, points, vertexAngle, height, first);
            g.draw(path);
            path.closePath();
        }

        private void drawLineArrow(Graphics2D g, List<Point> points, int vertexAngle, int height) {
            GeneralPath path = new GeneralPath();
            Point first = points.get(0);
            path.moveTo(first.getX(), first.getY());
            Point last = points.get(points.size() - 1);
            path.lineTo(last.getX(), last.getY());
            drawTriangle(g, points, vertexAngle, height, first);
            g.draw(path);
            path.closePath();
        }

        private void drawTriangle(Graphics2D g, List<Point> points, int vertexAngle, int height, Point first) {
            Point last = points.get(points.size() - 1);
            int foot = (int) (height * Math.tan(Math.toRadians(vertexAngle >> 1)));
            Polygon triangle = new Polygon();
            triangle.addPoint(last.x, last.y - height);
            triangle.addPoint(last.x - foot, last.y);
            triangle.addPoint(last.x + foot, last.y);

            AffineTransform newTrfm = new AffineTransform();
            AffineTransform oldTrfm = g.getTransform();
            g.setTransform(newTrfm);
            double rotateDegree = 90 + Math.toDegrees(Math.atan2(last.y - first.y, last.x - first.x));
            newTrfm.rotate(Math.toRadians(rotateDegree), last.getX(), last.getY());
            g.setTransform(newTrfm);
            g.draw(triangle);
            g.fill(triangle);
            g.setTransform(oldTrfm);
        }

        private void paintFullStar1(Graphics2D g, int baseX, int baseY) {
            int centerX = 0;
            int centerY = 0;
            int sideLength = 150;

            double AC = sideLength * Math.sin(Math.toRadians(126)) / Math.sin(Math.toRadians(36));
            double AH = sideLength * Math.cos(Math.toRadians(18));
            double aX = 0;
            double aY = -AC;
            double BH = sideLength * Math.sin(Math.toRadians(18));
            double bX = -BH;
            double bY = -(AC - AH);
            double dX = -bX;
            double dY = bY;
            g.setColor(Color.RED);

            AffineTransform trfm = new AffineTransform();
            AffineTransform oldTrfm = g.getTransform();
            g.setTransform(trfm);
            for (int i = 0; i < 5; i++) {
                GeneralPath path = new GeneralPath();
                path.moveTo(baseX + centerX, baseY + centerY);

                path.lineTo(baseX + aX, baseY + aY);
                path.lineTo(baseX + bX, baseY + bY);
                path.lineTo(baseX, baseY);
                path.lineTo(baseX + aX, baseY + aY);
                g.fill(path);
                path.lineTo(baseX + dX, baseY + dY);
                path.lineTo(baseX, baseY);
                path.closePath();
                g.draw(path);

                g.rotate(Math.toRadians(72), baseX, baseY);
            }
            g.setTransform(oldTrfm);

        }

        /**
         * Draw a star: each vertex angle of a star is 36 degrees
         * @param g
         */
        private void paintFullStar(Graphics2D g, int baseX, int baseY) {
            int centerX = 0;
            int centerY = 0;
            int sideLength = 100;
            GeneralPath path = new GeneralPath();
            path.moveTo(baseX + centerX, baseY + centerY);

            double AC = sideLength * Math.sin(Math.toRadians(126)) / Math.sin(Math.toRadians(36));
            double AH = sideLength * Math.cos(Math.toRadians(18));
            double aX = 0;
            double aY = -AC;
            double BH = sideLength * Math.sin(Math.toRadians(18));
            double bX = -BH;
            double bY = -(AC - AH);
            double dX = -bX;
            double dY = bY;
            path.lineTo(baseX + bX, baseY + bY);
            path.lineTo(baseX + aX, baseY + aY);
            path.lineTo(baseX + dX, baseY + dY);
            g.setColor(Color.RED);
            path.lineTo(baseX, baseY);
            path.closePath();
            g.draw(path);
            g.fill(path);

            AffineTransform trfm = new AffineTransform();
            AffineTransform oldTrfm = g.getTransform();
            g.setTransform(trfm);
            for (int i = 0; i < 4; i++) {
                g.rotate(Math.toRadians(72), baseX, baseY);
                g.draw(path);
                g.fill(path);
            }
            g.setTransform(oldTrfm);

        }

        private void paintShape(Graphics2D g) {

            int[] x = { -20, 0, 20, 0 };
            int[] y = { 20, 10, 20, -20 };

            GeneralPath p = new GeneralPath();
            p.moveTo(x[0], y[0]);

            for (int i = 1; i < x.length; i++) {
                p.lineTo(x[i], y[i]);
            }
            p.closePath();
            g.translate(100, 100);
            g.draw(p);

        }
    }

    public ShapePractice() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            JFrame jf = new JFrame(ShapePractice.class.getName());
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(new Dimension(1202, 900));
            jf.setLayout(new BorderLayout());
//            jf.testAdd(new ShapeImpl(Color.RED));
//            jf.testAdd(new Triangle());
            jf.add(new CustomPolygon());
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new ShapePractice();
    }

}
