package com.graph.datastructure.list;

import com.algs.datastructure.list.Node;
import com.algs.datastructure.list.SingleLinkedListImpl;
import com.algs.util.ObjectUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SingleLinkedListGraphImpl<E> {

    public static final int WIDTH;
    public static final int HEIGHT;

    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) ((int) screenSize.getWidth() * 0.75);
        HEIGHT = (int) ((int) screenSize.getHeight() * 0.75);
    }

    public static final String PANEL_TITLE = "SinglyLinkedList";

    private final SingleLinkedListImpl<E> data;
    private JFrame frame;
    private JPanel panel;

    public SingleLinkedListGraphImpl(SingleLinkedListImpl<E> data) {
        ObjectUtil.requireNonNull(data);
        initWindow();
        this.data = data;
        drawObject();
        if (Objects.nonNull(data.getHead())) {

        }
        drawNode(data.getHead());
    }

    private void drawObject() {

    }

    private void initWindow() {
        frame = new JFrame(PANEL_TITLE);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(null);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private void drawNode(Node<E> dataNode) {
        while (Objects.nonNull(dataNode)) {
//            String s = String.valueOf(dataNode.element);

            dataNode = dataNode.next;
            drawNode(dataNode);
        }
    }

}
