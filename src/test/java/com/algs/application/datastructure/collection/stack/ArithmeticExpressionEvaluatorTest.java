package com.algs.application.datastructure.collection.stack;

import com.algs.datastructure.collection.queue.BoundedArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;

class ArithmeticExpressionEvaluatorTest {

    @Test
    void getIntFromString() {
        ArithmeticExpressionEvaluator aee = new ArithmeticExpressionEvaluator();
        String s = RandomStringUtils.randomAlphanumeric(40);

        IQueue<Integer> numbers = aee.getIntFromString(s);
        Object[] integers = numbers.toArray();

        System.out.println(s);
        System.out.println(Arrays.toString(integers));
    }

    private String getDoubleString() {
        StringBuilder s = new StringBuilder();
        int time = 2 + RandomUtils.nextInt(5);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        for (int i = 0; i < time; i++) {
            String s1 = RandomStringUtils.randomAlphanumeric(5);
            double v = RandomUtils.nextInt(10);
            double dou = Double.parseDouble(nf.format(RandomUtils.nextDouble()));
            s.append(s1).append("%$").append(BigDecimal.valueOf(v + dou).toPlainString());
        }
        return s.toString();
    }

    @Test
    void getDoubleFromString() {
        ArithmeticExpressionEvaluator aee = new ArithmeticExpressionEvaluator();
        String s = getDoubleString();
        IQueue<Double> numbers = aee.getDoubleFromString(s.toString());
        Object[] doubles = numbers.toArray();

        System.out.println(s);
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    void evaluate() {

        IQueue<String> q = new BoundedArrayQueueImpl<>();
//        q.enque("(1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");    // 101
        q.enque("((1+5.0)/2.0)");    // 101
        q.enque("((1+5.0)/0.0)");    // 101
        ArithmeticExpressionEvaluator aae = new ArithmeticExpressionEvaluator();

        while (!q.isEmpty()) {
            String expression = q.deque();
            Double result = aae.evaluate(expression);
            System.out.println(expression + " = " + result);
        }

    }
}