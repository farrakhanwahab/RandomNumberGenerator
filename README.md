# Random Number Generator (Binary, Octal, Hexadecimal)

This project is a Java application for generating unique, non-repeating, 6-digit random numbers in binary, octal, or hexadecimal systems. The user can select the desired number system using a simple graphical user interface (GUI).

## Features
- **User Selection:** Choose between binary, octal, or hexadecimal number systems.
- **Unique Numbers:** Ensures that each generated number does not repeat within a session.
- **Secure Randomness:** Uses Java's `SecureRandom` for strong, unpredictable random numbers.
- **GUI:** Built with Java Swing for ease of use.

## How to Run
1. **Compile the Java source:**
   ```sh
   javac src/RandomNumberGenerator.java
   ```
2. **Run the application:**
   ```sh
   java -cp src RandomNumberGenerator
   ```

## Algorithm Overview
- The application uses `SecureRandom` to generate a random integer within the valid range for each number system.
- The number is converted to the selected base (binary, octal, or hexadecimal) and padded to 6 digits.
- A set is used to track previously generated numbers to ensure uniqueness within the session.
- The GUI allows users to generate numbers with a single click.

## Limitations
- Uniqueness is only guaranteed within a single run of the application.
- If all possible 6-digit numbers in a system are generated, the app will notify the user.
