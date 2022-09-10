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
}
