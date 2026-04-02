# ArrayList Benchmark

##  Overview

This project demonstrates using **JMH (Java Microbenchmark Harness)** that defining the initial capacity of an `ArrayList` is significantly more efficient than using the default capacity. It compares performance between a list created with a predefined size versus a list that starts with default capacity and must resize as elements are added.

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
Benchmark                      Mode  Cnt    Score   Error  Units
Main.fillOutFixedList         thrpt    5  150.232          ops/s
Main.fillOutRandomLengthList  thrpt    5   45.500          ops/s
```

## Features

- Compare ArrayList performance with vs without initial capacity
- JMH-based microbenchmarks
- Configurable benchmark parameters
- Detailed performance metrics

## Tech Stack / Built With

- **Java 25**
- **Maven 3.9+**
- **JMH 1.37** (Java Microbenchmark Harness)