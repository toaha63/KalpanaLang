
# KalpanaLang - Programming in Your Native Language



KalpanaLang is an interpreter-based programming language designed to allow programmers to write code in their native language. The initial version supports Bengali (Bangla) as the primary language with translations from English, Russian, and Hindi.

## Features

- **Native Language Support**: Write code in Bengali (with English, Russian, and Hindi translations)
- **Rich Standard Library**: Includes common programming constructs and algorithms
- **Multi-language Input**: Automatically detects and translates from English, Russian, or Hindi to Bengali
- **Array Operations**: Built-in support for arrays with sorting and searching algorithms
- **Interactive Input**: Get user input with type checking

## Language Syntax

### Data Types
- `পূর্ণসংখ্যা` (Integer)
- `ভগ্নাংশ` (Float/Double)
- `বাক্য` (String)
- `বুলিয়ান` (Boolean)

### Control Structures
- `যদি` (if)
- `যদিবা` (else if)
- `বা` (else)
- `লুপ` (for/while loop)
- `ভাঙো` (break)
- `এড়াও` (continue)

### Functions
- `ফাংশন` (function)
- `ফেরত` (return)
- `খালি` (void)

### Arrays
- `পূর্ণসংখ্যার_অ্যারে` (Integer array)
- `ভগ্নাংশের_অ্যারে` (Float array)
- `বাক্যের_অ্যারে` (String array)
- `বুলিয়ানের_অ্যারে` (Boolean array)
- `অ্যারের_আকার` (Array size)
- `বাবল_সর্ট` (Bubble sort)
- `কুইক_সর্ট` (Quick sort)
- `বাইনারি_সার্চ` (Binary search)

## Getting Started

### Prerequisites
- Java 8 or higher

### Running the Interpreter
1. Clone this repository
2. Compile the Java files:
   ```sh
   javac *.java
   ```
3. Create a source file (e.g., `source.bangla`) with your code
4. Run the interpreter:
   ```sh
   java Main
   ```

## Example Programs

### Hello World
```bangla
দেখাও("হ্যালো বিশ্ব!");
```

### Fibonacci Series
```bangla
পূর্ণসংখ্যা n = 10;
পূর্ণসংখ্যার_অ্যারে fib[n];

fib[1] = 1;
fib[2] = 1;

লুপ (পূর্ণসংখ্যা i = 3; i <= n; i++) {
    fib[i] = fib[i-1] + fib[i-2];
}

লুপ (পূর্ণসংখ্যা i = 1; i <= n; i++) {
    দেখাও(fib[i]);
}
```

### Function Example
```bangla
ফাংশন পূর্ণসংখ্যা factorial(পূর্ণসংখ্যা n) {
    যদি (n == 0) {
        ফেরত 1;
    }
    ফেরত n * factorial(n - 1);
}

দেখাও(factorial(5));
```

## Supported Language Translations

| English | Bengali | Russian | Hindi |
|---------|---------|---------|-------|
| print | দেখাও | печать | प्रिंट |
| integer | পূর্ণসংখ্যা | цел | पूर्णांक |
| float | ভগ্নাংশ | дробь | भिन्न |
| string | বাক্য | строка | स्ट्रिंग |
| if | যদি | если | अगर |
| else | বা | иначе | और |
| function | ফাংশন | функция | फंक्शन |

## Project Structure

```
KalpanaLang/
├── Main.java            - Main entry point
├── KalpanaLang.jar - jar file of interpreter
└── README.md            - This file
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by the need for native language programming tools
- Built with Java for portability and performance
