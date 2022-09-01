package com.graph.object;

import javax.swing.*;
import java.awt.*;

public class ObjectGraph<O> extends JPanel {

    private ObjectDrawer objectDrawer;

    public ObjectGraph(O dataObject) {
        objectDrawer = new ObjectDrawer(dataObject);
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;

        objectDrawer.setG(g);
        objectDrawer.draw();
    }

    /**
     * @param stop if object tree is too deep, stop drawing
     */
//    public void drawShape(Graphics2D g, boolean stop) {
//
//        g.setColor(new Color(Integer.parseInt("5D5792", 16)));
//        BasicStroke stroke = new BasicStroke(5.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f);
//        g.setStroke(stroke);
//
//        Font font = new Font(null, Font.BOLD, (int) (1.6 * (shape.getShapeWidth()) / "".length()));
//        FontMetrics fontMetrics = g.getFontMetrics(font);
//        int x = shape.getTopLeft().x + (shape.getShapeWidth() - fontMetrics.stringWidth("")) / 2;
//        int y = shape.getTopLeft().x + font.getSize() + fontMetrics.getAscent() - 5;
//
//        g.setColor(Color.RED);
//        g.setFont(font);
//        g.drawString(title, x, y);

//
//        Class<?> superClass = object.getClass();
//        while (Objects.nonNull(superClass)) {
//            Field[] declaredFields = superClass.getDeclaredFields();
//            try {
//                for (int i = 0; i < declaredFields.length; i++) {
//                    String fieldName = declaredFields[i].getName();
//                    String drawString = fieldName;
//                    char[] chars = fieldName.toCharArray();
//                    chars[0] = (char) (chars[0] - ('a' - 'A'));
//                    String getterMethod = "get" + new String(chars);
//                    try {
//                        Method declaredMethod = superClass.getDeclaredMethod(getterMethod);
//                        Object fieldObj = declaredMethod.invoke(object);
//                        ClassLoader classLoader = fieldObj.getClass().getClassLoader();
//                        if (Objects.isNull(classLoader)) {
//                            drawString += " (" + fieldObj + ")";
////                            System.out.println("-------- null classloader : " + drawString);
//                        } else {
////                            drawString = ;
//                        }
//                    } catch (NoSuchMethodException e) {
//
//                    }
//                    g.setColor(new Color(Integer.parseInt("3961AE", 16)));
//                    g.drawRect(shape.getTopLeft().x, shape.getTopLeft().y, shape.getShapeWidth(), 30);
//                    g.setColor(new Color(Integer.parseInt("04B0F3", 16)));
//                    g.fillRect(this.shape.getTopLeft().x, shape.getTopLeft().y, shape.getShapeWidth(), 30);
//
//                    g.setColor(Color.WHITE);
//                    font = new Font(null, Font.BOLD, (int) (1.6 * (shape.getShapeWidth()) / title.length()));
//                    fontMetrics = g.getFontMetrics(font);
//                    x = shape.getTopLeft().x + (shape.getShapeWidth() - fontMetrics.stringWidth(title)) / 2;
//                    y = shape.getTopLeft().y + font.getSize() + fontMetrics.getAscent() - 10;
//                    g.drawString(drawString, x, y);
//                }
//            } catch (ReflectiveOperationException e) {
//                e.printStackTrace();
//            }
//            superClass = superClass.getSuperclass();
//        }

//    }

}
