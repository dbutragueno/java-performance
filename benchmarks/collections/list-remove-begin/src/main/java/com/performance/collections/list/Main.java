package com.performance.collections.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Thread)
public class Main {

    private static final int REMOVE_ITERATIONS = 1000000;

    private final List<Integer> arrayList = new ArrayList<>();
    private final List<Integer> linkedList = new LinkedList<>();

    @Setup(Level.Invocation)
    public void setup() {
        arrayList.clear();
        linkedList.clear();
        for (int i = 0; i < REMOVE_ITERATIONS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public void removeBeginArrayList() {
        removeBegin(arrayList);
    }

    @Benchmark
    public void removeBeginLinkedList() {
        removeBegin(linkedList);
    }

    private void removeBegin(List<Integer> list) {
        for (int i = 0; i < REMOVE_ITERATIONS; i++) {
            list.removeFirst();
        }
    }
}
