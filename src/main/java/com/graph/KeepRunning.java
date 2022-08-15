package com.graph;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author Frank Chen
 * @time 6/12/2019 8:22 AM
 * @Description
 */
public class KeepRunning {

    private static Robot robot;

    private static String handelStr(String str) {
        str = str.replaceAll("<", "&lt");         str = str.replaceAll(">", "&gt");
        return str.replaceAll("\n","\\\\n");
    }

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {

//        TestObject testObj = new TestObject();
//        testObj.setStr1("sdfsdfsf");
//        Optional<TestObject> testOpt = Optional.empty();
//
//        TestObject eetwt = testOpt.get();

//        System.out.println(eetwt.getStr1());

        String test = "1 expectation failed.\nExpected status code <200> but was <404>";
        System.out.println("22 is" + test);
        System.out.println("11 is" + handelStr(test));

        System.out.println("hello world");

        try {
            robot = new Robot();// 创建Robot对象
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 将鼠标抵用到刚刚建立的工程上面，这个坐标是作者在自己的电脑上实验获得的，在不同的电脑上可能
        // 不一样，可以用
        Point point = MouseInfo.getPointerInfo().getLocation();
        System.out.println(point);//来打印当前鼠标的坐标，从而找到对的位置

//        robot.mouseMove(point.x, point.y);
////		robot.mouseMove(43, 136);
//        // 按下和释放鼠标左键，选定工程
//        robot.mousePress(KeyEvent.BUTTON1_MASK);
//        robot.mouseRelease(KeyEvent.BUTTON1_MASK);


        PointerInfo pinfo = MouseInfo.getPointerInfo();
        Point p = pinfo.getLocation();
        double previousX = p.getX();
        double previousY = p.getY();

        int TIMEOUT = 10000;

        while(1 == 1) {

            Thread.sleep(120000);

            //先判定坐标有没有发生改变
            Point p1 = MouseInfo.getPointerInfo().getLocation();
            double currentX = p1.getX();
            double currentY = p1.getY();

            System.out.println("previousX is " + previousX);
            System.out.println("previousY is " + previousY);
            System.out.println("currentX is " + currentX);
            System.out.println("currentY is " + currentY);

            if(Math.abs(previousX-currentX) < 3 || Math.abs(previousY-currentY) < 3) {
                //小于3 认为就没有动，这个时候我们需要触发一波鼠标移动事件+-
                // 移动鼠标选择自动穿件main函数s06971-vsp1

                System.out.println("触发鼠标移动事件");

                robot.mouseMove(1700, 448);
//                robot.mousePress(KeyEvent.BUTTON1_MASK);
//                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.delay(TIMEOUT);

                robot.mouseMove(1800, 448);
//                robot.mousePress(KeyEvent.BUTTON1_MASK);
//                robot.mouseRelease(KeyEvent.BUTTON1_MASK);

                Point p2 = MouseInfo.getPointerInfo().getLocation();
                previousX = p2.getX();
                previousY = p2.getY();
                System.out.println("鼠标移动结束");
                robot.delay(TIMEOUT);
            } else {
                System.out.println("不需要移动鼠标" + new Date());
                Point p2 = MouseInfo.getPointerInfo().getLocation();
                previousX = p2.getX();
                previousY = p2.getY();
            }

            System.out.println("一次循环结束");
        }

    }
}