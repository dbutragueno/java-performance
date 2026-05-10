# ArrayList Benchmark

##  Overview

This benchmark compares the performance of adding 1M elements to an `ArrayList` with a predefined initial capacity vs. the default capacity.

## Expected output

```
Benchmark                              Mode  Cnt    Score   Error  Units
Main.fillOutFixedCapacityList         thrpt    5  150.232          ops/s
Main.fillOutDefaultCapacityList       thrpt    5   45.500          ops/s
```

See [`benchmarks/jmh/README.md`](../../jmh/README.md) for JMH configuration and running instructions.