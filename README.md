 # Custom Random Number Generator (Java Assignment)

This project contains a custom-built Java class, `NovelRandomGenerator`, designed to produce pseudo-random numbers. It fulfills the assignment requirement of using static, overloaded methods to generate different data types (integers, doubles, floats) and implements a "novel algorithm" (a Linear Congruential Generator).

## Project Structure

This directory contains the following files:

* `NovelRandomGenerator.java`: The main utility class containing the core random generation logic and all static methods.
* `TestRandomGenerator.java`: An example class demonstrating how to call the methods in `NovelRandomGenerator`.
* `README.md`: This file, providing documentation, usage instructions, and mathematical details.

## 🚀 How to Compile and Run

You can compile and run this project from any terminal:

1.  **Navigate** to the `ASSINGMENT` directory:
    ```bash
    cd path/to/ASSINGMENT
    ```

2.  **Compile** all the Java files:
    ```bash
    javac *.java
    ```

3.  **Run** the test program to see the output:
    ```bash
    java TestRandomGenerator
    ```

## 📖 API Reference (How to Use)

All methods in `NovelRandomGenerator` are **static**. You do not need to create an object. You can call them directly using the class name.

**Example:**
```java
int myRandomNum = NovelRandomGenerator.generateInt(1, 100);
```

---

### Integer Methods

* `public static int generateInt()`
    * **Returns:** A random 32-bit integer (can be positive or negative).

* `public static int generateInt(int bound)`
    * **Returns:** A random integer between **0** (inclusive) and the specified **`bound`** (exclusive).
    * **Example:** `generateInt(10)` will return a number from 0, 1, 2, ..., 9.

* `public static int generateInt(int min, int max)`
    * **Returns:** A random integer between **`min`** (inclusive) and **`max`** (inclusive).
    * **Example:** `generateInt(50, 100)` will return a number from 50, 51, ..., 100.

### Double Methods

* `public static double generateDouble()`
    * **Returns:** A random `double` value between **0.0** (inclusive) and **1.0** (exclusive).

* `public static double generateDouble(double min, double max)`
    * **Returns:** A random `double` between **`min``** (inclusive) and **`max`** (exclusive).

### Float Methods

* `public static float generateFloat()`
    * **Returns:** A random `float` value between **0.0f** (inclusive) and **1.0f** (exclusive).

* `public static float generateFloat(float min, float max)`
    * **Returns:** A random `float` between **`min`** (inclusive) and **`max`** (exclusive).

---

## 🔬 Mathematical Details: The "Novel Algorithm"

The algorithm implemented in this class is a **Linear Congruential Generator (LCG)**. This is a classic and one of the simplest algorithms for generating a sequence of pseudo-random numbers.

### The LCG Formula

The core of the generator is a simple mathematical formula that produces the next number in the sequence based on the previous one.

$$
X_{n+1} = (a \cdot X_n + c) \mod m
$$

Where:
* **$X_{n+1}$** is the *next* number in the sequence.
* **$X_n$** is the *current* number (also known as the "seed").
* **`a`** is the **multiplier**.
* **`c`** is the **increment**.
* **`m`** is the **modulus**.
* **`mod`** is the modulo operation (the remainder of the division).

### Implementation Details

1.  **Seed (`X_n`):** The generator must start with an initial "seed" value. Our implementation uses `System.nanoTime()` to initialize the seed, ensuring that the sequence of random numbers is different every time the program runs.

2.  **Parameters:** The quality of the random numbers depends heavily on the chosen values for `a`, `c`, and `m`. This implementation uses the same standard parameters found in Java's built-in `java.util.Random` class:
    * `m = 2^48` (This is handled efficiently using a bitwise `&` mask).
    * `a = 25214903917`
    * `c = 11`

3.  **Generating Different Types:**
    * **Integers:** The formula produces a large 48-bit number. We take the most significant 32 bits to create a standard `int`.
    * **Doubles/Floats (0.0 to 1.0):** To get a value between 0.0 and 1.0, the generated integer is scaled down by dividing it by the maximum possible value.
    * **Ranges (min, max):** To generate a number in a specific range, we first generate a 0.0-1.0 value and then scale it to fit the desired range using the formula: `random_double * (max - min) + min`.
