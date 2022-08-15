package com.graph.datastructure.list;

import com.algs.datastructure.list.SingleLinkedListImpl;
import com.graph.practice.ShapePractice;

import javax.swing.*;
import java.awt.*;

public class ObjectGraphTest {

    public ObjectGraphTest() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JFrame jf = new JFrame(ShapePractice.class.getName());
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setSize(new Dimension(1202, 900));
            jf.setLayout(new BorderLayout());
            RectangleObject linkedList = new RectangleObject(new Point(100, 100));
            linkedList.setShapeHeight(220);
            linkedList.setShapeWidth(140);
            linkedList.setBorderWidth(20);
            jf.add(new ObjectGraph<>(new SingleLinkedListImpl<>(), linkedList));
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new ObjectGraphTest();
    }

}
