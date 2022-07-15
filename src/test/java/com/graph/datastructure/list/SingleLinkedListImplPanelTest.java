package com.graph.datastructure.list;

import org.junit.Test;

import javax.swing.*;
import java.io.IOException;

public class SingleLinkedListImplPanelTest {

    @Test
    public void test() {
//        SingleLinkedListImplPanel sslp = new SingleLinkedListImplPanel();

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                start();
//            }
//        });
//
        start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private void start() {
        JFrame jFrame = new JFrame(SingleLinkedListImplPanel.PANEL_TITLE);
        jFrame.setContentPane(new SingleLinkedListImplPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * {@link JFrame} doesn't set its size, but packs its components by invoking pack()
         */
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }

}
