package com.algs;

import com.algs.datastructure.collection.queue.IQueue;
import com.algs.datastructure.collection.queue.link.LinkedQueueImpl;
import com.algs.utils.DrawUtil;
import java.awt.BasicStroke;
import java.awt.Color;

public abstract class ImplComplexityGrowthCompareAnalysis<E> {

    protected static final int n = 512;
    protected static final int y = (int) ((98 * n) / 2.6);
    private static final IQueue<Color> colors = new LinkedQueueImpl<>();

    static {
        Color[] c = new Color[] {
                Color.RED,
                Color.green,
                Color.magenta,
                Color.orange,
                Color.cyan,
                Color.pink,
                Color.blue
        };
        for (Color color : c) {
            colors.enque(color);
        }
    }

    public abstract void drawReferenceLine();

    protected abstract Object construct(Class<?> targetClass, int offset);

    protected abstract void execEach(Object obj);

    public void analyze(Class<?>[] targetClasses) {
        for (Class<?> klass : targetClasses) {
            Color color = colors.deque();
            DrawUtil.setPenColor(color);
            System.out.println("Testing: " + klass.getName() + ", " + color.toString());
            for (int i = 0; i < n; i++) {
                Object targetObject = construct(klass, i);
                execEach(targetObject);
            }
        }
    }

    public void drawCoordinate() {
        DrawUtil.setCanvasSize();
        DrawUtil.setXscale(0, n * 0.75);
        DrawUtil.setYscale(0, y);
        DrawUtil.setPenRadius(0.006);
        DrawUtil.setPenColor();

        float[] dash = {1, 5};
        BasicStroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0F, dash, 0.0f);
        int c = n / 20;
        for (int i = 0; i < n; i += c) {
            if (i == 0) {
                DrawUtil.setPenRadius(0.006);
            } else {
                DrawUtil.setPenRadius(0.001);
                DrawUtil.line(i, 0, i, y, stroke);
            }
        }
        double v = y / 20;
        for (int i = 0; i < y; i += v) {
            if (i == 0) {
                DrawUtil.setPenRadius(0.006);
            } else {
                DrawUtil.setPenRadius(0.001);
                DrawUtil.line(0, i, n, i, stroke);
            }
        }
    }

    public abstract void analyze();

}
