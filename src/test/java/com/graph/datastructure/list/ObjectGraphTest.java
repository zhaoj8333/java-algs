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
            jf.add(new ObjectGraph<>(new SingleLinkedListImpl<>()));
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new ObjectGraphTest();
    }

}
