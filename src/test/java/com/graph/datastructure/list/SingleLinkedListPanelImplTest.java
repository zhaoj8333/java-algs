package com.graph.datastructure.list;

import com.algs.datastructure.collection.list.SinglyLinkedListImpl;

import javax.swing.*;
import java.awt.*;

//import org.apache.commons.lang.RandomStringUtils;

public class SingleLinkedListPanelImplTest {

    public static void main(String[] args) throws InterruptedException {

//        nullLayout();

//        label();

//        jframe();

//        jDialog();

        SinglyLinkedListImpl<String> ssl = new SinglyLinkedListImpl<>();
        for (int i = 0; i < 10; i++) {
//            ssl.testAdd(RandomStringUtils.random(5));
        }
        SingleLinkedListGraphImpl<String> sllp = new SingleLinkedListGraphImpl<>(ssl);

    }

    private static void jDialog() {
        JFrame jf = new JFrame(SingleLinkedListGraphImpl.PANEL_TITLE);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setSize(new Dimension(SingleLinkedListGraphImpl.WIDTH, SingleLinkedListGraphImpl.HEIGHT));
        JPanel jp = new JPanel();

        JButton click = new JButton("delete");
        click.setBackground(Color.RED);
        click.setPreferredSize(new Dimension(140, 40));
        click.addActionListener(e -> {
            JOptionPane.showConfirmDialog(jf, "Are you sure", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        });
        Box vbox = Box.createVerticalBox();
        vbox.add(click);
        jp.add(vbox);

        JButton get = new JButton("click me");
        get.setBackground(Color.RED);
        get.setPreferredSize(new Dimension(140, 40));
        get.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(jf, "", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            System.out.println(result);
        });
        Box box = Box.createVerticalBox();
        vbox.add(get);
        jp.add(box);

        JButton input = new JButton("select");
        input.setBackground(Color.RED);
        input.setPreferredSize(new Dimension(140, 40));
        String[] strings = {"CN", "JP", "US"};
        input.addActionListener(e -> {
            String o = (String) JOptionPane.showInputDialog(jf, "Select", "Confirm", JOptionPane.PLAIN_MESSAGE, null, strings, "CHINA");
            System.out.println(o);
        });
        Box abox = Box.createVerticalBox();
        vbox.add(input);
        jp.add(abox);

        JButton modal = new JButton("show modal");
        modal.setPreferredSize(new Dimension(140, 40));
        modal.addActionListener(e -> {
            JDialog warning = new JDialog(jf, "warning", true);
            warning.setSize(250, 150);
            warning.setResizable(false);
            warning.setLocationRelativeTo(null);
            JLabel c = new JLabel("content");
            JButton btn = new JButton("confirm");
            btn.addActionListener(e1 -> warning.dispose());
            JPanel jp1 = new JPanel();
            jp1.add(btn);
            jp1.add(c);
            warning.setContentPane(jp1);
            warning.setVisible(true);
        });
        vbox.add(modal);
        jp.add(abox);

        jf.setContentPane(jp);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

    private static void jframe() {
        JFrame jf = new JFrame(SingleLinkedListGraphImpl.PANEL_TITLE);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setSize(new Dimension(SingleLinkedListGraphImpl.WIDTH, SingleLinkedListGraphImpl.HEIGHT));
        jf.setIconImage(new ImageIcon("/home/allen/Project/algs-java/src/main/resources/icons/chrome.jpg").getImage());
        JPanel jp = new JPanel();

        JButton open = new JButton("Open");
        open.setSize(200, 50);
        open.setPreferredSize(new Dimension(150, 150));
        open.setLocation(500, 90);
        open.addActionListener(e -> {
            openNew(jf);
        });
        jp.add(open);

        jf.setContentPane(jp);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

    private static void openNew(JFrame jf) {
        JFrame nf = new JFrame("new Frame");
        nf.setSize(400, 300);
        nf.setLocationRelativeTo(jf);
        nf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        nf.setResizable(false);
        nf.setVisible(true);
    }

    private static void label() throws InterruptedException {
        JFrame jf = new JFrame(SingleLinkedListGraphImpl.PANEL_TITLE);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(new Dimension((int)(SingleLinkedListGraphImpl.WIDTH * 0.7), (int)(SingleLinkedListGraphImpl.HEIGHT * 0.7)));

        JPanel jp = new JPanel();
        jf.setContentPane(jp);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        JLabel jl = new JLabel();
        jl.setText("Label");
        jl.setFont(new Font("微软雅黑", Font.BOLD, 25));
        jl.setBounds(200, 200, 10, 35);
        jl.setForeground(Color.GREEN);
        jp.add(jl);
        jp.revalidate();

        Thread.sleep(600);

        JButton submit = new JButton("Submit");
        submit.setSize(200, 50);
        submit.setPreferredSize(new Dimension(150, 150));
        submit.setBorderPainted(false);
        jp.add(submit);
        jp.revalidate();
    }


    private static void nullLayout() {

        JFrame jf = new JFrame(SingleLinkedListGraphImpl.PANEL_TITLE);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setSize(new Dimension(SingleLinkedListGraphImpl.WIDTH, SingleLinkedListGraphImpl.HEIGHT));

        JPanel jp = new JPanel(null);
        JButton btn1 = new JButton("button1");
        btn1.setLocation(100, 100);
        btn1.setSize(120, 30);
        jp.add(btn1);

        jf.setContentPane(jp);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

}
