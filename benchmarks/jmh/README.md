# JMH

The `jmh` module is a parent POM that centralizes JMH dependencies, annotation processing, and the Maven Shade plugin configuration so that each leaf benchmark module only needs its benchmark code.

## Table of Contents

- [Adding JMH to a New Module](#adding-jmh-to-a-new-module)
- [Common JMH Parameters](#common-jmh-parameters)
- [Getting Started](#getting-started)

## Adding JMH to a New Module

Set `jmh` as the parent in your module's `pom.xml`:

```xml
<parent>
    <groupId>com.performance</groupId>
    <artifactId>jmh</artifactId>
    <version>v1.0.0</version>
    <relativePath>../../jmh/pom.xml</relativePath>
</parent>
```

Then reference the managed plugins in the `<build>` section:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
        </plugin>
        <plugin>
            <artifactId>maven-dependency-plugin</artifactId>
        </plugin>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

The parent POM provides:

- `jmh-core` and `jmh-generator-annprocess` dependencies
- JMH annotation processor via `maven-compiler-plugin`
- Shade plugin to produce an executable `benchmarks.jar`
- Dependency plugin for classpath resolution
- Exec plugin for running via Maven

## Common JMH Parameters

| Parameter | Description |
|-----------|-------------|
| `-f N` | Number of forks (separate JVM processes) |
| `-wi N` | Number of warmup iterations |
| `-i N` | Number of measurement iterations |
| `-t N` | Number of threads |
| `-bm mode` | Benchmark mode: `thrpt` (throughput), `avgt` (avg time), `sample` |

## Getting Started

```bash
# Build the module
mvn clean package

# Run with defaults
java -jar target/benchmarks.jar

# Quick verification run
java -jar target/benchmarks.jar -f 1 -wi 1 -i 1
```
