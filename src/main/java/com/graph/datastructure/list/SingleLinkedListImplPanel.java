package com.graph.datastructure.list;

import javax.swing.*;
import java.awt.*;

public class SingleLinkedListImplPanel extends JPanel {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final String PANEL_TITLE = "Single Linked List";

    public SingleLinkedListImplPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // setLayout();
        // add();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.LIGHT_GRAY);
    }

}
