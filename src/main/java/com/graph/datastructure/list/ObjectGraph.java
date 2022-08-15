package com.graph.datastructure.list;

import com.algs.util.GraphicsUtil;
import lombok.NonNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;

public class ObjectGraph<O> extends JPanel {

    public String title = "LinkedList";
    private O object;
    private ShapeWithBorder shape;
    private final List<RectangleObject> fields = new ArrayList<>();

    public ObjectGraph() {
        prepareObject();
    }

    public ObjectGraph(@NonNull O dataObject, ShapeWithBorder location) {
        this.object = dataObject;
        this.shape = location;
        prepareObject();
    }

    private void prepareObject() {
        if (Objects.isNull(object)) {
            fields.add(null);
            return;
        }
        prepare(object);
    }

    private void prepare(O object) {
        Class<?> thisClass = object.getClass();
        Class<?> superClass = thisClass;
        while (Objects.nonNull(superClass)) {
            Field[] declaredFields = superClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                String fieldName = declaredField.getName();
                char[] chars = fieldName.toCharArray();
                chars[0] = (char) (chars[0] - ('a' - 'A'));
                String getterMethod = "get" + new String(chars);
                try {
                    Method declaredMethod = superClass.getDeclaredMethod(getterMethod);
                    Object fieldObj = declaredMethod.invoke(object);
                    // todo
                    ClassLoader classLoader = fieldObj.getClass().getClassLoader();
                    fields.add(new RectangleObject(Objects.nonNull(classLoader)));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            superClass = superClass.getSuperclass();
        }
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        GraphicsUtil.drawCoordinateSystem(g);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(Color.GREEN);
//        BasicStroke stroke = new BasicStroke(shape.borderWidth, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
//        g.setStroke(stroke);
//        g.drawRect(shape.topLeft.x, shape.topLeft.y, shape.shapeWidth, shape.shapeHeight);

//        g.setStroke(new BasicStroke());
//        g.setColor(Color.RED);

        locate(g);
//        draw(g);

    }

    public void locateByLine(Graphics2D g) {
        int outerWidth = shape.getOuterWidth();
        int innerWidth = shape.getInnerWidth();
        Point topLeft = shape.getOuterTopLeft();
        Point innerTopLeft = shape.getInnerTopLeft();
        g.drawLine(topLeft.x, topLeft.y, topLeft.x + outerWidth - 1, topLeft.y);

        g.drawLine(innerTopLeft.x, innerTopLeft.y, innerTopLeft.x + innerWidth - 1, innerTopLeft.y);

        int outerHeight = shape.getOuterHeight();
        int innerHeight = shape.getInnerHeight();
        g.drawLine(topLeft.x, topLeft.y, topLeft.x, topLeft.y + outerHeight - 1);
        g.drawLine(innerTopLeft.x, innerTopLeft.y, innerTopLeft.x, innerTopLeft.y + innerHeight - 1);
    }

    public void locate(Graphics2D g) {
        java.util.List<Point> points = List.of(
            shape.getTopLeft(),
            shape.getInnerTopLeft(),
            shape.getOuterTopLeft(),
            shape.getOuterBottomLeft(),
            shape.getInnerBottomLeft(),
            shape.getInnerTopRight(),
            shape.getOuterTopRight(),
            shape.getInnerBottomRight(),
            shape.getOuterBottomRight(),
            shape.getCenter()
        );

        g.setColor(Color.RED);
        int diameter = 6;
        for (Point point : points) {
            g.drawOval(point.x - diameter / 2, point.y - diameter / 2, diameter, diameter);
            g.fillOval(point.x - diameter / 2, point.y - diameter / 2, diameter, diameter);
        }
    }

    public void draw(Graphics2D g) {

        g.setColor(new Color(Integer.parseInt("5D5792", 16)));
        BasicStroke stroke = new BasicStroke(5.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f);
        g.setStroke(stroke);

        Font font = new Font(null, Font.BOLD, (int) (1.6 * (shape.shapeWidth) / title.length()));
        FontMetrics fontMetrics = g.getFontMetrics(font);
        int x = shape.getTopLeft().x + (shape.getShapeWidth() - fontMetrics.stringWidth(title)) / 2;
        int y = shape.getTopLeft().x + font.getSize() + fontMetrics.getAscent() - 5;

        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString(title, x, y);


        Class<?> superClass = object.getClass();
        while (Objects.nonNull(superClass)) {
            Field[] declaredFields = superClass.getDeclaredFields();
            try {
                for (int i = 0; i < declaredFields.length; i++) {
                    String fieldName = declaredFields[i].getName();
                    String drawString = fieldName;
                    char[] chars = fieldName.toCharArray();
                    chars[0] = (char) (chars[0] - ('a' - 'A'));
                    String getterMethod = "get" + new String(chars);
                    try {
                        Method declaredMethod = superClass.getDeclaredMethod(getterMethod);
                        Object fieldObj = declaredMethod.invoke(object);
                        ClassLoader classLoader = fieldObj.getClass().getClassLoader();
                        if (Objects.isNull(classLoader)) {
                            drawString += " (" + fieldObj + ")";
//                            System.out.println("-------- null classloader : " + drawString);
                        } else {
//                            drawString = ;
                        }
                    } catch (NoSuchMethodException e) {

                    }
                    g.setColor(new Color(Integer.parseInt("3961AE", 16)));
                    g.drawRect(shape.getTopLeft().x, shape.getTopLeft().y, shape.getShapeWidth(), 30);
                    g.setColor(new Color(Integer.parseInt("04B0F3", 16)));
                    g.fillRect(this.shape.getTopLeft().x, shape.getTopLeft().y, shape.getShapeWidth(), 30);

                    g.setColor(Color.WHITE);
                    font = new Font(null, Font.BOLD, (int) (1.6 * (shape.getShapeWidth()) / title.length()));
                    fontMetrics = g.getFontMetrics(font);
                    x = shape.getTopLeft().x + (shape.getShapeWidth() - fontMetrics.stringWidth(title)) / 2;
                    y = shape.getTopLeft().y + font.getSize() + fontMetrics.getAscent() - 10;
                    g.drawString(drawString, x, y);
                }
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
            superClass = superClass.getSuperclass();
        }



    }

    @Override
    public void setComponentZOrder(Component comp, int index) {
        super.setComponentZOrder(comp, -100);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {

        System.out.println("Mouse Event");
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        GridLayout gridLayout = new GridLayout();
        super.setLayout(gridLayout);
    }

    @Override
    public void setFont(Font font) {
        font = new Font("", Font.BOLD, 20);
        super.setFont(font);
    }

    // @TODO
    @Override
    public void setToolTipText(String text) {
        super.setToolTipText("hhhhhhhhhhhh");
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(168, 200);
    }
}
