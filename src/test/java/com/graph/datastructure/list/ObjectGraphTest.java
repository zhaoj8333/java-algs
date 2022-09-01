package com.graph.datastructure.list;

import com.algs.datastructure.list.SingleLinkedListImpl;
import com.graph.object.AlgoWindow;
import com.graph.object.ObjectGraph;
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
            JFrame jf = new AlgoWindow(ShapePractice.class.getName());

            SingleLinkedListImpl<String> list = new SingleLinkedListImpl<>();
            list.add(null);

            jf.add(new ObjectGraph<>(list));
            jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jf.setSize(AlgoWindow.dimension);
            jf.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new ObjectGraphTest();
    }

}
