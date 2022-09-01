package com.graph.object;

import javax.swing.*;
import java.awt.*;

public class AlgoWindow extends JFrame {

    public static Dimension dimension = new Dimension(
            GraphConstants.ALGS_WINDOW_WIDTH,
            GraphConstants.ALGS_WINDOW_HEIGHT
    );

    public AlgoWindow(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void setLayout(LayoutManager manager) {
        super.setLayout(new BorderLayout());
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(dimension);
    }

    @Override
    public void setLocationRelativeTo(Component c) {
        super.setLocationRelativeTo(null);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(true);
    }
}
