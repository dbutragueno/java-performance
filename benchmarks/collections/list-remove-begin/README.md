# List Remove from Beginning Benchmark

This benchmark compares `ArrayList.removeFirst()` vs `LinkedList.removeFirst()` when removing all elements one by one from the head of a 1M-element list.

## Expected output

```
Benchmark                              Mode  Cnt    Score   Error  Units
Main.removeBeginArrayList             thrpt    5    0.027          ops/s
Main.removeBeginLinkedList            thrpt    5  456.827          ops/s
```

## Results explanation

`ArrayList` is backed by a resizable array. Each `removeFirst()` removes the element at index 0 and shifts every remaining element left by one position — an O(n) operation. Removing 1M elements from the head triggers ~5×10¹¹ element shifts total (sum of `n-1` down to 1). Despite the JVM optimising this to a fast `memmove`, the cumulative O(n²) cost limits throughput to **0.027 ops/s**.

`LinkedList` is a doubly-linked list. Each node stores a reference to the previous and next node. `removeFirst()` unlinks the head node and updates the head pointer to the next node — an O(1) operation regardless of list size. Each of the 1M removals does constant work, yielding **456.827 ops/s**.

The ~17,000× gap is smaller than the worst-case O(n) vs O(1) ratio would suggest because `ArrayList`'s bulk shift is a highly optimised memory move with excellent cache locality, while `LinkedList` pays per-element pointer indirection overhead.

## References

- [ArrayList (Java SE 25)](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/ArrayList.html)
- [LinkedList (Java SE 25)](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/LinkedList.html)
- [JMH configuration and running instructions](../../jmh/README.md)
