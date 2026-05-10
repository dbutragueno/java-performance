# Java Performance

A multi-module Maven project that uses JDK tooling to measure how data structure choices and coding patterns affect Java runtime performance. Each benchmark module targets a specific performance variable and isolates its impact under controlled, reproducible conditions. Benchmarks are configured with JMH forks, warmup iterations, and dual measurement modes (throughput and average time) to produce statistically meaningful results.

## Table of Contents

- [Repository Structure](#repository-structure)
- [Available Benchmarks](#available-benchmarks)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Tech Stack](#tech-stack)

## Repository Structure

```
java-performance/
└── benchmarks/
    ├── jmh/
    └── collections/
        ├── array-list-initial-capacity/
        └── list-insert-begin/
```

The root POM defines a multi-module Maven project. The [`benchmarks/jmh/`](benchmarks/jmh/README.md) module centralizes JMH configuration (dependencies, shade plugin) so each leaf module only needs its benchmark code. See [`benchmarks/README.md`](benchmarks/README.md) for available benchmarks and usage.

## Available Benchmarks

| Module | Description | Key Finding |
|---|---|---|
| `array-list-initial-capacity` | Compares `ArrayList` created with a predefined capacity vs. default capacity (1M elements) | Pre-allocating capacity avoids repeated internal array resizing and is significantly faster |
| `list-insert-begin` | Compares `ArrayList.addFirst()` vs `LinkedList.addFirst()` inserting 1M elements at the head | `LinkedList` has O(1) head insertion, while `ArrayList` shifts the entire backing array — a massive difference at scale |

## Getting Started

```bash
# Clone the repository
git clone https://github.com/<your-username>/java-performance.git
cd java-performance

# Build all modules
mvn clean package
```

## Tech Stack

- **Java 25** — Language and runtime
- **Maven** — Build system and multi-module project management
- **JMH 1.37** — Java Microbenchmark Harness
