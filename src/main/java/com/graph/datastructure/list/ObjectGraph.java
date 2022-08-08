package com.graph.datastructure.list;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.intellij.lang.annotations.JdkConstants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObjectGraph<O> extends JPanel {

    private O object;
    private String name;
    private ObjectGraph<O> parentObject;
    private final List<Field> fields = new ArrayList<>(4);

    public ObjectGraph() {
        this.name = "Null";
    }

    public ObjectGraph(@NonNull O object) {
        this.object = object;
        this.parseObject(object);
    }

    private void parseObject(Object obj) {
        Class<?> clazz = obj.getClass();
        try {
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            this.name = (String) clazz.getDeclaredMethod("getName").invoke(object);
        } catch (ReflectiveOperationException e) {
            this.name = clazz.getSimpleName().replace("Impl", "");
        }
        appendFields(clazz);
    }

    private void appendFields(Class<?> clazz) {
        if (Objects.isNull(clazz) || Objects.isNull(clazz.getClassLoader())) {
            return;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        fields.addAll(Arrays.asList(declaredFields));
        Class<?> superclass = clazz.getSuperclass();
        appendFields(superclass);
    }

    public int getNodeWidth() {
        return 150;
    }

    private int getNodeHeight() {
        return 200;
    }

    private int getNodeStartX() {
        return 60;
    }

    private int getNodeStartY() {
        return 60;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
        drawObject(g, this, false);
    }

    private void drawStringInRect(Graphics2D g, String content, int rectX, int rectY, int rectWidth, int rectHeight) {

    }

    public void drawObject(Graphics2D g, ObjectGraph<O> object, boolean verticalAlignMiddle) {

        g.setColor(new Color(Integer.parseInt("5D5792", 16)));
        BasicStroke basicStroke = new BasicStroke(5.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f);
        g.setStroke(basicStroke);
        g.drawRect(object.getNodeStartX(), object.getNodeStartY(), object.getNodeWidth(), object.getNodeHeight());
        g.setColor(new Color(Integer.parseInt("722FA5", 16)));
        g.fillRect(object.getNodeStartX(), object.getNodeStartY(), object.getNodeWidth(), object.getNodeHeight());

        Font font = new Font(null, Font.BOLD, (int) (1.6 * (this.getNodeWidth()) / this.name.length()));
        FontMetrics fontMetrics = g.getFontMetrics(font);
        int x = this.getNodeStartX() + (this.getNodeWidth() - fontMetrics.stringWidth(this.name)) / 2;
        int y = this.getNodeStartY() + font.getSize() + 5;
        if (verticalAlignMiddle) {
            y = this.getNodeStartY() + ((this.getNodeHeight() - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        }
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(this.name, x, y);

        drawFields(g);
    }

    private void drawFields(Graphics2D g) {
        BasicStroke basicStroke = new BasicStroke(3.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 5.0f);
        g.setStroke(basicStroke);
        for (int i = 0; i < this.fields.size(); i++) {
            g.setColor(new Color(Integer.parseInt("3383C8", 16)));
            int x = this.getNodeStartX() + 3;
            int y = this.getNodeStartY() + (i * 100) + 30;
            int width = this.getNodeWidth() - 6;
            int height = 40;
            g.drawRect(x, y, width, height);
            g.setColor(new Color(Integer.parseInt("04B0F3", 16)));
            g.fillRect(x, y, width, height);

            g.setColor(Color.WHITE);
            g.drawString(this.fields.get(i).getName(), x, y + 10);
            repaint();
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
