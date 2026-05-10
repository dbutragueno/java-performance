# List Insert at Beginning Benchmark

##  Overview

This benchmark compares `ArrayList.addFirst()` vs `LinkedList.addFirst()` when inserting 1M elements at the head of the list.

## Expected output

```
Benchmark                              Mode  Cnt    Score   Error  Units
Main.insertBeginArrayList             thrpt    5  150.232          ops/s
Main.insertBeginLinkedList            thrpt    5   45.500          ops/s
Main.insertBeginArrayList              avgt    5    0.007          s/op
Main.insertBeginLinkedList             avgt    5    0.022          s/op
```

See [`benchmarks/jmh/README.md`](../../jmh/README.md) for JMH configuration and running instructions.