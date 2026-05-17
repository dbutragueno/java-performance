package com.performance.collections.list;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Thread)
public class Main {

    private static final int INSERT_ITERATIONS = 1000000;

    private final List<Integer> arrayList = new ArrayList<>();
    private final List<Integer> linkedList = new LinkedList<>();

    void main() throws Exception {
        String[] args = new String[0];
        org.openjdk.jmh.Main.main(args);

        insertBeginArrayList();
        insertBeginLinkedList();
    }

    @Setup
    public void clear() {
        arrayList.clear();
        linkedList.clear();
    }

    @Benchmark
    public void insertBeginArrayList() {
        insetBegin(arrayList);
    }

    @Benchmark
    public void insertBeginLinkedList() {
        insetBegin(linkedList);
    }

    private void insetBegin(List<Integer> list) {
        for (int i = 0; i < INSERT_ITERATIONS; i++) {
            list.addFirst(i);
        }
    }
}
