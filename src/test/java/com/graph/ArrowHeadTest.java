package com.graph;

import com.graph.element.ArrowPanel;

import javax.swing.*;
import java.awt.*;

public class ArrowHeadTest {

    public ArrowHeadTest() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            ArrowPanel arrows = new ArrowPanel();

            @Override
            public void run() {

                JFrame f = new JFrame("Arrows");

                f.add(new ArrowPanel());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(new Dimension(1224, 639));
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

}
