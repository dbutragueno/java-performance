package com.performance.collections.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;

@State(Scope.Thread)
public class Main {

    private static final int LIST_SIZE = 1000000;

    private final ArrayList<Integer> fixedCapacityList = new ArrayList<>(LIST_SIZE);
    private final ArrayList<Integer> defaultCapacityList = new ArrayList<>();

    void main() throws Exception {
        String[] args = new String[0];
        org.openjdk.jmh.Main.main(args);

        fillOutFixedCapacityList();
        fillOutDefaultCapacityList();
    }

    @Setup
    public void clear() {
        fixedCapacityList.clear();
        defaultCapacityList.clear();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public void fillOutFixedCapacityList() {
        fillOutList(fixedCapacityList);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public void fillOutDefaultCapacityList() {
        fillOutList(defaultCapacityList);
    }

    private void fillOutList(ArrayList<Integer> list) {
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(i, i);
        }
    }
}
