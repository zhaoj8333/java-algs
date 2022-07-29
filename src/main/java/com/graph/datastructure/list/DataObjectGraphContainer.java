package com.graph.datastructure.list;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;

public class DataObjectGraphContainer extends JPanel {

    private final int index;
    private static final Color backgroundColor = new Color(0x722FA6);
    private static final Color boarderColor = new Color(0x5D5792);

    public DataObjectGraphContainer(int index) {
        this.index = index;
        JTextArea jTextArea = new JTextArea(1, 1);
        jTextArea.setMargin(new Insets(10, 5, 10, 5));
        jTextArea.setText(SingleLinkedListGraphImpl.PANEL_TITLE);
        jTextArea.setEditable(false);
        jTextArea.setBackground(backgroundColor);
        jTextArea.setFont(new Font("", Font.BOLD, 17));
        jTextArea.setForeground(Color.white);
        this.add(jTextArea);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        super.paintComponent(g2d);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {

    }

    @Override
    public void setBorder(Border border) {
        super.setBorder(BorderFactory.createLineBorder(boarderColor, 5, true));
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(backgroundColor);
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
