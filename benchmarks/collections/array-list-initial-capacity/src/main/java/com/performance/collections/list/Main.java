package com.performance.collections.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Thread)
public class Main {

    private static final int LIST_SIZE = 1000000;

    private final List<Integer> fixedCapacityList = new ArrayList<>(LIST_SIZE);
    private final List<Integer> defaultCapacityList = new ArrayList<>();

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
    public void fillOutFixedCapacityList() {
        fillOutList(fixedCapacityList);
    }

    @Benchmark
    public void fillOutDefaultCapacityList() {
        fillOutList(defaultCapacityList);
    }

    private void fillOutList(List<Integer> list) {
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(i, i);
        }
    }
}
