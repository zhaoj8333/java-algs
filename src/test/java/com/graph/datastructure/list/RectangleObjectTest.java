package com.graph.datastructure.list;

import com.graph.object.intrusive.node.RectangleObject;
import com.graph.practice.ShapePractice;

import javax.swing.*;
import java.awt.*;

public class RectangleObjectTest {

    private RectangleObject object;

    public RectangleObjectTest() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JFrame jf = new JFrame(ShapePractice.class.getName());
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(new Dimension(1502, 900));
            jf.setLayout(new BorderLayout());

            object = new RectangleObject();
//            object.setShapeWidth(120);
//            object.setShapeHeight(200);
//            object.setBorderWidth(1);
//            object.setFieldMargin(10);
//
//            jf.testAdd(object);
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);

            System.out.println(object.getOuterTopLeft());

        });
    }

    public static void main(String[] args) {
        RectangleObjectTest test = new RectangleObjectTest();
    }

}