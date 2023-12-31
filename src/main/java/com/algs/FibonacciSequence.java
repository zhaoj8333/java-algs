package com.algs;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Get the n-th number of Fibonacci Sequence
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 1, time = 1)
@Threads(5)
@Fork(1)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class FibonacciSequence {

    public static void main(String[] args) throws RunnerException {
//        int[] inputs = {1, 2, 3, 6, 10, 30, 40, 43};
//        int input = inputs[inputs.length - 2];
//        TimeTool.check("Fibonacci", () -> fib(input));
//        TimeTool.check("Fibonacci Optimized", () -> fibOptimizeByDoubleVar(input));

        Options opts = new OptionsBuilder()
                .include(FibonacciSequence.class.getSimpleName())
                .build();
        new Runner(opts).run();

    }

    @Param(value = {"1", "5", "10", "30", "40"})
    private int length;

    /**
     * i  j sum
     * -  -  -  -  -  -  -  -   -  -
     * 0  1  1  2  3  5  8  13 21 44 .... result
     */
    @Benchmark
    public int fibOptimizeByDoubleVar(Blackhole blackhole) {
        if (length <= 1) {
            return length;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= length; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        blackhole.consume(second);
        return second;
    }

    /**
     * @return Integer of the n-th number
     *
     * i  j sum
     * -  -  -  -  -  -  -  -   -  -
     * 0  1  1  2  3  5  8  13  21 44 .... result
     */
    @Benchmark
    public int fibOptimizeByArray(Blackhole blackhole) {
        if (length <= 1) {
            return length;
        }
        int[] res = new int[length + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= length; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        blackhole.consume(res);
        return res[length];
    }

    /**
     * 0 1 2 3 4 5 6 .... n
     *
     * 0 1 1 2 3 5 8 .... result
     *
     * By using recursive
     *
     * @return Integer of the n-th number
     *
     * @Link {fibonacci_recursive_time_complexity.png}
     */
    @Benchmark
    public int fib(Blackhole blackhole) {
        int res = fibRecursively(length);
        blackhole.consume(res);
        return res;
    }

    private int fibRecursively(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursively(n - 1) + fibRecursively(n - 2);
    }

}
