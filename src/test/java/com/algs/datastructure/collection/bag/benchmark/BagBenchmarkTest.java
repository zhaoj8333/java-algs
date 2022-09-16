package com.algs.datastructure.collection.bag.benchmark;

import com.algs.datastructure.collection.bag.ArrayBagImpl;
import com.algs.datastructure.collection.bag.IBag;
import com.algs.datastructure.collection.bag.LinkedListBagImpl;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 1, time = 1)
@Threads(5)
@Fork(1)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BagBenchmarkTest {

    @Test
    public void testPerformance() throws RunnerException {
        Options opts = new OptionsBuilder()
                .include(BagBenchmarkTest.class.getSimpleName())
                .build();
        new Runner(opts).run();

    }

    @Param(value = {"1000", "20000", "1000000", "10000000"})
    private int scale;

    @Benchmark
    public IBag<Integer> testArrayBagAdd(Blackhole blackhole) {
        IBag<Integer> arrayBag = new ArrayBagImpl<>();
        for (int i = 0; i < scale; i++) {
            arrayBag.add(i);
        }
        blackhole.consume(arrayBag);
        return arrayBag;
    }

    @Benchmark
    public IBag<Integer> testLinkedListBagAdd(Blackhole blackhole) {
        IBag<Integer> linkedlistBag = new LinkedListBagImpl<>();
        for (int i = 0; i < scale; i++) {
            linkedlistBag.add(i);
        }
        blackhole.consume(linkedlistBag);
        return linkedlistBag;
    }

}
