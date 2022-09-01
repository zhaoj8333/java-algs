package com.graph.object;

import com.algs.util.ObjectUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Line2D;

public class FieldGraph extends JPanel {

    private static final Color backgroundColor = new Color(0x04B0F3);
    private static final Color boarderColor = new Color(0x3961AE);
    private boolean isPointer;
    private Graphics parentGraphics;

    public FieldGraph(String name, boolean isPointer, Graphics parentGraphics) {
        if (isPointer) {
            ObjectUtil.requireNonNull(parentGraphics);
            this.parentGraphics = parentGraphics;
            this.isPointer = true;
        }
        this.isPointer = isPointer;
        JTextArea jTextArea = new JTextArea(1, 1);
        jTextArea.setText(name);
        jTextArea.setEditable(false);
        jTextArea.setMargin(new Insets(14, 5, 0, 5));
        jTextArea.setBackground(backgroundColor);
        jTextArea.setFont(new Font("", Font.BOLD, 15));
        jTextArea.setForeground(Color.white);
        add(jTextArea);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Point location = this.getLocation();
        double x = location.getX() + (this.getWidth() >> 1);
        double y = location.getY();
        double anchorX = x + this.getWidth();
        double anchorY = y;
        if (isPointer) {

//            parentGraphics.drawLine((int) x, (int) y, (int) anchorX, (int) anchorY);
//            System.out.println(String.format("%f, %f, %f, %f", x, y, anchorX, anchorY));

        }

//        parentGraphics.drawOval((int) x - 5, (int) y - 5, 10, 10);


//        parentGraphics.setColor(Color.RED);
//        parentGraphics.drawLine((int) x, (int) y, (int) anchorX, (int) anchorY);

        super.paintComponent(g2d);


    }

    @Override
    public void setBorder(Border border) {
        super.setBorder(BorderFactory.createLineBorder(boarderColor, 0, true));
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(backgroundColor);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 56);
    }

}
