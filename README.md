# LoggerFactory

A very lightweight tool to generate/build random data logs — useful for log-analysis experiments and Java learning exercises.

## What is this project

LoggerFactory provides a minimal, easy-to-use Java project that generates random log data. It’s designed for:

* Practicing log-analysis techniques.
* Demonstrating logging and parsing logic without depending on heavy production stacks.
* Educational exercises in Java involving logging, file I/O, or data analysis.

---

## Features

* Generates random logs in (plain-text) format.
* No heavy external dependencies — lightweight and easy to integrate.
* Minimal setup: just build and run.
* Includes sample configuration (via `pom.xml`) to get started quickly.

---

## Getting Started

### Prerequisites

* Java 8 (or newer)
* Maven

### Build & Run

```bash
git clone https://github.com/isGoodSoup/LoggerFactory.git
cd LoggerFactory
mvn clean package
java -jar target/LoggerFactory-<version>.jar
```

This will produce a log file (e.g. `app.log`) populated with randomly generated log entries.

---

## Usage Example

In your main class (or test harness), you can invoke the log generator. For example:

```java
// (pseudo-code / skeleton — adapt as needed)
public class Main {
    public static void main(String[] args) {
        LogGenerator generator = new LogGenerator();
        generator.generateRandomLogs(1000); // generate 1000 random log entries
    }
}
```

Then inspect `app.log` (or the configured output) to analyze the logs, filter by severity, timestamps, or feed into another tool.

---

## Configuration & Dependencies

* Uses Maven for build; dependencies are declared in `pom.xml`.
* No heavy logging frameworks required — ideal for testing and learning.
* Output is plain-text logs, easy to parse with custom scripts or log-analysis tools.

---

## Contributing

Contributions are welcome! Feel free to:

* Add more log generation strategies (e.g. JSON logs, structured logs)
* Add filtering, severity levels, or formatting options
* Implement output to different destinations (console, files, streams)
* Improve documentation or add usage examples/tests

To contribute: fork the repo, make your changes, and open a Pull Request.