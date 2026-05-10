# List Insert at Beginning Benchmark

##  Overview

This project uses **JMH (Java Microbenchmark Harness)** to benchmark the performance of inserting elements at the beginning of a list (`addFirst`). It compares `ArrayList` vs `LinkedList` to measure how each data structure handles head insertions at scale (1,000,000 elements).

## Installation

```bash
# Clone the repository
git clone <repository-url>
cd java-performance/collections/list

# Compile the project
mvn clean package
```

## Usage

### Run benchmarks

```bash
# Run with default configuration (5 forks, 5 warmup, 5 iterations)
java -jar target/benchmarks.jar

# Quick run (for testing)
java -jar target/benchmarks.jar -f 1 -wi 1 -i 1
```

### Common JMH parameters

| Parameter | Description |
|-----------|-------------|
| `-f N` | Number of forks (separate JVM processes). Default 5. |
| `-wi N` | Number of warmup iterations. Default 5. |
| `-i N` | Number of measurement iterations. Default 5. |
| `-t N` | Number of threads. Default 1. |
| `-bm mode` | Benchmark mode: `thrpt` (throughput), `avg` (average time), `sample` (sampling) |

Example:

```bash
java -jar target/benchmarks.jar -f 2 -wi 3 -i 3 -bm thrpt
```

### Expected output

```
Benchmark                              Mode  Cnt    Score   Error  Units
Main.insertBeginArrayList             thrpt    5  150.232          ops/s
Main.insertBeginLinkedList            thrpt    5   45.500          ops/s
Main.insertBeginArrayList              avgt    5    0.007          s/op
Main.insertBeginLinkedList             avgt    5    0.022          s/op
```

## Features

- Compare `ArrayList` vs `LinkedList` performance for head insertions (`addFirst`)
- JMH-based microbenchmarks (throughput and average time)
- Configurable benchmark parameters
- Detailed performance metrics

## Tech Stack / Built With

- **Java 25**
- **Maven 3.9+**
- **JMH 1.37** (Java Microbenchmark Harness)