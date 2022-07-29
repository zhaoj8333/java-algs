package com.graph.datastructure.list;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;

public class ObjectGraphContainerTest {

    @SneakyThrows
    public static void main(String[] args) {

        JFrame jf = new JFrame("Test");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(new Dimension(1224, 639));
        jf.setLayout(new FlowLayout());

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

//        for (int i = 0; i < 10; i++) {
//            DataObjectGraphContainer rec = new DataObjectGraphContainer(i);
//            jf.add(rec, i);
//            jf.revalidate();
//            Thread.sleep(300);
//        }
        DataObjectGraphContainer dogc = new DataObjectGraphContainer(0);
        jf.add(dogc);

        ObjectFieldGraphContainer size = new ObjectFieldGraphContainer("size", false, null);
        dogc.add(size);
        jf.revalidate();
        Thread.sleep(500);

        ObjectFieldGraphContainer next = new ObjectFieldGraphContainer("next", true, jf.getGraphics());
        Point location = next.getLocation();
        next.setLocation(location.x, location.y + 20);
        dogc.add(next);
        jf.revalidate();
        jf.update(jf.getGraphics());

    }


}
